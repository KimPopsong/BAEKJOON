import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int numberLength, eraseNumber;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        numberLength = Integer.parseInt(st.nextToken());
        eraseNumber = Integer.parseInt(st.nextToken());

        char[] number = br.readLine().toCharArray();

        ArrayDeque<Character> numberQueue = new ArrayDeque<>();

        for (char c : number) {
            while (!numberQueue.isEmpty() && numberQueue.peekLast() < c && eraseNumber > 0) {
                numberQueue.removeLast();

                eraseNumber -= 1;
            }

            numberQueue.addLast(c);
        }

        while (eraseNumber > 0) {
            numberQueue.removeLast();

            eraseNumber -= 1;
        }

        while (!numberQueue.isEmpty()) {
            answer.append(numberQueue.removeFirst());
        }

        System.out.print(answer);
    }
}
