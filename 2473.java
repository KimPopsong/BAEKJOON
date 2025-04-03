import java.io.*;
import java.util.*;

class Main {
	static int solutionNumber;
	static long minSum = Long.MAX_VALUE;
	static long[] minSolutions = new long[3]; // 용액 담기
	static long[] solutions;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		solutionNumber = Integer.parseInt(br.readLine());
		solutions = new long[solutionNumber];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < solutionNumber; i++) {
			solutions[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(solutions); // 오름차순 정렬
		// 이분탐색
		for (int left = 0; left <= solutionNumber - 3; left++) {
			for (int right = left + 2; right < solutionNumber; right++) {
				int l = left + 1;
				int r = right - 1;

				long preSum = solutions[left] + solutions[right];

				while (l <= r) {
					int mid = (r + l) / 2;

					long gap = preSum + solutions[mid];

					if (Math.abs(gap) < minSum) {
						minSum = Math.abs(gap);

						minSolutions[0] = solutions[left];
						minSolutions[1] = solutions[mid];
						minSolutions[2] = solutions[right];
					}

					if (gap > 0) {
						r = mid - 1;
					}

					else if (gap < 0) {
						l = mid + 1;
					}

					else {
						break;
					}
				}
			}
		}

		for (long i : minSolutions) {
			System.out.print(i + " ");
		}
	}
}
