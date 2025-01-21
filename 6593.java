import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		while (true) {
			int pageSize, rowSize, colSize; // 빌딩의 높이, 가로, 세로의 길이
			char[][][] building; // 빌딩
			Point start = new Point(0, 0, 0);

			st = new StringTokenizer(br.readLine());

			pageSize = Integer.parseInt(st.nextToken());
			rowSize = Integer.parseInt(st.nextToken());
			colSize = Integer.parseInt(st.nextToken());

			if (pageSize == 0 && rowSize == 0 && colSize == 0) {
				break;
			}

			building = new char[pageSize][rowSize][colSize];

			for (int p = 0; p < pageSize; p++) { // 빌딩, 시작점, 도착점 입력
				for (int r = 0; r < rowSize; r++) {
					String temp = br.readLine();

					for (int c = 0; c < colSize; c++) {
						building[p][r][c] = temp.charAt(c);

						if (building[p][r][c] == 'S') {
							start.p = p;
							start.r = r;
							start.c = c;
						}
					}
				}

				String temp = br.readLine(); // 띄어쓰기 지우기
			}

			ArrayDeque<Point> bfs = new ArrayDeque<>();
			boolean[][][] isVisit = new boolean[pageSize][rowSize][colSize];

			bfs.add(start);
			isVisit[start.p][start.r][start.c] = true;

			int time = 0;
			boolean flag = false;

			int[] dp = { 0, 0, 0, 0, -1, 1 }; // 상하좌우위아래
			int[] dr = { -1, 1, 0, 0, 0, 0 };
			int[] dc = { 0, 0, -1, 1, 0, 0 };
			while (!bfs.isEmpty()) {
				time += 1;

				ArrayDeque<Point> tempBfs = new ArrayDeque<>(bfs);
				bfs.clear();

				while (!tempBfs.isEmpty()) {
					Point p = tempBfs.removeFirst();

					for (int d = 0; d < 6; d++) {
						int pp = p.p + dp[d];
						int rr = p.r + dr[d];
						int cc = p.c + dc[d];

						if (0 <= pp && pp < pageSize && 0 <= rr && rr < rowSize && 0 <= cc && cc < colSize) { // 범위 안에
																												// 있고
							if (building[pp][rr][cc] != '#') { // 갈 수 있는 길이고
								if (isVisit[pp][rr][cc] == false) { // 가지 않은 길이라면
									if (building[pp][rr][cc] == 'E') { // 도착 지점이라면
										bfs.clear();
										tempBfs.clear();

										flag = true;

										break;
									}

									else {
										bfs.add(new Point(pp, rr, cc)); // 방문 예정
										isVisit[pp][rr][cc] = true;
									}
								}
							}
						}
					}
				}
			}

			if (flag) { // 탈출할 길을 찾았다면
				sb.append("Escaped in ").append(time).append(" minute(s).").append("\n");
			}

			else { // 못찾았다면
				sb.append("Trapped!").append("\n");
			}
		}

		System.out.println(sb);
	}

	public static class Point {
		int p, r, c;

		Point(int p, int r, int c) {
			this.p = p;
			this.r = r;
			this.c = c;
		}
	}
}
