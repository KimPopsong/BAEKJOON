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

		dp[0] = 1; // 나누어 떨어지는 경우를 보정

		for (int i = 1; i <= coinType; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}

		for (int c = 1; c <= coinType; c++) {
			int coin = coins[c]; // 사용할 동전

			for (int s = coin; s <= coinSum; s++) {
				dp[s] = dp[s] + dp[s - coin];
			}
		}

		System.out.println(dp[coinSum]);
	}
}
