import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int cowNumber, maxLength, count = 0;
		int[] cows;
		st = new StringTokenizer(br.readLine());

		cowNumber = Integer.parseInt(st.nextToken());
		maxLength = Integer.parseInt(st.nextToken());
		cows = new int[cowNumber];

		for (int i = 0; i < cowNumber; i++) {
			st = new StringTokenizer(br.readLine());

			cows[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < cowNumber - 1; i++) {
			int c1 = cows[i];

			for (int j = i + 1; j < cowNumber; j++) {
				int c2 = cows[j];

				if (c1 + c2 <= maxLength) {
					count += 1;
				}
			}
		}

		System.out.println(count);
	}
}
