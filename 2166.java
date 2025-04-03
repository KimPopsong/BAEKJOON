import java.io.*;
import java.util.*;

class Main {
	static int pointNumber;
	static Point[] points;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		pointNumber = Integer.parseInt(br.readLine());
		points = new Point[pointNumber + 1];

		for (int i = 0; i < pointNumber; i++) {
			st = new StringTokenizer(br.readLine());

			points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		points[pointNumber] = new Point(points[0].r, points[0].c); // 신발끈 공식을 위해 맨 처음 점을 넣어주기

		long sum1 = 0;

		for (int i = 0; i < pointNumber; i++) {
			sum1 += (long) points[i].r * (long) points[i + 1].c;
		}

		long sum2 = 0;

		for (int i = 0; i < pointNumber; i++) {
			sum2 += (long) points[i].c * (long) points[i + 1].r;
		}

		double area = Math.abs(sum1 - sum2) / 2.0;

		System.out.printf("%.1f", area);
	}

	static class Point {
		int r, c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
