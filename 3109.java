import java.io.*;
import java.util.*;

public class Main {
	static int rowSize, colSize; // 행렬의 크기
	static int count = 0;
	static boolean[][] isVisit;
	static String[] map;

	static Point[][] findRoot;
	static int[] dr = { 1, 0, -1 }; // dfs로 오른쪽 위부터 탐색

	public static void main(String[] args) throws IOException {
		initialize();

		for (int r = 0; r < rowSize; r++) { // 맨 위쪽 행부터 탐색
			ArrayDeque<Point> dfs = new ArrayDeque<>();

			dfs.add(new Point(r, 0));
			findRoot[r][0] = new Point(r, 0);

			while (!dfs.isEmpty()) {
				Point p = dfs.removeFirst();
				isVisit[p.r][p.c] = true;

				if (p.c == colSize - 1) { // 도착 했다면
					count += 1;

					int rr = p.r;
					int cc = p.c;

					while (cc != 0) {
						isVisit[rr][cc] = true;

						int rrr = findRoot[rr][cc].r;
						int ccc = findRoot[rr][cc].c;
						rr = rrr;
						cc = ccc;
					}

					break;
				}

				for (int d = 0; d < 3; d++) {
					int rr = p.r + dr[d];

					if (0 <= rr && rr < rowSize) { // 범위 안에 있고
						if (map[rr].charAt(p.c + 1) == '.') { // 갈 수 있는 길이고
							if (isVisit[rr][p.c + 1] == false) { // 가지 않은 길이라면
								// 방문
								dfs.addFirst(new Point(rr, p.c + 1));
								findRoot[rr][p.c + 1] = new Point(p.r, p.c);
							}
						}
					}
				}
			}
		}

		System.out.println(count);
	}

	private static void initialize() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());

		rowSize = Integer.parseInt(st.nextToken());
		colSize = Integer.parseInt(st.nextToken());
		isVisit = new boolean[rowSize][colSize];
		map = new String[rowSize];
		findRoot = new Point[rowSize][];

		for (int r = 0; r < rowSize; r++) {
			map[r] = br.readLine();
			findRoot[r] = new Point[colSize];
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
