import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        while (true) {
            int number = Integer.parseInt(br.readLine());

            if (number == 0) {
                break;
            }

            Long maxValue = -10000L, now = -10000L;

            for (int i = 0; i < number; i++) {
                int n = Integer.parseInt(br.readLine());

                now = Math.max(now + n, n);
                maxValue = Math.max(maxValue, now);
            }

            answer.append(maxValue).append("\n");
        }

        System.out.print(answer);
    }
}
