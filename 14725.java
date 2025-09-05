import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    static int feedNumber;
    static Map<String, Trie> tries = new TreeMap<>();
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력부 시작

        feedNumber = Integer.parseInt(br.readLine());

        // 입력부 종료

        for (int i = 0; i < feedNumber; i++) {
            st = new StringTokenizer(br.readLine());

            int depth = Integer.parseInt(st.nextToken());

            Trie trie;
            String start = st.nextToken();

            if (tries.containsKey(start)) {
                trie = tries.get(start);
            } else {
                trie = tries.computeIfAbsent(start, k -> new Trie());
            }

            for (int d = 1; d < depth; d++) {
                String s = st.nextToken();

                trie = trie.tries.computeIfAbsent(s, k -> new Trie());
            }
        }

        Print(tries, 0);

        System.out.print(answer);
    }

    static void Print(Map<String, Trie> tr, int depth) {
        for (String key : tr.keySet()) {
            answer.append("--".repeat(Math.max(0, depth)));
            answer.append(key).append("\n");

            Print(tr.get(key).tries, depth + 1);
        }
    }

    static class Trie {
        Map<String, Trie> tries = new TreeMap<>();
    }
}
