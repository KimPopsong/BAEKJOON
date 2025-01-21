import java.io.*;
import java.util.*;

class Main {
	static int size, appleNumber, moveNumber; // 맵의 크기, 사과의 개수, 움직임의 개수
	static int[][] map;
	static ArrayDeque<Command> commands = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		size = Integer.parseInt(br.readLine());
		appleNumber = Integer.parseInt(br.readLine());

		map = new int[size][size];

		for (int i = 0; i < appleNumber; i++) { // 사과의 위치 표시
			st = new StringTokenizer(br.readLine(), " ");

			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;

			map[r][c] = -1;
		}

		moveNumber = Integer.parseInt(br.readLine());

		for (int i = 0; i < moveNumber; i++) { // 명령 저장
			st = new StringTokenizer(br.readLine(), " ");

			int time = Integer.parseInt(st.nextToken());
			char command = st.nextToken().charAt(0);

			commands.add(new Command(time, command));
		}

		int[] dr = { 0, 1, 0, -1 }; // 오른쪽부터 시계방향
		int[] dc = { 1, 0, -1, 0 };
		int delta = 0; // 방향전환 노드

		int r = 0, c = 0; // 머리의 좌표
		int snakeSize = 1; // 뱀의 길이
		map[0][0] = 1;
		int time = 0;

		while (true) {
			time += 1;

			r = r + dr[delta];
			c = c + dc[delta];

			if (0 <= r && r < size && 0 <= c && c < size) { // 범위 안에 있다면
				if (map[r][c] > 0) { // 뱀의 몸통이 있다면
					break;
				}

				else if (map[r][c] == -1) { // 사과라면
					snakeSize += 1; // 뱀 길이 1 증가
					map[r][c] = snakeSize;
				}

				else {
					for (int rr = 0; rr < size; rr++) { // 뱀 이동하고
						for (int cc = 0; cc < size; cc++) {
							if (map[rr][cc] > 0) {
								map[rr][cc] -= 1;
							}
						}
					}

					map[r][c] = snakeSize;
				}
			}

			else { // 게임 종료
				break;
			}

			if (!commands.isEmpty()) {
				if (commands.peek().time == time) {
					Command command = commands.removeFirst();

					if (command.command == 'L') { // 좌회전
						delta -= 1;

						if (delta < 0) {
							delta = 3;
						}
					}

					else { // 우회전
						delta += 1;

						if (delta > 3) {
							delta = 0;
						}
					}
				}
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

	static class Command {
		int time;
		char command;

		Command(int time, char command) {
			this.time = time;
			this.command = command;
		}
	}
}
