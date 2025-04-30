import java.io.*;
import java.util.*;

public class Main {
	static int rowSize, colSize;
	static Point start, end;
	static int[][] map;

	static int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 }; // 12시부터 시계방향

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());

		rowSize = Integer.parseInt(st.nextToken());
		colSize = Integer.parseInt(st.nextToken());

		map = new int[rowSize][colSize];

		for (int r = 0; r < rowSize; r++) {
			st = new StringTokenizer(br.readLine());

			for (int c = 0; c < colSize; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < 2; i++) {
			st = new StringTokenizer(br.readLine());

			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int direction = Integer.parseInt(st.nextToken());

			if (direction == 2) {
				direction = 3;
			}

			else if (direction == 3) {
				direction = 2;
			}

			else if (direction == 4) {
				direction = 0;
			}

			if (i == 0) {
				start = new Point(r, c, direction);
			}

			else {
				end = new Point(r, c, direction);
			}
		}

		if (start.r == end.r && start.c == end.c && start.direction == end.direction) {
			System.out.println(0);

			System.exit(0);
		}

		int time = 0;
		ArrayDeque<Point> bfs = new ArrayDeque<>();
		boolean[][][] isVisit = new boolean[rowSize][colSize][4]; // [r][c][방향]

		bfs.add(start);
		isVisit[start.r][start.c][start.direction] = true;

		while (!bfs.isEmpty()) {
			time += 1;

			ArrayDeque<Point> tempBfs = new ArrayDeque<>(bfs);
			bfs.clear();

			while (!tempBfs.isEmpty()) {
				Point p = tempBfs.remove();

				int tempD = p.direction + 1; // 오른쪽 90도 회전

				if (tempD > 3) {
					tempD = 0;
				}

				if (isVisit[p.r][p.c][tempD] == false) {
					bfs.add(new Point(p.r, p.c, tempD));
					isVisit[p.r][p.c][tempD] = true;

					if (p.r == end.r && p.c == end.c && tempD == end.direction) {
						bfs.clear();
						tempBfs.clear();

						break;
					}
				}

				tempD = p.direction - 1; // 왼쪽 90도 회전

				if (tempD < 0) {
					tempD = 3;
				}

				if (isVisit[p.r][p.c][tempD] == false) {
					bfs.add(new Point(p.r, p.c, tempD));
					isVisit[p.r][p.c][tempD] = true;

					if (p.r == end.r && p.c == end.c && tempD == end.direction) {
						bfs.clear();
						tempBfs.clear();

						break;
					}
				}

				for (int d = 1; d <= 3; d++) { // 1 ~ 3만큼 이동
					int rr = p.r + dr[p.direction] * d;
					int cc = p.c + dc[p.direction] * d;

					if (0 <= rr && rr < rowSize && 0 <= cc && cc < colSize) {
						if (map[rr][cc] == 0) {
							if (isVisit[rr][cc][p.direction] == false) {
								if (rr == end.r && cc == end.c && p.direction == end.direction) {
									bfs.clear();
									tempBfs.clear();

									break;
								}

								bfs.add(new Point(rr, cc, p.direction));
								isVisit[rr][cc][p.direction] = true;
							}
						}

						else {
							break;
						}
					}

					else {
						break;
					}
				}
			}
		}

		System.out.println(time);
	}

	static class Point {
		int r, c, direction;

		Point(int r, int c, int direction) {
			this.r = r;
			this.c = c;
			this.direction = direction;
		}
	}
}
