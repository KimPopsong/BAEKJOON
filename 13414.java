import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int avail, clickNumber;
    static Set<String> clicks = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        avail = Integer.parseInt(st.nextToken());
        clickNumber = Integer.parseInt(st.nextToken());

        for (int i = 0; i < clickNumber; i++) {
            String studentNumber = br.readLine();

            clicks.remove(studentNumber);
            clicks.add(studentNumber);
        }

        int count = 0;
        for (String student : clicks) {
            answer.append(student).append("\n");
            count += 1;

            if (count == avail) {
                break;
            }
        }

        System.out.print(answer);
    }
}
