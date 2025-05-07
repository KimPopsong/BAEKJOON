import java.io.*;
import java.util.*;

public class Main {
	static int cowNumber;
	static PriorityQueue<Cow> cows;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		cowNumber = Integer.parseInt(br.readLine());
		cows = new PriorityQueue<>(new Comparator<Cow>() {
			@Override
			public int compare(Cow c1, Cow c2) {
				if (c1.arrivalTime == c2.arrivalTime) {
					return Integer.compare(c1.checkTime, c2.checkTime);
				}

				return Integer.compare(c1.arrivalTime, c2.arrivalTime);
			}
		});

		for (int i = 0; i < cowNumber; i++) {
			st = new StringTokenizer(br.readLine());

			int arrivalTime = Integer.parseInt(st.nextToken());
			int checkTime = Integer.parseInt(st.nextToken());

			cows.add(new Cow(arrivalTime, checkTime));
		}

		int time = 0;
		while (!cows.isEmpty()) {
			Cow cow = cows.remove();

			if (time < cow.arrivalTime) {
				time = cow.arrivalTime;
			}

			time += cow.checkTime;
		}

		System.out.println(time);
	}

	static class Cow {
		int arrivalTime, checkTime;

		Cow(int arrivalTime, int checkTime) {
			this.arrivalTime = arrivalTime;
			this.checkTime = checkTime;
		}
	}
}
