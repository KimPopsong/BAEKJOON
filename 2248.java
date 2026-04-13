import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int digit, maxOne;
    static long target;
    static long[][] combs = new long[32][32];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        digit = Integer.parseInt(st.nextToken());
        maxOne = Integer.parseInt(st.nextToken());
        target = Long.parseLong(st.nextToken());

        getComb();

        for (int i = 0; i < digit; i++) {  // 맨 앞자리부터 탐색
            // 맨 앞자리가 0이라 가정하고 경우의 수 계산
            long avail = 0L;

            for (int useOne = 0; useOne <= maxOne; useOne++) {
                avail += combs[digit - 1 - i][useOne];
            }

            if (target <= avail) {
                answer.append('0');
            } else {
                answer.append('1');

                maxOne -= 1;
                target -= avail;
            }
        }

        System.out.print(answer);
    }

    static void getComb() {
        for (int i = 0; i <= 31; i++) {
            combs[i][0] = 1;

            for (int j = 1; j <= i; j++) {
                combs[i][j] = combs[i - 1][j - 1] + combs[i - 1][j];
            }
        }
    }
}
