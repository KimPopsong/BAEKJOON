import java.io.*;
import java.util.*;

public class Main {
	static int number, queryNumber;
	static int[] numbers, segTree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		number = Integer.parseInt(br.readLine());
		numbers = new int[number];
		segTree = new int[number * 4];

		Arrays.fill(segTree, 1000000000);

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < number; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		getSegTree(0, number - 1, 1);

		queryNumber = Integer.parseInt(br.readLine());
		for (int i = 0; i < queryNumber; i++) {
			st = new StringTokenizer(br.readLine());

			int query = Integer.parseInt(st.nextToken());

			if (query == 1) {
				int changeIndex, to;
				changeIndex = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());

				numbers[changeIndex - 1] = to;

				modifySegTree(0, number - 1, 1, changeIndex - 1);
			}

			else {
				sb.append(segTree[1] + 1).append("\n");
			}
		}

		System.out.println(sb);
	}

	static int modifySegTree(int left, int right, int index, int changeIndex) {
		if (left == right) {
			segTree[index] = left;

			return segTree[index];
		}

		int mid = (left + right) / 2;

		int index1, index2;

		if (changeIndex <= mid) {
			index1 = modifySegTree(left, mid, index * 2, changeIndex);
			index2 = segTree[index * 2 + 1];
		}

		else {
			index1 = segTree[index * 2];
			index2 = modifySegTree(mid + 1, right, index * 2 + 1, changeIndex);
		}

		if (numbers[index1] <= numbers[index2]) {
			segTree[index] = index1;
		}

		else {
			segTree[index] = index2;
		}

		return segTree[index];
	}

	static int getSegTree(int left, int right, int index) { // 최소 숫자를 구하는 세그 트리 만들기
		if (left == right) {
			segTree[index] = left;

			return segTree[index];
		}
		int mid = (left + right) / 2;

		int index1 = getSegTree(left, mid, index * 2);
		int index2 = getSegTree(mid + 1, right, index * 2 + 1);

		if (numbers[index1] <= numbers[index2]) {
			segTree[index] = index1;
		}

		else {
			segTree[index] = index2;
		}

		return segTree[index];
	}
}
