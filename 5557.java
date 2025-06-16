import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int number;
        int[] numbers;
        long[][] dp;

        // 입력부 시작

        number = Integer.parseInt(br.readLine());
        numbers = new int[number];
        dp = new long[number - 1][21];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < number; i++)
        {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 입력부 종료

        dp[0][numbers[0]] = 1;

        for (int i = 1; i < number - 1; i++)
        {
            int n = numbers[i];

            for (int j = 0; j <= 20; j++)
            {
                long temp = dp[i - 1][j];

                if (temp != 0)
                {
                    if (0 <= j - n)
                    {
                        dp[i][j - n] += temp;
                    }

                    if (j + n <= 20)
                    {
                        dp[i][j + n] += temp;
                    }
                }
            }
        }

        System.out.print(dp[number - 2][numbers[number - 1]]);
    }
}
