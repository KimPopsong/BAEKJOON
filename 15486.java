import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int day;
    static int[] dp;
    static int[][] counsel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        day = Integer.parseInt(br.readLine());
        dp = new int[day + 1];
        counsel = new int[day][2];

        for (int i = 0; i < day; i++) {
            st = new StringTokenizer(br.readLine());

            counsel[i][0] = Integer.parseInt(st.nextToken());
            counsel[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = day - 1; i >= 0; i--) {
            if (i + counsel[i][0] <= day) {
                dp[i] = Math.max(dp[i + 1], dp[i + counsel[i][0]] + counsel[i][1]);
            } else {
                dp[i] = dp[i + 1];
            }
        }

        System.out.print(dp[0]);
    }
}
