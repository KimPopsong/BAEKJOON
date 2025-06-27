import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String originString = br.readLine();
        ArrayList<String> dict = new ArrayList<>();

        for (int n1 = 0; n1 < originString.length() - 2; n1++) {
            StringBuilder part1 = new StringBuilder(originString.substring(0, n1 + 1)).reverse();

            for (int n2 = n1 + 1; n2 < originString.length() - 1; n2++) {
                StringBuilder part2 = new StringBuilder(originString.substring(n1 + 1, n2 + 1)).reverse();
                StringBuilder part3 = new StringBuilder(originString.substring(n2 + 1)).reverse();

                String combined = new StringBuilder()
                    .append(part1)
                    .append(part2)
                    .append(part3)
                    .toString();

                dict.add(combined);
            }
        }

        Collections.sort(dict);
        
        System.out.println(dict.get(0));
    }
}
