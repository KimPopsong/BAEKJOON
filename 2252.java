import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int studentNumber, compareNumber;

		st = new StringTokenizer(br.readLine());
		studentNumber = Integer.parseInt(st.nextToken());
		compareNumber = Integer.parseInt(st.nextToken());

		ArrayList<Integer>[] compare = new ArrayList[studentNumber + 1]; // [ 학생 : [ 학생의 앞에 있어야 하는 사람들의 목록 ] ]
		int[] degree = new int[studentNumber + 1]; // 아래 있는

		for (int i = 1; i <= studentNumber; i++) {
			compare[i] = new ArrayList<>();
		}

		for (int i = 0; i < compareNumber; i++) {
			st = new StringTokenizer(br.readLine());

			int studentSmall = Integer.parseInt(st.nextToken());
			int studentBig = Integer.parseInt(st.nextToken());

			compare[studentBig].add(studentSmall);
			degree[studentSmall] += 1;
		}

		ArrayDeque<Integer> topology = new ArrayDeque<>();
		for (int i = 1; i <= studentNumber; i++) {
			if (degree[i] == 0) {
				topology.add(i);
			}
		}

		ArrayDeque<Integer> answer = new ArrayDeque<>();

		while (!topology.isEmpty()) {
			int student = topology.removeFirst();

			answer.addFirst(student);

			for (int i : compare[student]) {
				degree[i] -= 1;

				if (degree[i] == 0) {
					topology.addLast(i);
				}
			}
		}

		while (!answer.isEmpty()) {
			sb.append(answer.removeFirst()).append(" ");
		}

		System.out.println(sb);
	}
}
