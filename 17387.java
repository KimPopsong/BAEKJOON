import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] aStart = new int[2], aEnd = new int[2], bStart = new int[2], bEnd = new int[2];
    static int xStart, xEnd, yStart, yEnd;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        aStart[0] = Integer.parseInt(st.nextToken());
        aStart[1] = Integer.parseInt(st.nextToken());
        aEnd[0] = Integer.parseInt(st.nextToken());
        aEnd[1] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        bStart[0] = Integer.parseInt(st.nextToken());
        bStart[1] = Integer.parseInt(st.nextToken());
        bEnd[0] = Integer.parseInt(st.nextToken());
        bEnd[1] = Integer.parseInt(st.nextToken());

        xStart = Math.max(Math.min(aStart[0], aEnd[0]), Math.min(bStart[0], bEnd[0]));  // 겹치는 영역 계산
        xEnd = Math.min(Math.max(aStart[0], aEnd[0]), Math.max(bStart[0], bEnd[0]));

        yStart = Math.max(Math.min(aStart[1], aEnd[1]), Math.min(bStart[1], bEnd[1]));  // 겹치는 영역 계산
        yEnd = Math.min(Math.max(aStart[1], aEnd[1]), Math.max(bStart[1], bEnd[1]));

        double aIncline = (double) (aEnd[1] - aStart[1]) / (double) (aEnd[0] - aStart[0]);
        double bIncline = (double) (bEnd[1] - bStart[1]) / (double) (bEnd[0] - bStart[0]);

        double aIntercept = aStart[1] - aIncline * aStart[0];
        double bIntercept = bStart[1] - bIncline * bStart[0];

        double aY1 = aIncline * xStart + aIntercept;
        double aY2 = aIncline * xEnd + aIntercept;

        double bY1 = bIncline * xStart + bIntercept;
        double bY2 = bIncline * xEnd + bIntercept;

        final double EPS = 1e-9;  // 비교 허용 오차

        if (xStart > xEnd) {
            System.out.print(0);
        } else if (yStart > yEnd) {
            System.out.print(0);
        } else if (aEnd[0] == aStart[0] && bEnd[0] == bStart[0]) {
            // 둘 다 세로선
            if (aStart[0] == bStart[0]) {
                int aMinY = Math.min(aStart[1], aEnd[1]);
                int aMaxY = Math.max(aStart[1], aEnd[1]);
                int bMinY = Math.min(bStart[1], bEnd[1]);
                int bMaxY = Math.max(bStart[1], bEnd[1]);
                if (Math.max(aMinY, bMinY) <= Math.min(aMaxY, bMaxY)) System.out.print(1);
                else System.out.print(0);
            } else {
                System.out.print(0);
            }
        } else if (aEnd[0] == aStart[0]) {
            double x = aStart[0];
            bIntercept = bStart[1] - bIncline * bStart[0];
            double y = bIncline * x + bIntercept;

            int aMinY = Math.min(aStart[1], aEnd[1]);
            int aMaxY = Math.max(aStart[1], aEnd[1]);
            int bMinX = Math.min(bStart[0], bEnd[0]);
            int bMaxX = Math.max(bStart[0], bEnd[0]);
            int bMinY = Math.min(bStart[1], bEnd[1]);
            int bMaxY = Math.max(bStart[1], bEnd[1]);

            if (x + EPS >= bMinX && x - EPS <= bMaxX && y + EPS >= aMinY && y - EPS <= aMaxY && y + EPS >= bMinY && y - EPS <= bMaxY) {
                System.out.print(1);
            } else {
                System.out.print(0);
            }
        } else if (bEnd[0] == bStart[0]) {
            double x = bStart[0];
            aIntercept = aStart[1] - aIncline * aStart[0];
            double y = aIncline * x + aIntercept;

            int bMinY = Math.min(bStart[1], bEnd[1]);
            int bMaxY = Math.max(bStart[1], bEnd[1]);
            int aMinX = Math.min(aStart[0], aEnd[0]);
            int aMaxX = Math.max(aStart[0], aEnd[0]);
            int aMinY = Math.min(aStart[1], aEnd[1]);
            int aMaxY = Math.max(aStart[1], aEnd[1]);

            if (x + EPS >= aMinX && x - EPS <= aMaxX && y + EPS >= bMinY && y - EPS <= bMaxY && y + EPS >= aMinY && y - EPS <= aMaxY) {
                System.out.print(1);
            } else {
                System.out.print(0);
            }
        } else if ((aY1 >= bY1 - EPS && aY2 <= bY2 + EPS) || (aY1 <= bY1 + EPS && aY2 >= bY2 - EPS)) {
            System.out.print(1);
        } else {
            System.out.print(0);
        }
    }
}
