import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        long pick = Long.parseLong(br.readLine());

        long left = 1;
        long right = pick;
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = countLessEqual(mid, size);

            if (count >= pick) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    private static long countLessEqual(long x, int n) {
        long cnt = 0;

        for (int i = 1; i <= n; i++) {
            cnt = cnt + Math.min(n, x / i);
        }

        return cnt;
    }
}
