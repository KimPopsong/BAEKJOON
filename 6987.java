import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        // 입력부 시작

        for (int tc = 0; tc < 4; tc++) {
            st = new StringTokenizer(br.readLine());

            int[][] result = new int[6][3];

            for (int r = 0; r < 6; r++) {
                for (int c = 0; c < 3; c++) {
                    result[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            boolean res = check(0, 1, result);

            if (res) {
                answer.append("1 ");
            } else {
                answer.append("0 ");
            }
        }

        // 입력부 종료

        System.out.print(answer);
    }

    static boolean check(int index, int versus, int[][] result) {
        if (index >= 5) {
            for (int r = 0; r < 6; r++) {
                for (int c = 0; c < 3; c++) {
                    if (result[r][c] > 0) {
                        return false;
                    }
                }
            }

            return true;
        }

        if (versus >= 6) {
            return check(index + 1, index + 2, result);
        }

        for (int i = 0; i < 3; i++) {
            if (result[index][i] > 0 && result[versus][2 - i] > 0) {
                result[index][i] -= 1;
                result[versus][2 - i] -= 1;

                boolean res = check(index, versus + 1, result);

                result[index][i] += 1;
                result[versus][2 - i] += 1;

                if (res) {
                    return true;
                }
            }
        }

        return false;
    }
}
