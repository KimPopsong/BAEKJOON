import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int childrenNumber;
    static int[] children;
    static Map<Integer, Integer> longest = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        childrenNumber = Integer.parseInt(br.readLine());
        children = new int[childrenNumber];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < childrenNumber; i++) {
            children[i] = Integer.parseInt(st.nextToken());

            if (longest.containsKey(children[i] - 1)) {
                int n = longest.remove(children[i] - 1);

                longest.put(children[i], n + 1);
            } else {
                longest.put(children[i], 1);
            }
        }

        int longPart = 0;

        for (int k : longest.keySet()) {
            longPart = Math.max(longPart, longest.get(k));
        }

        System.out.print(childrenNumber - longPart);
    }
}
