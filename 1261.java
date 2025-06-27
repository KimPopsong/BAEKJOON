import java.util.*;
import java.io.*;

public class Main {
    static int rowSize, colSize;
    static int[][] maze;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력부 시작

        st = new StringTokenizer(br.readLine());

        colSize = Integer.parseInt(st.nextToken());
        rowSize = Integer.parseInt(st.nextToken());

        maze = new int[rowSize][colSize];

        for (int r = 0; r < rowSize; r++)
        {
            String temp = br.readLine();

            for (int c = 0; c < colSize; c++)
            {
                maze[r][c] = temp.charAt(c) - '0';
            }
        }

        // 입력부 종료

        PriorityQueue<Point> dijkstra = new PriorityQueue<>();
        int[][] isVisit = new int[rowSize][colSize];

        for (int r = 0; r < rowSize; r++)
        {
            for (int c = 0; c < colSize; c++)
            {
                isVisit[r][c] = Integer.MAX_VALUE;  // 방문여부 처리를 위해 초기화
            }
        }

        dijkstra.add(new Point(0, 0, 0));
        isVisit[0][0] = 0;

        int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};

        while (!dijkstra.isEmpty())
        {
            Point p = dijkstra.remove();

            for (int d = 0; d < 4; d++)
            {
                int rr = p.r + dr[d];
                int cc = p.c + dc[d];

                if (0 <= rr && rr < rowSize && 0 <= cc && cc < colSize)
                {
                    if (maze[rr][cc] == 0)  // 빈 공간일 경우
                    {
                        if (isVisit[rr][cc] > p.distance)
                        {
                            isVisit[rr][cc] = p.distance;

                            dijkstra.add(new Point(rr, cc, p.distance));
                        }
                    }

                    else  // 벽일 경우
                    {
                        if (isVisit[rr][cc] > p.distance + 1)
                        {
                            isVisit[rr][cc] = p.distance + 1;

                            dijkstra.add(new Point(rr, cc, p.distance + 1));
                        }
                    }
                }
            }
        }

        System.out.println(isVisit[rowSize - 1][colSize - 1]);
    }

    static class Point implements Comparable<Point> {
        int r, c, distance;

        Point(int r, int c, int distance)
        {
            this.r = r;
            this.c = c;
            this.distance = distance;
        }

        @Override
        public int compareTo(Point p)
        {
            return Integer.compare(this.distance, p.distance);
        }
    }
}
