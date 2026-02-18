import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int number, change;
        int[] numbers;

        number = Integer.parseInt(br.readLine());

        numbers = new int[number];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < number; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        change = Integer.parseInt(br.readLine());

        while (change > 0) {
            boolean flag = false;

            for (int i = 0; i < number - 1; i++) {
                int max = -1, index = -1;

                for (int j = i + 1; j < number && j <= i + change; j++) {
                    if (numbers[j] > numbers[i] && numbers[j] > max) {
                        max = numbers[j];
                        index = j;
                    }
                }

                if (index != -1) {
                    for (int j = index; j > i; j--) {
                        numbers[j] = numbers[j - 1];
                    }

                    numbers[i] = max;
                    flag = true;
                    change -= index - i;
                }
            }

            if (!flag) {
                break;
            }
        }

        for (int i : numbers) {
            answer.append(i).append(" ");
        }

        System.out.print(answer);
    }
}
