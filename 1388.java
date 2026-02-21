import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int count = 0, rowSize, colSize;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());

        map = new char[rowSize][colSize];

        for (int r = 0; r < rowSize; r++) {
            char[] temp = br.readLine().toCharArray();

            for (int c = 0; c < colSize; c++) {
                map[r][c] = temp[c];
            }
        }

        for (int r = 0; r < rowSize; r++) {
            for (int c = 0; c < colSize; c++) {
                if (map[r][c] == '-') {
                    count += 1;

                    int cc = c - 1;
                    while (cc < colSize - 1) {
                        cc += 1;

                        if (map[r][cc] == '-') {
                            map[r][cc] = '!';
                        } else {
                            break;
                        }
                    }
                } else if (map[r][c] == '|') {
                    count += 1;

                    int rr = r - 1;
                    while (rr < rowSize - 1) {
                        rr += 1;

                        if (map[rr][c] == '|') {
                            map[rr][c] = '!';
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }
}
