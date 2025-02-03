
//https://www.acmicpc.net/problem/26153
import java.io.*;
import java.util.*;

class Main {
	static int rowSize, colSize; // 맵의 크기
	static int myR, myC, materialNumber; // 내 땅의 좌표, 재료의 개수
	static int maxWater = 0; // 최대로 끌어올 수 있는 물의 양
	static int[][] map; // 지도
	static boolean[][] isVisit; // 지도

	static int[] dr = { -1, 0, 1, 0 }; // 짝수 index는 세로, 홀수 index는 가로
	static int[] dc = { 0, -1, 0, 1 }; // 상좌하우 순

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine(), " ");

		rowSize = Integer.parseInt(st.nextToken());
		colSize = Integer.parseInt(st.nextToken());

		map = new int[rowSize][colSize];
		isVisit = new boolean[rowSize][colSize];

		for (int i = 0; i < rowSize; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < colSize; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine(), " ");

		myR = Integer.parseInt(st.nextToken());
		myC = Integer.parseInt(st.nextToken());
		materialNumber = Integer.parseInt(st.nextToken());

		isVisit[myR][myC] = true;
		maxWater = map[myR][myC];
		for (int d = 0; d < 4; d++) { // 4방 탐색
			int rr = myR + dr[d];
			int cc = myC + dc[d];

			if (0 <= rr && rr < rowSize && 0 <= cc && cc < colSize) { // 범위 안에 있고
				isVisit[rr][cc] = true;

				if ((d % 2) == 0) { // 세로 이동이라면
					bruteForce(materialNumber - 1, map[myR][myC] + map[rr][cc], new Point(rr, cc), 0);
				}

				else {
					bruteForce(materialNumber - 1, map[myR][myC] + map[rr][cc], new Point(rr, cc), 1);
				}

				isVisit[rr][cc] = false;
			}
		}

		System.out.println(maxWater);
	}

	static class Point {
		int r, c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	/**
	 * 
	 * @param material
	 * @param sumWater
	 * @param p
	 * @param direction 0은 세로, 1은 가로
	 */
	static void bruteForce(int material, int sumWater, Point p, int direction) {
		if (material < 0) {
			return;
		}

		else if (material == 0) {
			maxWater = Math.max(maxWater, sumWater);

			return;
		}

		else {
			maxWater = Math.max(maxWater, sumWater);
		}

		for (int d = 0; d < 4; d++) { // 4방 탐색
			int rr = p.r + dr[d];
			int cc = p.c + dc[d];

			if (0 <= rr && rr < rowSize && 0 <= cc && cc < colSize) { // 범위 안에 있고
				if (isVisit[rr][cc] == false) { // 방문하지 않았다면
					isVisit[rr][cc] = true;

					if (direction == (d % 2)) { // 이전과 방향이 같다면 꺾을 필요가 없음
						bruteForce(material - 1, sumWater + map[rr][cc], new Point(rr, cc), direction);
					}

					else {
						bruteForce(material - 2, sumWater + map[rr][cc], new Point(rr, cc), d % 2);
					}

					isVisit[rr][cc] = false;
				}
			}
		}
	}
}
