import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int number, mod;
    static long answer;
    static int[] numbers, dp, mods;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        number = Integer.parseInt(st.nextToken());
        mod = Integer.parseInt(st.nextToken());
        numbers = new int[number];
        dp = new int[number + 1];
        mods = new int[mod];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < number; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= number; i++) {
            dp[i] = (dp[i - 1] + numbers[i - 1]) % mod;
        }

        for (int i = 0; i <= number; i++) {
            mods[dp[i]]++;
        }

        for (int i = 0; i < mod; i++) {
            if (mods[i] >= 2) {
                answer += (long) mods[i] * (mods[i] - 1) / 2;
            }
        }

        System.out.print(answer);
    }
}
