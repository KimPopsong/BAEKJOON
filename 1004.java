import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < testCase; tc++) {
            int planetNumber, count = 0;

            st = new StringTokenizer(br.readLine());

            Point start = new Point(Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()));
            Point end = new Point(Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()));

            planetNumber = Integer.parseInt(br.readLine());

            for (int i = 0; i < planetNumber; i++) {
                st = new StringTokenizer(br.readLine());

                int pX = Integer.parseInt(st.nextToken());
                int pY = Integer.parseInt(st.nextToken());
                int pR = Integer.parseInt(st.nextToken());

                double distStart = Math.sqrt(Math.pow(start.x - pX, 2) + Math.pow(start.y - pY, 2));
                double distEnd = Math.sqrt(Math.pow(end.x - pX, 2) + Math.pow(end.y - pY, 2));

                if ((pR <= distStart && pR >= distEnd) || (pR <= distEnd && pR >= distStart)) {
                    count += 1;
                }
            }

            answer.append(count).append("\n");
        }

        System.out.print(answer);
    }

    static class Point {

        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
