import java.util.*;
import java.io.*;

public class Main {
    static int rowSize, colSize, minMove = Integer.MAX_VALUE;
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    static char[][] map;
    static Marvel redMarvel, blueMarvel;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력부 시작

        st = new StringTokenizer(br.readLine());

        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());

        map = new char[rowSize][colSize];

        for (int r = 0; r < rowSize; r++)
        {
            String temp = br.readLine();

            for (int c = 0; c < colSize; c++)
            {
                if (temp.charAt(c) == 'R')
                {
                    redMarvel = new Marvel(r, c);
                    map[r][c] = '.';
                }

                else if (temp.charAt(c) == 'B')
                {
                    blueMarvel = new Marvel(r, c);
                    map[r][c] = '.';
                }

                else
                {
                    map[r][c] = temp.charAt(c);
                }
            }
        }

        // 입력부 종료

        dfs(1, redMarvel, blueMarvel);

        if (minMove == Integer.MAX_VALUE)
        {
            System.out.print(-1);
        }

        else
        {
            System.out.print(minMove);
        }
    }

    static void dfs(int depth, Marvel red, Marvel blue)
    {
        if (depth > 10 || depth >= minMove)
        {
            return;
        }

        for (int d = 0; d < 4; d++)  // 상하좌우
        {
            Marvel newRedMarvel = new Marvel(red.r, red.c);
            Marvel newBlueMarvel = new Marvel(blue.r, blue.c);

            int result = checkMarvel(newRedMarvel, newBlueMarvel, d);

            if (result == -1)
            {
                continue;
            }

            else if (result == 1)
            {
                minMove = Math.min(minMove, depth);

                return;
            }

            dfs(depth + 1, newRedMarvel, newBlueMarvel);
        }
    }

    static int checkMarvel(Marvel newRedMarvel, Marvel newBlueMarvel, int delta)
    {
        boolean redFlag = false, blueFlag = false;

        if (delta == 0)  // 상
        {
            if (newRedMarvel.r < newBlueMarvel.r)  // 빨간 구슬 먼저
            {
                redFlag = moveMarvel(newRedMarvel, newBlueMarvel, delta);
                blueFlag = moveMarvel(newBlueMarvel, newRedMarvel, delta);
            }

            else  // 파랑 구슬 먼저
            {
                blueFlag = moveMarvel(newBlueMarvel, newRedMarvel, delta);
                redFlag = moveMarvel(newRedMarvel, newBlueMarvel, delta);
            }
        }

        else if (delta == 1)  // 하
        {
            if (newRedMarvel.r >= newBlueMarvel.r)  // 빨간 구슬 먼저
            {
                redFlag = moveMarvel(newRedMarvel, newBlueMarvel, delta);
                blueFlag = moveMarvel(newBlueMarvel, newRedMarvel, delta);
            }

            else  // 파랑 구슬 먼저
            {
                blueFlag = moveMarvel(newBlueMarvel, newRedMarvel, delta);
                redFlag = moveMarvel(newRedMarvel, newBlueMarvel, delta);
            }
        }

        else if (delta == 2)  // 좌
        {
            if (newRedMarvel.c < newBlueMarvel.c)  // 빨간 구슬 먼저
            {
                redFlag = moveMarvel(newRedMarvel, newBlueMarvel, delta);
                blueFlag = moveMarvel(newBlueMarvel, newRedMarvel, delta);
            }

            else  // 파랑 구슬 먼저
            {
                blueFlag = moveMarvel(newBlueMarvel, newRedMarvel, delta);
                redFlag = moveMarvel(newRedMarvel, newBlueMarvel, delta);
            }
        }

        else  // 우
        {
            if (newRedMarvel.c >= newBlueMarvel.c)  // 빨간 구슬 먼저
            {
                redFlag = moveMarvel(newRedMarvel, newBlueMarvel, delta);
                blueFlag = moveMarvel(newBlueMarvel, newRedMarvel, delta);
            }

            else  // 파랑 구슬 먼저
            {
                blueFlag = moveMarvel(newBlueMarvel, newRedMarvel, delta);
                redFlag = moveMarvel(newRedMarvel, newBlueMarvel, delta);
            }
        }

        if (blueFlag)
        {
            return -1;
        }

        else if (redFlag)
        {
            return 1;
        }

        else
        {
            return 0;
        }
    }

    static boolean moveMarvel(Marvel firstMarvel, Marvel secondMarvel, int delta)
    {
        int rr = firstMarvel.r;
        int cc = firstMarvel.c;

        while (true)
        {
            rr = rr + dr[delta];
            cc = cc + dc[delta];

            if (map[rr][cc] == '#' || (rr == secondMarvel.r && cc == secondMarvel.c))
            {
                rr = rr - dr[delta];
                cc = cc - dc[delta];

                break;
            }

            else if (map[rr][cc] == 'O')
            {
                firstMarvel.r = -1;
                firstMarvel.c = -1;

                return true;
            }
        }

        firstMarvel.r = rr;
        firstMarvel.c = cc;

        return false;
    }

    static class Marvel {
        int r, c;

        Marvel(int r, int c)
        {
            this.r = r;
            this.c = c;
        }
    }
}
