import java.io.*;
import java.util.*;

class Main {
	static int nodeNumber; // 노드의 개수
	static Map<Integer, Map<Integer, Integer>> tree = new HashMap<>(); // { 노드 : { 도착 노드 : 거리 }}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		nodeNumber = Integer.parseInt(br.readLine());

		if (nodeNumber == 1) { // 1인 경우 예외처리
			System.out.println(0);

			System.exit(0);
		}

		for (int i = 1; i <= nodeNumber; i++) {
			tree.put(i, new HashMap<>());
		}

		for (int i = 0; i < nodeNumber - 1; i++) {
			st = new StringTokenizer(br.readLine());

			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());

			if (tree.get(node1).containsKey(node2)) { // 이미 노드가 있다면
				int d = tree.get(node1).get(node2);

				if (d < distance) {
					tree.get(node1).put(node2, distance); // 양방향 트리
					tree.get(node2).put(node1, distance);
				}
			}

			else {
				tree.get(node1).put(node2, distance); // 양방향 트리
				tree.get(node2).put(node1, distance);
			}
		}

		// 입력부 끝

		int startNode = 1; // 1번 노드에서, 가장 멀리있는 노드 찾기
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] isVisit = new boolean[nodeNumber + 1];

		isVisit[startNode] = true;

		for (int key : tree.get(startNode).keySet()) {
			pq.add(new Node(key, tree.get(startNode).get(key)));
		}

		while (!pq.isEmpty()) {
			Node node = pq.remove();

			if (isVisit[node.nodeNumber]) {
				continue;
			}

			isVisit[node.nodeNumber] = true;
			tree.get(startNode).put(node.nodeNumber, node.distance); // 갱신

			for (int key : tree.get(node.nodeNumber).keySet()) {
				pq.add(new Node(key, tree.get(node.nodeNumber).get(key) + node.distance));
			}
		}

		int farNode = 0; // 가장 먼 노드 찾기
		int farDistance = 0;
		for (int key : tree.get(startNode).keySet()) {
			if (tree.get(startNode).get(key) > farDistance) {
				farNode = key;
				farDistance = tree.get(startNode).get(key);
			}
		}

		startNode = farNode; // 가장 먼 노드에서, 다시 가장 멀리있는 노드 찾기
		pq = new PriorityQueue<>();
		isVisit = new boolean[nodeNumber + 1];

		isVisit[startNode] = true;

		for (int key : tree.get(startNode).keySet()) {
			pq.add(new Node(key, tree.get(startNode).get(key)));
		}

		while (!pq.isEmpty()) {
			Node node = pq.remove();

			if (isVisit[node.nodeNumber]) {
				continue;
			}

			isVisit[node.nodeNumber] = true;
			tree.get(startNode).put(node.nodeNumber, node.distance); // 갱신

			for (int key : tree.get(node.nodeNumber).keySet()) {
				pq.add(new Node(key, tree.get(node.nodeNumber).get(key) + node.distance));
			}
		}

		farNode = 0; // 가장 먼 노드 찾기
		farDistance = 0;
		for (int key : tree.get(startNode).keySet()) {
			if (tree.get(startNode).get(key) > farDistance) {
				farNode = key;
				farDistance = tree.get(startNode).get(key);
			}
		}

		System.out.println(farDistance);
	}

	static class Node implements Comparable<Node> {
		int nodeNumber;
		int distance;

		Node(int nodeNumber, int distance) {
			this.nodeNumber = nodeNumber;
			this.distance = distance;
		}

		@Override
		public int compareTo(Node node) {
			return this.distance - node.distance;
		}
	}
}
