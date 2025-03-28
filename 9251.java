import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		String string1 = new String(br.readLine());
		String string2 = new String(br.readLine());

		int[][] dp = new int[string1.length() + 1][string2.length() + 1];

		for (int i = 1; i <= string1.length(); i++) {
			for (int j = 1; j <= string2.length(); j++) {
				if (string1.charAt(i - 1) == string2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}

				else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		System.out.println(dp[string1.length()][string2.length()]);
	}
}
