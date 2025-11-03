import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String cypher = br.readLine();
        int[] dp = new int[cypher.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        if (cypher.charAt(0) == '0') {
            System.out.print(0);

            return;
        }

        for (int i = 2; i <= cypher.length(); i++) {
            char c1 = cypher.charAt(i - 2);
            char c2 = cypher.charAt(i - 1);

            int n = (c1 - '0') * 10 + (c2 - '0');

            if (c2 == '0') {
                if (c1 == '1' || c1 == '2') {
                    dp[i] = dp[i - 2];
                } else {
                    System.out.print(0);

                    return;
                }
            } else if (10 <= n && n <= 26) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000;
            } else {
                dp[i] = dp[i - 1];
            }
        }

        System.out.print(dp[cypher.length()]);
    }
}
