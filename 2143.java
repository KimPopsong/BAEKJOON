import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static long answer = 0, target;
    static long[] arr1, arr2;
    static Map<Long, Long> preSum1 = new HashMap<>(), preSum2 = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        target = Integer.parseInt(br.readLine());

        int size1 = Integer.parseInt(br.readLine());
        arr1 = new long[size1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size1; i++) {
            arr1[i] = Long.parseLong(st.nextToken());
        }

        int size2 = Integer.parseInt(br.readLine());
        arr2 = new long[size2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size2; i++) {
            arr2[i] = Long.parseLong(st.nextToken());
        }

        for (int i = 0; i < size1; i++) {
            long preSum = 0;

            for (int j = i; j < size1; j++) {
                preSum += arr1[j];

                preSum1.put(preSum, preSum1.getOrDefault(preSum, 0L) + 1);
            }
        }

        for (int i = 0; i < size2; i++) {
            long preSum = 0;

            for (int j = i; j < size2; j++) {
                preSum += arr2[j];

                preSum2.put(preSum, preSum2.getOrDefault(preSum, 0L) + 1);
            }
        }

        for (Map.Entry<Long, Long> p : preSum1.entrySet()) {
            answer += preSum2.getOrDefault(target - p.getKey(), 0L) * p.getValue();
        }

        System.out.println(answer);
    }
}
