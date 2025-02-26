import java.io.*;
import java.util.*;

public class Main {
	static char[] expression;
	static Map<String, Integer> priority = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		String answer = "";
		expression = br.readLine().toCharArray(); // 수식

		priority.put("(", 0);
		priority.put("+", 1);
		priority.put("-", 1);
		priority.put("*", 2);
		priority.put("/", 2);

		int tempPriority = 0; // 괄호에 따라 우선순위 변경
		ArrayDeque<String> alpha = new ArrayDeque<>(); // 기호를 저장할 스택
		ArrayDeque<String> sign = new ArrayDeque<>(); // 수식을 저장할 스택

		for (char c : expression) {
			if (c == '(') {
				sign.addLast(Character.toString(c));
			}

			else if (c == ')') {
				while (!sign.peekLast().equals("(")) { // '('가 나올 때까지 팝
					String s2 = alpha.removeLast();
					String s1 = alpha.removeLast();

					s1 = s1 + s2 + sign.removeLast();
					alpha.addLast(s1);
				}

				sign.removeLast();
			}

			else if (c == '+' || c == '-' || c == '*' || c == '/') {
				// 나의 우선순위가 더 높을때까지
				while (!sign.isEmpty() && priority.get(sign.peekLast()) >= priority.get(Character.toString(c))) {
					String s2 = alpha.removeLast();
					String s1 = alpha.removeLast();

					s1 = s1 + s2 + sign.removeLast();
					alpha.addLast(s1);
				}

				sign.addLast(Character.toString(c));
			}

			else { // 문자면 바로 넣기
				alpha.addLast(Character.toString(c));
			}
		}

		while (!sign.isEmpty()) {
			String s2 = alpha.removeLast();
			String s1 = alpha.removeLast();

			s1 = s1 + s2 + sign.removeLast();
			alpha.addLast(s1);
		}

		System.out.println(alpha.removeLast());
	}
}
