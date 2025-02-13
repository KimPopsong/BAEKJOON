import java.io.*;
import java.util.*;

public class Main {
	static final long MAXNUMBER = 1000001000000L; // 최대 범위
	static final int sqrtMAXNUMBER = (int) Math.sqrt(MAXNUMBER);
	static long min, max;
	static boolean[] erathos = new boolean[sqrtMAXNUMBER + 1]; // 소수 구분을 위한 에라토스테네스의 체
	static ArrayDeque<Integer> primeNumber = new ArrayDeque<>(); // 소수 저장

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());

		min = Long.parseLong(st.nextToken());
		max = Long.parseLong(st.nextToken());

		Arrays.fill(erathos, true); // true로 초기화
		erathos[0] = false;
		erathos[1] = false;

		for (int num = 2; num <= sqrtMAXNUMBER; num++) { // 소수 판별하기
			if (erathos[num] == false) {
				continue;
			}

			primeNumber.add(num);

			for (int j = 2; num * j <= sqrtMAXNUMBER; j++) {
				erathos[num * j] = false;
			}
		}

		Set<Long> squareNumbers = new HashSet<>(); // 제곱수를 저장
		long minSqrt = (long) Math.sqrt(min);
		long maxSqrt = (long) Math.sqrt(max);
		while (!primeNumber.isEmpty()) {
			long n = primeNumber.removeFirst();

			if (n > maxSqrt) {
				break;
			}

			else {
				long t = n * n;

				for (long i = min / t; t * i <= max; i++) {
					if (min <= t * i) {
						squareNumbers.add(t * i);
					}
				}
			}
		}

		System.out.println(max - min + 1 - squareNumbers.size());
	}
}
