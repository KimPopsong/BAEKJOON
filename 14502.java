import java.io.*;
import java.util.*;

public class Main {
    static int row;
    static int col;
    static int maxSafeArea = 0;
    static int[][] map = new int[9][9];
    static int[][] tempMap = new int[9][9];
    static ArrayList<Point> viruses = new ArrayList<>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringBuilder sb = new StringBuilder();

        String[] temp = br.readLine().split(" ");
        row = Integer.parseInt(temp[0]);
        col = Integer.parseInt(temp[1]);

        for (int i = 0; i < row; i++)
        {
            temp = br.readLine().split(" ");

            for (int j = 0; j < col; j++)
            {
                map[i][j] = Integer.parseInt(temp[j]);

                if (map[i][j] == 2)
                {
                    viruses.add(new Point(i, j));
                }
            }
        }

        BruteForce();

        System.out.println(maxSafeArea);
    }

    static void BruteForce()
    {
        for (int i = 0; i < row * col; i++)
        {
            Initialize();

            if (map[i / col][i % col] == 0)
            {
                for (int j = i + 1; j < row * col; j++)
                {
                    if (map[j / col][j % col] == 0)
                    {
                        for (int k = j + 1; k < row * col; k++)
                        {
                            if (map[k / col][k % col] == 0)
                            {
                                tempMap[i / col][i % col] = 1;
                                tempMap[j / col][j % col] = 1;
                                tempMap[k / col][k % col] = 1;

                                CalcVirusSpread();
                            }
                        }
                    }
                }
            }
        }
    }

    static void Initialize()
    {
        for (int i = 0; i < row; i++)
        {
            if (col >= 0)
                System.arraycopy(map[i], 0, tempMap[i], 0, col);
        }
    }

    static void CalcVirusSpread()
    {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        for (int i = 0; i < viruses.size(); i++)
        {
            Queue<Point> bfs = new ArrayDeque<>();
            bfs.add(viruses.get(i));

            while (!bfs.isEmpty())
            {
                Point p = bfs.poll();

                tempMap[p.r][p.c] = 2;

                for (int j = 0; j < 4; j++)
                {
                    int x = p.r + dx[j];
                    int y = p.c + dy[j];

                    if (x < 0 || y < 0 || x >= row || y >= col)
                    {
                        continue;
                    }

                    else if (tempMap[x][y] == 0)
                    {
                        bfs.add(new Point(x, y));
                    }
                }
            }
        }

        CalcSafeArea();
    }

    static void CalcSafeArea()
    {
        int t = 0;

        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                if (tempMap[i][j] == 0)
                {
                    t += 1;
                }
            }
        }

        if (t > maxSafeArea)
        {
            maxSafeArea = t;
        }

        Initialize();
    }

    public static class Point {
        int r, c;

        public Point(int r, int c)
        {
            this.r = r;
            this.c = c;
        }
    }
}
