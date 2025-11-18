import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int rowSize, colSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());

        for (int r = 0; r < rowSize; r++) {
            int streak = -1;
            char[] temp = br.readLine().toCharArray();

            for (int c = 0; c < colSize; c++) {
                if (temp[c] == 'c') {
                    streak = 0;
                    answer.append(0).append(" ");
                } else if (streak == -1) {
                    answer.append(streak).append(" ");
                } else {
                    answer.append(++streak).append(" ");
                }
            }

            answer.append("\n");
        }

        System.out.print(answer);
    }
}
