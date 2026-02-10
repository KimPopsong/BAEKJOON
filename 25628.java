import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int bun = Integer.parseInt(st.nextToken());
        int patty = Integer.parseInt(st.nextToken());

        System.out.println(Math.min(bun / 2, patty));
    }
}
