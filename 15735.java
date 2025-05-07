import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		BigInteger height = new BigInteger(br.readLine());

		BigInteger answer = height.multiply(height.add(BigInteger.valueOf(2)))
				.multiply(height.multiply(BigInteger.valueOf(2)).add(BigInteger.valueOf(1)))
				.divide(BigInteger.valueOf(8));

		System.out.println(answer);
	}
}
