import java.util.*;
import java.io.*;

public class Main {
    static int chapterNumber, maxTime;
    static int[] maxScore;
    static int[][] chapter;  // [ 예상 공부 시간, 문제의 배점 ]

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력부 시작

        st = new StringTokenizer(br.readLine());

        chapterNumber = Integer.parseInt(st.nextToken());
        maxTime = Integer.parseInt(st.nextToken());

        maxScore = new int[maxTime + 1];
        chapter = new int[chapterNumber][2];

        for (int i = 0; i < chapterNumber; i++)
        {
            st = new StringTokenizer(br.readLine());

            chapter[i][0] = Integer.parseInt(st.nextToken());
            chapter[i][1] = Integer.parseInt(st.nextToken());
        }

        // 입력부 종료

        for (int i = 0; i < chapterNumber; i++)
        {
            for (int time = maxTime; time >= chapter[i][0]; time--)
            {
                maxScore[time] = Math.max(maxScore[time], maxScore[time - chapter[i][0]] + chapter[i][1]);
            }
        }

        System.out.println(maxScore[maxTime]);
    }
}
