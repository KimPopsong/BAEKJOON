import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	static int number, changeTime, sumTime;
	static long[] numbers;
	static BigInteger[] segTree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());

		number = Integer.parseInt(st.nextToken());
		changeTime = Integer.parseInt(st.nextToken());
		sumTime = Integer.parseInt(st.nextToken());

		numbers = new long[number + 1];
		segTree = new BigInteger[number * 4];

		for (int i = 1; i <= number; i++) {
			numbers[i] = Long.parseLong(br.readLine());
		}

		makeSegTree(1, 1, number);

		for (int i = 0; i < changeTime + sumTime; i++) {
			st = new StringTokenizer(br.readLine());

			int command = Integer.parseInt(st.nextToken());
			long from = Long.parseLong(st.nextToken());
			long to = Long.parseLong(st.nextToken());

			if (command == 1) { // from번째 수를 to로 변경
				updateSegTree(1, 1, number, from, to);
			}

			else { // from ~ to의 합을 구함
				sb.append(getSegTree(1, 1, number, from, to)).append("\n");
			}
		}

		System.out.print(sb);
	}

	static void makeSegTree(int node, int left, int right) {
		if (left == right) {
			segTree[node] = BigInteger.valueOf(numbers[left]);
		}

		else {
			int mid = (left + right) / 2;

			makeSegTree(2 * node, left, mid);
			makeSegTree(2 * node + 1, mid + 1, right);

			segTree[node] = segTree[2 * node].add(segTree[2 * node + 1]);
		}
	}

	static void updateSegTree(int node, int left, int right, long from, long to) {
		if (left == right) {
			segTree[node] = BigInteger.valueOf(to);
		}

		else {
			int mid = (left + right) / 2;

			if (from <= mid) {
				updateSegTree(2 * node, left, mid, from, to);
			}

			else {
				updateSegTree(2 * node + 1, mid + 1, right, from, to);
			}

			segTree[node] = segTree[2 * node].add(segTree[2 * node + 1]);
		}
	}

	static BigInteger getSegTree(int node, int start, int end, long from, long to) {
		if (to < start || end < from) {
			return BigInteger.ZERO;
		}

		if (from <= start && end <= to) {
			return segTree[node];
		}

		int mid = (start + end) / 2;

		BigInteger lSum = getSegTree(2 * node, start, mid, from, to);
		BigInteger rSum = getSegTree(2 * node + 1, mid + 1, end, from, to);

		return lSum.add(rSum);
	}
}
