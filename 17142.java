import java.io.*;
import java.util.*;

public class Main {
	static int size, virusAvailPlace; // 연구소의 크기, 바이러스를 놓을 수 있는 장소의 개수
	static int virusNumber; // 바이러스의 총 개수
	static List<Point> viruses; // 바이러스의 위치
	static int[][] map; // 연구소
	static int minTime = Integer.MAX_VALUE;

	static List<Point> pickVirus;
	static boolean[][] isVisit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());

		size = Integer.parseInt(st.nextToken());
		virusAvailPlace = Integer.parseInt(st.nextToken());

		map = new int[size][size];
		viruses = new ArrayList<>();

		for (int r = 0; r < size; r++) {
			st = new StringTokenizer(br.readLine());

			for (int c = 0; c < size; c++) {
				int obj = Integer.parseInt(st.nextToken());

				if (obj == 2) { // 바이러스 목록을 따로 관리
					viruses.add(new Point(r, c));
					virusNumber += 1;
				}

				map[r][c] = obj;
			}
		}

		pickVirus = new ArrayList<>();
		selectVirus(0, 0);

		if (minTime == Integer.MAX_VALUE) {
			minTime = -1;
		}

		System.out.println(minTime);
	}

	static boolean check() {
		boolean flag = true;

		f: for (int r = 0; r < size; r++) { // 모두 방문하였는지 확인
			for (int c = 0; c < size; c++) {
				if (map[r][c] == 0 && isVisit[r][c] == false) {
					flag = false;
					break f;
				}
			}
		}

		return flag;
	}

	static void search() {
		int time = 0;

		ArrayDeque<Point> bfs = new ArrayDeque<>();
		isVisit = new boolean[size][size];

		for (Point p : pickVirus) {
			bfs.add(p);
			isVisit[p.r][p.c] = true;
		}

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		if (check()) {
			minTime = 0;

			return;
		}

		while (!bfs.isEmpty()) {
			time += 1;

			ArrayDeque<Point> tempBfs = bfs.clone();
			bfs.clear();

			while (!tempBfs.isEmpty()) {
				Point p = tempBfs.remove();

				for (int d = 0; d < 4; d++) {
					int rr = p.r + dr[d];
					int cc = p.c + dc[d];

					if (0 <= rr && rr < size && 0 <= cc && cc < size) { // 범위 안에 존재하고
						if (isVisit[rr][cc] == false) { // 방문하지 않았고
							if (map[rr][cc] != 1) { // 벽이 아니라면
								bfs.add(new Point(rr, cc));
								isVisit[rr][cc] = true;
							}
						}
					}
				}
			}

			if (check()) {
				minTime = Math.min(minTime, time);

				break;
			}
		}
	}

	static void selectVirus(int index, int selectVirusNumber) {
		if (selectVirusNumber == virusAvailPlace) { // 바이러스를 모두 선택하였으면
			search();

			return;
		}

		else {
			for (int i = index; i < virusNumber; i++) {
				pickVirus.add(viruses.get(i));
				selectVirus(i + 1, selectVirusNumber + 1);
				pickVirus.remove(pickVirus.size() - 1);
			}
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
