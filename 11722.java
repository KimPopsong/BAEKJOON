import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int numberLength = Integer.parseInt(br.readLine());
        int count = 0;
        int[] dp = new int[numberLength];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberLength; i++)
        {
            int number = Integer.parseInt(st.nextToken()) * -1;

            int index = Arrays.binarySearch(dp, 0, count, number);

            if (index >= 0)
            {
                continue;
            }

            else
            {
                index += 1;
                index *= -1;

                if (dp[index] == 0)
                {
                    count += 1;
                }

                dp[index] = number;
            }
        }

        System.out.println(count);
    }
}
