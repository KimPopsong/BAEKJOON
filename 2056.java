import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int jobNumber;
    static int[] spendTime, sumTime, parentNumber;  // 작업을 하는데 걸리는 시간
    static Map<Integer, Set<Integer>> parentJob = new HashMap<>();  // 부모

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        jobNumber = Integer.parseInt(br.readLine());
        spendTime = new int[jobNumber];
        sumTime = new int[jobNumber];
        parentNumber = new int[jobNumber];

        for (int i = 0; i < jobNumber; i++) {
            parentJob.put(i, new HashSet<>());
        }

        for (int i = 0; i < jobNumber; i++) {
            st = new StringTokenizer(br.readLine());

            spendTime[i] = Integer.parseInt(st.nextToken());
            sumTime[i] = spendTime[i];
            int pNumber = Integer.parseInt(st.nextToken());  // 선행 작업

            for (int j = 0; j < pNumber; j++) {
                parentJob.get(Integer.parseInt(st.nextToken()) - 1).add(i);
            }

            parentNumber[i] = pNumber;
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < jobNumber; i++) {
            if (parentNumber[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int job = queue.removeFirst();

            for (int child : parentJob.get(job)) {
                sumTime[child] = Math.max(sumTime[child], spendTime[child] + sumTime[job]);
                parentNumber[child] -= 1;

                if (parentNumber[child] == 0) {
                    queue.addLast(child);
                }
            }
        }

        int spend = 0;
        for (int time : sumTime) {
            spend = Math.max(spend, time);
        }

        System.out.print(spend);
    }
}
