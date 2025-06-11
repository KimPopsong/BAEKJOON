import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < testCase; tc++)
        {
            int canHire = 0;
            int employeeNumber = Integer.parseInt(br.readLine());

            int[][] employees = new int[employeeNumber][2];

            for (int i = 0; i < employeeNumber; i++)
            {
                st = new StringTokenizer(br.readLine());

                employees[i][0] = Integer.parseInt(st.nextToken());
                employees[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(employees, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2)
                {
                    return Integer.compare(o1[0], o2[0]);
                }
            });

            int minRank = employeeNumber + 1;
            for (int i = 0; i < employeeNumber; i++)
            {
                if (employees[i][1] < minRank)
                {
                    canHire += 1;
                    minRank = employees[i][1];
                }
            }

            sb.append(canHire).append("\n");
        }

        System.out.print(sb);
    }
}
