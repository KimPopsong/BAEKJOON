import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int numberSize, queryNumber;
    static long[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        numberSize = Integer.parseInt(st.nextToken());
        queryNumber = Integer.parseInt(st.nextToken());

        numbers = new long[numberSize];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberSize; i++) {
            numbers[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(numbers);

        for (int q = 0; q < queryNumber; q++) {
            st = new StringTokenizer(br.readLine());

            int left = Integer.parseInt(st.nextToken()) - 1;
            int right = Integer.parseInt(st.nextToken()) - 1;
            long value = Long.parseLong(st.nextToken());

            for (int i = left; i <= right; i++) {
                numbers[i] += value;
            }

            Arrays.sort(numbers);
        }

        for (long l : numbers) {
            answer.append(l).append(" ");
        }

        System.out.print(answer);
    }
}
