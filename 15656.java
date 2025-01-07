import java.util.*;
import java.io.*;

class Main {
	static int number, pick; // 숫자의 개수, 조합의 개수
	static int[] numbers;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().split(" ");

		number = Integer.parseInt(temp[0]);
		pick = Integer.parseInt(temp[1]);

		numbers = new int[number];

		temp = br.readLine().split(" ");

		for (int i = 0; i < number; i++) {
			numbers[i] = Integer.parseInt(temp[i]);
		}

		Arrays.sort(numbers);

		for (int i = 0; i < number; i++) {
			LinkedList<Integer> arr = new LinkedList<>();
			arr.add(numbers[i]);

			recursion(1, i, arr);
		}

		System.out.println(sb);
	}

	public static void recursion(int depth, int index, LinkedList<Integer> arr) {
		if (depth == pick) {
			for (int n : arr) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
		}

		else {
			for (int i = 0; i < number; i++) {
				arr.add(numbers[i]);

				recursion(depth + 1, i, arr);

				arr.remove(arr.size() - 1);
			}
		}
	}
}
