import java.io.*;
import java.util.*;

public class Main {
	static final int SIZE = 19; // 오목판의 크기
	static int[][] omok = new int[SIZE][SIZE];

	static int winner = 0; // 승자. 결정되지 않았다면 0
	static int winnerRow, winnerCol;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		for (int r = 0; r < SIZE; r++) { // 오목판 입력
			st = new StringTokenizer(br.readLine(), " ");

			for (int c = 0; c < SIZE; c++) {
				omok[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		end: for (int r = 0; r < SIZE; r++) {
			for (int c = 0; c < SIZE; c++) {
				if (omok[r][c] != 0) {
					if (check12(r, c) || check1(r, c) || check3(r, c) || check4(r, c)) { // 5목이 완성되었다면 탈출
						break end;
					}
				}
			}
		}

		// 답안 출력
		System.out.println(winner);
		if (winner == 0) {

		}

		else {
			System.out.println((winnerRow + 1) + " " + (winnerCol + 1)); // index를 좌표로 변환
		}
	}

	/**
	 * 배열을 사용하여 rr과 cc를 바꾸는 것 보다는 직접 움직이는게 더 빠를 것이라고 생각하여 배열을 사용하지 않았습니다.
	 * 
	 * @param r
	 * @param c
	 * @return
	 */
	static boolean check12(int r, int c) { // 12시방향 세로 확인
		int nod = omok[r][c];
		int count = 1;

		int rr = r;

		while (true) { // 아래쪽 확인
			rr = rr + 1;

			if (SIZE <= rr) {
				break;
			}

			else {
				if (omok[rr][c] == nod) {
					count += 1;
				}

				else {
					break;
				}
			}
		}

		rr = r;
		while (true) { // 위쪽 확인
			rr = rr - 1;

			if (rr < 0) {
				break;
			}

			else {
				if (omok[rr][c] == nod) {
					count += 1;
				}

				else {
					break;
				}
			}
		}

		if (count == 5) {
			winner = nod;
			winnerRow = rr + 1;
			winnerCol = c;

			return true;
		}

		else {
			return false;
		}
	}

	static boolean check1(int r, int c) { // 1시방향 대각선 확인
		int nod = omok[r][c];
		int count = 1;

		int rr = r;
		int cc = c;
		while (true) { // 우상단 확인
			rr = rr - 1;
			cc = cc + 1;

			if (0 <= rr && rr < SIZE && 0 <= cc && cc < SIZE) { // 범위 안에 있는지
				if (omok[rr][cc] == nod) {
					count += 1;
				}

				else {
					break;
				}
			}

			else {
				break;
			}
		}

		rr = r;
		cc = c;
		while (true) { // 좌하단 확인
			rr = rr + 1;
			cc = cc - 1;

			if (0 <= rr && rr < SIZE && 0 <= cc && cc < SIZE) { // 범위 안에 있는지
				if (omok[rr][cc] == nod) {
					count += 1;
				}

				else {
					break;
				}
			}

			else {
				break;
			}
		}

		if (count == 5) {
			winner = nod;
			winnerRow = rr - 1;
			winnerCol = cc + 1;

			return true;
		}

		else {
			return false;
		}
	}

	static boolean check3(int r, int c) { // 3시방향 가로 확인
		int nod = omok[r][c];
		int count = 1;

		int cc = c;
		while (true) { // 우측 확인
			cc = cc + 1;

			if (0 <= cc && cc < SIZE) { // 범위 안에 있는지
				if (omok[r][cc] == nod) {
					count += 1;
				}

				else {
					break;
				}
			}

			else {
				break;
			}
		}

		cc = c;
		while (true) { // 좌측 확인
			cc = cc - 1;

			if (0 <= cc && cc < SIZE) { // 범위 안에 있는지
				if (omok[r][cc] == nod) {
					count += 1;
				}

				else {
					break;
				}
			}

			else {
				break;
			}
		}

		if (count == 5) {
			winner = nod;
			winnerRow = r;
			winnerCol = cc + 1;

			return true;
		}

		else {
			return false;
		}
	}

	static boolean check4(int r, int c) { // 4시방향 대각선 확인
		int nod = omok[r][c];
		int count = 1;

		int rr = r;
		int cc = c;
		while (true) { // 우하단 확인
			rr = rr + 1;
			cc = cc + 1;

			if (0 <= rr && rr < SIZE && 0 <= cc && cc < SIZE) { // 범위 안에 있는지
				if (omok[rr][cc] == nod) {
					count += 1;
				}

				else {
					break;
				}
			}

			else {
				break;
			}
		}

		rr = r;
		cc = c;
		while (true) { // 좌상단 확인
			rr = rr - 1;
			cc = cc - 1;

			if (0 <= rr && rr < SIZE && 0 <= cc && cc < SIZE) { // 범위 안에 있는지
				if (omok[rr][cc] == nod) {
					count += 1;
				}

				else {
					break;
				}
			}

			else {
				break;
			}
		}

		if (count == 5) {
			winner = nod;
			winnerRow = rr + 1;
			winnerCol = cc + 1;

			return true;
		}

		else {
			return false;
		}
	}
}
