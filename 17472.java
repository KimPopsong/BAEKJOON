import java.io.*;
import java.util.*;

/**
 * 1. 입력
 * 
 * 2. 섬의 개수 확인 및 각 섬마다 번호 부여
 * 
 * 3. 갈 수 있는 모든 다리 설치
 * 
 * 4. 길이가 짧은 다리부터 크루스칼 알고리즘 적용
 */
public class Main {
	static int rowSize, colSize, islandNumber = 0;
	static int[] parents; // 각 섬이 연결되어있는지 확인
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		rowSize = Integer.parseInt(st.nextToken());
		colSize = Integer.parseInt(st.nextToken());

		map = new int[rowSize][colSize]; // 맵 초기화
		for (int r = 0; r < rowSize; r++) { // 입력
			st = new StringTokenizer(br.readLine());

			for (int c = 0; c < colSize; c++) {
				int n = Integer.parseInt(st.nextToken());

				if (n == 1) {
					n = 9;
				}

				map[r][c] = n;
			}
		}

		for (int r = 0; r < rowSize; r++) { // 각 섬마다 번호 부여
			for (int c = 0; c < colSize; c++) {
				if (islandNumber < map[r][c]) { // 섬에 번호가 부여가 안됐으면
					int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };

					islandNumber += 1;

					ArrayDeque<Point> bfs = new ArrayDeque<>();
					bfs.add(new Point(r, c));
					map[r][c] = islandNumber;

					while (!bfs.isEmpty()) {
						Point p = bfs.remove();

						for (int d = 0; d < 4; d++) {
							int rr = p.r + dr[d];
							int cc = p.c + dc[d];

							if (0 <= rr && rr < rowSize && 0 <= cc && cc < colSize) {
								if (map[rr][cc] == 9) {
									map[rr][cc] = islandNumber;
									bfs.add(new Point(rr, cc));
								}
							}
						}
					}
				}
			}
		}

		parents = new int[islandNumber + 1];
		for (int i = 1; i <= islandNumber; i++) {
			parents[i] = i;
		}

		PriorityQueue<Bridge> bridges = new PriorityQueue<>(); // 길이가 짧은 다리부터 저장
		int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };

		for (int r = 0; r < rowSize; r++) {
			for (int c = 0; c < colSize; c++) {
				if (map[r][c] != 0) {
					int island1 = map[r][c];

					for (int d = 0; d < 4; d++) {
						int rr = r;
						int cc = c;

						int bridgeLength = 0;

						while (true) {
							rr = rr + dr[d];
							cc = cc + dc[d];

							if (0 <= rr && rr < rowSize && 0 <= cc && cc < colSize) {
								if (map[rr][cc] == 0) {
									bridgeLength += 1;
								}

								else if (map[rr][cc] == island1) {
									bridgeLength = 0;

									break;
								}

								else { // 다른 섬 탐색 성공시
									if (bridgeLength > 1) {
										bridges.add(new Bridge(bridgeLength, island1, map[rr][cc]));
									}

									break;
								}
							}

							else { // 범위를 벗어나면 다리를 만들 수 없음
								bridgeLength = 0;

								break;
							}
						}
					}
				}
			}
		}

		// 섬끼리 연결하기
		int bridgeNumber = 0;
		int sumBridgeLength = 0;

		while (!bridges.isEmpty()) {
			if (bridgeNumber + 1 == islandNumber) {
				break;
			}

			Bridge bridge = bridges.remove();

			if (union(bridge.island1, bridge.island2)) {
				bridgeNumber += 1;
				sumBridgeLength += bridge.length;
			}
		}

		if (bridgeNumber + 1 == islandNumber) {
			System.out.println(sumBridgeLength);
		}

		else {
			System.out.println(-1);
		}
	}

	static int findParent(int n) {
		if (parents[n] == n) {
			return n;
		}

		return parents[n] = findParent(parents[n]);
	}

	static boolean union(int i1, int i2) {
		int root1 = findParent(i1);
		int root2 = findParent(i2);

		if (root1 == root2) {
			return false;
		}

		else {
			parents[root2] = root1;

			return true;
		}
	}

	static class Bridge implements Comparable<Bridge> {
		int length, island1, island2;

		Bridge(int length, int island1, int island2) {
			this.length = length;
			this.island1 = island1;
			this.island2 = island2;
		}

		@Override
		public int compareTo(Bridge b) {
			return Integer.compare(this.length, b.length);
		}
	}

	static class Point {
		int r, c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
