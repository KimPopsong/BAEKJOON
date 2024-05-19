import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int nationNumber, wantKnow;
        int rank = 1;
        List<Nation> nations = new ArrayList<>();

        String[] temp = br.readLine().split(" ");
        nationNumber = Integer.parseInt(temp[0]);
        wantKnow = Integer.parseInt(temp[1]);

        for (int i = 0; i < nationNumber; i++)
        {
            temp = br.readLine().split(" ");

            nations.add(new Nation(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), Integer.parseInt(temp[3])));  // 국가 입력
        }

        nations.sort(new Comparator<Nation>() {
            @Override
            public int compare(Nation n1, Nation n2)
            {
                if (n1.number > n2.number)
                {
                    return 1;

                }

                else
                {
                    return -1;
                }
            }
        });

        for (int i = 0; i < nationNumber; i++)
        {
            if (nations.get(i).number == wantKnow)
            {
                continue;
            }

            else
            {
                if (nations.get(i).gold > nations.get(wantKnow - 1).gold)  // 상대방의 금메달이 더 많다면
                {
                    rank += 1;
                }

                else if (nations.get(i).gold == nations.get(wantKnow - 1).gold)
                {
                    if (nations.get(i).silver > nations.get(wantKnow - 1).silver)
                    {
                        rank += 1;
                    }

                    else if (nations.get(i).silver == nations.get(wantKnow - 1).silver)
                    {
                        if (nations.get(i).bronze > nations.get(wantKnow - 1).bronze)
                        {
                            rank += 1;
                        }
                    }
                }
            }
        }

        System.out.println(rank);
    }

    static class Nation {
        int number;
        int gold, silver, bronze;

        Nation(int number, int gold, int silver, int bronze)
        {
            this.number = number;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }
}

/*
points.sort(new Comparator<Point>() {
            @Override
            public int compare(Point point, Point t1)
            {
                return 0;
            }
        });
 */
