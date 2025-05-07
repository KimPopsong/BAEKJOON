import java.io.*;
import java.util.*;

public class Main {
	static int chickenNumber, cowNumber, answer;
	static long[] chickens;
	static Cow[] cows;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		chickenNumber = Integer.parseInt(st.nextToken());
		cowNumber = Integer.parseInt(st.nextToken());

		chickens = new long[chickenNumber];
		cows = new Cow[cowNumber];

		for (int i = 0; i < chickenNumber; i++) {
			chickens[i] = Long.parseLong(br.readLine());
		}

		for (int i = 0; i < cowNumber; i++) {
			st = new StringTokenizer(br.readLine());

			cows[i] = new Cow(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
		}

		Arrays.sort(chickens);
		Arrays.sort(cows, new Comparator<Cow>() {
			@Override
			public int compare(Cow c1, Cow c2) {
				if (c1.startTime == c2.startTime) {
					return Long.compare(c1.startTime, c2.startTime);
				}

				return Long.compare(c1.endTime, c2.endTime);
			}
		});

		ArrayDeque<Long> leftQueue = new ArrayDeque<>();
		ArrayDeque<Long> rightQueue = new ArrayDeque<>();

		for (Long chicken : chickens) {
			rightQueue.addLast(chicken);
		}

		for (Cow cow : cows) {
			while (!leftQueue.isEmpty() && leftQueue.peekLast() > cow.startTime) {
				rightQueue.addFirst(leftQueue.removeLast());
			}

			while (!rightQueue.isEmpty() && rightQueue.peekFirst() < cow.startTime) {
				leftQueue.addLast(rightQueue.removeFirst());
			}

			if (!rightQueue.isEmpty() && cow.startTime <= rightQueue.peekFirst()
					&& rightQueue.peekFirst() <= cow.endTime) {
				answer += 1;

				rightQueue.removeFirst();
			}
		}

		System.out.println(answer);
	}

	static class Cow {
		long startTime, endTime;

		Cow(long startTime, long endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}
	}
}
