import java.io.*;
import java.util.*;

public class Main {
    static int size, passengerNumber;  // 맵의 크기, 승객의 수
    static long fuel;  // 연료의 양
    static int[][] map;
    static Point taxi;  // 택시의 좌표
    static ArrayList<Passenger> passengers = new ArrayList<>();  // 승객들의 좌표

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력부 시작

        st = new StringTokenizer(br.readLine());

        size = Integer.parseInt(st.nextToken());
        passengerNumber = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());

        map = new int[size][size];
        for (int r = 0; r < size; r++)
        {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < size; c++)
            {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        taxi = new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);  // 택시의 좌표 입력

        for (int i = 0; i < passengerNumber; i++)  // 승객 입력
        {
            st = new StringTokenizer(br.readLine());

            int startR = Integer.parseInt(st.nextToken()) - 1;
            int startC = Integer.parseInt(st.nextToken()) - 1;
            int endR = Integer.parseInt(st.nextToken()) - 1;
            int endC = Integer.parseInt(st.nextToken()) - 1;

            passengers.add(new Passenger(new Point(startR, startC), new Point(endR, endC)));
            map[startR][startC] = 2;
        }

        // 입력부 종료

        // 구현부 시작

        boolean flag = true;
        while (flag && passengerNumber > 0)
        {
            int usedFuel = 0;
            Point p = new Point(size, size);

            usedFuel = searchPassenger(taxi.r, taxi.c, p);

            if (usedFuel > fuel)  // 연료가 부족하다면 중단
            {
                flag = false;

                break;
            }

            else if (p.r == size && p.c == size)  // 길을 못찾았다면
            {
                flag = false;

                break;
            }

            taxi.r = p.r;  // 택시 이동
            taxi.c = p.c;
            map[p.r][p.c] = 0;
            fuel -= usedFuel;  // 연료 감소

            for (Passenger passenger : passengers)
            {
                if (passenger.startPoint.r == p.r && passenger.startPoint.c == p.c)
                {
                    int secondUsedFuel = transfer(passenger);  // 승객 이동

                    if (secondUsedFuel == -1)
                    {
                        flag = false;

                        break;
                    }

                    else if (secondUsedFuel > fuel)  // 연료가 부족하다면
                    {
                        flag = false;

                        break;
                    }

                    fuel += secondUsedFuel;  // 연료 보충

                    taxi.r = passenger.endPoint.r;  // 택시 이동
                    taxi.c = passenger.endPoint.c;

                    passengers.remove(passenger);  // 손님 제거
                    passengerNumber -= 1;

                    break;
                }
            }
        }

        // 구현부 종료

        // 답 출력

        if (flag)
        {
            System.out.print(fuel);
        }

        else
        {
            System.out.print(-1);
        }
    }

    private static int transfer(Passenger passenger)
    {
        int useFuel = 0;

        boolean[][] isVisit = new boolean[size][size];
        ArrayDeque<Point> bfs = new ArrayDeque<>();

        isVisit[passenger.startPoint.r][passenger.startPoint.c] = true;
        bfs.add(new Point(passenger.startPoint.r, passenger.startPoint.c));

        while (!bfs.isEmpty())
        {
            useFuel += 1;

            ArrayDeque<Point> temp = new ArrayDeque<>(bfs);
            bfs.clear();

            int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};

            while (!temp.isEmpty())
            {
                Point p = temp.removeFirst();

                for (int d = 0; d < 4; d++)
                {
                    int rr = p.r + dr[d];
                    int cc = p.c + dc[d];

                    if (0 <= rr && rr < size && 0 <= cc && cc < size)
                    {
                        if (!isVisit[rr][cc])
                        {
                            isVisit[rr][cc] = true;

                            if (map[rr][cc] != 1)
                            {
                                bfs.addLast(new Point(rr, cc));

                                if (rr == passenger.endPoint.r && cc == passenger.endPoint.c)
                                {
                                    return useFuel;
                                }
                            }
                        }
                    }
                }
            }
        }

        return -1;
    }

    private static int searchPassenger(int r, int c, Point point)
    {
        if (map[r][c] == 2)  // 자기 위치에 손님이 있다면
        {
            point.r = r;
            point.c = c;

            return 0;
        }

        int useFuel = 0;
        boolean[][] isVisit = new boolean[size][size];
        ArrayDeque<Point> bfs = new ArrayDeque<>();
        ArrayList<Point> passengerList = new ArrayList<>();

        isVisit[r][c] = true;
        bfs.add(new Point(r, c));

        int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};

        boolean isFind = false;
        while (!bfs.isEmpty())
        {
            useFuel += 1;

            ArrayDeque<Point> temp = new ArrayDeque<>(bfs);
            bfs.clear();

            while (!temp.isEmpty())
            {
                Point p = temp.removeFirst();

                for (int d = 0; d < 4; d++)
                {
                    int rr = p.r + dr[d];
                    int cc = p.c + dc[d];

                    if (0 <= rr && rr < size && 0 <= cc && cc < size)
                    {
                        if (!isVisit[rr][cc])
                        {
                            isVisit[rr][cc] = true;

                            if (map[rr][cc] == 0)
                            {
                                bfs.addLast(new Point(rr, cc));
                            }

                            else if (map[rr][cc] == 2)  // 손님을 찾았다면
                            {
                                isFind = true;
                                bfs.addLast(new Point(rr, cc));

                                passengerList.add(new Point(rr, cc));
                            }
                        }
                    }
                }
            }

            if (isFind)
            {
                break;
            }
        }

        for (Point p : passengerList)  // 우선순위가 가장 큰 손님 찾기
        {
            if (p.r < point.r)
            {
                point.r = p.r;
                point.c = p.c;
            }

            else if (p.r == point.r)
            {
                if (p.c < point.c)
                {
                    point.c = p.c;
                }
            }
        }

        return useFuel;
    }

    static class Point {
        int r, c;

        Point(int r, int c)
        {
            this.r = r;
            this.c = c;
        }
    }

    static class Passenger implements Comparable<Passenger> {
        Point startPoint, endPoint;

        Passenger(Point startPoint, Point endPoint)
        {
            this.startPoint = startPoint;
            this.endPoint = endPoint;
        }

        @Override
        public int compareTo(Passenger p)
        {
            if (this.startPoint.r == p.startPoint.r)
            {
                return Integer.compare(this.startPoint.c, p.startPoint.c);
            }

            return Integer.compare(this.startPoint.r, p.startPoint.r);
        }
    }
}
