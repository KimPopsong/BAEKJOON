import java.io.*;
import java.util.*;

public class Main {
	static int number, pick;
	static String[] numbers;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());

		number = Integer.parseInt(st.nextToken());
		pick = Integer.parseInt(st.nextToken());
		numbers = new String[number];

		for (int i = 0; i < number; i++) {
			numbers[i] = br.readLine();
		}

		Arrays.sort(numbers, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if (s1.length() < s2.length()) {
					return 1;
				}

				else if (s1.length() > s2.length()) {
					return -1;
				}

				else {
					String s12 = s1 + s2;
					String s21 = s2 + s1;

					return s21.compareTo(s12);
				}
			}
		});

		PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				String s12 = s1 + s2;
				String s21 = s2 + s1;

				return s21.compareTo(s12);
			}
		});

		for (int i = 0; i < pick - number; i++) {
			pq.add(numbers[0]);
		}

		for (int i = 0; i < number; i++) {
			pq.add(numbers[i]);
		}

		while (!pq.isEmpty()) {
			sb.append(pq.remove());
		}

		System.out.println(sb);
	}
}
