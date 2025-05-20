import java.io.*;
import java.util.*;

public class Main {
	static int parts = 0, stack = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String stick = br.readLine();

		for (int i = 1; i < stick.length(); i++) {
			if (stick.charAt(i) == ')') { // 닫히는 문자일 경우
				stack -= 1;

				if (stick.charAt(i - 1) == '(') { // 레이저일 경우

					parts += stack;
				}

				else {
					parts += 1;
				}
			}

			else {
				stack += 1;
			}
		}

		System.out.println(parts);
	}
}
