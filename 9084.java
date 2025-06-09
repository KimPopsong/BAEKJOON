import java.util.*;
import java.io.*;

public class Main {
    static int testCase, coinNumber, coinTarget, count;
    static int[] coins, dp;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        testCase = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < testCase; tc++)
        {
            count = 0;
            coinNumber = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            coins = new int[coinNumber];
            for (int i = 0; i < coinNumber; i++)
            {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            coinTarget = Integer.parseInt(br.readLine());
            // 입력부 종료


            dp = new int[coinTarget + 1];
            dp[0] = 1;

            for (int coin : coins)
            {
                for (int target = coin; target <= coinTarget; target++)
                {
                    dp[target] = dp[target] + dp[target - coin];
                }
            }

            sb.append(dp[coinTarget]).append("\n");
        }

        System.out.print(sb);
    }
}
