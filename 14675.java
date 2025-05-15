import java.util.*;
import java.io.*;

public class Main {
	static int nodeNumber, questionNumber;
	static int[] nodes;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		nodeNumber = Integer.parseInt(br.readLine());
		nodes = new int[nodeNumber + 1];

		for (int i = 0; i < nodeNumber - 1; i++) {
			st = new StringTokenizer(br.readLine());

			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());

			nodes[node1] += 1;
			nodes[node2] += 1;
		}

		questionNumber = Integer.parseInt(br.readLine());

		for (int i = 0; i < questionNumber; i++) {
			st = new StringTokenizer(br.readLine());

			int item = Integer.parseInt(st.nextToken()); // 항목. 1이면 단절점인지, 2이면 단절선인지
			int index = Integer.parseInt(st.nextToken());

			if (item == 1) { // 단절점인지 판단
				if (nodes[index] >= 2) {
					sb.append("yes").append("\n");
				}

				else {
					sb.append("no").append("\n");
				}
			}

			else {
				sb.append("yes").append("\n");
			}
		}

		System.out.println(sb);
	}
}
