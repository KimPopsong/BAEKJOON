import java.io.*;
import java.util.*;

class Main {
	static int seq1Length, seq2Length;
	static int[] seq1, seq2;
	static ArrayList<Integer> biggestCommonNumber = new ArrayList<>(); // 사전 순으로 가장 나중인 최대 사전 수열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		seq1Length = Integer.parseInt(br.readLine());
		seq1 = new int[seq1Length];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < seq1Length; i++) {
			seq1[i] = Integer.parseInt(st.nextToken());
		}

		seq2Length = Integer.parseInt(br.readLine());
		seq2 = new int[seq2Length];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < seq2Length; i++) {
			seq2[i] = Integer.parseInt(st.nextToken());
		}

		// 입력부 종료

		find(0, 0);

		sb.append(biggestCommonNumber.size()).append("\n");

		if (biggestCommonNumber.size() != 0) {
			for (int i : biggestCommonNumber) {
				sb.append(i).append(" ");
			}
		}

		System.out.println(sb);
	}

	static void find(int iStart, int jStart) {
		int biggestNumber = 0;
		int biggestIIndex = -1;
		int biggestJIndex = -1;

		for (int i = iStart; i < seq1Length; i++) {
			for (int j = jStart; j < seq2Length; j++) {
				if (seq1[i] == seq2[j]) {
					if (seq1[i] > biggestNumber) {
						biggestNumber = seq1[i];
						biggestIIndex = i;
						biggestJIndex = j;
					}
				}
			}
		}

		if (biggestNumber != 0) {
			biggestCommonNumber.add(biggestNumber);
			find(biggestIIndex + 1, biggestJIndex + 1);
		}
	}
}
