import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        final int MOD = 1000000007;

        int[] dp = new int[191231];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= 191230; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }

        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < testCase; tc++) {
            answer.append(dp[Integer.parseInt(br.readLine())]).append("\n");
        }

        System.out.print(answer);
    }
}
