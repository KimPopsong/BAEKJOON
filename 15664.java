import java.util.*;
import java.io.*;

class Main {
	static int number, combNumber; // 숫자의 개수, 수열에 들어가는 숫자의 개수
	static int[] numbers; // 숫자 목록
	static HashSet<LinkedList<Integer>> answer = new HashSet<>(); // 정답 저장

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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

		LinkedList<LinkedList<Integer>> list = new LinkedList<>(answer);

		Collections.sort(list, new Comparator<LinkedList<Integer>>() {
			@Override
			public int compare(LinkedList<Integer> o1, LinkedList<Integer> o2) {
				for (int i = 0; i < combNumber; i++) {
					if (o1.get(i) > o2.get(i)) {
						return 1;
					}

					else if (o1.get(i) < o2.get(i)) {
						return -1;
					}
				}

				return 0;
			}
		});

		for (LinkedList<Integer> ans : list) {
			for (int a : ans) {
				System.out.print(a + " ");
			}
			System.out.println();
		}
	}

	public static void recursion(LinkedList<Integer> tempList, int depth, int index) {
		if (depth == combNumber) {
			answer.add(new LinkedList<Integer>(tempList));

			return;
		}

		else {
			for (int i = index + 1; i < number; i++) {
				tempList.add(numbers[i]);
				recursion(tempList, depth + 1, i);
				tempList.remove(tempList.size() - 1);
			}
		}
	}
}
