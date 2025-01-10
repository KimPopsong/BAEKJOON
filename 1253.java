import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int number = Integer.parseInt(br.readLine());
		int goodNumber = 0;
		int[] numbers = new int[number];

		String[] temp = br.readLine().split(" ");

		for (int i = 0; i < number; i++) {
			numbers[i] = Integer.parseInt(temp[i]);
		}

		Arrays.sort(numbers);

		for (int nod = 0; nod < number; nod++) {
			int leftNode = 0;
			int rightNode = number - 1;

			while (leftNode < rightNode) {
				if (leftNode == nod) {
					leftNode += 1;

					continue;
				}

				else if (rightNode == nod) {
					rightNode -= 1;

					continue;
				}

				int nodeNumber = numbers[nod];
				int sum = numbers[leftNode] + numbers[rightNode];

				if (sum == nodeNumber) {
					goodNumber += 1;

					break;
				}

				else if (sum > nodeNumber) {
					rightNode -= 1;
				}

				else {
					leftNode += 1;
				}
			}
		}

		System.out.println(goodNumber);
	}
}
