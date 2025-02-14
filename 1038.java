import java.io.*;
import java.util.*;

public class Main {
	static int number, count = -1;
	static String target = new String("");
	static ArrayDeque<Integer> numbers = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		number = Integer.parseInt(br.readLine());

		for (int digit = 1; digit <= 10; digit++) { // 자릿수
			bruteforce(digit, 0, 10);
		}

		System.out.println(-1);
	}

	static void bruteforce(int maxDepth, int depth, int index) {
		if (maxDepth == depth) {
			count += 1;

			if (count == number) {
				while (!numbers.isEmpty()) {
					System.out.print(numbers.remove());
				}

				System.exit(0);
			}

			return;
		}

		for (int i = 0; i < index; i++) {
			numbers.addLast(i);
			bruteforce(maxDepth, depth + 1, i);
			numbers.removeLast();
		}
	}
}
