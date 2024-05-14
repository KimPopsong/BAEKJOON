import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    static int width, height, squareNumber;
    static int areaNumber = 0;
    static Queue<Integer> area = new PriorityQueue<>();

    static int[][] graphPaper;
    static boolean[][] isVisit;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] temp = br.readLine().split(" ");
        height = Integer.parseInt(temp[0]);
        width = Integer.parseInt(temp[1]);
        squareNumber = Integer.parseInt(temp[2]);

        graphPaper = new int[height][width];
        isVisit = new boolean[height][width];

        for (int i = 0; i < squareNumber; i++)
        {
            temp = br.readLine().split(" ");

            for (int j = height - Integer.parseInt(temp[3]); j < height - Integer.parseInt(temp[1]); j++)
            {
                for (int k = Integer.parseInt(temp[0]); k < Integer.parseInt(temp[2]); k++)
                {
                    graphPaper[j][k] = 1;
                }
            }
        }

        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                if (graphPaper[i][j] == 0)
                {
                    if (!isVisit[i][j])
                    {
                        areaNumber += 1;
                        isVisit[i][j] = true;
                        area.add(DFS(i, j));
                    }
                }
            }
        }

        System.out.println(areaNumber);
        for(int i = 0; i < areaNumber; i++)
        {
            System.out.print(area.poll() + " ");
        }
    }

    public static int DFS(int i, int j)
    {
        int area = 0;
        Queue<Point> dfs = new LinkedList<>();

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        dfs.add(new Point(i, j));
        while (!dfs.isEmpty())
        {
            int x = dfs.peek().x;
            int y = dfs.poll().y;

            area += 1;

            for (int ii = 0; ii < 4; ii++)
            {
                int xx = x + dx[ii];
                int yy = y + dy[ii];

                if (0 <= xx && xx < height && 0 <= yy && yy < width)
                {
                    if (graphPaper[xx][yy] == 0 && !isVisit[xx][yy])
                    {
                        isVisit[xx][yy] = true;
                        dfs.add(new Point(xx, yy));
                    }
                }
            }
        }

        return area;
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
}
