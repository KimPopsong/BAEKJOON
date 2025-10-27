import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int seatNumber, vipNumber, sumAvail = 1;
    static int[] fib = new int[41];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        seatNumber = Integer.parseInt(br.readLine());
        vipNumber = Integer.parseInt(br.readLine());

        fib[0] = 1;
        fib[1] = 1;
        fib[2] = 2;

        for (int i = 3; i <= 40; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        int start = 1;
        for (int i = 0; i < vipNumber; i++) {
            int next = Integer.parseInt(br.readLine());

            sumAvail *= fib[next - start];

            start = next + 1;
        }

        sumAvail *= fib[seatNumber - start + 1];

        System.out.print(sumAvail);
    }
}
