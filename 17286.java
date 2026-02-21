import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        double minDistance = Double.MAX_VALUE;
        Point yuumi = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        Point[] player = new Point[3];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());

            player[i] = new Point(Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()));
        }

        for (int player1 = 0; player1 < 3; player1++) {
            double distanceP1 = Math.sqrt(
                Math.pow(yuumi.r - player[player1].r, 2) + Math.pow(yuumi.c - player[player1].c,
                    2));

            for (int player2 = 0; player2 < 3; player2++) {
                if (player1 == player2) {
                    continue;
                }

                double distanceP2 = Math.sqrt(
                    Math.pow(player[player1].r - player[player2].r, 2) + Math.pow(
                        player[player1].c - player[player2].c, 2));

                for (int player3 = 0; player3 < 3; player3++) {
                    if (player1 == player3 || player2 == player3) {
                        continue;
                    }

                    double distanceP3 = Math.sqrt(
                        Math.pow(player[player2].r - player[player3].r, 2) + Math.pow(
                            player[player2].c - player[player3].c, 2));

                    minDistance = Math.min(minDistance, distanceP1 + distanceP2 + distanceP3);
                }
            }
        }

        System.out.println((int) minDistance);
    }

    static class Point {

        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
