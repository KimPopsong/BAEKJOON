import java.io.*;
import java.util.*;

public class Main {
	static int size;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		size = Integer.parseInt(br.readLine());

		map = new char[size][2 * size - 1];
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < 2 * size - 1; c++) {
				map[r][c] = ' ';
			}
		}

		drawStar(size, 0, size - 1);

		for (int r = 0; r < size; r++) {
			for (int c = 0; c < 2 * size - 1; c++) {
				sb.append(map[r][c]);
			}
			sb.append("\n");
		}

		System.out.print(sb);
	}

	static void drawStar(int n, int r, int c) {
		if (n == 3) {
			map[r][c] = '*';
			map[r + 1][c - 1] = '*';
			map[r + 1][c + 1] = '*';
			map[r + 2][c - 2] = '*';
			map[r + 2][c - 1] = '*';
			map[r + 2][c] = '*';
			map[r + 2][c + 1] = '*';
			map[r + 2][c + 2] = '*';
			return;
		}

		int half = n / 2;

		drawStar(half, r, c);
		drawStar(half, r + half, c - half);
		drawStar(half, r + half, c + half);
	}
}
