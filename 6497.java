import java.io.*;
import java.util.*;

public class Main {
	static int houseNumber, roadNumber, sumAllRoad, sumSpanningRoad;
	static int[] parent;
	static PriorityQueue<Road> roads;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		while (true) {
			st = new StringTokenizer(br.readLine());

			houseNumber = Integer.parseInt(st.nextToken());
			roadNumber = Integer.parseInt(st.nextToken());
			sumAllRoad = 0;
			sumSpanningRoad = 0;
			roads = new PriorityQueue<>();

			if (houseNumber == 0 && roadNumber == 0) {
				break;
			}

			for (int i = 0; i < roadNumber; i++) {
				st = new StringTokenizer(br.readLine());

				int h1 = Integer.parseInt(st.nextToken());
				int h2 = Integer.parseInt(st.nextToken());
				int distance = Integer.parseInt(st.nextToken());

				if (h1 > h2) {
					int temp = h1;
					h1 = h2;
					h2 = temp;
				}

				roads.add(new Road(h1, h2, distance));
				sumAllRoad += distance;
			}

			parent = new int[houseNumber];
			for (int i = 0; i < houseNumber; i++) {
				parent[i] = i;
			}

			while (!roads.isEmpty()) {
				Road road = roads.remove();

				if (union(road.h1, road.h2)) {
					sumSpanningRoad += road.distance;
				}
			}

			sb.append(sumAllRoad - sumSpanningRoad).append("\n");
		}

		System.out.print(sb);
	}

	static int findParent(int n) {
		if (parent[n] == n) {
			return n;
		}

		return parent[n] = findParent(parent[n]);
	}

	static boolean union(int h1, int h2) {
		int root1 = findParent(h1);
		int root2 = findParent(h2);

		if (root1 == root2) {
			return false;
		}

		else {
			parent[root2] = root1;

			return true;
		}
	}

	static class Road implements Comparable<Road> {
		int h1, h2, distance;

		Road(int h1, int h2, int distance) {
			this.h1 = h1;
			this.h2 = h2;
			this.distance = distance;
		}

		@Override
		public int compareTo(Road r) {
			return Integer.compare(this.distance, r.distance);
		}
	}
}
