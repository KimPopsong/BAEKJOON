import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int dollNumber, pickNumber;
    static double minVariance = Double.MAX_VALUE;
    static long[] dolls, preSum, preSquare;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        dollNumber = Integer.parseInt(st.nextToken());
        pickNumber = Integer.parseInt(st.nextToken());

        dolls = new long[dollNumber + 1];
        preSum = new long[dollNumber + 1];
        preSquare = new long[dollNumber + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= dollNumber; i++) {
            dolls[i] = Long.parseLong(st.nextToken());
            preSum[i] = dolls[i] + preSum[i - 1];
            preSquare[i] = dolls[i] * dolls[i] + preSquare[i - 1];
        }

        for (int length = pickNumber; length <= dollNumber; length++)  // 선택할 인형의 길이
        {
            // 이 공식을 어떻게 만들어...

            for (int i = length; i <= dollNumber; i++) {
                long sum = preSum[i] - preSum[i - length];
                long sumSquare = preSquare[i] - preSquare[i - length];
                long numerator = (long) length * sumSquare - sum * sum;
                double variance = (double) numerator / (double) (length * length);

                minVariance = Math.min(minVariance, variance);
            }
        }

        System.out.printf("%.11f", Math.sqrt(minVariance));
    }
}
