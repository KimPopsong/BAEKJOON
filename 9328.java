import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int rowSize, colSize;
    static char[][] map;
    static Set<Character> keys;

    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < testCase; tc++) {
            st = new StringTokenizer(br.readLine());

            rowSize = Integer.parseInt(st.nextToken());
            colSize = Integer.parseInt(st.nextToken());
            int gatherFile = 0;

            map = new char[rowSize][colSize];
            keys = new HashSet<>();  // 보유 키 현황
            Map<Character, ArrayDeque<Point>> doorBfs = new HashMap<>();

            for (int i = 65; i <= 90; i++)  // 문 초기화
            {
                doorBfs.put((char) i, new ArrayDeque<>());
            }

            for (int r = 0; r < rowSize; r++)  // map 입력
            {
                char[] temp = br.readLine().toCharArray();

                for (int c = 0; c < colSize; c++) {
                    map[r][c] = temp[c];
                }
            }

            String startKeys = br.readLine();

            if (!startKeys.equals("0"))  // 보유 키 있음
            {
                char[] tempKey = startKeys.toCharArray();

                for (char c : tempKey) {
                    openDoor(c);
                }
            }

            boolean[][] isVisit = new boolean[rowSize][colSize];
            ArrayDeque<Point> bfs = new ArrayDeque<>();

            for (int r = 0; r < rowSize; r++) {  // 테두리 검사사
                if (map[r][0] == '.') {
                    isVisit[r][0] = true;
                    bfs.add(new Point(r, 0));
                } else if (map[r][0] == '$') {
                    gatherFile += 1;
                    map[r][0] = '.';

                    isVisit[r][0] = true;
                    bfs.add(new Point(r, 0));
                } else if (97 <= map[r][0] && map[r][0] <= 122) {
                    openDoor(map[r][0]);

                    map[r][0] = '.';

                    isVisit[r][0] = true;
                    bfs.add(new Point(r, 0));
                } else if (65 <= map[r][0] && map[r][0] <= 90)  // 문이라면
                {
                    doorBfs.get(map[r][0]).add(new Point(r, 0));

                    isVisit[r][0] = true;
                }

                if (map[r][colSize - 1] == '.') {
                    isVisit[r][colSize - 1] = true;
                    bfs.add(new Point(r, colSize - 1));
                } else if (map[r][colSize - 1] == '$') {
                    gatherFile += 1;
                    map[r][colSize - 1] = '.';

                    isVisit[r][colSize - 1] = true;
                    bfs.add(new Point(r, colSize - 1));
                } else if (97 <= map[r][colSize - 1] && map[r][colSize - 1] <= 122) {
                    openDoor(map[r][colSize - 1]);

                    map[r][colSize - 1] = '.';

                    isVisit[r][colSize - 1] = true;
                    bfs.add(new Point(r, colSize - 1));
                } else if (65 <= map[r][colSize - 1] && map[r][colSize - 1] <= 90)  // 문이라면
                {
                    doorBfs.get(map[r][colSize - 1]).add(new Point(r, colSize - 1));

                    isVisit[r][colSize - 1] = true;
                }
            }

            for (int c = 1; c < colSize - 1; c++) {  // 테두리 검사사
                if (map[0][c] == '.') {
                    isVisit[0][c] = true;
                    bfs.add(new Point(0, c));
                } else if (map[0][c] == '$') {
                    gatherFile += 1;
                    map[0][c] = '.';

                    isVisit[0][c] = true;
                    bfs.add(new Point(0, c));
                } else if (97 <= map[0][c] && map[0][c] <= 122) {
                    openDoor(map[0][c]);

                    map[0][c] = '.';

                    isVisit[0][c] = true;
                    bfs.add(new Point(0, c));
                } else if (65 <= map[0][c] && map[0][c] <= 90)  // 문이라면
                {
                    doorBfs.get(map[0][c]).add(new Point(0, c));

                    isVisit[0][c] = true;
                }

                if (map[rowSize - 1][c] == '.') {
                    isVisit[rowSize - 1][c] = true;
                    bfs.add(new Point(rowSize - 1, c));
                } else if (map[rowSize - 1][c] == '$') {
                    gatherFile += 1;
                    map[rowSize - 1][c] = '.';

                    isVisit[rowSize - 1][c] = true;
                    bfs.add(new Point(rowSize - 1, c));
                } else if (97 <= map[rowSize - 1][c] && map[rowSize - 1][c] <= 122) {
                    openDoor(map[rowSize - 1][c]);

                    map[rowSize - 1][c] = '.';

                    isVisit[rowSize - 1][c] = true;
                    bfs.add(new Point(rowSize - 1, c));
                } else if (65 <= map[rowSize - 1][c] && map[rowSize - 1][c] <= 90)  // 문이라면
                {
                    doorBfs.get(map[rowSize - 1][c]).add(new Point(rowSize - 1, c));

                    isVisit[rowSize - 1][c] = true;
                }
            }

            while (!bfs.isEmpty()) {
                Point p = bfs.removeFirst();

                for (int d = 0; d < 4; d++) {
                    int rr = p.r + dr[d];
                    int cc = p.c + dc[d];

                    if (0 <= rr && rr < rowSize && 0 <= cc && cc < colSize)  // 범위 안에 있고
                    {
                        if (!isVisit[rr][cc])  // 방문하지 않았고
                        {
                            if (map[rr][cc] == '.')  // 빈 공간이라면
                            {
                                isVisit[rr][cc] = true;
                                bfs.add(new Point(rr, cc));
                            } else if (97 <= map[rr][cc] && map[rr][cc] <= 122)  // 열쇠라면
                            {
                                char key = map[rr][cc];
                                openDoor(key);

                                map[rr][cc] = '.';
                                isVisit[rr][cc] = true;
                                bfs.add(new Point(rr, cc));

                                ArrayDeque<Point> doors = doorBfs.get(Character.toUpperCase(key));

                                while (!doors.isEmpty()) {
                                    Point pp = doors.remove();

                                    bfs.add(new Point(pp.r, pp.c));
                                    isVisit[pp.r][pp.c] = true;
                                }
                            } else if (65 <= map[rr][cc] && map[rr][cc] <= 90)  // 문이라면
                            {
                                doorBfs.get(map[rr][cc]).add(new Point(rr, cc));

                                isVisit[rr][cc] = true;
                            } else if (map[rr][cc] == '$')  // 문서라면
                            {
                                gatherFile += 1;

                                map[rr][cc] = '.';
                                isVisit[rr][cc] = true;
                                bfs.add(new Point(rr, cc));
                            }
                        }
                    }
                }
            }

            answer.append(gatherFile).append("\n");
        }

        System.out.print(answer);
    }

    static void openDoor(char key)  // 문 제거
    {
        if (!keys.contains(key)) {
            char doorKey = Character.toUpperCase(key);

            for (int r = 0; r < rowSize; r++) {
                for (int c = 0; c < colSize; c++) {
                    if (map[r][c] == doorKey) {
                        map[r][c] = '.';
                    }
                }
            }

            keys.add(key);
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
