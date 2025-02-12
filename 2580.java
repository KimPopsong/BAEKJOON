import java.io.*;
import java.util.*;

public class Main {
	static int zeros = 0;
	static int[][] sudoku = new int[9][9];
	static Map<Integer, Set<Integer>> rows; // 행 별로 가능한 숫자 확인
	static Map<Integer, Set<Integer>> cols; // 열 별로 가능한 숫자 확인
	static Map<Integer, Set<Integer>> threeBythree; // 3 * 3 별로 가능한 숫자 확인. 좌상단부터 우하단 순서대로 0 ~ 8
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		initialize();

		for (int r = 0; r < 9; r++) {
			st = new StringTokenizer(br.readLine());

			for (int c = 0; c < 9; c++) {
				int num = Integer.parseInt(st.nextToken());

				sudoku[r][c] = num;

				if (num == 0) {
					zeros += 1;
				}

				else {
					rows.get(r).remove(num);
					cols.get(c).remove(num);
					threeBythree.get((r / 3) * 3 + (c / 3)).remove(num);
				}
			}
		}

		bruteforce(0, 0);
	}

	static void bruteforce(int rStart, int depth) {
		if (depth == zeros) {
			for (int r = 0; r < 9; r++) {
				for (int c = 0; c < 9; c++) {
					sb.append(sudoku[r][c]).append(" ");
				}

				sb.append("\n");
			}

			System.out.println(sb);
			System.exit(0);
		}

		for (int r = rStart; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				if (sudoku[r][c] == 0) {
					for (int k = 1; k < 10; k++) {
						Set<Integer> rowSet = rows.get(r);
						Set<Integer> colSet = cols.get(c);
						Set<Integer> tbtSet = threeBythree.get(((r / 3) * 3 + (c / 3)));

						if (rowSet.contains(k) && colSet.contains(k) && tbtSet.contains(k)) {
							rowSet.remove(k);
							colSet.remove(k);
							tbtSet.remove(k);
							sudoku[r][c] = k;

							bruteforce(r, depth + 1);

							rowSet.add(k);
							colSet.add(k);
							tbtSet.add(k);
							sudoku[r][c] = 0;
						}
					}

					return;
				}
			}
		}
	}

	static void initialize() {
		rows = new HashMap<>();
		cols = new HashMap<>();
		threeBythree = new HashMap<>();

		for (int r = 0; r < 9; r++) {
			rows.put(r, new HashSet<>());
			cols.put(r, new HashSet<>());
			threeBythree.put(r, new HashSet<>());

			Set<Integer> numbers = rows.get(r);

			for (int c = 1; c <= 9; c++) {
				numbers.add(c);
			}

			numbers = cols.get(r);

			for (int c = 1; c <= 9; c++) {
				numbers.add(c);
			}

			numbers = threeBythree.get(r);

			for (int c = 1; c <= 9; c++) {
				numbers.add(c);
			}
		}
	}
}
