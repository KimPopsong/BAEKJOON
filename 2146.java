import java.util.*;
import java.io.*;

public class Main {
    static int size, minDistance = Integer.MAX_VALUE;
    static int[][] map;  // 0 : 바다, 1 : 육지지

    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력부 시작

        size = Integer.parseInt(br.readLine());
        map = new int[size][size];

        for (int r = 0; r < size; r++)
        {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < size; c++)
            {
                int l = Integer.parseInt(st.nextToken());

                if (l == 1)
                {
                    map[r][c] = -1;
                }

                else
                {
                    map[r][c] = 0;
                }
            }
        }

        // 입력부 종료

        numberIsland();  // 섬에 번호 부여

        findEdge();  // 섬의 가장자리 탐색

        System.out.print(minDistance);
    }

    static void numberIsland()
    {
        int islandNumber = 1;

        for (int r = 0; r < size; r++)
        {
            for (int c = 0; c < size; c++)
            {
                if (map[r][c] == -1)
                {
                    ArrayDeque<Point> bfs = new ArrayDeque<>();

                    bfs.add(new Point(r, c));
                    map[r][c] = islandNumber;

                    while (!bfs.isEmpty())
                    {
                        Point p = bfs.remove();

                        for (int d = 0; d < 4; d++)
                        {
                            int rr = p.r + dr[d];
                            int cc = p.c + dc[d];

                            if (0 <= rr && rr < size && 0 <= cc && cc < size)
                            {
                                if (map[rr][cc] == -1)
                                {
                                    bfs.add(new Point(rr, cc));

                                    map[rr][cc] = islandNumber;
                                }
                            }
                        }
                    }

                    islandNumber += 1;
                }
            }
        }
    }

    // 섬의 가장자리 찾기
    static void findEdge()
    {
        for (int r = 0; r < size; r++)
        {
            for (int c = 0; c < size; c++)
            {
                if (map[r][c] != 0)  // 육지이고
                {
                    for (int d = 0; d < 4; d++)
                    {
                        int rr = r + dr[d];
                        int cc = c + dc[d];

                        if (0 <= rr && rr < size && 0 <= cc && cc < size)
                        {
                            if (map[rr][cc] == 0)  // 바다와 붙어있다면
                            {
                                search(rr, cc, map[r][c]);
                            }
                        }
                    }
                }
            }
        }
    }

    static void search(int r, int c, int islandNumber)
    {
        int distance = 0;

        boolean[][] isVisit = new boolean[size][size];
        ArrayDeque<Point> bfs = new ArrayDeque<>();

        isVisit[r][c] = true;
        bfs.add(new Point(r, c));

        while (!bfs.isEmpty() || distance < minDistance)
        {
            distance += 1;

            ArrayDeque<Point> temp = new ArrayDeque<>(bfs);
            bfs.clear();

            while (!temp.isEmpty())
            {
                Point p = temp.remove();

                for (int d = 0; d < 4; d++)
                {
                    int rr = p.r + dr[d];
                    int cc = p.c + dc[d];

                    if (0 <= rr && rr < size && 0 <= cc && cc < size)
                    {
                        if (isVisit[rr][cc] == false)
                        {
                            if (map[rr][cc] == 0)  // 바다라면
                            {
                                isVisit[rr][cc] = true;
                                bfs.add(new Point(rr, cc));  // 탐색 목록에 추가
                            }

                            else if (map[rr][cc] != islandNumber)  // 다른 섬이라면
                            {
                                minDistance = Math.min(minDistance, distance);

                                bfs.clear();
                                temp.clear();

                                break;
                            }
                        }
                    }
                }
            }
        }
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
