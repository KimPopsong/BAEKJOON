import java.io.*;
import java.util.*;

public class Main {
	static int count;
	static String target, pattern;
	static ArrayList<Integer> index = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		target = br.readLine();
		pattern = br.readLine();

		int[] dp = new int[pattern.length()];

		for (int i = 1, j = 0; i < pattern.length(); i++) {
			// i : 패턴의 접미사, j : 패턴의 접두사
			// 두 포인터의 위치에서 불일치 발생하면 맞은 직전위치의 정보를 활용해서 불필요한 비교 줄임
			while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = dp[j - 1]; // 직전까지 맞은 정보 활용

			}

			// j == 0 이거나 pattern[i] == pattern[j]인 상황
			// 현재 i위치까지의 부분 문자열의 접미사가 접두사와 일치하는 패턴의 촤장길이 저장
			if (pattern.charAt(i) == pattern.charAt(j)) {
				dp[i] = j + 1; // j위치까지 일치한 경우 길이 : j+1, 이후 j : 1칸 뒤로 이동
				j++;
			}

			else {
				dp[i] = 0; // 일치하는 접두사 접미사 없음
			}
		}

		for (int i = 0, j = 0; i < target.length(); i++) {
			while (j > 0 && target.charAt(i) != pattern.charAt(j)) {
				j = dp[j - 1];
			}

			if (target.charAt(i) == pattern.charAt(j)) {
				if (j == pattern.length() - 1) { // 끝까지 일치
					count += 1; // 패턴 찾음 -> 카운트 증가
					index.add(i - j + 1);

					j = dp[j]; // 틀린게 아님
				}

				else {// 아직 끝 도착 못함
					j += 1;
					// i : 반복문에서 자동으로 증가
				}
			}
		}

		sb.append(count).append("\n");
		for (int i : index) {
			sb.append(i).append("\n");
		}

		System.out.print(sb);
	}
}
