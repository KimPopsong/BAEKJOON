import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        // 입력부 시작

        int size = Integer.parseInt(br.readLine());
        int[] dp = new int[size + 1];

        // 입력부 종료

        dp[0] = 0;
        dp[1] = 3;

        if (size >= 2)
        {
            dp[2] = 7;
        }

        for (int i = 3; i <= size; i++)
        {
            dp[i] = (dp[i - 1] * 2 % 9901 + dp[i - 2] % 9901) % 9901;
        }

        System.out.println(dp[size]);
    }
}
