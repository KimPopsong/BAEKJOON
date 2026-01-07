import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int days, ticketPrice, bonus;
    static int[] wages, beforeVacation, afterVacation;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        days = Integer.parseInt(st.nextToken());
        ticketPrice = Integer.parseInt(st.nextToken());
        bonus = Integer.parseInt(st.nextToken());

        wages = new int[days];
        beforeVacation = new int[days + 2];
        afterVacation = new int[days + 2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < days; i++) {
            wages[i] = Integer.parseInt(st.nextToken());
            beforeVacation[i + 1] = beforeVacation[i] + wages[i] * bonus;
        }

        for (int i = days; i > 0; i--) {
            afterVacation[i] = afterVacation[i + 1] + wages[i - 1];
        }

        int left = 0, right = days, mid;
        while (left <= right) {
            boolean flag = false;  // 휴가 가능 여부
            mid = (left + right) / 2;  // 휴가 사용 가능 일자

            for (int i = 1; i < days + 2 - mid; i++)  // i일부터 연속 mid일 휴가
            {
                int sumWages = beforeVacation[i - 1] + afterVacation[i + mid];

                if (sumWages >= ticketPrice) {
                    flag = true;

                    break;
                }
            }

            if (flag) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        mid = (left + right) / 2;

        if (mid <= 0) {
            System.out.print(-1);
        } else {
            System.out.print(mid);
        }
    }
}
