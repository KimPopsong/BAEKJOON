import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int number;
    static int[] numbers, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        number = Integer.parseInt(br.readLine());
        numbers = new int[number];
        dp = new int[number];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < number; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            dp[i] = numbers[i];

            for (int j = 0; j < i; j++) {
                if (numbers[i] > numbers[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + numbers[i]);
                }
            }
        }

        int max = 0;
        for (int i : dp) {
            max = Math.max(max, i);
        }

        System.out.println(max);
    }
}
