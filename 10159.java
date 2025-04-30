import java.io.*;
import java.util.*;

public class Main {
	static int stuffNumber, edgeNumber;
	static int[] meetNodes;
	static ArrayList<Integer>[] edges, reverseEdges;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		stuffNumber = Integer.parseInt(br.readLine());
		edgeNumber = Integer.parseInt(br.readLine());

		meetNodes = new int[stuffNumber + 1];
		edges = new ArrayList[stuffNumber + 1];
		reverseEdges = new ArrayList[stuffNumber + 1];

		for (int i = 0; i <= stuffNumber; i++) {
			edges[i] = new ArrayList<>();
			reverseEdges[i] = new ArrayList<>();
		}

		for (int i = 0; i < edgeNumber; i++) {
			st = new StringTokenizer(br.readLine());

			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());

			edges[node1].add(node2);
			reverseEdges[node2].add(node1);
		}

		for (int node = 1; node <= stuffNumber; node++) { // 1번 노드부터 탐색
			int nodeCount = -1;

			ArrayDeque<Integer> bfs = new ArrayDeque<>();
			boolean[] isVisit = new boolean[stuffNumber + 1];

			bfs.add(node);
			isVisit[node] = true;

			while (!bfs.isEmpty()) {
				nodeCount += 1;

				int n = bfs.remove();

				for (int child : edges[n]) {
					if (!isVisit[child]) {
						isVisit[child] = true;
						bfs.add(child);
					}
				}
			}

			bfs = new ArrayDeque<>();
			isVisit = new boolean[stuffNumber + 1];

			bfs.add(node);
			isVisit[node] = true;

			while (!bfs.isEmpty()) {
				nodeCount += 1;

				int n = bfs.remove();

				for (int child : reverseEdges[n]) {
					if (!isVisit[child]) {
						isVisit[child] = true;
						bfs.add(child);
					}
				}
			}

			sb.append(stuffNumber - nodeCount).append("\n");
		}

		System.out.println(sb);
	}
}
