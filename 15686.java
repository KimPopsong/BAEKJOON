import java.io.*;
import java.util.*;

public class Main {
	static int size, leftChickenStoreNumber; // 크기, 남겨야 하는 치킨 집의 개수
	static int minDistance = Integer.MAX_VALUE; // 최소 치킨 거리
	static int[][] map; // 전체 지도
	static ArrayList<Point> houses = new ArrayList<>(); // 집의 좌표
	static ArrayList<Point> chickenStores = new ArrayList<>(); // 치킨 집의 좌표

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());

		size = Integer.parseInt(st.nextToken());
		leftChickenStoreNumber = Integer.parseInt(st.nextToken());

		map = new int[size][size];

		for (int r = 0; r < size; r++) {
			st = new StringTokenizer(br.readLine());

			for (int c = 0; c < size; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());

				if (map[r][c] == 1) {
					houses.add(new Point(r, c));
				}

				else if (map[r][c] == 2) {
					chickenStores.add(new Point(r, c));
				}
			}
		}

		bruteForce(0, 0, new ArrayList<>());

		System.out.println(minDistance);
	}

	static void bruteForce(int depth, int index, ArrayList<Point> picks) {
		if (depth == leftChickenStoreNumber) { // 치킨 집을 모두 골랐다면
			int chickenDistance = 0;

			for (Point house : houses) {
				int distance = Integer.MAX_VALUE;

				for (Point chicken : picks) {
					distance = Math.min(distance, Math.abs(house.r - chicken.r) + Math.abs(house.c - chicken.c));
				}

				chickenDistance += distance;
			}

			minDistance = Math.min(minDistance, chickenDistance);

			return;
		}

		for (int i = index; i < chickenStores.size(); i++) { // 조합 구하기
			picks.add(chickenStores.get(i));
			bruteForce(depth + 1, i + 1, picks);
			picks.remove(picks.size() - 1);
		}
	}

	static class Point {
		int r, c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
