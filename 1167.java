import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class Main {
	static int nodeNumber;
	static Map<Integer, Map<Integer, Integer>> map = new HashMap<>(); // { 노드 : { 다른 노드 : 거리 } }

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		nodeNumber = Integer.parseInt(br.readLine());

		for (int i = 1; i <= nodeNumber; i++) { // map 초기화
			map.put(i, new HashMap<>());
		}

		for (int i = 0; i < nodeNumber; i++) { // 간선 입력
			st = new StringTokenizer(br.readLine());

			int node = Integer.parseInt(st.nextToken());

			Map<Integer, Integer> childs = map.get(node);

			while (true) {
				int destination = Integer.parseInt(st.nextToken());

				if (destination == -1) {
					break;
				}

				int distance = Integer.parseInt(st.nextToken());

				if (childs.containsKey(destination)) { // node -> child 입력
					if (childs.get(destination) < distance) {
						childs.put(destination, distance);
					}
				}

				else {
					childs.put(destination, distance);
				}

				Map<Integer, Integer> child2 = map.get(destination); // child -> node 입력

				if (child2.containsKey(node)) {
					if (child2.get(node) < distance) {
						child2.put(node, distance);
					}
				}

				else {
					child2.put(node, distance);
				}
			}
		}

		// 입력 끝
		{
			PriorityQueue<Node> pq = new PriorityQueue<>();
			boolean[] isVisit = new boolean[nodeNumber + 1];

			pq.add(new Node(1, 0)); // 1번 노드를 기준으로 가장 먼 노드 구하기

			while (!pq.isEmpty()) {
				Node middleNode = pq.remove();

				if (isVisit[middleNode.destination]) { // 이미 방문한 노드라면
					continue;
				}

				isVisit[middleNode.destination] = true; // 방문 처리
				map.get(1).put(middleNode.destination, middleNode.distance);

				Map<Integer, Integer> endNode = map.get(middleNode.destination);

				for (int endDestination : endNode.keySet()) {
					pq.add(new Node(endDestination,
							map.get(1).get(middleNode.destination) + endNode.get(endDestination)));
				}
			}
		}

		int maxNode = 0;
		int maxDistance = 0;
		for (int k : map.get(1).keySet()) {
			int distance = map.get(1).get(k);

			if (distance > maxDistance) {
				maxDistance = distance;
				maxNode = k;
			}
		}

		{
			PriorityQueue<Node> pq = new PriorityQueue<>();
			boolean[] isVisit = new boolean[nodeNumber + 1];

			pq.add(new Node(maxNode, 0)); // maxNode를 기준으로 가장 먼 노드 구하기

			while (!pq.isEmpty()) {
				Node middleNode = pq.remove();

				if (isVisit[middleNode.destination]) { // 이미 방문한 노드라면
					continue;
				}

				isVisit[middleNode.destination] = true; // 방문 처리
				map.get(maxNode).put(middleNode.destination, middleNode.distance);

				Map<Integer, Integer> endNode = map.get(middleNode.destination);

				for (int endDestination : endNode.keySet()) {
					pq.add(new Node(endDestination,
							map.get(maxNode).get(middleNode.destination) + endNode.get(endDestination)));
				}
			}
			maxDistance = 0;
			for (int k : map.get(maxNode).keySet()) {
				maxDistance = Math.max(maxDistance, map.get(maxNode).get(k));
			}

			System.out.println(maxDistance);
		}
	}

	static class Node implements Comparable<Node> {
		int destination;
		int distance;

		Node(int destination, int distance) {
			this.destination = destination;
			this.distance = distance;
		}

		@Override
		public int compareTo(Node node) {
			return this.distance - node.distance;
		}
	}
}
