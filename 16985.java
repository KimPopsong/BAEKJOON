import java.io.*;
import java.util.*;

class Main {
	static final int SIZE = 5;
	static int minMove = Integer.MAX_VALUE;
	static int[][][] map = new int[SIZE][SIZE][SIZE];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		for (int p = 0; p < SIZE; p++) {
			for (int r = 0; r < SIZE; r++) {
				st = new StringTokenizer(br.readLine());

				for (int c = 0; c < SIZE; c++) {
					map[p][r][c] = Integer.parseInt(st.nextToken());
				}
			}
		}

		pick(0, new int[SIZE][SIZE][SIZE], new boolean[SIZE]);

		if (minMove == Integer.MAX_VALUE) {
			System.out.println(-1);
		}

		else {
			System.out.println(minMove);
		}
	}

	static void bfs(int[][][] newMap) {
		int move = 0;

		int[] startR = { 0, 0, SIZE - 1, SIZE - 1 };
		int[] startC = { 0, SIZE - 1, 0, SIZE - 1 };

		int[] dp = { -1, 1, 0, 0, 0, 0 };
		int[] dr = { 0, 0, -1, 1, 0, 0 };
		int[] dc = { 0, 0, 0, 0, -1, 1 };

		for (int i = 0; i < 4; i++) { // 4개의 꼭짓점을 확인
			if (newMap[0][startR[i]][startC[i]] == 1) { // 시작 지점으로 가능하고
				if (newMap[SIZE - 1][SIZE - startR[i] - 1][SIZE - startC[i] - 1] == 1) { // 반대쪽 꼭짓점도 도착 가능하다면
					boolean flag = false;
					ArrayDeque<Point> bfs = new ArrayDeque<>();
					boolean[][][] isVisit = new boolean[SIZE][SIZE][SIZE];

					bfs.add(new Point(0, startR[i], startC[i]));
					isVisit[0][startR[i]][startC[i]] = true;

					bfs: while (!bfs.isEmpty()) {
						move += 1;

						if (move >= minMove) {
							break;
						}

						ArrayDeque<Point> tempBfs = bfs.clone();
						bfs.clear();

						while (!tempBfs.isEmpty()) {
							Point p = tempBfs.removeFirst();

							for (int d = 0; d < 6; d++) {
								int pp = p.p + dp[d];
								int rr = p.r + dr[d];
								int cc = p.c + dc[d];

								// 범위 안에 있고
								if (0 <= pp && pp < SIZE && 0 <= rr && rr < SIZE && 0 <= cc && cc < SIZE) {
									if (newMap[pp][rr][cc] == 1) { // 갈 수 있는 길이고
										if (isVisit[pp][rr][cc] == false) { // 방문하지 않았다면
											// 도착 지점이라면
											if (pp == SIZE - 1 && rr == SIZE - startR[i] - 1
													&& cc == SIZE - startC[i] - 1) {
												flag = true;

												break bfs;
											}

											else {
												bfs.add(new Point(pp, rr, cc));
												isVisit[pp][rr][cc] = true;
											}
										}
									}
								}
							}
						}
					}

					if (flag) { // 최소 거리 확인
						minMove = Math.min(minMove, move);
					}
				}
			}
		}
	}

	static void rotate(int depth, int[][][] newMap) { // 0번 페이지부터 4번 페이지까지 90도로 회전
		if (depth == SIZE) { // 마지막 페이지까지 회전시켰다면
			bfs(newMap); // 탐색

			return;
		}

		else {
			for (int i = 0; i < 4; i++) { // 4번 반복
				int[][] tempMap = new int[SIZE][SIZE];

				for (int r = 0; r < SIZE; r++) { // 시계 방향으로 90도 회전시켜 임시 배열에 저장하고
					for (int c = 0; c < SIZE; c++) {
						tempMap[c][SIZE - r - 1] = newMap[depth][r][c];
					}
				}

				for (int r = 0; r < SIZE; r++) { // 원본 배열에 옮기기
					for (int c = 0; c < SIZE; c++) {
						newMap[depth][r][c] = tempMap[r][c];
					}
				}

				rotate(depth + 1, newMap); // 다음 페이지 탐색
			}
		}
	}

	static void pick(int depth, int[][][] newMap, boolean[] isVisit) { // 페이지를 고르는 순열
		if (depth == SIZE) {
			rotate(0, newMap);
		}

		else {
			for (int i = 0; i < SIZE; i++) {
				if (isVisit[i] == true) {
					continue;
				}

				else {
					for (int r = 0; r < SIZE; r++) {
						for (int c = 0; c < SIZE; c++) {
							newMap[depth][r][c] = map[i][r][c];
						}
					}

					isVisit[i] = true;
					pick(depth + 1, newMap, isVisit);
					isVisit[i] = false;
				}
			}
		}
	}

	static class Point {
		int p, r, c;

		Point(int p, int r, int c) {
			this.p = p;
			this.r = r;
			this.c = c;
		}
	}
}
