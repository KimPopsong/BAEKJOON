import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static int flowerNumber;
    static long minArea = Long.MAX_VALUE;
    static Point sc1, sc2;
    static ArrayList<Point> flowers = new ArrayList<>();
    static ArrayList<Distance> dists = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        flowerNumber = Integer.parseInt(st.nextToken());
        sc1 = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        sc2 = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));

        for (int i = 0; i < flowerNumber; i++) {
            st = new StringTokenizer(br.readLine());

            flowers.add(new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())));
        }

        for (Point f : flowers) {
            long d1 = (sc1.r - f.r) * (sc1.r - f.r) + (sc1.c - f.c) * (sc1.c - f.c);
            long d2 = (sc2.r - f.r) * (sc2.r - f.r) + (sc2.c - f.c) * (sc2.c - f.c);

            dists.add(new Distance(d1, d2));
        }

        dists.sort(new Comparator<Distance>() {
            @Override
            public int compare(Distance d1, Distance d2) {
                return Long.compare(d1.d1, d2.d1);
            }
        });

        long[] sc2Dists = new long[flowerNumber + 1];
        sc2Dists[flowerNumber] = 0;
        for (int i = flowerNumber - 1; i >= 0; i--) {
            sc2Dists[i] = Math.max(sc2Dists[i + 1], dists.get(i).d2);
        }

        for (int i = 0; i <= flowerNumber; i++) {
            long r1sq = (i == 0) ? 0 : dists.get(i - 1).d1;
            long r2sq = sc2Dists[i];
            
            minArea = Math.min(minArea, r1sq + r2sq);
        }

        System.out.println(minArea);
    }

    static class Distance {

        long d1, d2;

        public Distance(long d1, long d2) {
            this.d1 = d1;
            this.d2 = d2;
        }
    }

    static class Point {

        long r, c;

        Point(long r, long c) {
            this.r = r;
            this.c = c;
        }
    }
}
