import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int number = Integer.parseInt(br.readLine());
		int dpLength = 0;
		int[] dp = new int[number];
		Arrays.fill(dp, Integer.MAX_VALUE);

		for (int i = 0; i < number; i++) {
			int n = Integer.parseInt(br.readLine());

			int result = Arrays.binarySearch(dp, 0, dpLength, n);

			if (result >= 0) { // 0보다 크면 일치하는 값이 있으므로
				continue; // 생략
			}

			else {
				result = -result - 1;

				if (result == dpLength) {
					dpLength += 1;
				}

				dp[result] = n;
			}
		}

		System.out.print(number - dpLength);
	}
}
