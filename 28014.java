import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int count = 1, towerNumber = Integer.parseInt(br.readLine());
        int[] towers = new int[towerNumber];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < towerNumber; i++) {
            towers[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < towerNumber; i++) {
            if (towers[i] >= towers[i - 1]) {
                count += 1;
            }
        }

        System.out.println(count);
    }
}
