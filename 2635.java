import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int number = Integer.parseInt(br.readLine());
        int big = 0, bigCount = 2;

        for (int i = 1; i <= number; i++)
        {
            int t = number;
            int n = i;
            int c = 2;

            while (true)
            {
                t = t - n;

                if (t < 0)
                {
                    break;
                }

                else
                {
                    c += 1;

                    int tt = t;
                    t = n;
                    n = tt;
                }
            }

            if (c > bigCount)
            {
                bigCount = c;
                big = i;
            }
        }

        sb.append(bigCount).append("\n");
        sb.append(number).append(" ").append(big).append(" ");

        while (true)
        {
            number = number - big;

            if (number < 0)
            {
                break;
            }

            else
            {
                sb.append(number).append(" ");

                int t = number;
                number = big;
                big = t;
            }
        }

        System.out.println(sb);
    }
}
