import java.io.*;
import java.util.*;

class Main {
	static ArrayList<Integer> primeNumbers = new ArrayList<>();

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int number = Integer.parseInt(br.readLine());
		int count = 0;

		boolean[] primeNumber = new boolean[4000001];
		Arrays.fill(primeNumber, true);

		primeNumber[0] = false;
		primeNumber[1] = false;

		for (int i = 2; i <= 2000; i++) {
			if (primeNumber[i]) {
				for (int j = 2; i * j <= 4000000; j++) {
					primeNumber[i * j] = false;
				}

			}

			else {
				continue;
			}
		}

		for (int i = 2; i <= 4000000; i++) {
			if (primeNumber[i]) {
				primeNumbers.add(i);
			}
		}

		int leftNode = 0, rightNode = 0;
		int sumTemp = 2;
		while (true) {
			if (sumTemp == number) {
				count += 1;

				sumTemp -= primeNumbers.get(leftNode++);

				rightNode += 1;

				if (rightNode >= primeNumbers.size() || primeNumbers.get(rightNode) > number) {
					break;
				}

				else {
					sumTemp += primeNumbers.get(rightNode);
				}
			}

			else if (sumTemp < number) {
				rightNode += 1;

				if (rightNode >= primeNumbers.size() || primeNumbers.get(rightNode) > number) {
					break;
				}

				else {
					sumTemp += primeNumbers.get(rightNode);
				}
			}

			else {
				sumTemp -= primeNumbers.get(leftNode++);

				if (rightNode < leftNode) {
					rightNode = leftNode;

					if (rightNode >= primeNumbers.size() || primeNumbers.get(rightNode) > number) {
						break;
					}

					else {
						sumTemp += primeNumbers.get(rightNode);
					}
				}
			}
		}

		System.out.println(count);
	}
}
