import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < testCase; tc++) {
            int islandNumber, bridgeNumber;
            boolean[] isVisit;
            Map<Integer, Set<Integer>> bridges = new HashMap<>();
            Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();

            st = new StringTokenizer(br.readLine());

            islandNumber = Integer.parseInt(st.nextToken());
            bridgeNumber = Integer.parseInt(st.nextToken());
            isVisit = new boolean[islandNumber + 1];

            for (int i = 1; i <= islandNumber; i++) {
                bridges.put(i, new HashSet<>());
                prices.put(i, new HashMap<>());
            }

            for (int i = 0; i < bridgeNumber; i++) {
                st = new StringTokenizer(br.readLine());

                int island1 = Integer.parseInt(st.nextToken());
                int island2 = Integer.parseInt(st.nextToken());
                int price = Integer.parseInt(st.nextToken());

                bridges.get(island1).add(island2);
                bridges.get(island2).add(island1);

                prices.get(island1).put(island2, price);
                prices.get(island2).put(island1, price);
            }

            int price = 0;
            isVisit[1] = true;
            for (int is : bridges.get(1)) {
                price += dfs(bridges, prices, isVisit, is, 1);
            }

            answer.append(price).append("\n");
        }

        System.out.print(answer);
    }

    static int dfs(Map<Integer, Set<Integer>> bridges, Map<Integer, Map<Integer, Integer>> prices,
        boolean[] isVisit, int island, int parentIsland) {
        int price = 0;
        isVisit[island] = true;

        if (bridges.get(island).size() == 1) {  // 연결된 섬이 한 개라면
            return prices.get(parentIsland).get(island);
        } else {
            for (int is : bridges.get(island)) {
                if (isVisit[is]) {
                    continue;
                }

                price += dfs(bridges, prices, isVisit, is, island);
            }
        }

        return Math.min(prices.get(parentIsland).get(island), price);
    }
}
