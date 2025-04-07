import java.io.*;
import java.util.*;

public class Main {
	static int nodeNumber, edgeNumber;
	static Map<Integer, Set<Integer>> edges;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < testCase; tc++) {
			st = new StringTokenizer(br.readLine());

			nodeNumber = Integer.parseInt(st.nextToken());
			edgeNumber = Integer.parseInt(st.nextToken());

			edges = new HashMap<>();

			for (int i = 1; i <= nodeNumber; i++) {
				edges.put(i, new HashSet<>());
			}

			for (int i = 0; i < edgeNumber; i++) {
				st = new StringTokenizer(br.readLine());

				int node1 = Integer.parseInt(st.nextToken());
				int node2 = Integer.parseInt(st.nextToken());

				edges.get(node1).add(node2);
				edges.get(node2).add(node1);
			}

			// 1번 노드부터 색칠
			// 그래프가 분리되어 있을 수 있으므로 모든 노드 색칠
			int[] isVisit = new int[nodeNumber + 1]; // 0 : 방문안함, 1 : 빨강, 2 : 파랑
			for (int startNode = 1; startNode <= nodeNumber; startNode++) {
				if (isVisit[startNode] != 0) {
					continue;
				}

				ArrayDeque<Integer> bfs = new ArrayDeque<>();

				bfs.add(startNode);
				isVisit[startNode] = 1; // 빨강으로 시작

				while (!bfs.isEmpty()) {
					ArrayDeque<Integer> tempBfs = new ArrayDeque<>(bfs);
					bfs.clear();

					int color = 1;

					while (!tempBfs.isEmpty()) {
						int node = tempBfs.remove();

						if (isVisit[node] == 1) {
							color = 2;
						}

						else if (isVisit[node] == 2) {
							color = 1;
						}

						for (int endNode : edges.get(node)) {
							if (isVisit[endNode] == 0) {
								isVisit[endNode] = color;
								bfs.add(endNode);
							}
						}
					}
				}
			}

			boolean flag = true;

			for (int node = 1; node <= nodeNumber; node++) {
				flag = true;
				int color = isVisit[node];

				for (int endNode : edges.get(node)) {
					if (isVisit[endNode] == color) {
						flag = false;

						break;
					}
				}

				if (flag == false) {
					break;
				}
			}

			if (flag) {
				sb.append("YES").append("\n");
			}

			else {
				sb.append("NO").append("\n");
			}
		}

		System.out.print(sb);
	}
}
