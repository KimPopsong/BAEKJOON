import java.io.*;
import java.util.*;

public class Main {
	static int convStoreNumber; // 편의점의 개수
	static int[] parents;
	static Point start, end;
	static ArrayList<Point> points;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < testCase; tc++) {
			convStoreNumber = Integer.parseInt(br.readLine());
			parents = new int[convStoreNumber + 3];
			points = new ArrayList<>();

			for (int i = 0; i <= convStoreNumber + 2; i++) {
				parents[i] = i;
			}

			st = new StringTokenizer(br.readLine()); // 시작 좌표 입력
			start = new Point(0, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			for (int i = 1; i <= convStoreNumber; i++) { // 편의점 좌표 입력
				st = new StringTokenizer(br.readLine());
				points.add(new Point(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}

			st = new StringTokenizer(br.readLine()); // 종료 좌표 입력
			end = new Point(convStoreNumber + 1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			points.add(0, start);
			points.add(end);

			// 입력부 종료

			for (int i = 0; i < points.size(); i++) {
				Point p1 = points.get(i);

				for (int j = i + 1; j < points.size(); j++) {
					Point p2 = points.get(j);

					if (p1.getDistance(p2) <= 1000) {
						union(i, j);
					}
				}
			}

			// 출력
			if (union(0, convStoreNumber + 1) == false) {
				sb.append("happy").append("\n");
			}

			else {
				sb.append("sad").append("\n");
			}
		}

		System.out.print(sb);
	}

	static int findParent(int n) {
		if (parents[n] == n) {
			return n;
		}

		return parents[n] = findParent(parents[n]);
	}

	static boolean union(int p1, int p2) {
		int root1 = findParent(p1);
		int root2 = findParent(p2);

		if (root1 == root2) {
			return false;
		}

		parents[root2] = root1;

		return true;
	}

	static class Point {
		int index;
		int r, c;

		Point(int index, int r, int c) {
			this.index = index;
			this.r = r;
			this.c = c;
		}

		int getDistance(Point p) {
			return (Math.abs(this.r - p.r) + Math.abs(this.c - p.c));
		}
	}
}
