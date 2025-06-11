import java.util.*;
import java.io.*;

public class Main {
    static int rowSize, colSize;
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    static int[][] map, sumWay;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        // 입력부 시작

        st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());

        map = new int[rowSize][colSize];
        sumWay = new int[rowSize][colSize];
        for (int r = 0; r < rowSize; r++)
        {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < colSize; c++)
            {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        // 입력부 종료

        sumWay[rowSize - 1][colSize - 1] = 1;
        dfs(0, 0);

        if (sumWay[0][0] == -1)
        {
            System.out.println(0);
        }

        else
        {
            System.out.print(sumWay[0][0]);
        }
    }

    static int dfs(int r, int c)
    {
        int sum = 0;

        for (int d = 0; d < 4; d++)  // 4방 탐색
        {
            int rr = r + dr[d];
            int cc = c + dc[d];

            if (0 <= rr && rr < rowSize && 0 <= cc && cc < colSize)
            {
                if (map[r][c] > map[rr][cc])  // 현재 높이보다 작다면
                {
                    if (sumWay[rr][cc] < 0)
                    {
                        continue;
                    }

                    else if (sumWay[rr][cc] > 0)
                    {
                        sum += sumWay[rr][cc];
                    }

                    else
                    {
                        sum += dfs(rr, cc);  // 방문
                    }
                }
            }
        }

        sumWay[r][c] += sum;

        if (sumWay[r][c] == 0)  // 탐색을 끝냈음에도 갈 수 있는 길이 없다면
        {
            sumWay[r][c] = -1;  // 못가는 길 처리

            return 0;
        }

        return sumWay[r][c];
    }
}
