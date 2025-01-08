import java.util.*;
import java.io.*;

class Main {
	static int number, combNumber; // 숫자의 개수, 수열에 들어가는 숫자의 개수
	static int[] numbers; // 숫자 목록
	static LinkedHashSet<LinkedList<Integer>> answer = new LinkedHashSet<>(); // 정답 저장

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] temp = br.readLine().split(" ");

		number = Integer.parseInt(temp[0]);
		combNumber = Integer.parseInt(temp[1]);

		numbers = new int[number];
		temp = br.readLine().split(" ");

		for (int i = 0; i < number; i++) {
			numbers[i] = Integer.parseInt(temp[i]);
		}

		Arrays.sort(numbers); // 오름차순 정렬

		for (int i = 0; i < number; i++) {
			LinkedList<Integer> tempList = new LinkedList<>();
			tempList.add(numbers[i]);

			recursion(tempList, 1, i);
		}

		for (LinkedList<Integer> ans : answer) {
			for (int a : ans) {
				sb.append(a).append(" ");
			}
			sb.append("\n");
		}

		System.out.print(sb);
	}

	public static void recursion(LinkedList<Integer> tempList, int depth, int index) {
		if (depth == combNumber) {
			answer.add(new LinkedList<Integer>(tempList));

			return;
		}

		else {
			for (int i = 0; i < number; i++) {
				tempList.add(numbers[i]);
				recursion(tempList, depth + 1, i);
				tempList.remove(tempList.size() - 1);
			}
		}
	}
}
