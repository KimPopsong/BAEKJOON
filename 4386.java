import java.io.*;
import java.util.*;

public class Main {
	static int starNumber;
	static double distance = 0;
	static int[] parent;
	static Star[] stars;
	static PriorityQueue<Edge> edges = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		initialize();

		getSpanningTree();

		System.out.printf("%.2f", distance);
	}

	static void getSpanningTree() {
		int count = 0;

		while (!edges.isEmpty()) {
			if (count + 1 == starNumber) {
				break;
			}

			Edge edge = edges.remove();

			if (union(edge.s1, edge.s2)) {
				count += 1;

				distance += edge.dis;
			}
		}
	}

	static int getParent(int n) {
		if (n == parent[n]) {
			return n;
		}

		return parent[n] = getParent(parent[n]);
	}

	static boolean union(int h1, int h2) {
		int root1 = getParent(h1);
		int root2 = getParent(h2);

		if (root1 != root2) {
			parent[root2] = root1;

			return true;
		}

		return false;
	}

	static void initialize() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		starNumber = Integer.parseInt(br.readLine());

		parent = new int[starNumber + 1];
		stars = new Star[starNumber + 1];

		for (int i = 1; i <= starNumber; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < starNumber; i++) {
			st = new StringTokenizer(br.readLine());

			double r = Double.parseDouble(st.nextToken());
			double c = Double.parseDouble(st.nextToken());

			stars[i] = new Star(r, c);
		}

		for (int i = 0; i < starNumber - 1; i++) { // 모든 간선 정보 저장
			for (int j = i + 1; j < starNumber; j++) {
				edges.add(new Edge(i, j));
			}
		}
	}

	static class Edge implements Comparable<Edge> {
		int s1, s2; // 별의 좌표
		double dis; // 별 사이의 거리

		Edge(int s1, int s2) {
			this.s1 = s1;
			this.s2 = s2;
			this.dis = Math.sqrt(Math.pow(stars[s1].r - stars[s2].r, 2) + Math.pow(stars[s1].c - stars[s2].c, 2));
		}

		@Override
		public int compareTo(Edge o) {
			if (this.dis < o.dis) {
				return -1;
			}

			else if (this.dis == o.dis) {
				return 0;
			}

			else {
				return 1;
			}
		}
	}

	static class Star {
		double r, c;

		Star(double r, double c) {
			this.r = r;
			this.c = c;
		}
	}
}
