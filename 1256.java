import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    static int aNumber, zNumber, findIndex;
    static BigInteger[][] comb = new BigInteger[201][201];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        aNumber = Integer.parseInt(st.nextToken());
        zNumber = Integer.parseInt(st.nextToken());
        findIndex = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= 200; i++) {
            comb[i][0] = BigInteger.ONE;
            comb[i][i] = BigInteger.ONE;

            for (int j = 1; j < i; j++) {
                comb[i][j] = comb[i - 1][j - 1].add(comb[i - 1][j]);
            }
        }

        if (comb[aNumber + zNumber][aNumber].compareTo(BigInteger.valueOf(findIndex)) < 0) {
            answer.append(-1);
        } else {
            while (true) {
                if (aNumber <= 0) {
                    if (zNumber <= 0) {
                        break;
                    } else {
                        zNumber -= 1;

                        answer.append('z');
                    }
                } else if (zNumber <= 0) {
                    aNumber -= 1;

                    answer.append('a');
                } else {
                    BigInteger c = comb[aNumber + zNumber][aNumber].multiply(BigInteger.valueOf(aNumber)).divide(BigInteger.valueOf((aNumber + zNumber)));

                    if (c.compareTo(BigInteger.valueOf(findIndex)) >= 0) {
                        aNumber -= 1;

                        answer.append('a');
                    } else {
                        findIndex -= c.intValue();
                        zNumber -= 1;

                        answer.append('z');
                    }
                }
            }
        }

        System.out.print(answer);
    }
}
