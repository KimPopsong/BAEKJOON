import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int number, deleteNumber;
		int[] numbers;

		st = new StringTokenizer(br.readLine());

		number = Integer.parseInt(st.nextToken());
		deleteNumber = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		numbers = new int[number];
		for (int i = 0; i < number; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0;
		long maxLength = 0;
		int countOdd = 0;

		for (int right = 0; right < number; right++) {
			int num = numbers[right];

			if (num % 2 == 1) {
				countOdd += 1;
			}

			if (countOdd > deleteNumber) {
				while (left <= right) {
					int n = numbers[left];

					left += 1;

					if (n % 2 == 1) {
						countOdd -= 1;

						break;
					}
				}
			}

			maxLength = Math.max(maxLength, (right - left + 1 - countOdd));
		}

		System.out.println(maxLength);
	}
}
