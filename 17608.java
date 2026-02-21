import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int stickNumber = Integer.parseInt(br.readLine());
        int[] sticks = new int[stickNumber];

        for (int i = 0; i < stickNumber; i++) {
            sticks[i] = Integer.parseInt(br.readLine());
        }

        int count = 0, maxHeight = 0;
        for (int i = stickNumber - 1; i >= 0; i--) {
            if (sticks[i] > maxHeight) {
                maxHeight = sticks[i];
                count += 1;
            }
        }

        System.out.println(count);
    }
}
