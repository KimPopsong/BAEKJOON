import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < testCase; tc++) {
            int day = Integer.parseInt(br.readLine());
            long sumProfit = 0L;
            int[] prices = new int[day], higherPrice = new int[day];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < day; i++) {
                prices[i] = Integer.parseInt(st.nextToken());
            }

            higherPrice[day - 1] = prices[day - 1];
            for (int i = day - 2; i >= 0; i--) {
                higherPrice[i] = Math.max(higherPrice[i + 1], prices[i]);
            }

            for (int i = 0; i < day; i++) {
                sumProfit += higherPrice[i] - prices[i];
            }

            answer.append(sumProfit).append("\n");
        }

        System.out.print(answer);
    }
}
