import java.io.*;
import java.util.*;

public class Main {
	static int areaNumber; // 지역의 개수
	static int minGap = Integer.MAX_VALUE;
	static int[] areaPopulation; // 지역별 인구수
	static boolean[][] edges; // 간선

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		areaNumber = Integer.parseInt(br.readLine()); // 지역의 개수 입력
		areaPopulation = new int[areaNumber + 1];
		edges = new boolean[areaNumber + 1][areaNumber + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= areaNumber; i++) { // 지역별 인구수 입력
			areaPopulation[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= areaNumber; i++) { // 간선 표시
			st = new StringTokenizer(br.readLine());

			st.nextToken();

			while (st.hasMoreTokens()) {
				int node = Integer.parseInt(st.nextToken());

				edges[i][node] = true;
				edges[node][i] = true;
			}
		}

		for (int combNumber = 1; combNumber <= (areaNumber / 2); combNumber++) { // 조합 구하기
			findComb(combNumber, 0, 1, new ArrayList<>());
		}

		if (minGap == Integer.MAX_VALUE) {
			System.out.println(-1);
		}

		else {
			System.out.println(minGap);
		}
	}

	static boolean isConnect(Set<Integer> parts) { // 선거구를 받아 서로 연결되어 있는지 확인
		int startNode = 0;
		ArrayDeque<Integer> bfs = new ArrayDeque<>();
		boolean[] isVisit = new boolean[areaNumber + 1];

		Arrays.fill(isVisit, true);
		for (int i : parts) {
			isVisit[i] = false;
			startNode = i;
		}

		bfs.add(startNode);
		isVisit[startNode] = true;

		while (!bfs.isEmpty()) {
			int node = bfs.remove();

			for (int i = 1; i <= areaNumber; i++) {
				if (edges[node][i]) { // 노드가 연결되어 있고
					if (isVisit[i] == false) { // 가지 않은 지역이라면
						bfs.add(i);
						isVisit[i] = true;
					}
				}
			}
		}

		for (boolean i : isVisit) {
			if (i == false) {
				return false; // 연결되어 있지 않으면 false
			}
		}

		return true; // 연결되어 있으면 true
	}

	static void calcPopulationGap(Set<Integer> part1, Set<Integer> part2) { // 선거구의 인구 수 차이 확인
		if (isConnect(part1) == false || isConnect(part2) == false) { // 둘 중 한 개의 선거구라도 서로 연결되어 있지 않다면
			return; // 계산하지 않음
		}

		// 선거구의 합 구하고 차 구하기
		int sumPart1 = 0;
		for (int i : part1) {
			sumPart1 += areaPopulation[i];
		}

		int sumPart2 = 0;
		for (int i : part2) {
			sumPart2 += areaPopulation[i];
		}

		minGap = Math.min(minGap, Math.abs(sumPart1 - sumPart2));
	}

	static void findComb(int maxDepth, int depth, int index, ArrayList<Integer> combs) { // 조합 구하기
		if (maxDepth == depth) { // 조합 별 선거구 나누기
			Set<Integer> part1 = new HashSet<>();
			Set<Integer> part2 = new HashSet<>();

			for (int i = 1; i <= areaNumber; i++) {
				part2.add(i);
			}

			for (int i : combs) {
				part1.add(i);
				part2.remove(i);
			}

			calcPopulationGap(part1, part2);

			return;
		}

		for (int i = index; i <= areaNumber; i++) {
			combs.add(i);
			findComb(maxDepth, depth + 1, i + 1, combs);
			combs.remove(combs.size() - 1);
		}
	}
}
