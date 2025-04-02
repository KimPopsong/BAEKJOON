import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int sushiNumber, sushiTypeNumber, sushiStreak, sushiCoupon;
		int maxType = 0;
		int[] sushies;

		st = new StringTokenizer(br.readLine());

		sushiNumber = Integer.parseInt(st.nextToken());
		sushiTypeNumber = Integer.parseInt(st.nextToken());
		sushiStreak = Integer.parseInt(st.nextToken());
		sushiCoupon = Integer.parseInt(st.nextToken());

		sushies = new int[sushiNumber + sushiStreak - 1];

		for (int i = 0; i < sushiNumber; i++) {
			sushies[i] = Integer.parseInt(br.readLine());
		}

		for (int i = sushiNumber; i < sushiNumber + sushiStreak - 1; i++) {
			sushies[i] = sushies[i - sushiNumber];
		}

		Map<Integer, Integer> canEat = new HashMap<>();

		canEat.put(sushiCoupon, 1); // 쿠폰이 되는 초밥은 항상 들어가있음

		for (int i = 0; i < sushiStreak; i++) {
			add(canEat, sushies[i]);

			maxType = Math.max(maxType, canEat.keySet().size());
		}

		for (int i = 1; i < sushiNumber; i++) {
			subtract(canEat, sushies[i - 1]);
			add(canEat, sushies[i + sushiStreak - 1]);

			maxType = Math.max(maxType, canEat.keySet().size());
		}

		System.out.println(maxType);
	}

	static void add(Map<Integer, Integer> canEat, int sushi) {
		if (canEat.containsKey(sushi)) {
			canEat.put(sushi, canEat.get(sushi) + 1);
		}

		else {
			canEat.put(sushi, 1);
		}
	}

	static void subtract(Map<Integer, Integer> canEat, int sushi) {
		Integer left = canEat.get(sushi) - 1;

		if (left <= 0) {
			canEat.remove(sushi);
		}

		else {
			canEat.put(sushi, left);
		}
	}
}
