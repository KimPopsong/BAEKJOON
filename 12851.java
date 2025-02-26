import java.io.*;
import java.util.*;

public class Main {
	static int subin, sister;
	static int fastestTime = Integer.MAX_VALUE, findWay = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());

		subin = Integer.parseInt(st.nextToken());
		sister = Integer.parseInt(st.nextToken());
		int time = 0;

		if (subin >= sister) {
			System.out.println(subin - sister);
			System.out.println(1);

			return;
		}

		ArrayDeque<Integer> bfs = new ArrayDeque<>();
		int[] isVisit = new int[100001];

		bfs.add(subin);
		isVisit[subin] = 1;

		while (!bfs.isEmpty()) {
			time += 1;

			ArrayDeque<Integer> tempBfs = new ArrayDeque<>(bfs);
			bfs.clear();

			boolean flag = false;
			int[] isVisitCopy = isVisit.clone();

			while (!tempBfs.isEmpty()) {
				int n = tempBfs.remove();
				int move = isVisit[n];

				if (n + 1 <= 100000) {
					if (n + 1 == sister) {
						flag = true;
					}

					else if (isVisitCopy[n + 1] == 0) {
						bfs.add(n + 1);
					}

					isVisitCopy[n + 1] += move;
				}

				if (0 <= n - 1) {
					if (n - 1 == sister) {
						flag = true;
					}

					else if (isVisitCopy[n - 1] == 0) {
						bfs.add(n - 1);
					}

					isVisitCopy[n - 1] += move;
				}

				if (n * 2 <= 100000) {
					if (n * 2 == sister) {
						flag = true;
					}

					else if (isVisitCopy[n * 2] == 0) {
						bfs.add(n * 2);
					}

					isVisitCopy[n * 2] += move;
				}
			}

			isVisit = isVisitCopy.clone();

			if (flag) {
				fastestTime = time;

				break;
			}
		}

		System.out.println(fastestTime);
		System.out.println(isVisit[sister]);
	}
}
