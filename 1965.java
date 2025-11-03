import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int boxNumber;
    static ArrayList<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        boxNumber = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < boxNumber; i++) {
            int box = Integer.parseInt(st.nextToken());

            int result = Collections.binarySearch(numbers, box);

            if (result >= 0)  // 일치하는 숫자 있으면
            {
                continue;
            } else {
                result = result * -1 - 1;

                if (result >= numbers.size()) {
                    numbers.add(box);
                } else {
                    numbers.set(result, box);
                }
            }
        }

        System.out.println(numbers.size());
    }
}
