import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int size;
    static int[][] board;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        size = Integer.parseInt(br.readLine());

        board = new int[size][size];
        dp = new long[size][size];

        for (int r = 0; r < size; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < size; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                int jump = board[r][c];

                if (jump == 0) {
                    continue;
                }

                if (r + jump < size) {
                    dp[r + jump][c] += dp[r][c];
                }

                if (c + jump < size) {
                    dp[r][c + jump] += dp[r][c];
                }
            }
        }

        System.out.print(dp[size - 1][size - 1]);
    }
}
