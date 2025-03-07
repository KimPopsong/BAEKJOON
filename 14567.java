import java.io.*;
import java.util.*;

public class Main_bj_14567_선수과목_서울_14반_김대성 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int subjectNumber, edgeNumber;
		int[] subjectCanComplete, degree; // 이수할 수 있는 최소 학기, 차수
		ArrayList<Integer>[] subjects;

		st = new StringTokenizer(br.readLine());

		subjectNumber = Integer.parseInt(st.nextToken());
		edgeNumber = Integer.parseInt(st.nextToken());

		subjects = new ArrayList[subjectNumber + 1];
		subjectCanComplete = new int[subjectNumber + 1];
		degree = new int[subjectNumber + 1];

		for (int i = 1; i <= subjectNumber; i++) {
			subjects[i] = new ArrayList<>();
		}

		for (int i = 0; i < edgeNumber; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			subjects[start].add(end);
			degree[end] += 1;
		}

		int time = 0;
		ArrayDeque<Integer> topology = new ArrayDeque<>();

		for (int i = 1; i <= subjectNumber; i++) {
			if (degree[i] == 0) {
				topology.add(i);
			}
		}

		while (!topology.isEmpty()) {
			time += 1;
			ArrayDeque<Integer> tempTopology = new ArrayDeque<>(topology);
			topology.clear();

			while (!tempTopology.isEmpty()) {
				int sub = tempTopology.remove();

				subjectCanComplete[sub] = time;

				for (int i : subjects[sub]) {
					degree[i] -= 1;

					if (degree[i] == 0) {
						topology.add(i);
					}
				}
			}
		}

		for (int i = 1; i <= subjectNumber; i++) {
			sb.append(subjectCanComplete[i]).append(" ");
		}

		System.out.println(sb);
	}
}
