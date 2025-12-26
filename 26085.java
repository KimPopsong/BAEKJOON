import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int rowSize, colSize, countOne = 0, countZero = 0;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());
        map = new int[rowSize][colSize];

        for (int r = 0; r < rowSize; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < colSize; c++) {
                int n = Integer.parseInt(st.nextToken());
                map[r][c] = n;

                if (n == 1) {
                    countOne += 1;
                } else {
                    countZero += 1;
                }
            }
        }

        if (countOne % 2 == 1 || countZero % 2 == 1) {
            System.out.print(-1);
        } else {  // 인접한 쌍이 있는지 확인
            int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};

            boolean flag = false;
            for (int r = 0; r < rowSize && !flag; r++) {
                for (int c = 0; c < colSize && !flag; c++) {
                    int n = map[r][c];

                    for (int d = 0; d < 4; d++) {
                        int rr = r + dr[d];
                        int cc = c + dc[d];

                        if (0 <= rr && rr < rowSize && 0 <= cc && cc < colSize) {
                            if (map[rr][cc] == n) {
                                flag = true;

                                break;
                            }
                        }
                    }
                }
            }

            if (flag) {
                System.out.print(1);
            } else {
                System.out.print(-1);
            }
        }
    }
}
