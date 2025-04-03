import java.io.*;
import java.util.*;

class Main {
	static int singerNumber, pdNumber;
	static int[] topology; // 차수 저장
	static Map<Integer, Set<Integer>> graph = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());

		singerNumber = Integer.parseInt(st.nextToken());
		pdNumber = Integer.parseInt(st.nextToken());

		topology = new int[singerNumber + 1];

		for (int i = 1; i <= singerNumber; i++) {
			graph.put(i, new HashSet<>());
		}

		for (int i = 0; i < pdNumber; i++) {
			st = new StringTokenizer(br.readLine());

			int size = Integer.parseInt(st.nextToken());
			int[] temp = new int[size];

			for (int j = 0; j < size; j++) {
				temp[j] = Integer.parseInt(st.nextToken());
			}

			for (int j = 0; j < size - 1; j++) {
				graph.get(temp[j]).add(temp[j + 1]);
			}
		}

		for (int key : graph.keySet()) {
			Set<Integer> values = graph.get(key);

			for (int i : values) {
				topology[i] += 1;
			}
		}

		ArrayDeque<Integer> topologySort = new ArrayDeque<>();

		for (int i = 1; i <= singerNumber; i++) {
			if (topology[i] == 0) {
				topologySort.add(i);
			}
		}

		while (!topologySort.isEmpty()) {
			int n = topologySort.removeFirst();

			sb.append(n).append("\n");

			for (int i : graph.get(n)) {
				topology[i] -= 1;

				if (topology[i] == 0) {
					topologySort.addLast(i);
				}
			}
		}

		boolean flag = true;
		for (int i = 1; i <= singerNumber; i++) {
			if (topology[i] != 0) {
				flag = false;

				break;
			}
		}

		if (flag) {
			System.out.print(sb);
		}

		else {
			System.out.println(0);
		}
	}
}
