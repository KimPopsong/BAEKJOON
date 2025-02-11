import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int number = Integer.parseInt(br.readLine());
		long[] numbers = new long[number];
		long maxNumber = 0;

		for (int i = 0; i < number; i++) {
			numbers[i] = Long.parseLong(br.readLine());
		}
		Arrays.sort(numbers);

		Set<Long> xy = new HashSet<>();

		for (int x = 0; x < number; x++) {
			for (int y = 0; y < number; y++) {
				xy.add(numbers[x] + numbers[y]);
			}
		}

		for (int z = 0; z < number; z++) {
			for (int k = 0; k < number; k++) {
				if (xy.contains(numbers[k] - numbers[z])) {
					maxNumber = Math.max(maxNumber, numbers[k]);
				}
			}
		}

		System.out.println(maxNumber);
	}
}
