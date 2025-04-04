import java.io.*;
import java.util.*;

public class Main {
	static final int MOD = 1000000007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long[] dp = new long[1516];

		dp[1] = 0;
		dp[2] = 1;

		for (int i = 3; i <= 1515; i++) {
			dp[i] = (dp[i - 1] % MOD + (dp[i - 2] * 2) % MOD) % MOD;
		}

		System.out.println(dp[Integer.parseInt(br.readLine())]);
	}
}
