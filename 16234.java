import java.io.*;
import java.util.*;

class Main {
	static int landSize, gapMin, gapMax; // 땅의 크기, 인구 이동의 최솟값, 최댓값
	static int time = 0; // 인구 이동이 발생하는 일 수
	static int[][] land; // 땅
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().split(" ");

		landSize = Integer.parseInt(temp[0]);
		gapMin = Integer.parseInt(temp[1]);
		gapMax = Integer.parseInt(temp[2]);

		land = new int[landSize][landSize];

		for (int i = 0; i < landSize; i++) {
			temp = br.readLine().split(" ");

			for (int j = 0; j < landSize; j++) {
				land[i][j] = Integer.parseInt(temp[j]);
			}
		}

		while (true) // 인구이동 시작
		{
			ArrayDeque<ArrayDeque<Point>> move = new ArrayDeque<>(); // 인구 이동이 일어나는 나라를 저장하고 한꺼번에 이동
			boolean[][] isVisit = new boolean[landSize][landSize];

			boolean flag = false;

			for (int r = 0; r < landSize; r++) {
				for (int c = 0; c < landSize; c++) {
					if (isVisit[r][c] == false) // 탐색하지 않았다면
					{
						ArrayDeque<Point> searched = new ArrayDeque<>(); // 탐색한 나라의 목록 저장
						ArrayDeque<Point> bfs = new ArrayDeque<>();

						searched.add(new Point(r, c));
						bfs.add(new Point(r, c));
						isVisit[r][c] = true;

						while (!bfs.isEmpty()) // 주변 국가 탐색
						{
							Point point = bfs.remove();

							for (int i = 0; i < 4; i++) {
								int rr = point.r + dr[i];
								int cc = point.c + dc[i];

								if (0 <= rr && rr < landSize && 0 <= cc && cc < landSize) { // 범위 안에 있고
									if (isVisit[rr][cc] == false) { // 방문하지 않았고
										int gap = Math.abs(land[point.r][point.c] - land[rr][cc]);

										if (gapMin <= gap && gap <= gapMax) { // 인구의 차이가 gap 사이라면
											searched.add(new Point(rr, cc));
											bfs.add(new Point(rr, cc));
											isVisit[rr][cc] = true;
										}
									}
								}
							}
						}

						if (searched.size() >= 2) {
							move.add(searched);
						}
					}

				}
			}

			for (ArrayDeque<Point> nations : move) // move에 들어간 나라들 인구이동 시키기
			{
				int moveNationsNumber = nations.size();
				int sumNations = 0;
				int aveNations;

				for (Point point : nations) {
					sumNations += land[point.r][point.c];
				}

				aveNations = (int) Math.floor(sumNations / moveNationsNumber); // 인구의 평균 구해주기

				for (Point point : nations) {
					if (land[point.r][point.c] == aveNations) // 현재 인구가 인구의 평균과 같다면
					{
						continue; // 인구이동 없음
					}

					else // 인구 이동
					{
						land[point.r][point.c] = aveNations;

						flag = true;
					}
				}
			}

			if (!flag) // 이동한 나라가 없으면 탈출
			{
				break;
			}

			else {
				time += 1;
			}
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
