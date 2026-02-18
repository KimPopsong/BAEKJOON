import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class Main {

    static BigDecimal[] fib = new BigDecimal[491];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        fib[0] = BigDecimal.ZERO;
        fib[1] = BigDecimal.ONE;
        for (int i = 2; i < 491; i++) {
            fib[i] = fib[i - 1].add(fib[i - 2]);
        }

        while (true) {
            int time = Integer.parseInt(br.readLine());

            if (time == -1) {
                break;
            }

            answer.append("Hour ").append(time).append(": ").append(fib[time])
                .append(" cow(s) affected\n");
        }

        System.out.print(answer);
    }
}
