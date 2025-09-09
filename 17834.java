import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int bushNumber, roadNumber;
    static long answer = 0;
    static int[] color;
    static ArrayList<Integer>[] roads;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력부 시작

        st = new StringTokenizer(br.readLine());

        bushNumber = Integer.parseInt(st.nextToken());
        roadNumber = Integer.parseInt(st.nextToken());

        color = new int[bushNumber + 1];
        roads = new ArrayList[bushNumber + 1];

        for (int i = 1; i <= bushNumber; i++) {
            roads[i] = new ArrayList<>();
        }

        for (int i = 0; i < roadNumber; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            roads[from].add(to);
            roads[to].add(from);
        }

        // 입력부 종료

        boolean flag = true;
        ArrayDeque<Integer> bfs = new ArrayDeque<>();
        bfs.add(1);  // 모든 수풀은 연결되어 있으므로 1번부터 시작
        color[1] = 1;

        while (!bfs.isEmpty() && flag) {
            int bush = bfs.remove();

            for (int nearBush : roads[bush]) {
                if (color[nearBush] == 0) {
                    color[nearBush] = -color[bush];  // 반대 색상으로 칠하기
                    bfs.add(nearBush);
                } else {  // 이미 색칠되어 있다면
                    if (color[bush] == color[nearBush]) {  // 같은 색상이라면 탈출
                        flag = false;

                        break;
                    }
                }
            }
        }

        if (!flag) {
            System.out.println(0);
        } else {
            int red = 0;
            int blue = 0;

            for (int i = 1; i <= bushNumber; i++) {
                if (color[i] == 1) {
                    red++;
                } else if (color[i] == -1) {
                    blue++;
                }
            }

            System.out.println(red * blue * 2);
        }
    }
}
