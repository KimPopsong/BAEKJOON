import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int solutionNumber = Integer.parseInt(br.readLine());
		int minGap = Integer.MAX_VALUE, minLeft = 0, minRight = 0;
		int[] solutions = new int[solutionNumber];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < solutionNumber; i++) {
			solutions[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(solutions);

		int leftNode = 0, rightNode = solutionNumber - 1;
		int before = Integer.MAX_VALUE;
		while (leftNode < rightNode) {
			int gap = Math.abs(solutions[rightNode] + solutions[leftNode]);

			if (gap < minGap) {
				minGap = gap;

				minLeft = solutions[leftNode];
				minRight = solutions[rightNode];
			}

			if (solutions[rightNode] + solutions[leftNode] >= 0) {
				rightNode -= 1;
			}

			else {
				leftNode += 1;
			}

			before = gap;
		}

		System.out.println(minLeft + " " + minRight);
	}
}
