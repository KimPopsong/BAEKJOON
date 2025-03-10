import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;

	static int nodeNumber, roadNumber, wormholeNumber; // 노드의 개수, 길의 개수, 웜홀의 개수
	static int[][] roads; // 도로

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();

		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < testCase; tc++) {
			initialize();

			if (check(1)) {
				sb.append("YES").append("\n");
			}

			else {
				sb.append("NO").append("\n");
			}
		}

		System.out.print(sb);
		br.close();
	}

	/**
	 * 벨만 포드 알고리즘 사용. 음의 사이클이 존재하는지 확인
	 */
	static boolean check(int startNode) {
		int[] distance = new int[nodeNumber + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[startNode] = 0; // 1번 노드 시작

		// 벨만-포드 알고리즘 수행 (N-1번 반복)
		for (int i = 1; i < nodeNumber; i++) {
			for (int u = 1; u <= nodeNumber; u++) {
				for (int v = 1; v <= nodeNumber; v++) {
					if (distance[u] != Integer.MAX_VALUE) {
						if (distance[v] > distance[u] + roads[u][v]) {
							distance[v] = distance[u] + roads[u][v];
						}
					}
				}
			}
		}

		// 음의 사이클 존재 여부 확인 (추가 1회 수행)
		boolean hasNegativeCycle = false;
		for (int u = 1; u <= nodeNumber; u++) {
			for (int v = 1; v <= nodeNumber; v++) {
				if (distance[u] != Integer.MAX_VALUE) {
					if (distance[v] > distance[u] + roads[u][v]) {
						hasNegativeCycle = true;
					}
				}
			}
		}

		// 음의 사이클이 있으면 "YES", 없으면 "NO"
		return hasNegativeCycle;
	}

	static void initialize() throws IOException { // 초기화
		st = new StringTokenizer(br.readLine());

		nodeNumber = Integer.parseInt(st.nextToken());
		roadNumber = Integer.parseInt(st.nextToken());
		wormholeNumber = Integer.parseInt(st.nextToken());

		roads = new int[nodeNumber + 1][nodeNumber + 1];

		for (int s = 1; s <= nodeNumber; s++) { // 도로 초기화
			for (int e = 1; e <= nodeNumber; e++) {
				if (s == e) {
					continue;
				}

				roads[s][e] = 987654321;
			}
		}

		for (int i = 0; i < roadNumber; i++) { // 도로 입력
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());

			roads[start][end] = Math.min(roads[start][end], time); // 방향이 없음
			roads[end][start] = Math.min(roads[end][start], time); // 도로가 여러 개 있을 수 있음
		}

		for (int i = 0; i < wormholeNumber; i++) { // 웜홀 입력
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());

			roads[start][end] = Math.min(roads[start][end], -1 * time); // 방향이 있음
		}
	}
}
