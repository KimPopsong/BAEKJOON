import java.io.*;
import java.util.*;

public class Main {
	static int rowSize, colSize, canLeft, canRight, canGo;
	static int[][] map;
	static Point start;
	static ArrayDeque<Point> bfs = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		rowSize = Integer.parseInt(st.nextToken());
		colSize = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		canLeft = Integer.parseInt(st.nextToken());
		canRight = Integer.parseInt(st.nextToken());

		map = new int[rowSize][colSize];
		for (int r = 0; r < rowSize; r++) {
			String temp = br.readLine();

			for (int c = 0; c < colSize; c++) {
				map[r][c] = temp.charAt(c) - '0';

				if (map[r][c] == 2) {
					start = new Point(r, c, canLeft, canRight);
					canGo += 1;

					bfs.add(start);
				}
			}
		}

		int[] dr = { -1, 1 };

		while (!bfs.isEmpty()) {
			Point p = bfs.removeFirst();

			for (int d = 0; d < 2; d++) { // 세로 이동
				int rr = p.r + dr[d];

				while (0 <= rr && rr < rowSize) {
					if (map[rr][p.c] == 0) {
						map[rr][p.c] = 2;
						canGo += 1;

						bfs.add(new Point(rr, p.c, p.left, p.right));
					}

					else if (map[rr][p.c] == 1) {
						break;
					}

					rr = rr + dr[d];
				}
			}

			if (p.left > 0) { // 왼쪽 이동
				int cc = p.c - 1;

				if (0 <= cc) {
					if (map[p.r][cc] == 0) {
						map[p.r][cc] = 2;
						canGo += 1;

						bfs.add(new Point(p.r, cc, p.left - 1, p.right));
					}
				}
			}

			if (p.right != 0) { // 오른쪽 이동
				int cc = p.c + 1;

				if (cc < colSize) {
					if (map[p.r][cc] == 0) {
						map[p.r][cc] = 2;
						canGo += 1;

						bfs.add(new Point(p.r, cc, p.left, p.right - 1));
					}
				}
			}
		}

		System.out.println(canGo);
	}

	static class Point {
		int r, c;
		int left, right;

		Point(int r, int c, int left, int right) {
			this.r = r;
			this.c = c;
			this.left = left;
			this.right = right;
		}
	}
}
