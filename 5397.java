import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < testCase; tc++) {
            int cursor = 0;  // 커서의 위치
            char[] command = br.readLine().toCharArray();

            List<Character> password = new LinkedList<>();

            for (char c : command) {
                if (c == '<') {  // 왼쪽
                    cursor = Math.max(cursor - 1, 0);
                } else if (c == '>') {  // 오른쪽
                    cursor = Math.min(cursor + 1, password.size());
                } else if (c == '-') {  // 백스페이스
                    if (cursor <= 0) {
                        continue;
                    }

                    password.remove(--cursor);
                } else {  // 문자 입력
                    password.add(cursor++, c);
                }
            }

            for (Character c : password) {
                answer.append(c);
            }
            answer.append("\n");
        }

        System.out.print(answer);
    }
}
