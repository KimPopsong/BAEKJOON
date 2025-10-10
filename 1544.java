import java.util.*;
import java.io.*;

public class Main {
    static int wordNumber;
    static Set<String> words = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        wordNumber = Integer.parseInt(br.readLine());

        for (int i = 0; i < wordNumber; i++) {
            String str = br.readLine();

            for (int c = 0; c < str.length(); c++) {
                if (words.contains(str)) {
                    break;
                }

                str = str.substring(1) + str.charAt(0);
            }

            words.add(str);
        }

        System.out.println(words.size());
    }
}
