import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int stockNumber, maxGap = 0, minPrice = Integer.MAX_VALUE;

        stockNumber = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < stockNumber; i++) {
            int stock = Integer.parseInt(st.nextToken());

            minPrice = Math.min(minPrice, stock);

            maxGap = Math.max(maxGap, stock - minPrice);
        }

        System.out.println(maxGap);
    }
}
