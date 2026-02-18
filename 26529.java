import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] fib = new int[46];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i < 46; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        for (int tc = 0; tc < testCase; tc++) {
            int n = Integer.parseInt(br.readLine());

            answer.append(fib[n]).append("\n");
        }

        System.out.print(answer);
    }
}
