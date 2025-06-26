import java.io.*;
import java.util.*;

public class Main {
    static int n, k;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        boolean[] human = new boolean[n + 1];

        sb.append("<");

        int node = 0;
        int count = 0;
        while (true)
        {
            int countK = 0;

            while (countK < k)
            {
                node += 1;

                if (node > n)
                {
                    node = 1;
                }

                if (human[node] == false)
                {
                    countK += 1;
                }
            }

            human[node] = true;
            count += 1;
            sb.append(node);

            if (count != n)
            {
                sb.append(", ");
            }

            else
            {
                break;
            }
        }

        sb.append(">");

        System.out.print(sb);
    }
}
