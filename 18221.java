import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int size, answer;
    static int[][] classroom;
    static Point professor, student;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        size = Integer.parseInt(br.readLine());

        classroom = new int[size][size];

        for (int r = 0; r < size; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < size; c++) {
                classroom[r][c] = Integer.parseInt(st.nextToken());

                if (classroom[r][c] == 5) {
                    professor = new Point(r, c);
                } else if (classroom[r][c] == 2) {
                    student = new Point(r, c);
                }
            }
        }

        if (Math.sqrt(Math.pow(professor.r - student.r, 2) + Math.pow(professor.c - student.c, 2)) >= 5) {
            int count = 0;

            for (int r = Math.min(professor.r, student.r); r <= Math.max(professor.r, student.r); r++) {
                for (int c = Math.min(professor.c, student.c); c <= Math.max(professor.c, student.c); c++) {
                    if (classroom[r][c] == 1) {
                        count += 1;
                    }
                }
            }

            if (count >= 3) {
                answer = 1;
            }
        }

        System.out.println(answer);
    }

    static class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
