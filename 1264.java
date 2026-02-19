import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        boolean flag = true;
        while (flag) {
            int count = 0;
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                String s = st.nextToken();

                if (s.equals("#")) {
                    flag = false;

                    break;
                }

                for (char c : s.toCharArray()) {
                    if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A'
                        || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                        count += 1;
                    }
                }
            }

            if (flag) {
                answer.append(count).append("\n");
            }
        }

        System.out.print(answer);
    }
}
