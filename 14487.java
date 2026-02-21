import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int villageNumber = Integer.parseInt(br.readLine());
        int sumPrice = 0, maxPrice = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < villageNumber; i++) {
            int price = Integer.parseInt(st.nextToken());

            sumPrice += price;
            maxPrice = Math.max(maxPrice, price);
        }

        System.out.println(sumPrice - maxPrice);
    }
}
