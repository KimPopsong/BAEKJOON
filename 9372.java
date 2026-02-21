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
            st = new StringTokenizer(br.readLine());

            int countryNumber = Integer.parseInt(st.nextToken());
            int planeNumber = Integer.parseInt(st.nextToken());

            for (int i = 0; i < planeNumber; i++) {
                st = new StringTokenizer(br.readLine());
            }

            answer.append(countryNumber - 1).append("\n");
        }

        System.out.print(answer);
    }
}
