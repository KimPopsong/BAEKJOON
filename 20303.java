import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int childrenNumber, edgeNumber, maxSteal, answer;
    static int[] candies, group;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        childrenNumber = Integer.parseInt(st.nextToken());
        edgeNumber = Integer.parseInt(st.nextToken());
        maxSteal = Integer.parseInt(st.nextToken());

        candies = new int[childrenNumber + 1];
        group = new int[childrenNumber + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= childrenNumber; i++) {
            candies[i] = Integer.parseInt(st.nextToken());
            group[i] = i;
        }

        for (int i = 0; i < edgeNumber; i++) {
            st = new StringTokenizer(br.readLine());

            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            union(c1, c2);
        }

        Group[] tempGroups = new Group[childrenNumber + 1];
        for (int i = 1; i <= childrenNumber; i++) {
            tempGroups[i] = new Group(0, 0);
        }

        for (int i = 1; i <= childrenNumber; i++) {
            int p = findGroup(i);

            tempGroups[p].childrenNumber += 1;
            tempGroups[p].candies += candies[i];
        }

        ArrayList<Group> groups = new ArrayList<>();
        for (int i = 1; i <= childrenNumber; i++) {
            if (tempGroups[i].childrenNumber != 0) {
                groups.add(tempGroups[i]);
            }
        }

        int[] dp = new int[maxSteal];
        for (Group g : groups) {
            for (int i = maxSteal - 1; i >= g.childrenNumber; i--) {
                dp[i] = Math.max(dp[i], dp[i - g.childrenNumber] + g.candies);
            }
        }

        System.out.println(dp[maxSteal - 1]);
    }

    static int findGroup(int x) {
        if (group[x] == x) {
            return x;
        }

        return group[x] = findGroup(group[x]);
    }

    static boolean union(int c1, int c2) {
        int g1 = findGroup(c1);
        int g2 = findGroup(c2);

        if (g1 == g2) {
            return false;
        } else if (g1 > g2) {
            int t = g1;
            g1 = g2;
            g2 = t;
        }

        group[g2] = g1;

        return true;
    }

    static class Group {
        int childrenNumber, candies;

        Group(int childrenNumber, int candies) {
            this.childrenNumber = childrenNumber;
            this.candies = candies;
        }
    }
}
