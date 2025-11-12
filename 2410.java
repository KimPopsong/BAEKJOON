import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int number = Integer.parseInt(br.readLine());
        dp = new int[number + 1];

        dp[1] = 1;
        for (int i = 2; i <= number; i++) {
            if (i % 2 == 1) {  // 홀수
                dp[i] = dp[i - 1];
            } else {  // 짝수
                dp[i] = (dp[i - 1] + dp[i / 2]) % 1000000000;
            }
        }

        System.out.print(dp[number]);
    }
}
