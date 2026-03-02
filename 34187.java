import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int low = 0, high = 2025;

        while (true) {
            int mid = (low + high) / 2;
            print("?", mid);

            String result = br.readLine();

            if (low == high) {
                print("!", low);

                break;
            } else if (result.equals("Cold")) {
                low = mid;
                high = (mid + high) / 2;
            } else if (result.equals("Hot")) {
                low = (low + mid) / 2;
                high = mid - 1;
            } else {
                print("!", mid);

                return;
            }
        }
    }

    static void print(String mark, int value) {
        System.out.println(mark + " " + value);
        System.out.flush();
    }
}
