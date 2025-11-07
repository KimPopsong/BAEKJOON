import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int buildingNumber;
    static int[] parent;
    static long[] originalTime, time;
    static Map<Integer, Set<Integer>> topology = new HashMap<>();
    static ArrayDeque<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        buildingNumber = Integer.parseInt(br.readLine());
        parent = new int[buildingNumber + 1];
        originalTime = new long[buildingNumber + 1];
        time = new long[buildingNumber + 1];

        for (int i = 1; i <= buildingNumber; i++) {
            topology.put(i, new HashSet<>());
        }

        for (int i = 1; i <= buildingNumber; i++) {
            st = new StringTokenizer(br.readLine());

            long t = Long.parseLong(st.nextToken());  // 건물을 짓는데 걸리는 시간
            originalTime[i] = t;
            time[i] = t;

            while (st.hasMoreTokens()) {
                int p = Integer.parseInt(st.nextToken());

                if (p == -1) {
                    break;
                }

                topology.get(p).add(i);
                parent[i] += 1;
            }

            if (parent[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int n = queue.removeFirst();

            for (int p : topology.get(n)) {
                parent[p] -= 1;
                time[p] = Math.max(time[p], originalTime[p] + time[n]);

                if (parent[p] == 0) {
                    queue.addLast(p);
                }
            }
        }

        for (int i = 1; i <= buildingNumber; i++) {
            answer.append(time[i]).append("\n");
        }

        System.out.print(answer);
    }
}
