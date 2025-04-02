import java.io.*;
import java.util.*;

public class Main {
	static int houseNumber;
	static int[][] price;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		houseNumber = Integer.parseInt(br.readLine());
		price = new int[houseNumber][3];

		for (int i = 0; i < houseNumber; i++) {
			st = new StringTokenizer(br.readLine());

			price[i][0] = Integer.parseInt(st.nextToken());
			price[i][1] = Integer.parseInt(st.nextToken());
			price[i][2] = Integer.parseInt(st.nextToken());
		}

		System.out.println(Math.min(Math.min(pick(0), pick(1)), pick(2)));
	}

	static int pick(int start) {
		int[][] newPrice = new int[houseNumber][3];

		for (int i = 0; i < houseNumber; i++) { // price 복사
			newPrice[i][0] = price[i][0];
			newPrice[i][1] = price[i][1];
			newPrice[i][2] = price[i][2];
		}

		newPrice[houseNumber - 1][start] = 1001;

		for (int j = 0; j < 3; j++) {
			if (j == start) {
				continue;
			}

			newPrice[0][j] = 1001;
		}

		for (int i = 1; i < houseNumber; i++) { // 중간 층 선택
			newPrice[i][0] = newPrice[i][0] + Math.min(newPrice[i - 1][1], newPrice[i - 1][2]);
			newPrice[i][1] = newPrice[i][1] + Math.min(newPrice[i - 1][0], newPrice[i - 1][2]);
			newPrice[i][2] = newPrice[i][2] + Math.min(newPrice[i - 1][0], newPrice[i - 1][1]);
		}

		return Math.min(Math.min(newPrice[houseNumber - 1][0], newPrice[houseNumber - 1][1]), newPrice[houseNumber - 1][2]);
	}
}
