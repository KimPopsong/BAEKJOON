import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int nephewNumber, snackNumber; // 조카의 수, 과자의 수,
		ArrayList<Integer> snacks = new ArrayList<>();

		long left = 0, right = 0;

		st = new StringTokenizer(br.readLine());

		nephewNumber = Integer.parseInt(st.nextToken());
		snackNumber = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < snackNumber; i++) {
			int n = Integer.parseInt(st.nextToken());

			right += n;
			snacks.add(n);
		}

		long maxSnack = 0;
		while (left <= right) {
			long mid = (left + right) / 2;
			long count = 0;

			if (mid == 0) {
				break;
			}

			for (int snack : snacks) {
				count += snack / mid;
			}

			if (count >= nephewNumber) {
				maxSnack = mid;

				left = mid + 1;
			}

			else {
				right = mid - 1;
			}
		}

		System.out.println(maxSnack);
	}
}
