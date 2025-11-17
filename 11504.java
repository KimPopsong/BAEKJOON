import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < testCase; tc++) {
            int number, size, low = 0, high = 0, count = 0;
            ArrayDeque<Integer> numbers = new ArrayDeque<>();

            st = new StringTokenizer(br.readLine());

            number = Integer.parseInt(st.nextToken());
            size = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < size; i++) {
                low += Math.pow(10, size - i - 1) * Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < size; i++) {
                high += Math.pow(10, size - i - 1) * Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                numbers.addLast(Integer.parseInt(st.nextToken()));
            }

            int target = 0;
            for (int i = 0; i < size; i++) {
                int n = numbers.removeFirst();

                target += Math.pow(10, size - i - 1) * n;

                numbers.addLast(n);
            }

            for (int i = 0; i < number; i++) {
                if (low <= target && target <= high) {
                    count += 1;
                }

                target %= Math.pow(10, size - 1);
                target *= 10;

                int n = numbers.removeFirst();

                target += n;

                numbers.addLast(n);
            }

            answer.append(count).append("\n");
        }

        System.out.print(answer);
    }
}
