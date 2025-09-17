import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        for (int testCase = 1; ; testCase++)
        {
            st = new StringTokenizer(br.readLine());

            int availDay = Integer.parseInt(st.nextToken());
            int streakDay = Integer.parseInt(st.nextToken());
            int vacationDay = Integer.parseInt(st.nextToken());

            if (availDay == 0 && streakDay == 0 && vacationDay == 0)
            {
                break;
            }

            int avail = (vacationDay / streakDay) * availDay;

            if (vacationDay % streakDay <= availDay)
            {
                avail += vacationDay % streakDay;
            }

            else
            {
                avail += availDay;
            }

            answer.append("Case ").append(testCase).append(": ").append(avail).append("\n");
        }

        System.out.print(answer);
    }
}
