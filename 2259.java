import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int moleNumber, speed;
    static ArrayList<Mole> moles = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        moleNumber = Integer.parseInt(st.nextToken());
        speed = Integer.parseInt(st.nextToken());

        moles.add(new Mole(0, 0, 0));
        for (int i = 0; i < moleNumber; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int appearTime = Integer.parseInt(st.nextToken());

            moles.add(new Mole(r, c, appearTime));
        }

        Collections.sort(moles);

        long[] dp = new long[moleNumber + 1];
        for (int i = 1; i <= moleNumber; i++) {
            dp[i] = -1;
        }
        dp[0] = 0;

        for (int i = 1; i <= moleNumber; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] == -1) {
                    continue;
                }

                long dt = (long) moles.get(i).appearTime - moles.get(j).appearTime;
                long dr = (long) moles.get(i).r - moles.get(j).r;
                long dc = (long) moles.get(i).c - moles.get(j).c;

                long distancePow = dr * dr + dc * dc;
                long limitPow = (dt * (long) speed) * (dt * (long) speed);

                if (limitPow >= distancePow) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        long max = 0;
        for (long l : dp) {
            max = Math.max(max, l);
        }

        System.out.print(max);
    }

    static class Mole implements Comparable<Mole> {

        int r, c, appearTime;

        Mole(int r, int c, int appearTime) {
            this.r = r;
            this.c = c;
            this.appearTime = appearTime;
        }

        @Override
        public int compareTo(Mole m) {
            return Integer.compare(this.appearTime, m.appearTime);
        }
    }
}
