import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int length = Integer.parseInt(br.readLine());
		int dpLength = 0;
		int[] dp = new int[length];
		Arrays.fill(dp, Integer.MAX_VALUE);

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < length; i++) {
			int number = Integer.parseInt(st.nextToken());

			int position = Arrays.binarySearch(dp, 0, dpLength, number);

			if (position >= 0) {
				continue;
			}

			int temp = Math.abs(position) - 1;

			dp[temp] = number;

			if (temp == dpLength) {
				dpLength += 1;
			}
		}

		System.out.println(dpLength);
	}
}
