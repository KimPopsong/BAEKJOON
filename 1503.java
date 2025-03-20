import java.io.*;
import java.util.*;

class Main {
	static int target, number, minGap = Integer.MAX_VALUE;
	static boolean[] cantUse = new boolean[1002];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());

		target = Integer.parseInt(st.nextToken());
		number = Integer.parseInt(st.nextToken());

		if (number != 0) {
			st = new StringTokenizer(br.readLine());
		}

		while (st.hasMoreTokens()) {
			cantUse[Integer.parseInt(st.nextToken())] = true;
		}

		for (int number1 = 1; number1 <= 1000; number1++) {
			if (cantUse[number1]) {
				continue;
			}

			for (int number2 = 1; number2 <= 1000; number2++) {
				if (cantUse[number2]) {
					continue;
				}

				int temp = number1 * number2;

				for (int number3 = 1; number3 <= 1001; number3++) {
					if (cantUse[number3]) {
						continue;
					}

					minGap = Math.min(minGap, Math.abs(target - (temp * number3)));
				}
			}
		}

		System.out.println(minGap);
	}
}
