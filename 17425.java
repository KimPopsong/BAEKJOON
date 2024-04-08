import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine().strip());
        long[] divisor = new long[1000001];

        for (int i = 1; i <= 1000000; i++)
        {
            for (int j = 1; j <= 1000000 / i; j++)
            {
                divisor[i * j] += i;
            }
        }

        for (int i = 1; i <= 1000000; i++)
        {
            divisor[i] += divisor[i - 1];
        }

        for (int i = 0; i < testCase; i++)
        {
            int test = Integer.parseInt(br.readLine().strip());

            sb.append(divisor[test]).append("\n");
        }

        System.out.print(sb);
    }
}
