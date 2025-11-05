import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int numberSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        numberSize = Integer.parseInt(br.readLine());
        int[][] dp = new int[numberSize][10];

        Arrays.fill(dp[0], 1);

        for (int i = 1; i < numberSize; i++) {
            dp[i][0] = 1;

            for (int j = 1; j < 10; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 10007;
            }
        }

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += dp[numberSize - 1][i];
        }

        System.out.println(sum % 10007);
    }
}
