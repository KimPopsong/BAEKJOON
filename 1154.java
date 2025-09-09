import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int studentNumber;
    static int[] color;
    static boolean[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        // 입력부 시작

        studentNumber = Integer.parseInt(br.readLine());

        color = new int[studentNumber + 1];
        graph = new boolean[studentNumber + 1][studentNumber + 1];

        for (int r = 0; r <= studentNumber; r++) {
            for (int c = 0; c <= studentNumber; c++) {
                if (r == c) {
                    continue;
                }

                graph[r][c] = true;
            }
        }

        while (true) {
            st = new StringTokenizer(br.readLine());

            int s1 = Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken());

            if (s1 == -1 && s2 == -1) {
                break;
            }

            graph[s1][s2] = false;
            graph[s2][s1] = false;
        }

        // 입력부 종료
        boolean flag = true;
        for (int node = 1; node <= studentNumber && flag; node++) {
            if (color[node] != 0) {
                continue;
            }

            ArrayDeque<Integer> bfs = new ArrayDeque<>();
            bfs.add(node);
            color[node] = 1;

            while (!bfs.isEmpty() && flag) {
                int student = bfs.removeFirst();

                for (int i = 1; i <= studentNumber; i++) {
                    if (graph[student][i]) {
                        if (color[i] == 0) {
                            color[i] = -color[student];
                            bfs.addLast(i);
                        } else if (color[i] == color[student]) {
                            flag = false;

                            break;
                        }
                    }
                }
            }
        }

        if (flag) {
            answer.append("1").append("\n");
            for (int i = 1; i <= studentNumber; i++) {
                if (color[i] == 1) {
                    answer.append(i).append(" ");
                }
            }
            answer.append("-1").append("\n");

            for (int i = 1; i <= studentNumber; i++) {
                if (color[i] == -1) {
                    answer.append(i).append(" ");
                }
            }
            answer.append("-1");
        } else {
            answer.append("-1");
        }

        System.out.println(answer);
    }
}
