import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int groundSize, commandNumber;
		int[] ground, dp;
		ArrayList<Command> commands = new ArrayList<>();

		st = new StringTokenizer(br.readLine());

		groundSize = Integer.parseInt(st.nextToken());
		commandNumber = Integer.parseInt(st.nextToken());

		ground = new int[1 + groundSize];
		dp = new int[1 + groundSize];

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= groundSize; i++) {
			ground[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < commandNumber; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			commands.add(new Command(s, e, d));
		}

		for (Command c : commands) {
			int start = c.start;
			int end = c.end;
			int delta = c.delta;

			dp[start - 1] -= delta;
			dp[end] += delta;
		}

		int delta = 0;
		for (int i = groundSize; i > 0; i--) {
			delta += dp[i];

			ground[i] += delta;
		}

		for (int i = 1; i <= groundSize; i++) {
			System.out.print(ground[i] + " ");
		}
	}

	static class Command {
		int start, end, delta;

		public Command(int start, int end, int delta) {
			this.start = start;
			this.end = end;
			this.delta = delta;
		}
	}
}
