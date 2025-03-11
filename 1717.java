import java.io.*;
import java.util.*;

public class Main {
	static int[] parent, rank;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int number = Integer.parseInt(st.nextToken());
		int operationNumber = Integer.parseInt(st.nextToken());

		parent = new int[number + 1];
		rank = new int[number + 1];

		for (int i = 0; i <= number; i++) {
			parent[i] = i; // 처음에는 자기 자신이 대표
			rank[i] = 1; // 초기 랭크는 1
		}

		for (int i = 0; i < operationNumber; i++) {
			st = new StringTokenizer(br.readLine());

			int command = Integer.parseInt(st.nextToken());
			int element1 = Integer.parseInt(st.nextToken());
			int element2 = Integer.parseInt(st.nextToken());

			if (command == 0) { // 합집합 연산
				union(element1, element2);
			}

			else { // 같은 집합인지 확인
				if (find(element1) == find(element2)) {
					sb.append("YES\n");
				}

				else {
					sb.append("NO\n");
				}
			}
		}

		System.out.print(sb);
	}

	// 부모 찾기 (경로 압축 적용)
	static int find(int x) {
		if (parent[x] == x)
			return x;

		else {
			return parent[x] = find(parent[x]); // 경로 압축
		}
	}

	// 합집합 (랭크 고려하여 병합)
	static void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);

		if (rootX != rootY) {
			if (rank[rootX] > rank[rootY]) {
				parent[rootY] = rootX;
			}

			else if (rank[rootX] < rank[rootY]) {
				parent[rootX] = rootY;
			}

			else {
				parent[rootY] = rootX;
				rank[rootX]++;
			}
		}
	}
}
