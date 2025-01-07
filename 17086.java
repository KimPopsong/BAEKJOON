import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int rowSize, colSize;
		int maxDistance = Integer.MIN_VALUE;
		int[][] map;

		String[] temp = br.readLine().split(" ");

		rowSize = Integer.parseInt(temp[0]);
		colSize = Integer.parseInt(temp[1]);

		map = new int[rowSize][colSize];

		for (int i = 0; i < rowSize; i++) // map 입력
		{
			temp = br.readLine().split(" ");

			for (int j = 0; j < colSize; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}

		int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 }; // 12시 방향부터 시계방향
		int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
		for (int r = 0; r < rowSize; r++) // 탐색
		{
			for (int c = 0; c < colSize; c++) {
				if (map[r][c] == 0) {
					int time = 0;
					ArrayDeque<Point> bfs = new ArrayDeque<>();
					boolean[][] isVisit = new boolean[rowSize][colSize];

					bfs.add(new Point(r, c));
					isVisit[r][c] = true;

					while (!bfs.isEmpty()) // 안전거리 확인
					{
						time += 1;

						ArrayDeque<Point> tempBfs = new ArrayDeque<>(bfs);
						bfs.clear();

						while (!tempBfs.isEmpty()) {
							Point point = tempBfs.remove();

							for (int d = 0; d < 8; d++) {
								int rr = point.r + dr[d];
								int cc = point.c + dc[d];

								if (0 <= rr && rr < rowSize && 0 <= cc && cc < colSize) // 범위 안에 있고
								{
									if (isVisit[rr][cc] == false) // 방문을 안했다면
									{
										if (map[rr][cc] == 1) // 다른 아기 상어를 만났다면
										{
											bfs.clear(); // 탐색 중단
											tempBfs.clear();

											maxDistance = Math.max(maxDistance, time);

											break;
										}

										else {
											bfs.add(new Point(rr, cc));
											isVisit[rr][cc] = true;
										}
									}
								}
							}
						}
					}
				}
			}
		}

		System.out.println(maxDistance);
	}

	static class Point {
		int r, c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
