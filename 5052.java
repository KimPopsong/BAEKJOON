import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < testCase; tc++) {
            boolean flag = true;
            int number = Integer.parseInt(br.readLine());
            Set<String> numbers = new HashSet<>();

            String[] phoneNumbers = new String[number];

            for (int i = 0; i < number; i++) {
                phoneNumbers[i] = br.readLine();
            }

            Arrays.sort(phoneNumbers, new Comparator<>() {
                @Override
                public int compare(String s1, String s2) {
                    return Integer.compare(s1.length(), s2.length());
                }
            });  // 길이 순 정렬

            for (int i = 0; i < number; i++) {
                String str = phoneNumbers[i];

                String s = "";

                for (int j = 0; j < str.length(); j++) {
                    s += str.charAt(j);

                    if (numbers.contains(s)) {
                        flag = false;

                        break;
                    }
                }

                if (flag == false) {
                    break;
                }

                numbers.add(str);
            }

            if (flag) {
                answer.append("YES").append("\n");
            } else {
                answer.append("NO").append("\n");
            }
        }

        System.out.print(answer);
    }
}
