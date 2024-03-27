import java.io.*;
import java.util.*;

public class Main {
    static int caveSize;
    static int[][] caveMap = new int[126][126];  // 동굴 지도
    static int[][] visited = new int[126][126];  // 완전 탐색을 위한 배열

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int time = 1; ; time++)
        {
            caveSize = Integer.parseInt(br.readLine().strip());

            if (caveSize == 0)  // 0입력시 종료
            {
                break;
            }

            else
            {
                for (int i = 0; i < caveSize; i++)  // Initialize
                {
                    String[] temp = br.readLine().split(" ");

                    for (int j = 0; j < caveSize; j++)
                    {
                        caveMap[i][j] = Integer.parseInt(temp[j]);
                        visited[i][j] = Integer.MAX_VALUE;
                    }
                }

                int answer = DFS();

                sb.append("Problem ").append(time).append(": ").append(answer).append("\n");
            }
        }

        System.out.print(sb);
    }

    public static int DFS()
    {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<Point> dfs = new ArrayDeque<>();

        dfs.add(new Point(0, 0));
        visited[0][0] = caveMap[0][0];

        while (!dfs.isEmpty())
        {
            int r = dfs.peek().row;
            int c = dfs.peek().col;

            dfs.poll();

            for (int d = 0; d < 4; d++)
            {
                int row = r + dx[d];
                int col = c + dy[d];

                if (row < 0 || col < 0 || row >= caveSize || col >= caveSize)
                {
                    continue;
                }

                else
                {
                    if(visited[row][col] > visited[r][c] + caveMap[row][col])
                    {
                        visited[row][col] = visited[r][c] + caveMap[row][col];

                        dfs.add(new Point(row, col));
                    }
                }
            }
        }

        return visited[caveSize - 1][caveSize - 1];
    }

    public static class Point {
        int row, col;

        Point(int row, int col)
        {
            this.row = row;
            this.col = col;
        }
    }
}
