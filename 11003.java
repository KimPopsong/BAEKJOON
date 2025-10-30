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

        int number, partLength;
        int[] numbers;
        ArrayDeque<Number> numberQueue = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        number = Integer.parseInt(st.nextToken());
        partLength = Integer.parseInt(st.nextToken());
        numbers = new int[number];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < number; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < number; i++) {
            int n = numbers[i];

            while (!numberQueue.isEmpty() && numberQueue.peekLast().value > n) {
                numberQueue.removeLast();
            }

            numberQueue.addLast(new Number(i, n));

            while (numberQueue.peekFirst().index < i - partLength + 1) {
                numberQueue.removeFirst();
            }

            answer.append(numberQueue.peekFirst().value).append(" ");
        }

        System.out.print(answer);
    }

    static class Number {
        int index, value;

        Number(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
