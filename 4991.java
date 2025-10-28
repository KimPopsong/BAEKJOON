import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int rowSize, colSize, minMove;
    static char[][] map;
    static int[][] distances;  // 먼지 사이의 거리 저장
    static Point robot;
    static ArrayList<Point> dusts;  // 먼지 저장

    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());

            colSize = Integer.parseInt(st.nextToken());
            rowSize = Integer.parseInt(st.nextToken());
            minMove = Integer.MAX_VALUE;

            if (rowSize == 0 || colSize == 0) {
                break;
            }

            map = new char[rowSize][colSize];
            dusts = new ArrayList<>();

            for (int r = 0; r < rowSize; r++) {
                char[] temp = br.readLine().toCharArray();

                for (int c = 0; c < colSize; c++) {
                    map[r][c] = temp[c];

                    if (map[r][c] == 'o') {
                        robot = new Point(r, c);

                        map[r][c] = '.';
                    } else if (map[r][c] == '*') {
                        dusts.add(new Point(r, c));

                        map[r][c] = '.';
                    }
                }
            }

            distances = new int[dusts.size()][dusts.size()];

            if (!calcDistances()) {  // 먼지끼리 방문하지 못하는 장소가 있으면 가지치기
                answer.append(-1).append("\n");

                continue;
            }

            if (!startRobot()) {
                answer.append(-1).append("\n");

                continue;
            }

            answer.append(minMove).append("\n");
        }

        System.out.print(answer);
    }

    static boolean startRobot() {
        for (int destinationDust = 0; destinationDust < dusts.size(); destinationDust++) {  // 로봇의 위치부터 먼지의 위치 계산
            boolean flag = false;
            int turn = 0;
            Point endNode = dusts.get(destinationDust);

            boolean[][] isVisit = new boolean[rowSize][colSize];
            ArrayDeque<Point> bfs = new ArrayDeque<>();

            isVisit[robot.r][robot.c] = true;
            bfs.add(robot);

            while (!bfs.isEmpty()) {
                turn += 1;

                ArrayDeque<Point> tempBfs = new ArrayDeque<>(bfs);
                bfs.clear();

                while (!tempBfs.isEmpty()) {
                    Point p = tempBfs.remove();

                    for (int d = 0; d < 4; d++) {
                        int rr = p.r + dr[d];
                        int cc = p.c + dc[d];

                        if (0 <= rr && rr < rowSize && 0 <= cc && cc < colSize) {
                            if (!isVisit[rr][cc]) {
                                if (map[rr][cc] == '.') {
                                    isVisit[rr][cc] = true;
                                    bfs.add(new Point(rr, cc));

                                    if (rr == endNode.r && cc == endNode.c) {
                                        flag = true;

                                        tempBfs.clear();
                                        bfs.clear();

                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if (flag) {
                boolean[] isVisitDust = new boolean[dusts.size()];
                isVisitDust[destinationDust] = true;

                calcMinMove(0, destinationDust, turn, isVisitDust);
            } else {  // 방문하지 못하는 곳은 false로 가지치기
                return false;
            }
        }

        return true;
    }

    static void calcMinMove(int depth, int index, int move, boolean[] isVisit) {
        if (depth == dusts.size() - 1) {
            minMove = Math.min(minMove, move);

            return;
        }

        for (int dust = 0; dust < dusts.size(); dust++) {
            if (isVisit[dust]) {
                continue;
            }

            isVisit[dust] = true;
            calcMinMove(depth + 1, dust, move + distances[index][dust], isVisit);
            isVisit[dust] = false;
        }
    }

    static boolean calcDistances() {
        for (int start = 0; start < dusts.size(); start++) {
            Point startNode = dusts.get(start);

            for (int end = start + 1; end < dusts.size(); end++) {
                boolean flag = false;
                int turn = 0;
                Point endNode = dusts.get(end);

                boolean[][] isVisit = new boolean[rowSize][colSize];
                ArrayDeque<Point> bfs = new ArrayDeque<>();

                isVisit[startNode.r][startNode.c] = true;
                bfs.add(startNode);

                while (!bfs.isEmpty()) {
                    turn += 1;

                    ArrayDeque<Point> tempBfs = new ArrayDeque<>(bfs);
                    bfs.clear();

                    while (!tempBfs.isEmpty()) {
                        Point p = tempBfs.remove();

                        for (int d = 0; d < 4; d++) {
                            int rr = p.r + dr[d];
                            int cc = p.c + dc[d];

                            if (0 <= rr && rr < rowSize && 0 <= cc && cc < colSize) {
                                if (!isVisit[rr][cc]) {
                                    if (map[rr][cc] == '.') {
                                        isVisit[rr][cc] = true;
                                        bfs.add(new Point(rr, cc));

                                        if (rr == endNode.r && cc == endNode.c) {
                                            flag = true;

                                            tempBfs.clear();
                                            bfs.clear();

                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                if (flag) {
                    distances[start][end] = turn;
                    distances[end][start] = turn;
                } else {  // 방문하지 못하는 곳은 false로 가지치기
                    return false;
                }
            }
        }

        return true;
    }

    static class Edge implements Comparable<Edge> {
        int start, end, distance;

        Edge(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge e) {
            return Integer.compare(this.distance, e.distance);
        }
    }

    static class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
