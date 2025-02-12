import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	static int number;
	static int[] romeNumber = { 1, 5, 10, 50 };
	static Set<Integer> sumNumber = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		number = Integer.parseInt(br.readLine());

		bruteforce(0, 0, 0);

		System.out.println(sumNumber.size());
	}

	static void bruteforce(int index, int depth, int sum) {
		if (depth == number) {
			sumNumber.add(sum);

			return;
		}

		for (int i = index; i < 4; i++) {
			bruteforce(i, depth + 1, sum + romeNumber[i]);
		}
	}
}
