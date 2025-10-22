import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < testCase; tc++) {
            st = new StringTokenizer(br.readLine());

            int count = 0;
            int bookNumber = Integer.parseInt(st.nextToken());
            int studentNumber = Integer.parseInt(st.nextToken());

            int[] parent = new int[bookNumber + 1];
            ArrayList<Student> students = new ArrayList<>();

            for (int i = 1; i <= bookNumber; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < studentNumber; i++) {
                st = new StringTokenizer(br.readLine());

                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                students.add(new Student(start, end));
            }

            Collections.sort(students);

            for (Student student : students) {
                int p = findParent(parent, student.start);

                if (p > student.end || p == 0)  // 범위를 벗어남
                {
                    continue;
                }

                if (p + 1 > bookNumber) {
                    parent[p] = 0;
                } else {
                    parent[p] = p + 1;
                }

                count += 1;
            }

            answer.append(count).append("\n");
        }

        System.out.print(answer);
    }

    static int findParent(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = findParent(parent, parent[x]);
    }

    static class Student implements Comparable<Student> {
        int start, end;

        Student(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Student s) {
            if (this.end == s.end) {
                return Integer.compare(this.start, s.start);
            }

            return Integer.compare(this.end, s.end);
        }
    }
}
