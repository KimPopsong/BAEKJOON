import java.io.*;
import java.util.*;

public class Main {
	static int mapSize, sharkNumber, nowSharkNumber, scentLeftTime, time = 0;
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static int[][] map;
	static Map[][] sharkMap;
	static Shark[] sharks;

	public static void main(String[] args) throws IOException {
		initialize(); // 초기화

		while (nowSharkNumber != 1 && time < 1000) { // 1번 상어만 남거나, 1000초가 넘을 때까지
			time += 1;

			sharkMove(); // 상어가 이동

			// 현재 상어가 없는 모든 칸에 냄새 -1
			for (int r = 0; r < mapSize; r++) {
				for (int c = 0; c < mapSize; c++) {
					if (sharkMap[r][c].scentLeft > 0 && map[r][c] == 0) {
						sharkMap[r][c].scentLeft -= 1;
					}
				}
			}
		}

		if (nowSharkNumber != 1) {
			System.out.println(-1);
		}

		else {
			System.out.println(time);
		}
	}

	static void sharkMove() {
		int[][] newMap = new int[mapSize][mapSize];

		for (int i = 1; i <= sharkNumber; i++) { // 1번 상어부터 이동
			if (sharks[i] == null) { // 상어가 없다면 무시
				continue;
			}

			Shark shark = sharks[i];

			boolean flag = false;

			// 우선순위 순으로 빈 칸 찾기
			for (int d = 0; d < 4; d++) {
				int direction = shark.priority[shark.direction][d]; // 우선 순위에 따른 방향 선택

				int rr = shark.r + dr[direction];
				int cc = shark.c + dc[direction];

				if (0 <= rr && rr < mapSize && 0 <= cc && cc < mapSize) {
					if (sharkMap[rr][cc].scentLeft == 0) { // 상어 냄새가 없다면
						flag = true;

						if (newMap[rr][cc] == 0) { // 움직이려는 자리에 상어가 없다면
							shark.direction = direction; // 상어 이동
							shark.r = rr;
							shark.c = cc;

							newMap[rr][cc] = shark.number;
						}

						else { // 상어가 있다면
							sharks[i] = null; // 상어 사망
							nowSharkNumber -= 1;
						}

						break;
					}
				}
			}

			if (!flag) { // 갈 길을 못찾았다면
				for (int d = 0; d < 4; d++) { // 자신의 냄새 따라가기
					int direction = shark.priority[shark.direction][d]; // 우선 순위에 따른 방향 선택

					int rr = shark.r + dr[direction];
					int cc = shark.c + dc[direction];

					if (0 <= rr && rr < mapSize && 0 <= cc && cc < mapSize) {
						if (sharkMap[rr][cc].scentLeft != 0 && sharkMap[rr][cc].shark == i) { // 자신의 냄새를 찾았다면
							flag = true;

							if (newMap[rr][cc] == 0) { // 움직이려는 자리에 상어가 없다면
								shark.direction = direction; // 상어 이동
								shark.r = rr;
								shark.c = cc;

								newMap[rr][cc] = shark.number;
							}

							else { // 상어가 있다면
								sharks[i] = null; // 상어 사망
								nowSharkNumber -= 1;
							}

							break;
						}
					}
				}
			}
		}

		for (int r = 0; r < mapSize; r++) {
			for (int c = 0; c < mapSize; c++) {
				map[r][c] = newMap[r][c];
			}
		}

		for (int i = 1; i <= sharkNumber; i++) {
			if (sharks[i] == null) { // 상어가 없다면 무시
				continue;
			}

			Shark shark = sharks[i];

			sharkMap[shark.r][shark.c].shark = shark.number;
			sharkMap[shark.r][shark.c].scentLeft = scentLeftTime;
		}
	}

	static void initialize() throws IOException { // 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());

		mapSize = Integer.parseInt(st.nextToken());
		sharkNumber = Integer.parseInt(st.nextToken());
		scentLeftTime = Integer.parseInt(st.nextToken());

		nowSharkNumber = sharkNumber;
		map = new int[mapSize][mapSize];
		sharkMap = new Map[mapSize][mapSize];
		sharks = new Shark[sharkNumber + 1];

		for (int r = 0; r < mapSize; r++) { // map 입력
			st = new StringTokenizer(br.readLine());

			for (int c = 0; c < mapSize; c++) {
				int n = Integer.parseInt(st.nextToken());

				if (n != 0) {
					Shark shark = new Shark(n, r, c);

					sharks[n] = shark;

					map[r][c] = n;
					sharkMap[r][c] = new Map(n, scentLeftTime);
				}

				else {
					sharkMap[r][c] = new Map(0, 0);
				}
			}
		}

		st = new StringTokenizer(br.readLine()); // 상어의 방향 입력
		for (int i = 1; i <= sharkNumber; i++) {
			sharks[i].direction = Integer.parseInt(st.nextToken()) - 1;
		}

		for (int i = 1; i <= sharkNumber; i++) { // 상어의 방향 우선순위 입력
			for (int j = 0; j < 4; j++) {
				st = new StringTokenizer(br.readLine());

				for (int k = 0; k < 4; k++) {
					sharks[i].priority[j][k] = Integer.parseInt(st.nextToken()) - 1;
				}
			}
		}
	}

	static class Shark {
		int number; // 상어의 번호
		int r, c; // 상어의 좌표
		int direction; // 상어가 바라보는 방향
		int[][] priority = new int[4][4]; // 바라보는 방향별 우선순위

		public Shark(int number, int r, int c) {
			this.number = number;
			this.r = r;
			this.c = c;
		}
	}

	static class Map {
		int shark; // 냄새를 남긴 상어의 번호
		int scentLeft;

		public Map(int shark, int scentLeft) {
			this.shark = shark;
			this.scentLeft = scentLeft;
		}

		void add(int shark) {
			this.shark = shark;
			scentLeft = scentLeftTime;
		}
	}
}
