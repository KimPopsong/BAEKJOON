import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int subin, sister;  // 수빈과 동생의 위치
        int[] time = new int[100002];  // 특정 위치로 가는데 걸리는 최소 시간
        Queue<Integer> bfs = new ArrayDeque<>();

        String[] temp = br.readLine().split(" ");
        subin = Integer.parseInt(temp[0]);
        sister = Integer.parseInt(temp[1]);

        bfs.add(subin);

        for (int i = 0; i < 100001; i++)
        {
            time[i] = Integer.MAX_VALUE;
        }
        time[subin] = 0;

        while (!bfs.isEmpty())
        {
            Queue<Integer> tempQueue = new ArrayDeque<>(bfs);
            bfs.clear();

            while (!tempQueue.isEmpty())  // 2 * X로 갈 수 있는 위치를 모두 넣어줌
            {
                int n = tempQueue.poll();
                bfs.add(n);

                if (n != 0)
                {
                    for (int i = 2; n * i <= 100000; i *= 2)  // 2 * X의 위치로 이동하는 순간이동은 시간이 같음
                    {
                        if (time[n * i] > time[n])
                        {
                            time[n * i] = time[n];
                            bfs.add(n * i);
                        }
                    }
                }
            }

            tempQueue.addAll(bfs);
            bfs.clear();

            while (!tempQueue.isEmpty())
            {
                int n = tempQueue.poll();

                if ((n + 1 <= 100000) && (time[n + 1] > time[n] + 1))
                {
                    time[n + 1] = time[n] + 1;
                    bfs.add(n + 1);
                }

                if ((n - 1 >= 0) && (time[n - 1] > time[n] + 1))
                {
                    time[n - 1] = time[n] + 1;
                    bfs.add(n - 1);
                }
            }
        }

        System.out.println(time[sister]);
    }
}
