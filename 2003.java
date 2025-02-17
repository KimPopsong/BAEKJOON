import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int number, sum, count = 0;
		int[] numbers;

		st = new StringTokenizer(br.readLine());
		number = Integer.parseInt(st.nextToken());
		sum = Integer.parseInt(st.nextToken());

		numbers = new int[number];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < number; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		int leftNode = 0, rightNode = 0;
		int sumTemp = numbers[0];
		while (true) {
			if (sumTemp == sum) {
				count += 1;

				sumTemp -= numbers[leftNode++];

				rightNode += 1;

				if (rightNode >= number) {
					break;
				}

				sumTemp += numbers[rightNode];
			}

			else if (sumTemp > sum) {
				sumTemp -= numbers[leftNode++];

				if (leftNode > rightNode) {
					rightNode = leftNode;

					if (rightNode >= number) {
						break;
					}

					sumTemp += numbers[rightNode];
				}
			}

			else {
				rightNode += 1;

				if (rightNode >= number) {
					break;
				}

				sumTemp += numbers[rightNode];
			}
		}

		System.out.println(count);
	}
}
