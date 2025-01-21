import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int sumNum = 0, mostNum = 0, mostTime = 0;
		HashMap<Integer, Integer> numbers = new HashMap<>();

		for (int i = 0; i < 10; i++) {
			int num = Integer.parseInt(br.readLine());

			sumNum += num;

			if (numbers.containsKey(num)) {
				numbers.put(num, numbers.get(num) + 1);
			}

			else {
				numbers.put(num, 1);
			}
		}

		for (int k : numbers.keySet()) {
			if (numbers.get(k) > mostTime) {
				mostTime = numbers.get(k);
				mostNum = k;
			}
		}

		System.out.println(sumNum / 10);
		System.out.println(mostNum);
	}
}
