import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        double width = Double.parseDouble(st.nextToken());
        double height = Double.parseDouble(st.nextToken());

        System.out.printf("%.1f", width * height / 2);
    }
}
