import java.io.*;
import java.util.*;

public class Main {
    static int peopleNumber, edgeNumber;
    static int[] teams;
    static ArrayList<Integer>[] edges;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력부 시작

        st = new StringTokenizer(br.readLine());

        peopleNumber = Integer.parseInt(st.nextToken());
        edgeNumber = Integer.parseInt(st.nextToken());

        teams = new int[peopleNumber + 1];
        edges = new ArrayList[peopleNumber + 1];

        for (int i = 1; i <= peopleNumber; i++)
        {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < edgeNumber; i++)
        {
            st = new StringTokenizer(br.readLine());

            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            edges[p1].add(p2);
            edges[p2].add(p1);
        }

        // 입력부 종료

        boolean flag = true;
        ArrayDeque<Integer> bfs = new ArrayDeque<>();

        for (int p = 1; p <= peopleNumber && flag; p++)
        {
            if (teams[p] != 0)
            {
                continue;
            }

            bfs.add(p);  // 1번 사람부터 시작
            teams[p] = 1;

            while (!bfs.isEmpty())
            {
                int people = bfs.remove();

                for (int i : edges[people])
                {
                    if (teams[i] == 0)
                    {
                        bfs.add(i);
                        teams[i] = -teams[people];
                    }

                    else if (teams[i] == teams[people])  // 이론이 틀렸다면
                    {
                        flag = false;

                        bfs.clear();

                        break;
                    }
                }
            }
        }

        if (flag)
        {
            System.out.println(1);
        }

        else
        {
            System.out.println(0);
        }
    }
}
