import java.io.*;
import java.util.*;

public class Main {
    static boolean flag = false;
    static int peopleNumber, edgeNumber;
    static Map<Integer, Set<Integer>> map = new HashMap<>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력부 시작

        st = new StringTokenizer(br.readLine());
        peopleNumber = Integer.parseInt(st.nextToken());
        edgeNumber = Integer.parseInt(st.nextToken());

        for (int i = 0; i < peopleNumber; i++)
        {
            map.put(i, new HashSet<>());
        }

        for (int i = 0; i < edgeNumber; i++)
        {
            st = new StringTokenizer(br.readLine());

            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            map.get(p1).add(p2);
            map.get(p2).add(p1);
        }

        // 입력부 종료

        for (int i = 0; i < peopleNumber; i++)
        {
            if (flag)
            {
                break;
            }

            boolean[] isVisit = new boolean[peopleNumber];
            isVisit[i] = true;

            dfs(0, isVisit, i);
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

    static void dfs(int depth, boolean[] isVisit, int node)
    {
        if (depth >= 4 || flag)
        {
            flag = true;

            return;
        }

        for (int i : map.get(node))
        {
            if (!isVisit[i])
            {
                isVisit[i] = true;
                dfs(depth + 1, isVisit, i);
                isVisit[i] = false;
            }
        }
    }
}
