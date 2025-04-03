import java.io.*;
import java.util.*;

class Main {
	static int buildingNumber, edgeNumber, winningBuilding;
	static int[] time, prefixTime, degree; // 건물별 건설 시간, 누적 건설 시간, 위상 정렬 차수
	static Map<Integer, Set<Integer>> edges;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < testCase; tc++) {
			st = new StringTokenizer(br.readLine());

			buildingNumber = Integer.parseInt(st.nextToken());
			edgeNumber = Integer.parseInt(st.nextToken());

			time = new int[buildingNumber + 1];
			prefixTime = new int[buildingNumber + 1];
			degree = new int[buildingNumber + 1];
			edges = new HashMap<>();

			for (int i = 1; i <= buildingNumber; i++) { // edges 초기화
				edges.put(i, new HashSet<>());
			}

			st = new StringTokenizer(br.readLine()); // 건물별 건설 시간 입력

			for (int i = 1; i <= buildingNumber; i++) {
				time[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < edgeNumber; i++) { // 간선 정보 입력
				st = new StringTokenizer(br.readLine());

				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());

				edges.get(start).add(end);
			}

			winningBuilding = Integer.parseInt(br.readLine());

			// 입력부 종료

			for (Set<Integer> v : edges.values()) { // 차수 계산
				for (int i : v) {
					degree[i] += 1;
				}
			}

			// 위상 정렬

			ArrayDeque<Integer> topologySort = new ArrayDeque<>();

			for (int i = 1; i <= buildingNumber; i++) {
				if (degree[i] == 0) {
					topologySort.add(i);
				}
			}

			while (!topologySort.isEmpty()) {
				int n = topologySort.removeFirst();

				for (int p : edges.get(n)) {
					degree[p] -= 1;

					prefixTime[p] = Math.max(prefixTime[p], prefixTime[n] + time[n]);

					if (degree[p] == 0) {
						topologySort.addLast(p);
					}
				}
			}

			sb.append(prefixTime[winningBuilding] + time[winningBuilding]).append("\n");
		}

		System.out.print(sb);
	}
}
