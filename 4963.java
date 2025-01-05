import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true)  // 0, 0이 입력으로 들어올때까지 반복
        {
            int rowSize, colSize;  // 행의 길이, 열의 길이
            int landNumber = 0;  // 섬의 개수
            int[][] land;

            String[] temp = br.readLine().split(" ");

            rowSize = Integer.parseInt(temp[1]);
            colSize = Integer.parseInt(temp[0]);

            if (rowSize == 0 && colSize == 0)  // 0, 0일시 탈출
            {
                break;
            }

            land = new int[rowSize][colSize];

            for (int i = 0; i < rowSize; i++)  // land 입력
            {
                temp = br.readLine().split(" ");

                for (int j = 0; j < colSize; j++)
                {
                    land[i][j] = Integer.parseInt(temp[j]);
                }
            }

            ArrayDeque<Point> bfs = new ArrayDeque<>();
            boolean[][] isVisit = new boolean[rowSize][colSize];

            int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};  // 12시 방향부터 시계방향
            int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

            for (int r = 0; r < rowSize; r++)  // 탐색
            {
                for (int c = 0; c < colSize; c++)
                {
                    if (land[r][c] == 1)  // 육지이면서
                    {
                        if (!isVisit[r][c])  // 방문하지 않았다면
                        {
                            bfs.add(new Point(r, c));
                            landNumber += 1;

                            while (!bfs.isEmpty())
                            {
                                Point p = bfs.removeFirst();

                                for (int i = 0; i < 8; i++)
                                {
                                    int rr = p.r + dr[i];
                                    int cc = p.c + dc[i];

                                    if (0 <= rr && rr < rowSize && 0 <= cc && cc < colSize)  // 범위 안
                                    {
                                        if (land[rr][cc] == 1)
                                        {
                                            if (!isVisit[rr][cc])
                                            {
                                                bfs.add(new Point(rr, cc));
                                                isVisit[rr][cc] = true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            sb.append(landNumber).append("\n");
        }

        System.out.println(sb);
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
