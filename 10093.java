import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] temp = br.readLine().split(" ");

        long num1 = Long.parseLong(temp[0]);
        long num2 = Long.parseLong(temp[1]);

        if (num1 > num2)
        {
            long t = num1;
            num1 = num2;
            num2 = t;
        }

        else if (num1 == num2)
        {
            System.out.println(0);

            return;
        }

        sb.append(num2 - num1 - 1).append("\n");

        for (long n = num1 + 1; n < num2; n++)
        {
            sb.append(n).append(" ");
        }

        System.out.println(sb);
    }
}
