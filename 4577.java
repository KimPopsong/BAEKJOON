import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int gameNumber = 0;

		while (true) {
			gameNumber += 1; // 몇 번째 게임인지

			int rowSize, colSize;
			char[][] game;
			String commands;

			int nowR = 0, nowC = 0; // 시작점의 위치
			HashSet<Point> targetPoint = new HashSet<>(); // 목표점의 좌표

			// 입력 시작
			String[] temp = br.readLine().split(" ");

			rowSize = Integer.parseInt(temp[0]);
			colSize = Integer.parseInt(temp[1]);

			if (rowSize == 0 && colSize == 0) {
				break;
			}

			game = new char[rowSize][colSize];

			/**
			 * game 입력. 목표점의 위치를 저장하고, 대문자를 모두 소문자로 전환
			 */
			for (int r = 0; r < rowSize; r++) {
				temp = br.readLine().split("");

				for (int c = 0; c < colSize; c++) {
					game[r][c] = temp[c].charAt(0);

					if (game[r][c] == 'w') {
						nowR = r;
						nowC = c;

						game[r][c] = '.';
					}

					else if (game[r][c] == 'W') {
						nowR = r;
						nowC = c;

						game[r][c] = '.';
						targetPoint.add(new Point(r, c));
					}

					else if (game[r][c] == '+') {
						game[r][c] = '.';
						targetPoint.add(new Point(r, c));
					}

					else if (game[r][c] == 'B') {
						game[r][c] = 'b';
						targetPoint.add(new Point(r, c));
					}
				}
			}

			commands = br.readLine();
			// 입력 종료

			int[] dr = { -1, 1, 0, 0 };
			int[] dc = { 0, 0, -1, 1 };
			for (int i = 0; i < commands.length(); i++) {
				char command = commands.charAt(i);
				int nod = 0;

				if (command == 'U') { // 위로 이동
					nod = 0;
				}

				else if (command == 'D') { // 아래
					nod = 1;
				}

				else if (command == 'L') { // 왼쪽
					nod = 2;
				}

				else { // 오른쪽
					nod = 3;
				}

				int rr = nowR + dr[nod];
				int cc = nowC + dc[nod];

				if (game[rr][cc] == '.') { // 갈 수 있는 길인 경우
					nowR = rr;
					nowC = cc;
				}

				else if (game[rr][cc] == '#') { // 벽인 경우
					continue;
				}

				else { // 박스인 경우
					int rrr = rr + dr[nod]; // 그 다음칸 확인
					int ccc = cc + dc[nod];

					if (game[rrr][ccc] == '.') { // 갈 수 있는 길이라면
						game[rrr][ccc] = 'b'; // 박스 이동
						game[rr][cc] = '.';

						nowR = rr;
						nowC = cc;
					}
				}

				if (check(game, targetPoint)) { // 게임이 종료되었는지 확인
					break;
				}
			}

			String result = "";
			if (check(game, targetPoint)) {
				result = "complete";
			}

			else {
				result = "incomplete";
			}

			// 게임판 정상화
			game[nowR][nowC] = 'w';

			for (Point p : targetPoint) { // 게임판 정상화
				if (game[p.r][p.c] == '.') {
					game[p.r][p.c] = '+';
				}

				else if (game[p.r][p.c] == 'b') {
					game[p.r][p.c] = 'B';
				}

				else if (game[p.r][p.c] == 'w') {
					game[p.r][p.c] = 'W';
				}
			}

			// 게임판 출력 시작
			sb.append("Game ").append(gameNumber).append(": ").append(result).append("\n");

			for (int r = 0; r < rowSize; r++) {
				for (int c = 0; c < colSize; c++) {
					sb.append(game[r][c]);
				}
				sb.append("\n");
			}
			// 게임판 출력 종료
		}

		System.out.println(sb);
	}

	static boolean check(char[][] game, HashSet<Point> targetPoint) {
		for (int r = 0; r < game.length; r++) {
			for (int c = 0; c < game[0].length; c++) {
				if (game[r][c] == 'b') {
					Point p = new Point(r, c);
					if (!targetPoint.contains(p)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	static class Point {
		int r, c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null || getClass() != obj.getClass())
				return false;
			Point point = (Point) obj;
			return r == point.r && c == point.c;
		}

		@Override
		public int hashCode() {
			return Objects.hash(r, c);
		}
	}

}
