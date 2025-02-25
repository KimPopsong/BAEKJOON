import java.io.*;
import java.util.*;

class Main {
	static final int SIZE = 4;

	static int eatMax = 0;
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 }; // 12시부터 반시계 방향
	static int[] dc = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static Point[] fishIndex = new Point[SIZE * SIZE + 1]; // 번호에 맞는 물고기가 어디 칸에 있는지 저장
	static Fish[][] map = new Fish[SIZE][SIZE];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		for (int r = 0; r < SIZE; r++) {
			st = new StringTokenizer(br.readLine());

			for (int c = 0; c < SIZE; c++) {
				int size = Integer.parseInt(st.nextToken());
				int direction = Integer.parseInt(st.nextToken());

				map[r][c] = new Fish(size, direction - 1);
				fishIndex[size] = new Point(r, c);
			}
		}

		Fish sharkInfo = new Fish(map[0][0].size, map[0][0].direction);
		Point sharkLocation = new Point(0, 0);
		fishIndex[map[0][0].size] = null;
		map[0][0] = null;

		bruteForce(map, sharkLocation, sharkInfo, fishIndex);

		System.out.println(eatMax);
	}

	static void moveFish(Fish[][] newMap, Point sharkLocation, Fish sharkInfo, Point[] newFishIndex) { // 물고기 이동
		for (int i = 1; i <= SIZE * SIZE; i++) { // 1번 물고기부터 이동
			if (newFishIndex[i] == null) { // 이미 잡아먹혔다면 생략
				continue;
			}

			// 물고기는 한 칸을 이동
			// 빈 칸이나 다른 물고기가 있는 칸으로 이동 가능

			Fish fish = newMap[newFishIndex[i].r][newFishIndex[i].c];
			int destR = newFishIndex[i].r;
			int destC = newFishIndex[i].c;

			for (int j = 0; j < 8; j++) {
				int rr = destR + dr[fish.direction];
				int cc = destC + dc[fish.direction];

				if (0 <= rr && rr < SIZE && 0 <= cc && cc < SIZE) { // 범위 안에 있고
					if (rr != sharkLocation.r || cc != sharkLocation.c) { // 상어가 아니라면
						// 이동
						if (newMap[rr][cc] == null) { // 이동할 곳이 이미 비었다면
							newFishIndex[i] = new Point(rr, cc);

							newMap[rr][cc] = new Fish(fish);
							newMap[destR][destC] = null;
						}

						else { // 물고기가 있다면
							Fish moveFish = new Fish(newMap[rr][cc]);

							newFishIndex[moveFish.size] = new Point(destR, destC);
							newFishIndex[i] = new Point(rr, cc);

							newMap[destR][destC] = moveFish;
							newMap[rr][cc] = fish;
						}

						break;
					}
				}

				fish.direction += 1;

				if (fish.direction >= 8) {
					fish.direction = 0;
				}
			}
		}
	}

	static void bruteForce(Fish[][] newMap, Point sharkLocation, Fish sharkInfo, Point[] newFishIndex) {
		moveFish(newMap, sharkLocation, sharkInfo, newFishIndex);

		for (int d = 1; d <= 3; d++) { // 상어 이동
			// 상어는 최대 3번 이동 가능

			boolean canMove = true;

			Point newSharkLocation = new Point(sharkLocation);
			Fish newSharkInfo = new Fish(sharkInfo);

			newSharkLocation.r = sharkLocation.r + dr[newSharkInfo.direction] * d;
			newSharkLocation.c = sharkLocation.c + dc[newSharkInfo.direction] * d;

			// 범위 안에 있다면
			if (0 <= newSharkLocation.r && newSharkLocation.r < SIZE && 0 <= newSharkLocation.c
					&& newSharkLocation.c < SIZE) {
				if (newMap[newSharkLocation.r][newSharkLocation.c] != null) { // 물고기가 있다면
					// 물고기를 잡아먹고 이동

					Fish[][] newNewMap = new Fish[SIZE][SIZE];
					Point[] newNewFishIndex = new Point[SIZE * SIZE + 1];

					for (int r = 0; r < SIZE; r++) {
						for (int c = 0; c < SIZE; c++) {
							if (newMap[r][c] == null) {
								newNewMap[r][c] = null;
							}

							else {
								newNewMap[r][c] = new Fish(newMap[r][c]);
							}
						}
					}

					for (int i = 1; i <= SIZE * SIZE; i++) {
						if (newFishIndex[i] == null) {
							newNewFishIndex[i] = null;
						}

						else {
							newNewFishIndex[i] = new Point(newFishIndex[i]);
						}
					}

					Fish eatenFish = newNewMap[newSharkLocation.r][newSharkLocation.c];
					newNewFishIndex[eatenFish.size] = null;
					newSharkInfo.direction = eatenFish.direction;
					newSharkInfo.size = sharkInfo.size + eatenFish.size;
					newNewMap[newSharkLocation.r][newSharkLocation.c] = null;

					bruteForce(newNewMap, newSharkLocation, newSharkInfo, newNewFishIndex);
				}

				else { // 움직일 수 없다면
					canMove = false;
				}
			}

			else { // 움직일 수 없다면
				canMove = false;
			}

			if (canMove == false) { // 움직일 수 없다면
				eatMax = Math.max(eatMax, newSharkInfo.size);
			}
		}
	}

	static class Fish {
		int size;
		int direction;

		Fish(int size, int direction) {
			this.size = size;
			this.direction = direction;
		}

		Fish(Fish fish) {
			this.size = fish.size;
			this.direction = fish.direction;
		}
	}

	static class Point {
		int r, c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

		Point(Point point) {
			this.r = point.r;
			this.c = point.c;
		}
	}
}
