import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int time = Integer.parseInt(br.readLine());
		int answer = 0;
		Map<Integer, Integer> cows = new HashMap<>();

		for (int i = 0; i < time; i++) {
			st = new StringTokenizer(br.readLine());

			int cowNumber = Integer.parseInt(st.nextToken());
			int place = Integer.parseInt(st.nextToken());

			if (cows.containsKey(cowNumber)) {
				int before = cows.get(cowNumber);

				if (before != place) {
					answer += 1;

					cows.put(cowNumber, place);
				}
			}

			else {
				cows.put(cowNumber, place);
			}
		}

		System.out.println(answer);
	}
}
