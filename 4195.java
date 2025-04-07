import java.io.*;
import java.util.*;

public class Main {
	static int edgeNumber;
	static Map<String, Integer> degree;
	static Map<String, String> parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCase; tc++) {
			edgeNumber = Integer.parseInt(br.readLine());
			degree = new HashMap<>();
			parent = new HashMap<>();

			for (int i = 0; i < edgeNumber; i++) {
				st = new StringTokenizer(br.readLine());

				String f1 = st.nextToken();
				String f2 = st.nextToken();

				if (!parent.containsKey(f1)) {
					degree.put(f1, 1);
					parent.put(f1, f1);
				}

				if (!parent.containsKey(f2)) {
					degree.put(f2, 1);
					parent.put(f2, f2);
				}

				String p = union(f1, f2); // 부모의 이름 찾기

				sb.append(degree.get(p)).append("\n");
			}
		}

		System.out.print(sb);
	}

	static String findParent(String f) {
		if (parent.get(f).equals(f)) {
			return f;
		}

		String result = findParent(parent.get(f));
		parent.put(f, result);
		return result;
	}

	static String union(String f1, String f2) {
		String root1 = findParent(f1);
		String root2 = findParent(f2);

		if (!root1.equals(root2)) {
			degree.put(root1, degree.get(root1) + degree.get(root2));
			parent.put(root2, root1);
		}

		return root1;
	}
}
