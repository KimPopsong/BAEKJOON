import java.io.*;
import java.util.*;

public class Main {
    static int provinceNumber, budgetMax, answer;
    static int[] provinces;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        // 입력부 시작

        provinceNumber = Integer.parseInt(br.readLine());
        provinces = new int[provinceNumber];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < provinceNumber; i++)
        {
            provinces[i] = Integer.parseInt(st.nextToken());
        }

        budgetMax = Integer.parseInt(br.readLine());

        // 입력부 종료

        Arrays.sort(provinces);

        int left = 0, right = provinces[provinceNumber - 1];

        while (left <= right)
        {
            int budget = (left + right) / 2;

            int budgetSum = 0;

            for (int p : provinces)
            {
                budgetSum += Math.min(p, budget);
            }

            if (budgetSum > budgetMax)  // 예산 초과
            {
                right = budget - 1;
            }

            else
            {
                answer = budget;
                left = budget + 1;
            }
        }

        System.out.println(answer);
    }
}
