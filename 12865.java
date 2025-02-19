import java.io.*;
import java.util.*;

class Main {
	static int stuffNumber, maxWeight;
	static int[] weights, values;
	static int[][] dp;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		stuffNumber = Integer.parseInt(st.nextToken());
		maxWeight = Integer.parseInt(st.nextToken());

		weights = new int[stuffNumber + 1];
		values = new int[stuffNumber + 1];
		dp = new int[stuffNumber + 1][maxWeight + 1];

		for (int i = 1; i <= stuffNumber; i++) {
			st = new StringTokenizer(br.readLine());

			weights[i] = Integer.parseInt(st.nextToken());
			values[i] = Integer.parseInt(st.nextToken());
		}
		// 입력부 종료

		for (int s = 1; s <= stuffNumber; s++) {
			for (int w = 1; w <= maxWeight; w++) {
				if (w - weights[s] < 0) {
					dp[s][w] = dp[s - 1][w];
				}

				else {
					dp[s][w] = Math.max(dp[s - 1][w - weights[s]] + values[s], dp[s - 1][w]);
				}
			}
		}

		System.out.println(dp[stuffNumber][maxWeight]);
	}
}
