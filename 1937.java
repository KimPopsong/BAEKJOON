import java.io.*;
import java.util.*;

public class Main {
    static int size;
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    static int[][] map, isVisit;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        // 입력부 시작

        size = Integer.parseInt(br.readLine());
        map = new int[size][size];
        isVisit = new int[size][size];

        for (int r = 0; r < size; r++)
        {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < size; c++)
            {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        // 입력부 종료

        for (int r = 0; r < size; r++)
        {
            for (int c = 0; c < size; c++)
            {
                if (isVisit[r][c] == 0)
                {
                    bfs(r, c);
                }
            }
        }

        int maxDepth = 0;

        for (int r = 0; r < size; r++)
        {
            for (int c = 0; c < size; c++)
            {
                if (isVisit[r][c] > maxDepth)
                {
                    maxDepth = isVisit[r][c];
                }
            }
        }

        System.out.println(maxDepth);
    }

    static int bfs(int r, int c)
    {
        int maxDepth = 0;

        for (int d = 0; d < 4; d++)
        {
            int rr = r + dr[d];
            int cc = c + dc[d];

            if (0 <= rr && rr < size && 0 <= cc && cc < size)  // 범위 안에 있고
            {
                if (map[rr][cc] > map[r][c])  // 기존 대나무보다 많고
                {
                    if (isVisit[rr][cc] == 0)  // 방문하지 않은 노드가 있다면 방문
                    {
                        maxDepth = Math.max(maxDepth, bfs(rr, cc));
                    }

                    else
                    {
                        maxDepth = Math.max(maxDepth, isVisit[rr][cc]);
                    }
                }
            }
        }

        isVisit[r][c] = maxDepth + 1;

        return maxDepth + 1;
    }
}
