import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int originalNumber = 0;
        char[] number = br.readLine().toCharArray();

        for (int i = 0; i < number.length; i++) {
            if (number[i] > '4') {
                number[i] = (char) (number[i] - 1);
            }
        }

        for (int i = number.length - 1; i >= 0; i--)  // 9진수로 계산
        {
            originalNumber += (int) ((number[i] - '0') * Math.pow(9, number.length - i - 1));
        }

        System.out.print(originalNumber);
    }
}
