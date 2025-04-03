import java.io.*;
import java.util.*;

class Main {
	static int people;
	static boolean[] exists;
	static int[] picks;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		people = Integer.parseInt(br.readLine());
		exists = new boolean[1000001];
		picks = new int[people];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < people; i++) {
			picks[i] = Integer.parseInt(st.nextToken());
			exists[picks[i]] = true;
		}

		int[] div = new int[1000001], mult = new int[people]; // 약수의 개수, 배수의 개수

		for (int i = 0; i < people; i++) {
			for (int j = 2; j <= 1000000 / picks[i]; j++) {
				if (exists[picks[i] * j]) {
					mult[i] += 1;
					div[picks[i] * j] += 1;
				}
			}
		}

		for (int i = 0; i < people; i++) {
			sb.append(mult[i] - div[picks[i]]).append(" ");
		}

		System.out.println(sb);
	}
}
