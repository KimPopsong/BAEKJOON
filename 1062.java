import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.StringTokenizer;

public class Main {
    static int wordNumber, letterNumber, wordLearned = 0;
    static BitSet letterLearned = new BitSet(26);
    static ArrayList<BitSet> words = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        wordNumber = Integer.parseInt(st.nextToken());
        letterNumber = Integer.parseInt(st.nextToken());

        for (int i = 0; i < wordNumber; i++) {  // 단어 입력받고 전처리
            String temp = br.readLine();
            char[] word = temp.substring(4, temp.length() - 4).toCharArray();
            BitSet wordSet = new BitSet(26);

            for (char c : word) {
                wordSet.set(c - 'a');
            }

            words.add(wordSet);
        }

        if (letterNumber < 5)  // 최소 5개의 문자는 배워야 함
        {
            System.out.println(0);

            return;
        } else if (letterNumber == 26) {  // 모든 글자 습득 가능
            System.out.println(wordNumber);

            return;
        }

        // 필수 단어 학습
        letterNumber -= 5;
        letterLearned.set('a' - 'a');
        letterLearned.set('c' - 'a');
        letterLearned.set('i' - 'a');
        letterLearned.set('n' - 'a');
        letterLearned.set('t' - 'a');

        dfs(0, 0);

        System.out.println(wordLearned);
    }

    static void dfs(int depth, int index) {
        if (depth == letterNumber) {
            int count = 0;

            for (BitSet word : words) {
                BitSet result = (BitSet) letterLearned.clone();
                result.and(word);

                if (result.equals(word)) {
                    count += 1;
                }
            }

            wordLearned = Math.max(wordLearned, count);

            return;
        }

        for (int i = index; i < 26; i++) {  // 배울 글자를 조합
            if (letterLearned.get(i)) {  // 이미 배운 글자라면 생략
                continue;
            }

            letterLearned.set(i);
            dfs(depth + 1, i + 1);
            letterLearned.clear(i);
        }
    }
}
