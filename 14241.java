import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int slimeNumber = Integer.parseInt(br.readLine());
        int sumScore = 0;
        PriorityQueue<Integer> slimes = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens())
        {
            slimes.add(Integer.parseInt(st.nextToken()));
        }

        while (slimes.size() != 1)
        {
            int s1 = slimes.remove();
            int s2 = slimes.remove();

            sumScore += s1 * s2;
            slimes.add(s1 + s2);
        }

        System.out.print(sumScore);
    }
}
