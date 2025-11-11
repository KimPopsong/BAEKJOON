import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int count = 0;
        int length = Integer.parseInt(br.readLine());
        char[] string = br.readLine().toCharArray();

        for (int left = 0; left < length; left++) {
            if (string[left] == 'A') {
                boolean flag = false;
                boolean endTag = false;

                int right = 0;
                for (right = left + 1; right < length; right++) {
                    if (string[right] == 'N') {
                        if (flag) {
                            flag = false;

                            break;
                        } else {
                            flag = true;
                        }
                    } else if (string[right] == 'A') {
                        endTag = true;

                        break;
                    }
                }

                if (flag && endTag) {
                    count += 1;
                }

                left = right - 1;
            }
        }

        System.out.print(count);
    }
}
