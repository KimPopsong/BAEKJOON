import java.io.*;
import java.util.*;

public class Main {
	static final int MOD = 1000000007;
	static int diceNumber;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		diceNumber = Integer.parseInt(br.readLine());

		long numer = 0, denom = 1; // 분자, 분모

		for (int i = 0; i < diceNumber; i++) {
			st = new StringTokenizer(br.readLine());
			long d = Integer.parseInt(st.nextToken());
			long n = Integer.parseInt(st.nextToken());

			numer = numer * d + n * denom;
			denom = denom * d;

			numer %= MOD;
			denom %= MOD;
		}

		System.out.println((getSquare(denom, MOD - 2) * numer) % MOD);
	}

	static long getSquare(long num, long exp) {
		if (num == 1) {
			return 1;
		}

		else if (exp == 1) {
			return num;
		}

		long sq = getSquare(num, exp / 2);

		if (exp % 2 == 1) {
			return (((sq * sq) % MOD) * (num % MOD)) % MOD;
		}

		else {
			return ((sq * sq) % MOD) % MOD;
		}
	}
}
