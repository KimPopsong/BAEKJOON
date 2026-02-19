import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int rowSize, colSize, roomNumber, convenienceStoreNumber, minScore = Integer.MAX_VALUE;
    static int[][] map;  // 편의점과의 거리 저장
    static ArrayList<Room> rooms = new ArrayList<>();
    static ArrayList<Point> convenienceStores = new ArrayList<>();

    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());
        roomNumber = Integer.parseInt(st.nextToken());
        convenienceStoreNumber = Integer.parseInt(st.nextToken());

        map = new int[rowSize + 1][colSize + 1];
        for (int r = 0; r < rowSize + 1; r++) {
            for (int c = 0; c < colSize + 1; c++) {
                map[r][c] = -1;
            }
        }

        for (int i = 0; i < roomNumber; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int rentFee = Integer.parseInt(st.nextToken());

            rooms.add(new Room(r, c, rentFee));
        }

        for (int i = 0; i < convenienceStoreNumber; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            convenienceStores.add(new Point(r, c));
            map[r][c] = 0;
        }

        int distance = 0;
        ArrayDeque<Point> bfs = new ArrayDeque<>(convenienceStores);

        while (!bfs.isEmpty()) {
            distance += 1;
            ArrayDeque<Point> tempBfs = new ArrayDeque<>();

            while (!bfs.isEmpty()) {
                Point convenienceStore = bfs.removeFirst();

                for (int d = 0; d < 4; d++) {
                    int r = convenienceStore.r + dr[d];
                    int c = convenienceStore.c + dc[d];

                    if (0 < r && r <= rowSize && 0 < c && c <= colSize) {
                        if (map[r][c] == -1) {
                            map[r][c] = distance;
                            tempBfs.add(new Point(r, c));
                        }
                    }
                }
            }

            bfs = tempBfs;
        }

        for (Room room : rooms) {
            minScore = Math.min(minScore, room.rentFee * map[room.r][room.c]);
        }

        System.out.println(minScore);
    }

    static class Point {

        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static class Room extends Point {

        int rentFee;

        Room(int r, int c, int rentFee) {
            super(r, c);
            this.rentFee = rentFee;
        }
    }
}
