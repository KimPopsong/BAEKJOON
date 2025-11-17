import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(st.nextToken());
        int index = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine());
        int[] numbers = new int[number];

        for (int i = 0; i < number; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);
        System.out.print(numbers[index]);
    }
}
