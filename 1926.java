import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int rowSize, colSize;
		int paintNumber = 0, paintMaxSize = 0;
		int[][] canvas;

		String[] temp = br.readLine().split(" ");

		rowSize = Integer.parseInt(temp[0]);
		colSize = Integer.parseInt(temp[1]);

		canvas = new int[rowSize][colSize];

		for (int i = 0; i < rowSize; i++) {
			temp = br.readLine().split(" ");

			for (int j = 0; j < colSize; j++) {
				canvas[i][j] = Integer.parseInt(temp[j]);
			}
		}

		boolean[][] isVisit = new boolean[rowSize][colSize];
		ArrayDeque<Point> bfs = new ArrayDeque<>();

		int[] dr = { -1, 1, 0, 0 }; // 상하좌우 순
		int[] dc = { 0, 0, -1, 1 };
		for (int r = 0; r < rowSize; r++) // 탐색
		{
			for (int c = 0; c < colSize; c++) {
				if (canvas[r][c] == 1) // 그림이 그려져 있고
				{
					if (isVisit[r][c] == false) // 확인하지 않았다면
					{
						int paintSize = 0;
						paintNumber += 1;

						bfs.add(new Point(r, c));
						isVisit[r][c] = true;

						while (!bfs.isEmpty()) {
							paintSize += 1;

							Point point = bfs.remove();

							for (int d = 0; d < 4; d++) {
								int rr = point.r + dr[d];
								int cc = point.c + dc[d];

								if (0 <= rr && rr < rowSize && 0 <= cc && cc < colSize) {
									if (canvas[rr][cc] == 1) {
										if (isVisit[rr][cc] == false) {
											bfs.add(new Point(rr, cc));
											isVisit[rr][cc] = true;
										}
									}
								}
							}
						}

						paintMaxSize = Math.max(paintMaxSize, paintSize);
					}
				}
			}
		}

		System.out.println(paintNumber);
		System.out.println(paintMaxSize);
	}

	static class Point {
		int r, c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
