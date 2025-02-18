import java.io.*;
import java.util.*;

class Main {
	static Set<String> LCS = new HashSet<>();
	static String string1, string2, string3;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		string1 = new String(br.readLine());
		string2 = new String(br.readLine());
		string3 = new String(br.readLine());

		System.out.println(calcDP(string1, string2, string3));
	}

	static int calcDP(String s1, String s2, String s3) { // DP 배열 구하기
		int[][][] dp = new int[s1.length() + 1][s2.length() + 1][s3.length() + 1];

		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				for (int k = 1; k <= s3.length(); k++) {
					if (s1.charAt(i - 1) == s2.charAt(j - 1) && s2.charAt(j - 1) == s3.charAt(k - 1)) {
						dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
					}

					else {
						dp[i][j][k] = Math.max(Math.max(dp[i - 1][j][k], dp[i][j - 1][k]), dp[i][j][k - 1]);
					}
				}
			}
		}

		return dp[s1.length()][s2.length()][s3.length()];
	}
}
