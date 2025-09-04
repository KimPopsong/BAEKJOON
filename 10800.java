import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int ballNumber;
    static long sumBall;
    static long[] sizeByColor;
    static ArrayList<Ball>[] balls;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 입력부 시작

        ballNumber = Integer.parseInt(br.readLine());
        sizeByColor = new long[ballNumber + 1];
        balls = new ArrayList[2001];

        for (int i = 1; i <= 2000; i++) {
            balls[i] = new ArrayList<>();
        }

        for (int i = 0; i < ballNumber; i++) {
            st = new StringTokenizer(br.readLine());

            int color = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());

            balls[size].add(new Ball(i, color, size));
        }

        // 입력부 종료

        for (int i = 1; i <= 2000; i++) {
            int tempSumBall = 0;
            int[] tempSizeByColor = new int[ballNumber + 1];

            for (Ball ball : balls[i]) {
                ball.canEat = sumBall - sizeByColor[ball.color];
                tempSumBall += ball.size;
                tempSizeByColor[ball.color] += ball.size;
            }

            sumBall += tempSumBall;
            for (int j = 1; j <= ballNumber; j++) {
                sizeByColor[j] += tempSizeByColor[j];
            }
        }

        ArrayList<Ball> ballsByNumber = new ArrayList<>();

        for (int i = 1; i <= 2000; i++) {
            ballsByNumber.addAll(balls[i]);
        }

        Collections.sort(ballsByNumber, new Comparator<Ball>() {
            @Override
            public int compare(Ball o1, Ball o2) {
                return Integer.compare(o1.number, o2.number);
            }
        });

        for (Ball ball : ballsByNumber) {
            sb.append(ball.canEat).append("\n");
        }

        System.out.print(sb);
    }

    static class Ball {
        int number, color, size;
        long canEat;

        Ball(int number, int color, int size) {
            this.number = number;
            this.color = color;
            this.size = size;
        }
    }
}
