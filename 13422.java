import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < testCase; tc++) {
			int houseNumber, streak, crimePrevent, availSteal = 0; // 집의 개수, 연속해서 훔칠 집, 미만으로 훔칠 수 있는 돈, 가능한 경우의 수
			int[] houses, preSum;

			st = new StringTokenizer(br.readLine());

			houseNumber = Integer.parseInt(st.nextToken());
			streak = Integer.parseInt(st.nextToken());
			crimePrevent = Integer.parseInt(st.nextToken());

			houses = new int[houseNumber];
			preSum = new int[houseNumber + streak];

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < houseNumber; i++) {
				houses[i] = Integer.parseInt(st.nextToken());
			}

			// 누적합 구하기
			for (int i = 0; i < houseNumber; i++) {
				preSum[i + 1] = preSum[i] + houses[i];
			}

			for (int i = 0; i < streak - 1; i++) {
				preSum[houseNumber + i + 1] = preSum[houseNumber + i] + houses[i];
			}
			// 누적합 구하기 끝

			if (houseNumber == streak) { // 예외처리
				if (preSum[houseNumber] < crimePrevent) {
					availSteal = 1;
				}
			}

			else {
				int left = 0;
				for (int right = streak; right < houseNumber + streak; right++) {
					if (preSum[right] - preSum[left] < crimePrevent) {
						availSteal += 1;
					}

					left += 1;
				}
			}

			sb.append(availSteal).append("\n");
		}

		System.out.println(sb);
	}
}
