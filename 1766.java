import java.io.*;
import java.util.*;

public class Main {
	static int problemNumber, edgeNumber;
	static int[] degree;
	static Map<Integer, Set<Integer>> edges = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());

		problemNumber = Integer.parseInt(st.nextToken());
		edgeNumber = Integer.parseInt(st.nextToken());

		degree = new int[problemNumber + 1];

		for (int i = 1; i <= problemNumber; i++) {
			edges.put(i, new HashSet<>());
		}

		for (int i = 0; i < edgeNumber; i++) {
			st = new StringTokenizer(br.readLine());

			int p1 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());

			degree[p2] += 1;
			edges.get(p1).add(p2);
		}

		PriorityQueue<Integer> topologySort = new PriorityQueue<>();
		for (int i = 1; i <= problemNumber; i++) {
			if (degree[i] == 0) {
				topologySort.add(i);
			}
		}

		while (!topologySort.isEmpty()) {
			int p = topologySort.remove();

			sb.append(p).append(" ");

			for (int nextP : edges.get(p)) {
				degree[nextP] -= 1;

				if (degree[nextP] <= 0) {
					topologySort.add(nextP);
				}
			}
		}

		System.out.print(sb);
	}
}
