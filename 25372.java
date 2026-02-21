import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < testCase; tc++) {
            String password = br.readLine();

            if (6 <= password.length() && password.length() <= 9) {
                answer.append("yes").append("\n");
            } else {
                answer.append("no").append("\n");
            }
        }

        System.out.print(answer);
    }
}
