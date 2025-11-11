import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int rowSize, colSize;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());

        map = new int[rowSize][colSize];

        for (int c = colSize - 1; c >= 0; c--) {
            st = new StringTokenizer(br.readLine());

            for (int r = 0; r < rowSize; r++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        boolean flag = true;
        for (int r = 0; r < rowSize; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < colSize; c++) {
                if (map[r][c] != Integer.parseInt(st.nextToken())) {
                    flag = false;
                }
            }
        }

        if (flag) {
            System.out.print("""
                    |>___/|        /}
                    | O < |       / }
                    (==0==)------/ }
                    | ^  _____    |
                    |_|_/     ||__|
                    """);
        } else {
            System.out.print("""
                    |>___/|     /}
                    | O O |    / }
                    ( =0= )\"\"\"\"  \\
                    | ^  ____    |
                    |_|_/    ||__|
                    """);
        }
    }
}
