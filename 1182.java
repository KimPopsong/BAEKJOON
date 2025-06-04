import java.io.*;
import java.util.*;

public class Main {
    static boolean flag = false;
    static int number, targetNumber, answer = 0, sumAllNumber = 0;
    static int[] numbers;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        number = Integer.parseInt(st.nextToken());
        targetNumber = Integer.parseInt(st.nextToken());

        numbers = new int[number];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < number; i++)
        {
            numbers[i] = Integer.parseInt(st.nextToken());

            sumAllNumber += numbers[i];
        }

        if (number % 2 == 0)
        {
            flag = true;
        }

        for (int pick = 1; pick <= number; pick++)
        {
            getSubset(pick, 0, 0, 0);
        }

        System.out.println(answer);
    }

    public static void getSubset(int maxDepth, int depth, int index, int sum)
    {
        if (depth == maxDepth)
        {
            if (sum == targetNumber)
            {
                answer += 1;
            }

            return;
        }

        for (int i = index; i < number; i++)
        {
            getSubset(maxDepth, depth + 1, i + 1, sum + numbers[i]);
        }
    }
}
