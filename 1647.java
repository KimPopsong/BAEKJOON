import java.io.*;
import java.util.*;

public class Main {
	static int houseNumber, roadNumber, minPrice = 0;
	static int[] parent;
	static PriorityQueue<Road> roads = new PriorityQueue<>();
	static ArrayList<Road> pickRoads = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		initialize();

		getSpanningTree();
		
		System.out.println(minPrice);
	}

	static void getSpanningTree() {
		int count = 0;

		while (!roads.isEmpty()) {
			if (count + 2 == houseNumber) {
				break;
			}

			Road road = roads.remove();

			if (union(road.h1, road.h2)) {
				minPrice += road.price;
				
				count += 1;
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

		st = new StringTokenizer(br.readLine());

		houseNumber = Integer.parseInt(st.nextToken());
		roadNumber = Integer.parseInt(st.nextToken());

		parent = new int[houseNumber + 1];

		for (int i = 0; i < roadNumber; i++) {
			st = new StringTokenizer(br.readLine());

			int h1 = Integer.parseInt(st.nextToken());
			int h2 = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());

			roads.add(new Road(h1, h2, price));
		}

		for (int i = 1; i <= houseNumber; i++) {
			parent[i] = i;
		}
	}

	static class Road implements Comparable<Road> {
		int h1, h2, price;

		Road(int h1, int h2, int price) {
			this.h1 = h1;
			this.h2 = h2;
			this.price = price;
		}

		@Override
		public int compareTo(Road o) {
			return price - o.price;
		}
	}
}
