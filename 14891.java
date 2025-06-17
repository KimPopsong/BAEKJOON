import java.io.*;
import java.util.*;

class Main {
    static int moveNumber;
    static ArrayList<ArrayList<Integer>> cog;

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        cog = new ArrayList<>();

        for (int i = 0; i < 4; i++)
        {
            String temp = br.readLine();

            cog.add(new ArrayList<>());

            for (int j = 0; j < 8; j++)
            {
                cog.get(i).add(temp.charAt(j) - '0');
            }
        }

        moveNumber = Integer.parseInt(br.readLine());

        for (int m = 0; m < moveNumber; m++)
        {
            st = new StringTokenizer(br.readLine());

            int moveCog = Integer.parseInt(st.nextToken()) - 1; // 움직일 톱니바퀴
            int direction = Integer.parseInt(st.nextToken()); // 방향. 1 : 시계, -1 : 반시계

            if (direction == 1)
            { // 시계 방향으로 회전
                cog.get(moveCog).add(0, cog.get(moveCog).remove(7));
            }

            else
            { // 반시계 방향으로 회전
                cog.get(moveCog).add(cog.get(moveCog).remove(0));
            }

            int tempDirection = direction;
            for (int right = moveCog + 1; right < 4; right++)
            { // 기준 톱니바퀴의 오른쪽부터 확인
                int magnet;

                if (tempDirection == 1)
                { // 이전의 톱니바퀴가 시계 방향으로 회전했다면
                    magnet = cog.get(right - 1).get(3);
                }

                else
                {
                    magnet = cog.get(right - 1).get(1);
                }

                if (magnet != cog.get(right).get(6))
                { // 붙어있는 극의 극성이 다르다면
                    if (tempDirection == 1)
                    { // 이전 톱니바퀴가 시계 방향으로 회전했다면
                        tempDirection = -1;

                        cog.get(right).add(cog.get(right).remove(0));
                    }

                    else
                    {
                        tempDirection = 1;
                        cog.get(right).add(0, cog.get(right).remove(7));
                    }
                }

                else
                { // 같다면 회전하지 않음
                    break;
                }
            }

            tempDirection = direction;
            for (int left = moveCog - 1; left >= 0; left--)
            { // 기준 톱니바퀴의 왼쪽 확인
                int magnet;

                if (tempDirection == 1)
                { // 이전의 톱니바퀴가 시계 방향으로 회전했다면
                    magnet = cog.get(left + 1).get(7);
                }

                else
                {
                    magnet = cog.get(left + 1).get(5);
                }

                if (magnet != cog.get(left).get(2))
                { // 붙어있는 극의 극성이 다르다면
                    if (tempDirection == 1)
                    { // 이전 톱니바퀴가 시계 방향으로 회전했다면
                        tempDirection = -1;

                        cog.get(left).add(cog.get(left).remove(0));
                    }

                    else
                    {
                        tempDirection = 1;

                        cog.get(left).add(0, cog.get(left).remove(7));
                    }
                }

                else
                {
                    break;
                }
            }
        }

        int score = 0;
        for (int i = 0; i < 4; i++)
        {
            if (cog.get(i).get(0) == 1)
            {
                score += Math.pow(2, i);
            }
        }

        System.out.print(score);
    }
}
