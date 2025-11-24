import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int move = 0;

        st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int pickNumber = Integer.parseInt(st.nextToken());
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= size; i++)  // queue 초기화
        {
            queue.addLast(i);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < pickNumber; i++) {
            int pick = Integer.parseInt(st.nextToken());

            int temp = 0;

            while (queue.peekFirst() != pick) {
                temp += 1;
                queue.addLast(queue.removeFirst());
            }

            queue.removeFirst();
            temp = Math.min(temp, queue.size() - temp + 1);

            move += temp;
        }

        System.out.print(move);
    }
}
