import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int wireNumber = Integer.parseInt(br.readLine()); // 전선의 개수
		int[][] wires = new int[wireNumber][2]; // [출발, 도착] 순
		int[] dp = new int[wireNumber];

		for (int i = 0; i < wireNumber; i++) {
			String[] temp = br.readLine().split(" ");

			for (int j = 0; j < 2; j++) {
				wires[i][j] = Integer.parseInt(temp[j]);
			}
		}

		Arrays.sort(wires, new Comparator<int[]>() { // 출발점을 기준으로 정렬
			@Override
			public int compare(int[] w1, int[] w2) {
				return w1[0] - w2[0];
			}
		});

		dp[0] = 1;

		for (int i = 1; i < wireNumber; i++) {
			int nod = wires[i][1];

			dp[i] = 1;

			for (int j = i - 1; j >= 0; j--) {
				if (wires[j][1] < nod) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

		int answer = 0;

		for (int d : dp) {
			answer = Math.max(answer, d);
		}

		System.out.println(wireNumber - answer);
	}
}
