import java.util.*;
import java.io.*;

class Main {
	static int size, dababaNumber, answer = 0;
	static ArrayList<Dababa> dababas = new ArrayList();
	static Set<String> coord = new HashSet<>();
	static int[] dr = { -2, 2, 0, 0 }, dc = { 0, 0, -2, 2 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());

		size = Integer.parseInt(st.nextToken());
		dababaNumber = Integer.parseInt(st.nextToken());

		for (int i = 0; i < dababaNumber; i++) {
			st = new StringTokenizer(br.readLine());

			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			coord.add(new String(r + " " + c));

			dababas.add(new Dababa(r, c));
		}

		for (Dababa dbb : dababas) {
			for (int d = 0; d < 4; d++) {
				int rr = dbb.r + dr[d];
				int cc = dbb.c + dc[d];

				if (0 < rr && rr <= size && 0 < cc && cc <= size) {
					if (!coord.contains(rr + " " + cc)) {
						answer += 1;
						coord.add(rr + " " + cc);
					}
				}
			}
		}

		System.out.println(answer);
	}

	static class Dababa {
		int r, c;

		Dababa(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
