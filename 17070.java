import java.io.*;
import java.util.*;

class Main {
	static int size, count;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		size = Integer.parseInt(br.readLine());
		map = new int[size][size];

		for (int r = 0; r < size; r++) {
			st = new StringTokenizer(br.readLine());

			for (int c = 0; c < size; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		// 입력부 종료

		dfs(0, 1, 1); // 가로로 시작

		System.out.println(count);
	}

	/**
	 * 
	 * @param r
	 * @param c
	 * @param direction 이전 파이프의 방향, -1 : 세로, 0 : 대각선, 1 : 가로
	 */
	static void dfs(int r, int c, int direction) {
		if (r == size - 1 && c == size - 1) { // 도착지에 도착
			count += 1;

			return;
		}

		// 대각선은 항상 이동 가능
		if (r + 1 < size && c + 1 < size) { // 범위 안에 있고
			if (map[r + 1][c] == 0 && map[r][c + 1] == 0 && map[r + 1][c + 1] == 0) { // 벽이 아니라면
				dfs(r + 1, c + 1, 0);
			}
		}

		if (direction != 1) { // 이전 파이프가 가로 방향이 아니라면
			if (r + 1 < size) { // 범위 안에 있고
				if (map[r + 1][c] == 0) { // 벽이 아니라면
					dfs(r + 1, c, -1); // 세로 이동
				}
			}
		}

		if (direction != -1) { // 이전 파이프가 세로 방향이 아니라면
			if (c + 1 < size) { // 범위 안에 있고
				if (map[r][c + 1] == 0) { // 벽이 아니라면
					dfs(r, c + 1, 1); // 가로 이동
				}
			}
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
