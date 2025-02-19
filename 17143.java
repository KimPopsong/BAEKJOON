import java.io.*;
import java.util.*;

class Main {
	static int rowSize, colSize, sharkNumber, sharkCatch = 0;
	static int[][] map;
	static PriorityQueue<Shark> sharks = new PriorityQueue<>(); // size가 큰 순으로 정렬

	static int[] dr = { -1, 1, 0, 0 }; // 위, 아래, 오른쪽, 왼쪽 순
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());

		rowSize = Integer.parseInt(st.nextToken());
		colSize = Integer.parseInt(st.nextToken());
		sharkNumber = Integer.parseInt(st.nextToken());

		map = new int[rowSize][colSize];

		for (int number = 1; number <= sharkNumber; number++) { // 상어의 정보 입력 및 저장
			st = new StringTokenizer(br.readLine());

			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());
			int direction = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());

			map[r - 1][c - 1] = number; // 상어의 번호 저장

			if (direction == 1 || direction == 2) { // 벽에 부딪치면 방향을 바꾸고
				speed %= ((rowSize - 1) * 2); // 일정 주기가 반복되므로, speed 보정
			}

			else {
				speed %= ((colSize - 1) * 2);
			}

			Shark shark = new Shark(r - 1, c - 1, number, speed, direction - 1, size);
			sharks.add(shark);
		}

		for (int turn = 0; turn < colSize; turn++) {
			// turn에 맞는 열에 있는 상어 잡아먹기
			for (int r = 0; r < rowSize; r++) {
				if (map[r][turn] != 0) { // 상어가 있다면
					int n = map[r][turn];

					PriorityQueue<Shark> sharkTemp = new PriorityQueue<>(sharks);
					sharks.clear();

					while (!sharkTemp.isEmpty()) {
						Shark s = sharkTemp.remove();

						if (s.number == n) {
							sharkCatch += s.size;

							break;
						}

						else {
							sharks.add(s);
						}
					}
					sharks.addAll(sharkTemp);

					map[r][turn] = 0;

					break;
				}
			}

			// 상어 이동시키기
			for (int r = 0; r < rowSize; r++) { // map 초기화
				for (int c = 0; c < colSize; c++) {
					map[r][c] = 0;
				}
			}

			PriorityQueue<Shark> sharkTemp = new PriorityQueue<>(sharks);
			sharks.clear();

			while (!sharkTemp.isEmpty()) { // 크기 순으로 이동시켜서, 나중에 오는 상어는 잡아먹히기
				Shark sharkMove = sharkTemp.remove();

				if (sharkMove.direction == 0 || sharkMove.direction == 1) { // 세로 이동
					sharkMove.row = sharkMove.row + dr[sharkMove.direction] * sharkMove.speed;

					while (true) { // 상어 이동
						if (sharkMove.row < 0) {
							sharkMove.direction = 1;
							sharkMove.row *= -1;
						}

						else if (sharkMove.row >= rowSize) {
							sharkMove.direction = 0;
							sharkMove.row = rowSize * 2 - sharkMove.row - 2;
						}

						else {
							break;
						}
					}
				}

				else { // 가로 이동
					sharkMove.col = sharkMove.col + dc[sharkMove.direction] * sharkMove.speed;

					while (true) {
						if (sharkMove.col < 0) {
							sharkMove.direction = 2;
							sharkMove.col *= -1;
						}

						else if (sharkMove.col >= colSize) {
							sharkMove.direction = 3;
							sharkMove.col = colSize * 2 - sharkMove.col - 2;
						}

						else {
							break;
						}
					}
				}

				// map에 저장
				if (map[sharkMove.row][sharkMove.col] == 0) { // 상어가 없다면
					map[sharkMove.row][sharkMove.col] = sharkMove.number;
					sharks.add(sharkMove);
				}

				else { // 다른 상어가 있다면
					continue;
				}
			}
		}

		System.out.println(sharkCatch);
	}

	static class Shark implements Comparable<Shark> {
		int row, col; // 상어의 좌표
		int number, speed, direction, size; // 상어의 번호, 속력, 방향, 크기

		public Shark(int row, int col, int number, int speed, int direction, int size) {
			this.row = row;
			this.col = col;
			this.number = number;
			this.speed = speed;
			this.direction = direction;
			this.size = size;
		}

		@Override
		public int compareTo(Shark s) {
			return s.size - this.size;
		}
	}
}
