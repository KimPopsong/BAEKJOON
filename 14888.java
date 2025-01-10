import java.util.*;
import java.io.*;

class Main {
	static int number; // 수의 개수
	static int maxSum = Integer.MIN_VALUE, minSum = Integer.MAX_VALUE;
	static int[] numbers, signs; // 수 모음, 부호 모음

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		number = Integer.parseInt(br.readLine());

		numbers = new int[number];
		signs = new int[4]; // +, -, *, / 순

		String[] temp = br.readLine().split(" ");

		for (int i = 0; i < number; i++) {
			numbers[i] = Integer.parseInt(temp[i]);
		}

		temp = br.readLine().split(" ");

		for (int i = 0; i < 4; i++) {
			signs[i] = Integer.parseInt(temp[i]);
		}

		recursion(numbers[0], 1); // 맨 처음 숫자는 항상 더하기

		System.out.println(maxSum);
		System.out.println(minSum);
	}

	static void recursion(int sum, int depth) {
		if (depth == number) {
			maxSum = Math.max(maxSum, sum);
			minSum = Math.min(minSum, sum);

			return;
		}

		for (int i = 0; i < 4; i++) {
			if (signs[i] >= 1) // 부호 처리
			{
				signs[i] -= 1;

				switch (i) {
				case 0: // 더하기
					recursion(sum + numbers[depth], depth + 1);

					break;
				case 1: // 빼기
					recursion(sum - numbers[depth], depth + 1);

					break;
				case 2: // 곱하기
					recursion(sum * numbers[depth], depth + 1);

					break;
				case 3: // 나누기
					recursion((int) (sum / numbers[depth]), depth + 1);

					break;
				}

				signs[i] += 1;
			}
		}
	}
}
