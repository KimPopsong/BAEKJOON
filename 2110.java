import java.io.*;
import java.util.*;

public class Main {
    static int houseNumber, routerNumber;
    static int[] houses;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        houseNumber = Integer.parseInt(st.nextToken());
        routerNumber = Integer.parseInt(st.nextToken());

        houses = new int[houseNumber];

        for (int i = 0; i < houseNumber; i++)
        {
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        int left = 1;
        int right = 1000000000;

        while (left <= right)
        {
            int mid = (left + right) / 2;

            int count = 0;
            int node = 0;
            for (int i = 0; i < houseNumber; i++)
            {
                if (houses[i] >= node)
                {
                    count += 1;
                    node = houses[i] + mid;
                }
            }

            if (count >= routerNumber)
            {
                left = mid + 1;
            }

            else
            {
                right = mid - 1;
            }
        }

        System.out.println((left + right) / 2);
    }
}
