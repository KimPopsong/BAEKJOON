import java.io.*;
import java.util.*;

class Main {
	static int pointNumber, turnNumber;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());

		pointNumber = Integer.parseInt(st.nextToken());
		turnNumber = Integer.parseInt(st.nextToken());

		parent = new int[pointNumber];

		for (int i = 0; i < pointNumber; i++) {
			parent[i] = i;
		}

		boolean flag = false;
		int turn = 1;
		for (turn = 1; turn <= turnNumber; turn++) {
			st = new StringTokenizer(br.readLine());

			int point1 = Integer.parseInt(st.nextToken());
			int point2 = Integer.parseInt(st.nextToken());

			if (union(point1, point2)) {
				flag = true;

				break;
			}
		}

		if (flag) { // 게임이 끝났다면
			System.out.println(turn);
		}

		else {
			System.out.println(0);
		}
	}

	static int findParent(int n) {
		if (parent[n] == n) {
			return n;
		}

		return parent[n] = findParent(parent[n]);
	}

	static boolean union(int n1, int n2) {
		int p1 = findParent(n1);
		int p2 = findParent(n2);

		if (p1 == p2) {
			return true;
		}

		else {
			parent[p2] = p1;

			return false;
		}
	}
}
