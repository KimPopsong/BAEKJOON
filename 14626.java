import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] isbn = br.readLine().toCharArray();

        boolean flag = false;  // 3을 곱해야 할 경우 true
        int sum = 0;

        for (int i = 0; i < 13; i++)
        {
            if (isbn[i] == '*')
            {
                if (i % 2 == 1)
                {
                    flag = true;
                }
            }

            else if (i % 2 == 0)
            {
                sum += isbn[i] - '0';
            }

            else
            {
                sum += (isbn[i] - '0') * 3;
            }
        }

        int mult = flag ? 3 : 1;
        
        for (int i = 0; i <= 9; i++)
        {
            if ((sum + mult * i) % 10 == 0)
            {
                System.out.println(i);
            }
        }
    }
}
