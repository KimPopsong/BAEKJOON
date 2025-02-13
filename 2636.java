import java.io.*;
import java.util.*;

public class Main {
	static int rowSize, colSize;
	static int[][] map; // 0 : 공기, 1 : 치즈, 2 : 다음 시간에 녹을 치즈
	static boolean[][] isVisit;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());

		rowSize = Integer.parseInt(st.nextToken()); // 가장자리는 공기가 들어가야 하므로 가장자리의 크기만큼 키우기
		colSize = Integer.parseInt(st.nextToken());

		map = new int[rowSize][colSize];

		for (int r = 0; r < rowSize; r++) {
			st = new StringTokenizer(br.readLine());

			for (int c = 0; c < colSize; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		ArrayDeque<Point> cheeseMelt = new ArrayDeque<>(); // 녹을 치즈
		isVisit = new boolean[rowSize][colSize];

		{ // 맨 처음 녹을 치즈 선별
			ArrayDeque<Point> findMeltCheese = new ArrayDeque<>();
			findMeltCheese.add(new Point(0, 0)); // 가장자리 부분은 항상 공기

			while (!findMeltCheese.isEmpty()) {
				Point air = findMeltCheese.remove();

				for (int d = 0; d < 4; d++) {
					int rr = air.r + dr[d];
					int cc = air.c + dc[d];

					if (0 <= rr && rr < rowSize && 0 <= cc && cc < colSize) { // 범위 안에 있고
						if (isVisit[rr][cc] == false) { // 방문하지 않았다면
							isVisit[rr][cc] = true; // 방문 처리

							if (map[rr][cc] == 0) { // 공기라면
								findMeltCheese.add(new Point(rr, cc)); // 방문 예정에 넣기
							}

							else if (map[rr][cc] == 1) { // 치즈라면
								cheeseMelt.add(new Point(rr, cc)); // 녹일 예정에 넣기
							}
						}
					}
				}
			}
		}

		// 치즈 녹이기
		int time = 0;
		int leftCheese = 0;
		while (!cheeseMelt.isEmpty()) {
			time += 1;
			leftCheese = cheeseMelt.size();

			ArrayDeque<Point> airs = new ArrayDeque<>();

			while (!cheeseMelt.isEmpty()) {
				Point cheese = cheeseMelt.remove();

				map[cheese.r][cheese.c] = 0;
				airs.add(cheese);
			}

			while (!airs.isEmpty()) {
				Point air = airs.remove();

				for (int d = 0; d < 4; d++) {
					int rr = air.r + dr[d];
					int cc = air.c + dc[d];

					if (0 <= rr && rr < rowSize && 0 <= cc && cc < colSize) { // 범위 안에 있고
						if (isVisit[rr][cc] == false) { // 방문하지 않았다면
							isVisit[rr][cc] = true; // 방문 처리

							if (map[rr][cc] == 0) { // 공기라면
								airs.add(new Point(rr, cc)); // 방문 예정에 넣기
							}

							else if (map[rr][cc] == 1) { // 치즈라면
								cheeseMelt.add(new Point(rr, cc)); // 녹일 예정에 넣기
							}
						}
					}
				}
			}
		}

		System.out.println(time);
		System.out.println(leftCheese);
	}

	static class Point {
		int r, c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
