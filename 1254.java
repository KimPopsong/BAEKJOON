import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String originText = br.readLine();

        int node = 0;
        String add = "";

        while (true) {
            String text = originText + add;

            if (isPalindrome(text)) {
                break;
            }

            add = originText.charAt(node++) + add;
        }

        System.out.print(originText.length() + add.length());
    }

    static boolean isPalindrome(String text) {
        boolean flag = true;
        int length = text.length();

        for (int i = 0; i < length / 2; i++) {
            if (text.charAt(i) != text.charAt(length - i - 1)) {
                flag = false;

                break;
            }
        }

        return flag;
    }
}
