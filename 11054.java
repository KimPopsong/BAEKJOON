import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int number = Integer.parseInt(br.readLine());
		int[] numbers = new int[number];
		int[] dpl = new int[number];
		int[] dpr = new int[number];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < number; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < number; i++) { // 왼쪽부터 탐색
			int n = numbers[i];
			int max = 1;

			for (int j = 0; j < i; j++) {
				if (numbers[j] < n) {
					max = Math.max(max, dpl[j] + 1);
				}
			}

			dpl[i] = max;
		}

		for (int i = number - 1; i >= 0; i--) { // 오른쪽에서 탐색
			int n = numbers[i];
			int max = 1;

			for (int j = number - 1; j > i; j--) {
				if (numbers[j] < n) {
					max = Math.max(max, dpr[j] + 1);
				}
			}

			dpr[i] = max;
		}

		int answer = 0;
		for (int i = 0; i < number; i++) {
			answer = Math.max(answer, dpl[i] + dpr[i]);
		}

		System.out.println(answer - 1);
	}
}
