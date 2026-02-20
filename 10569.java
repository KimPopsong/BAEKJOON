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

            int vertex = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());

            answer.append(2 + edge - vertex).append("\n");
        }

        System.out.print(answer);
    }
}
