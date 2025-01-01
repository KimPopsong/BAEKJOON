import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int cityNumber, roadNumber, distance, startCity;  // 도시의 개수, 도로의 개수, 거리, 출발 도시의 번호
        HashMap<Integer, ArrayDeque<Integer>> roads = new HashMap<>();

        String[] temp = br.readLine().split(" ");

        cityNumber = Integer.parseInt(temp[0]);
        roadNumber = Integer.parseInt(temp[1]);
        distance = Integer.parseInt(temp[2]);
        startCity = Integer.parseInt(temp[3]);

        for (int i = 1; i <= cityNumber; i++)
        {
            roads.put(i, new ArrayDeque<>());
        }

        for (int i = 0; i < roadNumber; i++)
        {
            temp = br.readLine().split(" ");

            int start = Integer.parseInt(temp[0]);
            int end = Integer.parseInt(temp[1]);

            roads.get(start).add(end);
        }

        ArrayDeque<Integer> search = new ArrayDeque<>();
        int[] isVisit = new int[cityNumber + 1];

        for (int i = 0; i <= cityNumber; i++)
        {
            isVisit[i] = -1;
        }

        search.add(startCity);  // 초기화
        isVisit[startCity] = 0;
        int time = 0;

        while (!search.isEmpty())
        {
            time += 1;

            ArrayDeque<Integer> tempQueue = new ArrayDeque<>(search);
            search.clear();

            while (!tempQueue.isEmpty())
            {
                int city = tempQueue.removeFirst();

                for (Integer destination : roads.get(city))
                {
                    if (isVisit[destination] == -1)  // 방문하지 않았다면
                    {
                        isVisit[destination] = time;  // 거리 표시
                        search.add(destination);
                    }
                }
            }
        }

        boolean flag = false;

        for (int i = 1; i <= cityNumber; i++)
        {
            if (isVisit[i] == distance)
            {
                sb.append(i).append("\n");

                flag = true;
            }
        }

        if (!flag)
        {
            sb.append(-1).append("\n");
        }

        System.out.println(sb);
    }
}
