import java.io.*;
import java.util.*;

public class Main {
	static int rowSize, colSize;
	static int clickSwitch, maxLight;
	static Map<String, Integer> bulbs = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		rowSize = Integer.parseInt(st.nextToken());
		colSize = Integer.parseInt(st.nextToken());

		for (int r = 0; r < rowSize; r++) { // 문자열과 그와 비슷한 문자열에 대한 빈도수를 구함
			String s = br.readLine();
			bulbs.put(s, bulbs.getOrDefault(s, 0) + 1);
		}

		clickSwitch = Integer.parseInt(br.readLine());

		for (String bulb : bulbs.keySet()) {
			int zeroCount = 0;

			for (int c = 0; c < colSize; c++) {
				if (bulb.charAt(c) == '0') {
					zeroCount += 1;
				}
			}

			if (zeroCount > clickSwitch) { // 꺼진 전구를 모두 킬 수 없다면
				continue; // 다음 탐색
			}

			else {
				int leftClick = clickSwitch - zeroCount;

				if (leftClick % 2 == 0) { // 전구를 모두 킬 수 있다면
					maxLight = Math.max(maxLight, bulbs.get(bulb));
				}
			}
		}
		
		System.out.println(maxLight);
	}
}
