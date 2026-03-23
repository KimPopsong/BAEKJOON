import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int slide, lineA;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        lineA = Integer.parseInt(st.nextToken());
        slide = Integer.parseInt(st.nextToken());

        System.out.print(lineA * lineA - slide * slide);
    }
}
