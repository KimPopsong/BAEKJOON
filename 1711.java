import java.util.*;
import java.io.*;

public class Main {
    static int pointNumber, answer = 0;
    static ArrayList<Point> points = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        pointNumber = Integer.parseInt(br.readLine());

        for (int i = 0; i < pointNumber; i++) {
            st = new StringTokenizer(br.readLine());

            long r = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            points.add(new Point(r, c));
        }

        for (int a = 0; a < pointNumber - 2; a++) {
            Point pointA = points.get(a);

            for (int b = a + 1; b < pointNumber - 1; b++) {
                Point pointB = points.get(b);

                long slideAB =
                        (pointA.r - pointB.r) * (pointA.r - pointB.r)
                      + (pointA.c - pointB.c) * (pointA.c - pointB.c);

                for (int c = b + 1; c < pointNumber; c++) {
                    Point pointC = points.get(c);

                    long slideAC =
                            (pointA.r - pointC.r) * (pointA.r - pointC.r)
                          + (pointA.c - pointC.c) * (pointA.c - pointC.c);
                    long slideBC =
                            (pointB.r - pointC.r) * (pointB.r - pointC.r)
                          + (pointB.c - pointC.c) * (pointB.c - pointC.c);

                    long maxSlide = Math.max(slideAB, Math.max(slideAC, slideBC));

                    if (2 * maxSlide == slideAB + slideAC + slideBC) {
                        answer += 1;
                    }
                }
            }
        }

        System.out.print(answer);
    }

    static class Point {
        long r, c;

        Point(long r, long c) {
            this.r = r;
            this.c = c;
        }
    }
}
