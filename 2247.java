import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int target = Integer.parseInt(br.readLine());
        long CSOD = 0L;

        for (int i = 2; i <= target / 2; i++) {
            CSOD = (CSOD + (long) (target / i - 1) * i) % 1000000;
        }

        System.out.println(CSOD);
    }
}
