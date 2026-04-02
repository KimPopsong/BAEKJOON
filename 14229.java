import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static final char[] DNA = {'A', 'C', 'G', 'T'};
    static int DNALength;
    static char[] originDNA;
    static Set<String> DNACombs, canMake;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        originDNA = br.readLine().toCharArray();
        DNALength = originDNA.length;

        for (int pick = 1; pick <= DNALength + 1; pick++) {
            DNACombs = new HashSet<>();
            canMake = new HashSet<>();

            getPermutation(pick, 0, "", DNACombs);
            getAvailComb(Math.min(pick, DNALength), canMake);

            for (String comb : DNACombs) {
                if (!canMake.contains(comb)) {
                    System.out.println(comb);

                    return;
                }
            }
        }
    }

    private static void getAvailComb(int length, Set<String> set) {
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < length; i++) {
            temp.append(originDNA[i]);
        }

        set.add(temp.toString());

        for (int i = 0; i < DNALength - length; i++) {
            temp.deleteCharAt(0).append(originDNA[i + length]);
            set.add(temp.toString());
        }
    }

    static void getPermutation(int maxDepth, int depth, String comb, Set<String> set) {
        if (depth == maxDepth) {
            set.add(comb);

            return;
        }

        for (int i = 0; i < 4; i++) {
            getPermutation(maxDepth, depth + 1, comb + DNA[i], set);
        }
    }
}
