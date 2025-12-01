import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long destination;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        destination = Long.parseLong(br.readLine());

        long low = 1, high = 2000000000L;
        long ans = high;

        while (low <= high) {
            long mid = (low + high) / 2;

            long room = 3L * mid * (mid - 1) + 1L;

            if (room >= destination) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.print(ans);
    }
}
