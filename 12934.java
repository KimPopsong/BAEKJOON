import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int MAX = 2000001;

    static long yh, dh;
    static long[] preSum = new long[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        yh = Long.parseLong(st.nextToken());
        dh = Long.parseLong(st.nextToken());

        for (int i = 1; i < MAX; i++) {
            preSum[i] = preSum[i - 1] + (long) i;
        }

        boolean isExists = false;
        int index = 0;
        long sum = yh + dh;
        for (int i = 1; i < MAX; i++) {
            if (preSum[i] == sum) {
                isExists = true;
                index = i;

                break;
            }
        }

        if (!isExists) {
            System.out.print(-1);
        } else {
            int count = 0;

            while (yh > 0) {
                if (yh < index) {
                    yh = 0;
                } else {
                    yh -= index;
                    index -= 1;
                }

                count += 1;
            }

            System.out.print(count);
        }
    }
}
