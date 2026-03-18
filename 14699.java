import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int shelterNumber, roadNumber;
    static int[] heights;
    static Map<Integer, Set<Integer>> roads = new HashMap<>();
    static Map<Integer, Integer> shelterCanVisit = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        shelterNumber = Integer.parseInt(st.nextToken());
        roadNumber = Integer.parseInt(st.nextToken());

        heights = new int[shelterNumber + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= shelterNumber; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= shelterNumber; i++) {
            roads.put(i, new HashSet<>());
            shelterCanVisit.put(i, 0);
        }

        for (int i = 0; i < roadNumber; i++) {
            st = new StringTokenizer(br.readLine());

            int shelter1 = Integer.parseInt(st.nextToken());
            int shelter2 = Integer.parseInt(st.nextToken());

            roads.get(shelter1).add(shelter2);
            roads.get(shelter2).add(shelter1);
        }

        for (int i = 1; i <= shelterNumber; i++) {
            if (shelterCanVisit.get(i) == 0) {
                dfs(i);
            }

            answer.append(shelterCanVisit.get(i)).append("\n");
        }

        System.out.print(answer);
    }

    static int dfs(int shelterNow) {
        int max = 0;

        for (int shelterNext : roads.get(shelterNow)) {
            if (heights[shelterNext] > heights[shelterNow]) {
                if (shelterCanVisit.get(shelterNext) == 0) {
                    max = Math.max(max, dfs(shelterNext));
                } else {
                    max = Math.max(max, shelterCanVisit.get(shelterNext));
                }
            }
        }

        shelterCanVisit.put(shelterNow, max + 1);

        return max + 1;
    }
}
