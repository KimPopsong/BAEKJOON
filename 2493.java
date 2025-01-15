import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int towerNumber = Integer.parseInt(br.readLine()); // 탑의 개수
		int[] towers = new int[towerNumber]; // 탑
		int[] answer = new int[towerNumber]; // 답 저장

		String[] temp = br.readLine().split(" ");
		for (int i = 0; i < towerNumber; i++) {
			towers[i] = Integer.parseInt(temp[i]);
		}

		Stack<Tower> stack = new Stack<>();

		for (int index = towerNumber - 1; index >= 0; index--) // 뒤에서부터 탐색
		{
			int height = towers[index];

			while (!stack.isEmpty()) // stack과 높이 비교
			{
				Tower top = stack.pop();

				if (height >= top.height) // 길이가 높거나 같다면
				{
					answer[top.index] = index + 1;
				}

				else // 아니라면
				{
					stack.push(top); // 다시 넣고

					break; // 탈출
				}
			}

			stack.push(new Tower(height, index)); // stack에 추가
		}

		for (int ans : answer) {
			sb.append(ans).append(" ");
		}
		System.out.println(sb);
	}

	static class Tower {
		int height, index;

		Tower(int height, int index) {
			this.height = height;
			this.index = index;
		}
	}
}
