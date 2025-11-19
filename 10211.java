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
            int number = Integer.parseInt(br.readLine());
            int maxNumber = -10000, now = -10000;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < number; i++) {
                int n = Integer.parseInt(st.nextToken());

                now = Math.max(now + n, n);
                maxNumber = Math.max(maxNumber, now);
            }

            answer.append(maxNumber).append("\n");
        }

        System.out.print(answer);
    }
}
