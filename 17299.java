import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int number = Integer.parseInt(br.readLine()); // 숫자의 개수
		int[] numbers = new int[number]; // 숫자 저장
		int[] answer = new int[number]; // 답안 저장
		Map<Integer, Integer> map = new HashMap<>(); // {숫자 : 나온 횟수}를 쌍으로 저장

		String[] temp = br.readLine().split(" ");
		for (int i = 0; i < number; i++) {
			numbers[i] = Integer.parseInt(temp[i]);
		}

		for (int n : numbers) { // map 초기화
			if (map.containsKey(n)) {
				map.put(n, map.get(n) + 1);
			}

			else {
				map.put(n, 1);
			}
		}

		Stack<Number> numberStack = new Stack<>();

		for (int i = 0; i < number; i++) {
			if (!numberStack.isEmpty()) // 스택이 있다면 비교
			{
				while (!numberStack.isEmpty()) // 스택이 비거나
				{
					Number top = numberStack.pop();

					if (map.get(top.number) < map.get(numbers[i])) // 나온 횟수가 더 많다면
					{
						answer[top.index] = numbers[i];
					}

					else {
						numberStack.push(top);

						break;
					}
				}
			}

			numberStack.push(new Number(numbers[i], i));
		}

		while (!numberStack.isEmpty()) {
			answer[numberStack.pop().index] = -1;
		}

		for (int a : answer) {
			sb.append(a).append(" ");
		}
		System.out.println(sb);
	}

	static class Number {
		int number, index;

		Number(int number, int index) {
			this.number = number;
			this.index = index;
		}
	}
}
