import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int number = Integer.parseInt(br.readLine()); // 숫자의 개수
		int[] numbers = new int[number]; // 숫자 저장
		int[] answer = new int[number]; // 답안 저장

		String[] temp = br.readLine().split(" ");
		for (int i = 0; i < number; i++) {
			numbers[i] = Integer.parseInt(temp[i]);
		}

		Stack<Number> numberStack = new Stack<>();

		for (int i = 0; i < number; i++) {
			if (!numberStack.isEmpty()) // 스택이 있다면 비교
			{
				while (!numberStack.isEmpty()) // 스택이 비거나
				{
					if (numberStack.peek().number < numbers[i]) // 비교가 끝날때까지 반복
					{
						answer[numberStack.pop().index] = numbers[i];
					}

					else {
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
