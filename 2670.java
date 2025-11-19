import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static double maxNumber = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(br.readLine());
        double now = 0;

        for (int i = 0; i < number; i++) {
            double num = Double.parseDouble(br.readLine());

            now = Math.max(now * num, num);
            maxNumber = Math.max(maxNumber, now);
        }

        System.out.printf("%.3f", maxNumber);
    }
}
