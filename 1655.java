import java.io.*;
import java.util.*;

public class Main {
    static int number;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        number = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());  // 가장 큰 수가 top
        PriorityQueue<Integer> minQ = new PriorityQueue<>();  // 가장 작은 수가 top

        for (int i = 0; i < number; i++)
        {
            int num = Integer.parseInt(br.readLine());

            if (maxQ.isEmpty() || num <= maxQ.peek())
            {
                maxQ.add(num);
            }

            else
            {
                minQ.add(num);
            }

            // Step 2: 힙의 크기 균형 맞추기
            if (maxQ.size() > minQ.size() + 1)
            {
                minQ.add(maxQ.remove());
            }

            else if (minQ.size() > maxQ.size())
            {
                maxQ.add(minQ.remove());
            }

            answer.append(maxQ.peek()).append("\n");
        }

        System.out.print(answer);
    }
}
