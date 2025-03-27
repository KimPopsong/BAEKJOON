import java.io.*;
import java.util.*;

public class Main {
	static int nodeNumber, edgeNumber;
	static int[] parent;
	static PriorityQueue<Edge> edges = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		nodeNumber = Integer.parseInt(st.nextToken());
		edgeNumber = Integer.parseInt(st.nextToken());

		parent = new int[nodeNumber + 1];

		for (int i = 1; i <= nodeNumber; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < edgeNumber; i++) {
			st = new StringTokenizer(br.readLine());

			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			edges.add(new Edge(n1, n2, weight));
		}

		int count = 0;
		long sumWeight = 0;

		while (!edges.isEmpty()) {
			if (count + 1 == nodeNumber) {
				break;
			}

			Edge e = edges.remove();

			if (union(e.n1, e.n2)) {
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

	static boolean union(int n1, int n2) {
		int root1 = findParent(n1);
		int root2 = findParent(n2);

		if (root1 == root2) {
			return false;
		}

		else {
			parent[root2] = root1;

			return true;
		}
	}

	static class Edge implements Comparable<Edge> {
		int n1, n2, weight;

		public Edge(int n1, int n2, int weight) {
			this.n1 = n1;
			this.n2 = n2;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return weight - o.weight;
		}
	}
}
