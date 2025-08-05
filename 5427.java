import java.util.*;
import java.io.*;

public class Main {
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++)
        {
            int rowSize, colSize;
            int[][] map;

            st = new StringTokenizer(br.readLine());
            colSize = Integer.parseInt(st.nextToken());
            rowSize = Integer.parseInt(st.nextToken());

            map = new int[rowSize][colSize];

            ArrayDeque<Point> fires = new ArrayDeque<>();
            ArrayDeque<Point> me = new ArrayDeque<>();

            for (int r = 0; r < rowSize; r++)
            {
                String temp = br.readLine();

                for (int c = 0; c < colSize; c++)
                {
                    if (temp.charAt(c) == '#')  // 벽
                    {
                        map[r][c] = 1;
                    }

                    else if (temp.charAt(c) == '*')  // 불
                    {
                        map[r][c] = 2;
                        fires.add(new Point(r, c));
                    }

                    else if (temp.charAt(c) == '@')  // 상근
                    {
                        me.add(new Point(r, c));
                    }
                }
            }

            boolean flag = false;
            int time = 0;
            boolean[][] isVisit = new boolean[rowSize][colSize];

            while (!fires.isEmpty() || !me.isEmpty())
            {
                time += 1;

                // 불 먼저 이동
                ArrayDeque<Point> tempFire = new ArrayDeque<>(fires);
                fires.clear();

                while (!tempFire.isEmpty())
                {
                    Point fire = tempFire.remove();

                    for (int d = 0; d < 4; d++)
                    {
                        int rr = fire.r + dr[d];
                        int cc = fire.c + dc[d];

                        if (0 <= rr && rr < rowSize && 0 <= cc && cc < colSize)
                        {
                            if (map[rr][cc] == 0)
                            {
                                map[rr][cc] = 2;
                                fires.add(new Point(rr, cc));
                            }
                        }
                    }
                }

                ArrayDeque<Point> tempMe = new ArrayDeque<>(me);
                me.clear();

                while (!tempMe.isEmpty())
                {
                    Point m = tempMe.remove();

                    for (int d = 0; d < 4; d++)
                    {
                        int rr = m.r + dr[d];
                        int cc = m.c + dc[d];

                        if (0 <= rr && rr < rowSize && 0 <= cc && cc < colSize)
                        {
                            if (isVisit[rr][cc] == false)
                            {
                                if (map[rr][cc] == 0)
                                {
                                    isVisit[rr][cc] = true;
                                    me.add(new Point(rr, cc));
                                }
                            }
                        }

                        else  // 탈출
                        {
                            flag = true;
                            fires.clear();
                            tempMe.clear();
                            me.clear();

                            break;
                        }
                    }
                }
            }

            if (flag)
            {
                sb.append(time).append("\n");
            }

            else
            {
                sb.append("IMPOSSIBLE").append("\n");
            }
        }

        System.out.print(sb);
    }

    static class Point {
        int r, c;

        Point(int r, int c)
        {
            this.r = r;
            this.c = c;
        }
    }
}
