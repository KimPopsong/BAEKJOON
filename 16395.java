import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()) - 1;
        int r = Integer.parseInt(st.nextToken()) - 1;

        long nn = 1L;
        for (long i = n; i > Math.max(r, n - r); i--) {
            nn *= i;
        }

        long rr = 1L;
        for (long i = 2; i <= Math.min(r, n - r); i++) {
            rr *= i;
        }

        System.out.print(nn / rr);
    }
}
