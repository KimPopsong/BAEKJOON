import java.io.*;
import java.util.*;

public class Main {
    static int intervalCount = 0, minObstacle = Integer.MAX_VALUE;
    static int caveLength, caveHeight;
    static double[] stalagmite, stalactite;  // 석순, 종유석

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        // 입력부 시작

        st = new StringTokenizer(br.readLine());

        caveLength = Integer.parseInt(st.nextToken());
        caveHeight = Integer.parseInt(st.nextToken());

        stalagmite = new double[caveLength / 2];
        stalactite = new double[caveLength / 2];

        for (int i = 0; i < caveLength; i++)
        {
            int h = Integer.parseInt(br.readLine());

            if (i % 2 == 0)  // 석순
            {
                stalagmite[i / 2] = h;
            }

            else  // 종유석
            {
                stalactite[i / 2] = h;
            }
        }

        // 입력부 종료

        Arrays.sort(stalagmite);
        Arrays.sort(stalactite);

        for (double height = 0.5; height <= caveHeight; height += 1)
        {
            int obstacle = searchResult(stalagmite, height) + searchResult(stalactite, caveHeight - height);

            if (obstacle < minObstacle)
            {
                intervalCount = 1;

                minObstacle = obstacle;
            }

            else if (obstacle == minObstacle)
            {
                intervalCount += 1;
            }
        }

        System.out.println(minObstacle + " " + intervalCount);
    }

    static int searchResult(double[] arrays, double height)
    {
        int index = Arrays.binarySearch(arrays, height);// 들어갈 공간을 이분 탐색

        index = (index + 1) * -1;  // 원래의 인덱스 찾기

        return (caveLength / 2) - index;
    }
}
