import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int pointNumber, crossSum = 0, maxCross = 0;
    static int[] maxCrosses, line = {0, 0, 300, 400, 100};
    static ArrayList<Point> points = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        pointNumber = Integer.parseInt(br.readLine());
        maxCrosses = new int[pointNumber / 2];

        for (int i = 0; i < pointNumber / 2; i++) {
            st = new StringTokenizer(br.readLine());

            int line1 = Integer.parseInt(st.nextToken());
            int point1 = Integer.parseInt(st.nextToken());
            int line2 = Integer.parseInt(st.nextToken());
            int point2 = Integer.parseInt(st.nextToken());

            if (line1 == 2 || line1 == 3) {
                point1 = line[line1] - point1;
            } else {
                point1 += line[line1];  // 직사각형의 변을 펼치기
            }

            if (line2 == 2 || line2 == 3) {
                point2 = line[line2] - point2;
            } else {
                point2 += line[line2];
            }

            points.add(new Point(point1, point2));
        }

        for (int i = 0; i < pointNumber / 2; i++) {
            Point p1 = points.get(i);

            for (int j = i + 1; j < pointNumber / 2; j++) {
                Point p2 = points.get(j);

                boolean flag = false;

                if (p1.p1 < p2.p1 && p2.p1 < p1.p2 && p1.p2 < p2.p2) {
                    flag = true;
                } else if (p2.p1 < p1.p1 && p1.p1 < p2.p2 && p2.p2 < p1.p2) {
                    flag = true;
                }

                if (flag) {
                    crossSum += 1;
                    maxCrosses[i] += 1;
                    maxCrosses[j] += 1;
                }
            }
        }

        for (int c : maxCrosses) {
            maxCross = Math.max(maxCross, c);
        }

        System.out.println(crossSum);
        System.out.println(maxCross);
    }

    static class Point {
        int p1, p2;

        Point(int p1, int p2) {
            this.p1 = Math.min(p1, p2);
            this.p2 = Math.max(p1, p2);
        }
    }
}
