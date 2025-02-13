import java.io.*;
import java.util.*;

public class Main {
	static int rowSize, colSize;
	static char[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());

		rowSize = Integer.parseInt(st.nextToken());
		colSize = Integer.parseInt(st.nextToken());
		ArrayDeque<Point> jihun = new ArrayDeque<>(); // 지훈이가 갈 경로
		ArrayDeque<Point> fire = new ArrayDeque<>(); // 불이 퍼지는 경로

		map = new char[rowSize][colSize];

		for (int r = 0; r < rowSize; r++) {
			char[] line = br.readLine().toCharArray(); // 한 번에 문자 배열로 변환
			System.arraycopy(line, 0, map[r], 0, colSize);

			for (int c = 0; c < colSize; c++) { // 지훈이와 불의 위치 확인 후 넣기
				if (map[r][c] == 'J') {
					jihun.add(new Point(r, c));
				}

				else if (map[r][c] == 'F') {
					fire.add(new Point(r, c));
				}
			}
		}

		int time = 0;
		boolean flag = false;
		end: while (!jihun.isEmpty()) {
			time += 1;

			// 불 먼저 이동
			ArrayDeque<Point> fireTemp = fire.clone();
			fire.clear();

			while (!fireTemp.isEmpty()) { // 불 퍼뜨리기
				Point f = fireTemp.remove();

				for (int d = 0; d < 4; d++) {
					int rr = f.r + dr[d];
					int cc = f.c + dc[d];

					if (0 <= rr && rr < rowSize && 0 <= cc && cc < colSize) { // 범위 안에 있고
						if (map[rr][cc] == '.' || map[rr][cc] == 'J') { // 벽이 아니라면
							fire.add(new Point(rr, cc));
							map[rr][cc] = 'F';
						}
					}
				}
			}

			// 지훈 이동
			ArrayDeque<Point> jihunTemp = jihun.clone();
			jihun.clear();

			while (!jihunTemp.isEmpty()) {
				Point j = jihunTemp.remove();

				for (int d = 0; d < 4; d++) {
					int rr = j.r + dr[d];
					int cc = j.c + dc[d];

					if (0 <= rr && rr < rowSize && 0 <= cc && cc < colSize) {
						if (map[rr][cc] == '.') { // 빈 공간이면
							jihun.add(new Point(rr, cc));
							map[rr][cc] = 'J';
						}
					}

					else { // 탈출 성공
						flag = true;

						break end;
					}
				}
			}
		}

		if (flag) {
			System.out.println(time);
		}

		else {
			System.out.println("IMPOSSIBLE");
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
