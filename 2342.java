import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int move;
    static int[][] memo;
    static int[][][] dp;
    static ArrayList<Integer> moves = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        memo = new int[][]{{0, 2, 2, 2, 2}, {2, 1, 3, 4, 3}, {2, 3, 1, 3, 4}, {2, 4, 3, 1, 3}, {2, 3, 4, 3, 1}};

        st = new StringTokenizer(br.readLine());
        while (true) {
            int m = Integer.parseInt(st.nextToken());

            if (m == 0) {
                break;
            }

            move += 1;
            moves.add(m);
        }

        dp = new int[moves.size()][5][5];

        System.out.print(dfs(0, 0, 0));
    }

    static int dfs(int left, int right, int depth) {
        if (depth == move) {
            return 0;
        } else if (dp[depth][left][right] != 0) {
            return dp[depth][left][right];
        }

        int next = moves.get(depth);

        dp[depth][left][right] = Math.min(dfs(next, right, depth + 1) + memo[left][next], dfs(left, next, depth + 1) + memo[right][next]);

        return dp[depth][left][right];
    }
}
