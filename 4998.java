import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        while (true)
        {
            int count = 0;
            String temp = br.readLine();

            if (temp == null)
            {
                break;
            }

            st = new StringTokenizer(temp);

            double origin = Double.parseDouble(st.nextToken());
            double interest = Double.parseDouble(st.nextToken());
            double target = Double.parseDouble(st.nextToken());

            while (origin <= target)
            {
                count += 1;

                origin += origin * interest / 100;
            }

            answer.append(count).append("\n");
        }

        System.out.print(answer);
    }
}
