import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int passanger = 0;
		int maxPassanger = 0;

		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int getOut = Integer.parseInt(st.nextToken());
			int getIn = Integer.parseInt(st.nextToken());

			passanger = passanger - getOut + getIn;

			maxPassanger = Math.max(maxPassanger, passanger);
		}

		System.out.println(maxPassanger);
	}
}
