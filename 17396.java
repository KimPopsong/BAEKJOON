import java.util.*;
import java.io.*;

public class Main {
    static int pointNumber, roadNumber;
    static int[] isVisible;
    static Map<Integer, Set<Point>> roads = new HashMap<>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        // 입력부 시작

        st = new StringTokenizer(br.readLine());
        pointNumber = Integer.parseInt(st.nextToken());
        roadNumber = Integer.parseInt(st.nextToken());

        isVisible = new int[pointNumber];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < pointNumber; i++)
        {
            isVisible[i] = Integer.parseInt(st.nextToken());  // 시야 여부 입력
            roads.put(i, new HashSet<>());
        }

        for (int i = 0; i < roadNumber; i++)
        {
            st = new StringTokenizer(br.readLine());

            int startPoint = Integer.parseInt(st.nextToken());
            int endPoint = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            roads.get(startPoint).add(new Point(endPoint, time));
            roads.get(endPoint).add(new Point(startPoint, time));
        }

        long answer = -1;
        boolean[] isVisit = new boolean[pointNumber];
        PriorityQueue<Point> pq = new PriorityQueue<>();

        pq.addAll(roads.get(0));
        isVisit[0] = true;

        while (!pq.isEmpty())
        {
            Point p = pq.remove();

            if (p.endPoint == pointNumber - 1)  // 종료
            {
                answer = p.time;

                break;
            }

            if (isVisible[p.endPoint] == 0)  // 갈 수 있고
            {
                if (isVisit[p.endPoint] == false)  // 가지 않은 길이라면
                {
                    isVisit[p.endPoint] = true;  // 방문 처리

                    for (Point nextPoint : roads.get(p.endPoint))
                    {
                        if (isVisit[nextPoint.endPoint] == false)
                        {
                            nextPoint.time += p.time;

                            pq.add(nextPoint);
                        }
                    }
                }
            }
        }

        System.out.print(answer);
    }

    static class Point implements Comparable<Point> {
        int endPoint;
        long time;

        Point(int endPoint, int time)
        {
            this.endPoint = endPoint;
            this.time = time;
        }

        @Override
        public int compareTo(Point p)
        {
            return Long.compare(this.time, p.time);
        }
    }
}
