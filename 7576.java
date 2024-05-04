import java.io.*;
import java.util.*;

public class Main {
    static int boxRow, boxCol;
    static int[][] box;
    static int day = -1;  // 토마토가 익는데 걸리는 시간
    static Queue<Point> bfs = new ArrayDeque<>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] temp = br.readLine().split(" ");

        boxCol = Integer.parseInt(temp[0]);
        boxRow = Integer.parseInt(temp[1]);

        box = new int[boxRow][boxCol];

        for (int i = 0; i < boxRow; i++)
        {
            temp = br.readLine().split(" ");

            for (int j = 0; j < boxCol; j++)
            {
                box[i][j] = Integer.parseInt(temp[j]);

                if (box[i][j] == 1)
                {
                    bfs.add(new Point(i, j));
                }
            }
        }

        CalcRipe();  // bfs

        if (CheckRipe())
        {
            System.out.println(day);
        }

        else
        {
            System.out.println(-1);
        }
    }

    static void CalcRipe()
    {
        Queue<Point> temp = new ArrayDeque<>();

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!bfs.isEmpty())
        {
            temp.addAll(bfs);
            bfs.clear();

            while (!temp.isEmpty())
            {
                int r = temp.peek().row;
                int c = temp.poll().col;

                for (int d = 0; d < 4; d++)
                {
                    if (r + dx[d] >= boxRow || r + dx[d] < 0 || c + dy[d] >= boxCol || c + dy[d] < 0)
                    {
                        continue;
                    }

                    else
                    {
                        if (box[r + dx[d]][c + dy[d]] == 0)
                        {
                            box[r + dx[d]][c + dy[d]] = 1;
                            bfs.add(new Point(r + dx[d], c + dy[d]));
                        }
                    }
                }
            }

            day += 1;
        }
    }

    static boolean CheckRipe()
    {
        for (int i = 0; i < boxRow; i++)
        {
            for (int j = 0; j < boxCol; j++)
            {
                if (box[i][j] == 0)
                {
                    return false;
                }
            }
        }

        return true;
    }

    static class Point {
        int row, col;

        Point(int r, int c)
        {
            row = r;
            col = c;
        }
    }
}
