import java.io.*;
import java.util.*;

public class Main {
    static int weightNumber, maxWeight = 0;
    static int[] weights;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        // 입력부 시작

        weightNumber = Integer.parseInt(br.readLine());
        weights = new int[weightNumber];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < weightNumber; i++)
        {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        // 입력부 종료

        Arrays.sort(weights);

        if (weights[0] != 1)
        {
            System.out.println(1);

            System.exit(0);
        }

        int left = 0;
        int right = weights[0];
        for (int i = 1; i < weightNumber; i++)
        {
            if (left + weights[i] <= right + 1)
            {
                right += weights[i];
            }

            else
            {
                break;
            }
        }

        System.out.println(right + 1);
    }
}
