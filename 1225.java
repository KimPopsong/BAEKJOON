import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        long sum = 0;
        String num1 = st.nextToken();
        String num2 = st.nextToken();

        for (char n1 : num1.toCharArray()) {
            for (char n2 : num2.toCharArray()) {
                sum += (long) Integer.parseInt(String.valueOf(n1)) * Integer.parseInt(
                    String.valueOf(n2));
            }
        }

        System.out.println(sum);
    }
}
