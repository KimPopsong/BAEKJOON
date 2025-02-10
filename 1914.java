import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int diskNumber = Integer.parseInt(br.readLine());

		System.out.println(new BigInteger("2").pow(diskNumber).subtract(new BigInteger("1")));

		if (diskNumber <= 20) {
			hanoi(diskNumber, 1, 2, 3);
		}

		System.out.println(sb);
	}

	static void hanoi(int disk, int from, int temp, int to) {
		if (disk == 0) {
			return;
		}

		hanoi(disk - 1, from, to, temp);
		sb.append(from).append(" ").append(to).append("\n");
		hanoi(disk - 1, temp, from, to);
	}
}
