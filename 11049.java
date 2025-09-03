import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int matrixNumber;
    static int[][] dp;
    static Matrix[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        matrixNumber = Integer.parseInt(br.readLine());
        dp = new int[matrixNumber][matrixNumber];
        matrix = new Matrix[matrixNumber][matrixNumber];

        for (int i = 0; i < matrixNumber; i++) {
            st = new StringTokenizer(br.readLine());

            matrix[i][i] = new Matrix(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int r = 0; r < matrixNumber; r++) {
            for (int c = 0; c < matrixNumber; c++) {
                if (r == c) {
                    dp[r][c] = 0;

                    continue;
                }

                dp[r][c] = Integer.MAX_VALUE;
            }
        }

        System.out.println(recursion(0, matrixNumber - 1));
    }

    static int recursion(int row, int col) {
        if (dp[row][col] != Integer.MAX_VALUE) {
            return dp[row][col];
        }

        for (int k = row; k < col; k++) {
            int left = recursion(row, k);
            int right = recursion(k + 1, col);

            int cost = left + right + matrix[row][k].row * matrix[row][k].col * matrix[k + 1][col].col;

            if (dp[row][col] > cost) {
                dp[row][col] = cost;
                matrix[row][col] = new Matrix(matrix[row][k].row, matrix[k + 1][col].col);
            }
        }

        return dp[row][col];
    }

    static class Matrix {
        int row, col;

        Matrix(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
