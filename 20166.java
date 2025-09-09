import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int rowSize, colSize, stringNumber;
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1}, dc = {0, 1, 1, 1, 0, -1, -1, -1};
    static char[][] map;
    static Map<String, Integer> time = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());
        stringNumber = Integer.parseInt(st.nextToken());

        map = new char[rowSize][colSize];

        for (int r = 0; r < rowSize; r++) {
            char[] s = br.readLine().toCharArray();

            for (int c = 0; c < colSize; c++) {
                map[r][c] = s[c];
            }
        }

        for (int r = 0; r < rowSize; r++) {
            for (int c = 0; c < colSize; c++) {
                ArrayDeque<Str> bfs = new ArrayDeque<>();
                bfs.add(new Str(r, c, String.valueOf(map[r][c])));
                time.put(String.valueOf(map[r][c]), time.getOrDefault(String.valueOf(map[r][c]), 0) + 1);

                for (int t = 0; t < 4; t++) {
                    ArrayDeque<Str> tempBfs = new ArrayDeque<>(bfs);
                    bfs.clear();

                    while (!tempBfs.isEmpty()) {
                        Str str = tempBfs.removeFirst();

                        for (int d = 0; d < 8; d++) {
                            int rr = str.r + dr[d];
                            int cc = str.c + dc[d];

                            if (rr < 0) {
                                rr += rowSize;
                            } else if (rowSize <= rr) {
                                rr -= rowSize;
                            }

                            if (cc < 0) {
                                cc += colSize;
                            } else if (colSize <= cc) {
                                cc -= colSize;
                            }

                            time.put(map[rr][cc] + str.s, time.getOrDefault(map[rr][cc] + str.s, 0) + 1);
                            bfs.add(new Str(rr, cc, map[rr][cc] + str.s));
                        }
                    }
                }
            }
        }

        for (int i = 0; i < stringNumber; i++) {
            String s = br.readLine();

            System.out.println(time.getOrDefault(s, 0));
        }
    }

    static class Str {
        int r, c;
        String s;

        Str(int r, int c, String s) {
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }
}
