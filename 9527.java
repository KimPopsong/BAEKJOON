import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long start, end, sumCount = 0;
    static long[] binary = new long[55];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력부 시작

        st = new StringTokenizer(br.readLine());

        start = Long.parseLong(st.nextToken());
        end = Long.parseLong(st.nextToken());

        // 입력부 종료

        binary[1] = 1;  // 1의 개수 누적 합
        for (int i = 2; i < 55; i++) {
            binary[i] = (binary[i - 1] << 1) + (1L << (i - 1));
        }

        System.out.print(calc(end) - calc(start - 1));
    }

    static long calc(long number) {
        if (number <= 0) {
            return 0;
        }

        int bitLength = Long.SIZE - Long.numberOfLeadingZeros(number);

        long left = number - (1L << (bitLength - 1));

        return left + 1L + binary[bitLength - 1] + calc(left);
    }
}
