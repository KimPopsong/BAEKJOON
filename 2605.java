import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int studentNumber = Integer.parseInt(br.readLine());
        ArrayList<Integer> order = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        int student = 1;
        while (st.hasMoreTokens()) {
            int studentOrder = Integer.parseInt(st.nextToken());

            order.add(studentOrder, student++);
        }

        for (int i = order.size() - 1; i >= 0; i--) {
            answer.append(order.get(i)).append(" ");
        }

        System.out.print(answer);
    }
}
