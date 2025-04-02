import java.io.*;
import java.util.*;

public class Main {
	static int length, questionNumber;
	static int[] numbers;
	static boolean[][] isPalindrome;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		length = Integer.parseInt(br.readLine());
		numbers = new int[length];
		isPalindrome = new boolean[length][length];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < length; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		calcPalindrome();

		questionNumber = Integer.parseInt(br.readLine());

		for (int i = 0; i < questionNumber; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;

			if (isPalindrome[from][to]) {
				sb.append(1);
			}

			else {
				sb.append(0);
			}

			sb.append("\n");
		}

		System.out.print(sb);
	}

	static void calcPalindrome() {
		for (int i = 0; i < length; i++) {
			int count = 0;
			int[] arr = new int[length];

			for (int j = i; j < length; j++) {
				arr[count++] = numbers[j];

				if (isPal(arr, count)) {
					isPalindrome[i][j] = true;
				}
			}
		}
	}

	static boolean isPal(int[] arr, int length) {
		boolean flag = true;

		for (int i = 0; i < length / 2; i++) {
			if (arr[i] != arr[length - i - 1]) {
				flag = false;

				break;
			}
		}

		return flag;
	}
}
