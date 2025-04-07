import java.io.*;
import java.util.*;

public class Main {
	static int number;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		number = Integer.parseInt(br.readLine());
		dp = new int[number + 1];

		ArrayDeque<Integer> bfs = new ArrayDeque<>();
		bfs.add(1);
		dp[1] = 1;

		while (!bfs.isEmpty()) {
			int n = bfs.removeFirst();

			if (n * 3 <= number && dp[n * 3] == 0) {
				dp[n * 3] = n;
				bfs.addLast(n * 3);
			}

			if (n * 2 <= number && dp[n * 2] == 0) {
				dp[n * 2] = n;
				bfs.addLast(n * 2);
			}

			if (n + 1 <= number && dp[n + 1] == 0) {
				dp[n + 1] = n;
				bfs.addLast(n + 1);
			}
		}
		
		int count = 0;
		int node = number;
		while (node != 1) {
			count += 1;
			node = dp[node];
		}

		sb.append(count).append("\n");

		node = number;
		while (node != 1) {
			sb.append(node).append(" ");
			node = dp[node];
		}

		sb.append(1);

		System.out.print(sb);
	}
}
