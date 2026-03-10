import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int rowSize, colSize;
    static int[] front, right;
    static int[][] blocks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());

        front = new int[colSize];
        right = new int[rowSize];
        blocks = new int[rowSize][colSize];

        for (int r = 0; r < rowSize; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < colSize; c++) {
                blocks[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());  // 앞에서 본 모양
        for (int c = 0; c < colSize; c++) {
            front[c] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());  // 오른쪽에서 본 모양
        for (int r = rowSize - 1; r >= 0; r--) {
            right[r] = Integer.parseInt(st.nextToken());
        }

        for (int r = 0; r < rowSize; r++) {  // 블럭 쌓기
            for (int c = 0; c < colSize; c++) {
                if (blocks[r][c] != 0) {
                    blocks[r][c] = Math.min(front[c], right[r]);
                }
            }
        }

        boolean flag = true;

        for (int c = 0; c < colSize; c++) {  // 앞에서 본 모양 검증
            boolean lineFlag = false;

            for (int r = 0; r < rowSize; r++) {
                if (blocks[r][c] == front[c]) {
                    lineFlag = true;

                    break;
                }
            }

            if (!lineFlag) {
                flag = false;

                break;
            }
        }

        for (int r = 0; r < rowSize; r++) {
            boolean lineFlag = false;

            for (int c = 0; c < colSize; c++) {
                if (blocks[r][c] == right[r]) {
                    lineFlag = true;

                    break;
                }
            }

            if (!lineFlag) {
                flag = false;

                break;
            }
        }

        if (flag) {
            for (int r = 0; r < rowSize; r++) {
                for (int c = 0; c < colSize; c++) {
                    answer.append(blocks[r][c]).append(" ");
                }

                answer.append("\n");
            }
        } else {
            answer.append("-1");
        }

        System.out.print(answer);
    }
}
