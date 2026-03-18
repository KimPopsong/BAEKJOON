import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int snackNumber;
    static int[] picks;
    static double[] dp, prefixSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        snackNumber = Integer.parseInt(br.readLine());
        picks = new int[snackNumber + 1];
        dp = new double[snackNumber + 1];
        prefixSum = new double[snackNumber + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= snackNumber; i++) {
            picks[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 0;
        prefixSum[0] = 0;

        for (int leftSnack = 1; leftSnack <= snackNumber; leftSnack++) {
            int startIndex = leftSnack - picks[leftSnack];

            double sum = prefixSum[leftSnack - 1];

            if (startIndex - 1 >= 0) {
                sum -= prefixSum[startIndex - 1];
            }

            dp[leftSnack] = 1 + (sum / picks[leftSnack]);
            prefixSum[leftSnack] = prefixSum[leftSnack - 1] + dp[leftSnack];
        }

        System.out.print(dp[snackNumber]);
    }
}
