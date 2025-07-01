import java.io.*;
import java.util.*;

public class Main {
    static int answer = 0;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int stringNumber = Integer.parseInt(br.readLine());

        for (int i = 0; i < stringNumber; i++)
        {
            String s = br.readLine();

            ArrayDeque<Character> deque = new ArrayDeque<>();

            for (int j = 0; j < s.length(); j++)
            {
                if (deque.isEmpty())  // 큐가 비었다면
                {
                    deque.addLast(s.charAt(j));
                }

                else
                {
                    if (deque.peekLast() == s.charAt(j))
                    {
                        deque.removeLast();
                    }

                    else
                    {
                        deque.addLast(s.charAt(j));
                    }
                }
            }

            if (deque.isEmpty())
            {
                answer += 1;
            }
        }

        System.out.println(answer);
    }
}
