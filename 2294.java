import java.io.*;
import java.util.*;

public class Main {
	static int coinType, coinSum;
	static int[] coins;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());

		coinType = Integer.parseInt(st.nextToken());
		coinSum = Integer.parseInt(st.nextToken());

		coins = new int[coinType + 1];
		dp = new int[coinSum + 1];

		Arrays.fill(dp, 10000000);
		dp[0] = 0;

		for (int i = 1; i <= coinType; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(coins);

		for (int c = 1; c <= coinType; c++) {
			int coin = coins[c]; // 사용할 동전

			for (int s = coin; s <= coinSum; s++) {
				dp[s] = Math.min(dp[s], Math.min(dp[s - coin] + 1, s / coin + dp[s % coin]));
			}
		}

		if (dp[coinSum] == 10000000) {
			System.out.println(-1);
		}

		else {
			System.out.println(dp[coinSum]);
		}
	}
}
