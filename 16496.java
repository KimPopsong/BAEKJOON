import java.io.*;
import java.util.*;

public class Main {
	static int number;
	static String[] numbers;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		number = Integer.parseInt(br.readLine());
		numbers = new String[number];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < number; i++) {
			numbers[i] = st.nextToken();
		}

		boolean zeroFlag = true;
		for (int i = 0; i < number; i++) {
			if (!numbers[i].equals("0")) {
				zeroFlag = false;

				break;
			}
		}

		if (zeroFlag) {
			System.out.println("0");

			System.exit(0);
		}

		Arrays.sort(numbers, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				String s12 = s1 + s2;
				String s21 = s2 + s1;

				return s21.compareTo(s12);
			}
		});

		for (String s : numbers) {
			sb.append(s);
		}

		System.out.println(sb);
	}
}
