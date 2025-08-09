import java.util.*;
import java.io.*;

public class Main {
    static int maxCustomer, cityNumber;
    static int[] investment;
    static int[][] advertisement;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력부 시작

        st = new StringTokenizer(br.readLine());

        maxCustomer = Integer.parseInt(st.nextToken());
        cityNumber = Integer.parseInt(st.nextToken());
        investment = new int[maxCustomer + 101];
        advertisement = new int[cityNumber][2];

        for (int i = 0; i < cityNumber; i++)
        {
            st = new StringTokenizer(br.readLine());

            advertisement[i][0] = Integer.parseInt(st.nextToken());
            advertisement[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(investment, 2100000000);
        investment[0] = 0;

        // 입력부 종료

        for (int i = 0; i < cityNumber; i++)
        {
            for (int c = advertisement[i][1]; c <= maxCustomer + 100; c += 1)
            {
                investment[c] = Math.min(investment[c], investment[c - advertisement[i][1]] + advertisement[i][0]);
            }
        }

        int minPrice = Integer.MAX_VALUE;

        for (int i = maxCustomer; i <= maxCustomer + 100; i++)
        {
            minPrice = Math.min(minPrice, investment[i]);
        }

        System.out.print(minPrice);
    }
}
