import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int rowSize, colSize;
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    static int[][] map, idMap;
    static ArrayList<Integer> blanks = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());

        map = new int[rowSize][colSize];
        idMap = new int[rowSize][colSize];

        for (int r = 0; r < rowSize; r++) {
            char[] temp = br.readLine().toCharArray();

            for (int c = 0; c < colSize; c++) {
                map[r][c] = temp[c] - '0';
            }
        }

        blanks.add(0);
        for (int r = 0; r < rowSize; r++)  // 빈 칸을 찾아, 연결된 빈 칸이 몇 개인지 확인
        {
            for (int c = 0; c < colSize; c++) {
                if (idMap[r][c] == 0)  // id가 할당되지 않고
                {
                    if (map[r][c] == 0)  // 빈 칸이라면
                    {
                        int id = blanks.size();
                        int count = 1;

                        ArrayDeque<Point> bfs = new ArrayDeque<>();

                        bfs.add(new Point(r, c));
                        idMap[r][c] = id;

                        while (!bfs.isEmpty()) {
                            Point p = bfs.removeFirst();

                            for (int d = 0; d < 4; d++) {
                                int rr = p.r + dr[d];
                                int cc = p.c + dc[d];

                                if (0 <= rr && rr < rowSize && 0 <= cc && cc < colSize) {
                                    if (idMap[rr][cc] == 0) {
                                        if (map[rr][cc] == 0) {
                                            count += 1;

                                            idMap[rr][cc] = id;
                                            bfs.add(new Point(rr, cc));
                                        }
                                    }
                                }
                            }
                        }
                        blanks.add(count);
                    }
                }
            }
        }

        for (int r = 0; r < rowSize; r++) {
            for (int c = 0; c < colSize; c++) {
                if (map[r][c] == 1) {
                    Set<Integer> ids = new HashSet<>();

                    for (int d = 0; d < 4; d++) {
                        int rr = r + dr[d];
                        int cc = c + dc[d];

                        if (0 <= rr && rr < rowSize && 0 <= cc && cc < colSize) {
                            ids.add(idMap[rr][cc]);
                        }
                    }

                    for (int i : ids) {
                        map[r][c] += blanks.get(i);
                    }

                    map[r][c] %= 10;
                }

                answer.append(map[r][c]);
            }
            answer.append("\n");
        }

        System.out.print(answer);
    }

    static class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
