import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int destinationX, destinationY, poolNumber;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        destinationX = Integer.parseInt(st.nextToken());
        destinationY = Integer.parseInt(st.nextToken());
        poolNumber = Integer.parseInt(st.nextToken());

        int time = 0;
        ArrayDeque<Point> bfs = new ArrayDeque<>();
        Set<String> isVisit = new HashSet<>();

        int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

        for (int i = 0; i < poolNumber; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            isVisit.add(x + " " + y);
        }

        if (destinationX == 0 && destinationY == 0) {
            System.out.println(0);

            return;
        }

        bfs.add(new Point(0, 0));
        isVisit.add(0 + " " + 0);

        while (!bfs.isEmpty()) {
            time += 1;
            ArrayDeque<Point> newBfs = new ArrayDeque<>(bfs);
            bfs.clear();

            while (!newBfs.isEmpty()) {
                Point p = newBfs.removeFirst();

                for (int d = 0; d < 4; d++) {
                    int x = p.x + dx[d];
                    int y = p.y + dy[d];

                    if (x == destinationX && y == destinationY) {
                        bfs.clear();
                        newBfs.clear();

                        break;
                    } else if (!isVisit.contains(x + " " + y)) {  // 기존에 방문하지 않았다면
                        bfs.add(new Point(x, y));
                        isVisit.add(x + " " + y);
                    }
                }
            }
        }

        System.out.println(time);
    }

    static class Point {

        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
