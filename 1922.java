import java.io.*;
import java.util.*;

public class Main {
	static int computerNumber, edgeNumber;
	static int[] parent;
	static PriorityQueue<Edge> edges = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		computerNumber = Integer.parseInt(br.readLine());
		edgeNumber = Integer.parseInt(br.readLine());

		parent = new int[computerNumber + 1];

		for (int i = 1; i <= computerNumber; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < edgeNumber; i++) {
			st = new StringTokenizer(br.readLine());

			int c1 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			edges.add(new Edge(c1, c2, weight));
		}

		int count = 0;
		long sumWeight = 0;

		while (!edges.isEmpty()) {
			if (count + 1 == computerNumber) {
				break;
			}

			Edge e = edges.remove();

			if (union(e.c1, e.c2)) {
				sumWeight += e.weight;
				count += 1;
			}
		}

		System.out.println(sumWeight);
	}

	static int findParent(int n) {
		if (parent[n] == n) {
			return n;
		}

		return parent[n] = findParent(parent[n]);
	}

	static boolean union(int c1, int c2) {
		int root1 = findParent(c1);
		int root2 = findParent(c2);

		if (root1 == root2) {
			return false;
		}

		else {
			parent[root2] = root1;

			return true;
		}
	}

	static class Edge implements Comparable<Edge> {
		int c1, c2, weight;

		public Edge(int c1, int c2, int weight) {
			this.c1 = c1;
			this.c2 = c2;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return weight - o.weight;
		}
	}
}
