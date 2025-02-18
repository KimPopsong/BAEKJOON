import java.io.*;
import java.util.*;

class Solution {
	static int studentNumber, edgeNumber;
	static Map<Integer, Set<Integer>> edges;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());

		studentNumber = Integer.parseInt(st.nextToken());
		edgeNumber = Integer.parseInt(st.nextToken());
		int count = 0;

		edges = new HashMap<>();
		for (int student = 1; student <= studentNumber; student++) {
			edges.put(student, new HashSet<>());
		}

		for (int i = 0; i < edgeNumber; i++) {
			st = new StringTokenizer(br.readLine());

			Set<Integer> set = edges.get(Integer.parseInt(st.nextToken()));
			set.add(Integer.parseInt(st.nextToken()));
		}

		for (int student = 1; student <= studentNumber; student++) {
			Set<Integer> canGo = edges.get(student);

			ArrayDeque<Integer> find = new ArrayDeque<>();
			boolean[] isVisit = new boolean[studentNumber + 1];

			isVisit[student] = true;
			for (int s : canGo) {
				find.add(s);
				isVisit[s] = true;
			}

			while (!find.isEmpty()) {
				int s = find.removeFirst();

				for (int d : edges.get(s)) {
					if (isVisit[d] == false) {

						canGo.add(d);

						find.add(d);
						isVisit[d] = true;
					}
				}
			}
		}

		for (int student = 1; student <= studentNumber; student++) {
			for (int destination : edges.get(student)) {
				edges.get(destination).add(student);
			}
		}

		for (int student = 1; student <= studentNumber; student++) {
			if (edges.get(student).size() == studentNumber - 1) {
				count += 1;
			}
		}

		System.out.println(count);
	}
}
