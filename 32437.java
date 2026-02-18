import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Main {

    static BigDecimal[] fib = new BigDecimal[41];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        fib[0] = BigDecimal.ONE;
        fib[1] = BigDecimal.ONE;
        for (int i = 2; i < 41; i++) {
            fib[i] = fib[i - 1].add(fib[i - 2]);
        }

        System.out.print(fib[Integer.parseInt(br.readLine())]);
    }
}
