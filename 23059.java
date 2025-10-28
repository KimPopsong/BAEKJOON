import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int edgeNumber;
    static Set<String> items = new HashSet<>();
    static Map<String, Integer> topology = new HashMap<>();
    static Map<String, Set<String>> itemTree = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        edgeNumber = Integer.parseInt(br.readLine());

        for (int i = 0; i < edgeNumber; i++) {
            st = new StringTokenizer(br.readLine());

            String item1 = st.nextToken();
            String item2 = st.nextToken();

            itemTree.computeIfAbsent(item1, k -> new HashSet<>()).add(item2);
            itemTree.computeIfAbsent(item2, k -> new HashSet<>());

            topology.putIfAbsent(item1, 0);
            topology.put(item2, topology.getOrDefault(item2, 0) + 1);
        }

        PriorityQueue<String> itemBuy = new PriorityQueue<>();

        Iterator<Map.Entry<String, Integer>> it = topology.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<String, Integer> tp = it.next();

            if (tp.getValue() == 0) {
                itemBuy.add(tp.getKey());
                it.remove();
            }
        }

        while (!itemBuy.isEmpty()) {
            PriorityQueue<String> nextQueue = new PriorityQueue<>(itemBuy);
            itemBuy.clear();

            while (!nextQueue.isEmpty()) {

                String item = nextQueue.remove();

                answer.append(item).append("\n");

                for (String nextItem : itemTree.get(item)) {
                    int left = topology.get(nextItem) - 1;

                    if (left == 0) {
                        itemBuy.add(nextItem);

                        topology.remove(nextItem);
                    } else {
                        topology.put(nextItem, left);
                    }
                }
            }
        }

        if (topology.size() > 0) {
            answer = new StringBuilder();

            answer.append("-1");
        }

        System.out.print(answer);
    }
}
