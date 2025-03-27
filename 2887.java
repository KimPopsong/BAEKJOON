import java.io.*;
import java.util.*;

public class Main {
	static int planetNumber;
	static int distance = 0;
	static int[] parent;
	static Planet[] planets;
	static PriorityQueue<Edge> edges = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		initialize();

		Planet[] planetsCopy = new Planet[planets.length];
		for (int i = 0; i < planets.length; i++) {
			Planet p = planets[i];
			planetsCopy[i] = new Planet(p.id, p.p, p.r, p.c);
		}

		getEdges(planetsCopy);

		getSpanningTree();

		System.out.println(distance);
	}

	static void getEdges(Planet[] newPlanets) {
		Arrays.sort(newPlanets, new Comparator<Planet>() { // p로 정렬
			@Override
			public int compare(Planet p1, Planet p2) {
				return p1.p - p2.p;
			}
		});

		for (int i = 0; i < planetNumber - 1; i++) {
			edges.add(new Edge(newPlanets[i].id, newPlanets[i + 1].id));
		}

		Arrays.sort(newPlanets, new Comparator<Planet>() { // r로 정렬
			@Override
			public int compare(Planet p1, Planet p2) {
				return p1.r - p2.r;
			}
		});

		for (int i = 0; i < planetNumber - 1; i++) {
			edges.add(new Edge(newPlanets[i].id, newPlanets[i + 1].id));
		}

		Arrays.sort(newPlanets, new Comparator<Planet>() { // c로 정렬
			@Override
			public int compare(Planet p1, Planet p2) {
				return p1.c - p2.c;
			}
		});

		for (int i = 0; i < planetNumber - 1; i++) {
			edges.add(new Edge(newPlanets[i].id, newPlanets[i + 1].id));
		}
	}

	static void getSpanningTree() {
		int count = 0;

		while (!edges.isEmpty()) {
			if (count + 1 == planetNumber) {
				break;
			}

			Edge edge = edges.remove();

			if (union(edge.p1, edge.p2)) {
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

		planetNumber = Integer.parseInt(br.readLine());

		parent = new int[planetNumber];
		planets = new Planet[planetNumber];

		for (int i = 0; i < planetNumber; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < planetNumber; i++) {
			st = new StringTokenizer(br.readLine());

			planets[i] = new Planet(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}
	}

	static class Edge implements Comparable<Edge> {
		int p1, p2; // 행성의 인덱스
		int dis; // 행성 사이의 거리

		Edge(int p1, int p2) {
			this.p1 = p1;
			this.p2 = p2;

			Planet pla1 = planets[p1];
			Planet pla2 = planets[p2];

			dis = Math.min(Math.min(Math.abs(pla1.p - pla2.p), Math.abs(pla1.r - pla2.r)), Math.abs(pla1.c - pla2.c));
		}

		@Override
		public int compareTo(Edge e) {
			return dis - e.dis;
		}
	}

	static class Planet {
		int id;
		int p, r, c;

		Planet(int id, int p, int r, int c) {
			this.id = id;
			this.p = p;
			this.r = r;
			this.c = c;
		}
	}
}
