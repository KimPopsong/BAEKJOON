import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int arr1Length, arr2Length;
		ArrayDeque<Integer> arr1 = new ArrayDeque<>();
		ArrayDeque<Integer> arr2 = new ArrayDeque<>();
		ArrayDeque<Integer> sumArray = new ArrayDeque<>();

		st = new StringTokenizer(br.readLine());
		arr1Length = Integer.parseInt(st.nextToken());
		arr2Length = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < arr1Length; i++) {
			arr1.add(Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < arr2Length; i++) {
			arr2.add(Integer.parseInt(st.nextToken()));
		}

		while (!arr1.isEmpty() && !arr2.isEmpty()) {
			if (arr1.peekFirst() < arr2.peekFirst()) {
				sumArray.add(arr1.removeFirst());
			}

			else {
				sumArray.add(arr2.removeFirst());
			}
		}

		while (!arr1.isEmpty()) {
			sumArray.add(arr1.removeFirst());
		}

		while (!arr2.isEmpty()) {
			sumArray.add(arr2.removeFirst());
		}

		while (!sumArray.isEmpty()) {
			sb.append(sumArray.removeFirst()).append(" ");
		}

		System.out.println(sb);
	}
}
