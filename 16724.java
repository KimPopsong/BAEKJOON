import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int safezone = 0;
    static int rowSize, colSize;
    static boolean[][] isVisit;
    static char[][] map;
    static int[][] numberedMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());

        isVisit = new boolean[rowSize][colSize];  // 중복 방문 여부 체크
        map = new char[rowSize][colSize];
        numberedMap = new int[rowSize][colSize];

        for (int r = 0; r < rowSize; r++) {
            char[] temp = br.readLine().toCharArray();

            for (int c = 0; c < colSize; c++) {
                map[r][c] = temp[c];
            }
        }

        for (int r = 0; r < rowSize; r++) {
            for (int c = 0; c < colSize; c++) {
                if (numberedMap[r][c] == 0)  // 넘버링이 안되었다면
                {
                    int number = 0;
                    ArrayDeque<Point> points = new ArrayDeque<>();  // 방문한 장소 리스트


                    int rr = r, cc = c;

                    while (true) {
                        if (isVisit[rr][cc]) {
                            if (numberedMap[rr][cc] != 0) {
                                number = numberedMap[rr][cc];
                            } else {
                                number = ++safezone;
                            }

                            break;
                        }

                        points.add(new Point(rr, cc));
                        isVisit[rr][cc] = true;

                        if (map[rr][cc] == 'U') {
                            rr = Math.max(0, rr - 1);
                        } else if (map[rr][cc] == 'D') {
                            rr = Math.min(rowSize - 1, rr + 1);
                        } else if (map[rr][cc] == 'L') {
                            cc = Math.max(0, cc - 1);
                        } else {
                            cc = Math.min(colSize - 1, cc + 1);
                        }
                    }

                    while (!points.isEmpty()) {
                        Point p = points.remove();

                        numberedMap[p.r][p.c] = number;
                    }
                }
            }
        }

        System.out.print(safezone);
    }

    static class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
