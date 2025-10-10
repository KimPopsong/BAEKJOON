import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int size;
    static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        size = Integer.parseInt(br.readLine());
        map = new boolean[size][size];

        draw(0, 0, size, size);

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (map[r][c]) {
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void draw(int startR, int startC, int endR, int endC) {
        if (endR - startR == 1 && endC - startC == 1) {
            map[startR][startC] = true;

            return;
        }

        int midR1 = (endR - startR) / 3 + startR;
        int midC1 = (endC - startC) / 3 + startC;
        int midR2 = (endR - startR) / 3 * 2 + startR;
        int midC2 = (endC - startC) / 3 * 2 + startC;

        draw(startR, startC, midR1, midC1);
        draw(startR, midC1, midR1, midC2);
        draw(startR, midC2, midR1, endC);

        draw(midR1, startC, midR2, midC1);
        draw(midR1, midC2, midR2, endC);

        draw(midR2, startC, endR, midC1);
        draw(midR2, midC1, endR, midC2);
        draw(midR2, midC2, endR, endC);
    }
}
