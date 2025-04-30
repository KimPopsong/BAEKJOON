import java.io.*;
import java.util.*;

public class Main {
	static int godNumber, edgeNumber;
	static int[] parent;
	static double haveToMade = 0; // 만들어야 하는 통로의 길이
	static ArrayList<God> gods = new ArrayList<>();
	static PriorityQueue<Edge> edges = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());

		godNumber = Integer.parseInt(st.nextToken());
		edgeNumber = Integer.parseInt(st.nextToken());

		parent = new int[godNumber + 1];
		for (int i = 1; i <= godNumber; i++) {
			parent[i] = i;
		}

		for (int i = 1; i <= godNumber; i++) {
			st = new StringTokenizer(br.readLine());

			gods.add(new God(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		for (int i = 0; i < edgeNumber; i++) {
			st = new StringTokenizer(br.readLine());

			int g1 = Integer.parseInt(st.nextToken());
			int g2 = Integer.parseInt(st.nextToken());

			if (g1 > g2) {
				int temp = g1;
				g1 = g2;
				g2 = temp;
			}

			union(g1, g2);
		}

		for (int i = 0; i < godNumber - 1; i++) {
			God g1 = gods.get(i);

			for (int j = i + 1; j < godNumber; j++) {
				God g2 = gods.get(j);

				edges.add(new Edge(g1.number, g2.number, g1.getDistance(g2)));
			}
		}

		while (!edges.isEmpty()) {
			for (int i = 1; i <= godNumber; i++) {
				findParent(i);
			}

			Edge e = edges.remove();

			if (union(e.g1, e.g2)) {
				haveToMade += e.distance;
			}
		}

		System.out.printf("%.2f", haveToMade);
	}

	static int findParent(int n) {
		if (parent[n] == n) {
			return n;
		}

		else {
			return parent[n] = findParent(parent[n]);
		}
	}

	static boolean union(int g1, int g2) {
		int root1 = findParent(g1);
		int root2 = findParent(g2);

		if (root1 > root2) {
			int temp = root1;
			root1 = root2;
			root2 = temp;
		}

		if (root1 == root2) {
			return false;
		}

		else {
			parent[root2] = root1;

			return true;
		}
	}

	static class Edge implements Comparable<Edge> {
		int g1, g2; // 신들의 번호
		double distance; // 거리

		Edge(int g1, int g2, double distance) {
			this.g1 = g1;
			this.g2 = g2;
			this.distance = distance;
		}

		@Override
		public int compareTo(Edge e) {
			return Double.compare(this.distance, e.distance);
		}
	}

	static class God {
		int number, x, y;

		God(int number, int x, int y) {
			this.number = number;
			this.x = x;
			this.y = y;
		}

		double getDistance(God g) {
			return Math.sqrt(Math.pow(this.x - g.x, 2) + Math.pow(this.y - g.y, 2));
		}
	}
}
