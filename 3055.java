import java.io.*;
import java.util.*;

public class Main {
	static int rowSize, colSize;
	static char[][] map;
	static Point start, end;
	static ArrayDeque<Point> water = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());

		rowSize = Integer.parseInt(st.nextToken());
		colSize = Integer.parseInt(st.nextToken());

		map = new char[rowSize][colSize];

		for (int r = 0; r < rowSize; r++) {
			char[] temp = br.readLine().toCharArray();

			for (int c = 0; c < colSize; c++) {
				map[r][c] = temp[c];

				if (map[r][c] == 'S') {
					start = new Point(r, c);
				}

				else if (map[r][c] == 'D') {
					end = new Point(r, c);
				}

				else if (map[r][c] == '*') {
					water.add(new Point(r, c));
				}
			}
		}

		boolean flag = false;
		int time = 0;
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		ArrayDeque<Point> bfs = new ArrayDeque<>();
		bfs.add(start);

		while (!bfs.isEmpty() || !water.isEmpty()) {
			time += 1;

			ArrayDeque<Point> tempWater = new ArrayDeque<>(water);
			water.clear();

			while (!tempWater.isEmpty()) {
				Point p = tempWater.remove();

				for (int d = 0; d < 4; d++) {
					int rr = p.r + dr[d];
					int cc = p.c + dc[d];

					if (0 <= rr && rr < rowSize && 0 <= cc && cc < colSize) {
						if (map[rr][cc] == '.' || map[rr][cc] == 'S') {
							map[rr][cc] = '*';
							water.add(new Point(rr, cc));
						}
					}
				}
			}

			ArrayDeque<Point> temp = new ArrayDeque<>(bfs);
			bfs.clear();

			while (!temp.isEmpty()) {
				Point p = temp.remove();

				for (int d = 0; d < 4; d++) {
					int rr = p.r + dr[d];
					int cc = p.c + dc[d];

					if (0 <= rr && rr < rowSize && 0 <= cc && cc < colSize) {
						if (map[rr][cc] == '.' || map[rr][cc] == 'D') {
							map[rr][cc] = 'S';
							bfs.add(new Point(rr, cc));

							if (rr == end.r && cc == end.c) {
								flag = true;

								bfs.clear();
								water.clear();
								temp.clear();

								break;
							}
						}
					}
				}
			}
		}

		if (flag) {
			System.out.println(time);
		}

		else {
			System.out.println("KAKTUS");
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
