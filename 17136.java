import java.io.*;
import java.util.*;

class Main {
	static final int SIZE = 10;
	static int one = 0, usePaper = 26;
	static int[][] map = new int[SIZE][SIZE];
	static int[] paper = { 0, 5, 5, 5, 5, 5 }; // 크기가 n * n인 종이

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		for (int r = 0; r < SIZE; r++) {
			st = new StringTokenizer(br.readLine());

			for (int c = 0; c < SIZE; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());

				if (map[r][c] == 1) {
					one += 1;
				}
			}
		}

		bruteForce(map, one, 0);

		if (usePaper == 26) {
			System.out.println(-1);
		}

		else {
			System.out.println(usePaper);
		}
	}

	static void bruteForce(int[][] newMap, int leftOne, int use) {
		if (leftOne == 0) { // 더이상 남은 0이 없다면
			usePaper = Math.min(usePaper, use);

			return;
		}

		else if (use >= usePaper) {
			return;
		}

		for (int r = 0; r < SIZE; r++) {
			for (int c = 0; c < SIZE; c++) {
				if (newMap[r][c] == 1) { // 1을 찾았다면
					for (int size = 5; size > 0; size--) { // 사이즈가 5인 종이부터 1인 종이까지 확인
						if (paper[size] <= 0) { // 남은 종이가 없다면 다른 종이 사용
							continue;
						}

						else if (r + size > SIZE || c + size > SIZE) {
							continue;
						}

						boolean flag = true;

						for (int rr = r; rr < r + size; rr++) {
							for (int cc = c; cc < c + size; cc++) {
								if (newMap[rr][cc] == 0) { // 현재 사이즈의 종이를 찾을 수 없다면
									flag = false;

									break;
								}
							}

							if (flag == false) {
								break;
							}
						}

						if (flag) { // 종이 사이즈가 맞다면
							int[][] newNewMap = new int[SIZE][SIZE];

							for (int rr = 0; rr < SIZE; rr++) { // 배열 복사
								for (int cc = 0; cc < SIZE; cc++) {
									newNewMap[rr][cc] = newMap[rr][cc];
								}
							}

							for (int rr = r; rr < r + size; rr++) {
								for (int cc = c; cc < c + size; cc++) {
									newNewMap[rr][cc] = 0; // 색종이 사용
								}
							}

							paper[size] -= 1;
							bruteForce(newNewMap, leftOne - (size * size), use + 1);
							paper[size] += 1;
						}
					}

					return;
				}
			}
		}
	}
}
