import java.io.*;
import java.util.*;

public class Main {
	static int rowSize, colSize;
	static char[][] map; // . : 물, X : 빙판, L : 백조
	static int time = -1;
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };

	static ArrayList<Point> swans = new ArrayList<>();
	static ArrayDeque<Point> bfs = new ArrayDeque<>();
	static ArrayDeque<Point> nextBfs = new ArrayDeque<>(); // 다음에 움직일 백조의 위치
	static ArrayDeque<Point> melt = new ArrayDeque<>(); // 녹는 빙하의 위치를 저장
	static ArrayDeque<Point> nextMelt = new ArrayDeque<>(); // 녹는 빙하의 위치를 저장
	static boolean[][] isVisit;
	static boolean[][] isMelt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		rowSize = Integer.parseInt(st.nextToken());
		colSize = Integer.parseInt(st.nextToken());

		map = new char[rowSize][colSize];
		isVisit = new boolean[rowSize][colSize];
		isMelt = new boolean[rowSize][colSize];

		for (int r = 0; r < rowSize; r++) {
			char[] line = br.readLine().toCharArray();

			for (int c = 0; c < colSize; c++) {
				map[r][c] = line[c];

				if (map[r][c] == 'L') {
					swans.add(new Point(r, c));
				}
			}
		}

		// 입력 끝

		// 녹일 빙하 먼저 찾기

		for (int r = 0; r < rowSize; r++) {
			for (int c = 0; c < colSize; c++) {
				if (map[r][c] == 'X') { // 현재 위치가 빙하이고
					for (int d = 0; d < 4; d++) {
						int rr = r + dr[d];
						int cc = c + dc[d];

						if (0 <= rr && rr < rowSize && 0 <= cc && cc < colSize) {
							if (map[rr][cc] != 'X') { // 주변에 물이 있다면
								melt.add(new Point(r, c)); // 녹을 예정

								break;
							}
						}
					}
				}
			}
		}

		// 녹일 빙하 찾기 끝

		// 탐색

		bfs.add(swans.get(0));
		isVisit[swans.get(0).r][swans.get(0).c] = true;

		end: while (true) {
			time += 1;

			// 백조가 만나는지 확인
			while (!bfs.isEmpty()) {
				Point s = bfs.remove();

				for (int d = 0; d < 4; d++) {
					int rr = s.r + dr[d];
					int cc = s.c + dc[d];

					if (0 <= rr && rr < rowSize && 0 <= cc && cc < colSize) {
						if (!isVisit[rr][cc]) {
							isVisit[rr][cc] = true;

							if (map[rr][cc] == 'X') {
								nextBfs.add(new Point(rr, cc)); // 빙하라면 다음 큐에 저장
							}

							else {
								bfs.add(new Point(rr, cc)); // 물이라면 즉시 이동

								if (swans.get(1).r == rr && swans.get(1).c == cc) { // 만났다면 종료
									break end;
								}
							}
						}
					}
				}
			}

			bfs = nextBfs.clone();
			nextBfs.clear();
			// 탐색 종료

			// 빙하 녹이기
			while (!melt.isEmpty()) { // 녹임 적용
				Point m = melt.remove();

				int r = m.r;
				int c = m.c;

				map[r][c] = '.';

				for (int d = 0; d < 4; d++) { // 녹은 빙하의 4면에 빙하가 있는지 확인
					int rr = r + dr[d];
					int cc = c + dc[d];

					if (0 <= rr && rr < rowSize && 0 <= cc && cc < colSize) { // 범위 안에 있고
						if (map[rr][cc] == 'X') {
							if (isMelt[rr][cc] == false) {

								isMelt[rr][cc] = true;
								nextMelt.add(new Point(rr, cc));
							}
						}
					}
				}
			}

			melt = nextMelt.clone();
			nextMelt.clear();
		}

		System.out.println(time);
	}

	static class Point {
		int r, c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
