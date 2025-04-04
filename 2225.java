import java.io.*;
import java.util.*;

public class Main {
	static int sumNumber, number;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());

		sumNumber = Integer.parseInt(st.nextToken());
		number = Integer.parseInt(st.nextToken());

		dp = new int[number][sumNumber + 1];

		Arrays.fill(dp[0], 1);

		for (int i = 0; i < number; i++) {
			dp[i][0] = 1;
		}

		for (int r = 1; r < number; r++) {
			for (int c = 1; c <= sumNumber; c++) {
				dp[r][c] = (dp[r - 1][c] % 1000000000 + dp[r][c - 1] % 1000000000) % 1000000000;
			}
		}

		System.out.println(dp[number - 1][sumNumber]);
	}
}
