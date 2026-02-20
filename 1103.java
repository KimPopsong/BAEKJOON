import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean cycleFlag = false;
    static int rowSize, colSize;
    static boolean[][] isVisit;
    static int[][] map, memoization;

    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());

        isVisit = new boolean[rowSize][colSize];
        map = new int[rowSize][colSize];
        memoization = new int[rowSize][colSize];
        for (int r = 0; r < rowSize; r++) {
            String s = br.readLine();

            for (int c = 0; c < colSize; c++) {
                if (s.charAt(c) == 'H') {
                    map[r][c] = -1;
                } else {
                    map[r][c] = Integer.parseInt(String.valueOf(s.charAt(c)));
                }
            }
        }

        dfs(0, 0);

        if (cycleFlag) {
            System.out.println(-1);
        } else {
            System.out.println(memoization[0][0]);
        }
    }

    static void dfs(int r, int c) {
        if (cycleFlag || isVisit[r][c]) {
            cycleFlag = true;

            return;
        }

        isVisit[r][c] = true;
        int max = 0;

        for (int d = 0; d < 4; d++) {
            int rr = r + dr[d] * map[r][c];
            int cc = c + dc[d] * map[r][c];

            if (0 <= rr && rr < rowSize && 0 <= cc && cc < colSize) {
                if (memoization[rr][cc] == 0) {
                    if (map[rr][cc] != -1) {
                        dfs(rr, cc);
                    }
                }

                max = Math.max(max, memoization[rr][cc]);
            }
        }

        isVisit[r][c] = false;
        memoization[r][c] = max + 1;
    }
}
