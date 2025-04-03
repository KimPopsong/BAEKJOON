import java.io.*;
import java.util.*;

class Main {
	static int appNumber, removeMemory, sumMemory, sumOverhead; // 전체 메모리, 전체 오버헤드
	static long[] dp; // 1차원 knapsack
	static ArrayList<App> apps = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());

		appNumber = Integer.parseInt(st.nextToken());
		removeMemory = Integer.parseInt(st.nextToken());

		for (int i = 0; i < appNumber; i++) {
			apps.add(new App());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < appNumber; i++) {
			int m = Integer.parseInt(st.nextToken());

			apps.get(i).memory = m;
			sumMemory += m;
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < appNumber; i++) {
			int o = Integer.parseInt(st.nextToken());

			apps.get(i).overhead = o;
			sumOverhead += o;
		}

		for (int i = 0; i < appNumber; i++) { // overhead가 0인 메모리 삭제
			App app = apps.get(i);

			if (app.overhead == 0) {
				removeMemory -= app.memory;
				sumMemory -= app.memory;
				sumOverhead -= app.overhead;

				apps.remove(app);

				appNumber -= 1;
				i -= 1;
			}
		}

		removeMemory = Math.max(removeMemory, 0); // 0이하일시 보정

		dp = new long[sumMemory - removeMemory + 1];

		// 초기화 및 입력 종료

		for (App app : apps) { // 앱을 차례대로 선택
			int memory = app.memory;
			int overhead = app.overhead;

			for (int m = sumMemory - removeMemory; m >= memory; m--) {
				dp[m] = Math.max(dp[m], dp[m - memory] + overhead);
			}
		}

		System.out.println(sumOverhead - dp[sumMemory - removeMemory]);
	}

	static class App {
		int memory, overhead;

		App(int memory, int overhead) {
			this.memory = memory;
			this.overhead = overhead;
		}

		public App() {
		}
	}
}
