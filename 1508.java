import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int trackLength, refereeNumber, placeNumber;
    static int[] refereePlace;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 입력부 시작

        st = new StringTokenizer(br.readLine());

        trackLength = Integer.parseInt(st.nextToken());
        refereeNumber = Integer.parseInt(st.nextToken());
        placeNumber = Integer.parseInt(st.nextToken());

        refereePlace = new int[placeNumber];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < placeNumber; i++) {
            refereePlace[i] = Integer.parseInt(st.nextToken());
        }

        // 입력부 종료

        int left = 0, right = trackLength;
        int mid;
        boolean[] answer = new boolean[placeNumber];

        while (left <= right) {
            mid = (left + right) / 2;

            boolean[] temp = new boolean[placeNumber];

            int before = refereePlace[0];
            int count = 1;  // 심판의 수
            temp[0] = true;

            for (int i = 1; i < placeNumber; i++) {
                if (refereePlace[i] - before >= mid) {
                    before = refereePlace[i];
                    count += 1;
                    temp[i] = true;
                }
            }

            if (count >= refereeNumber) {
                left = mid + 1;

                int c = 0;
                for (int j = 0; j < placeNumber; j++) {
                    answer[j] = temp[j];

                    if (temp[j]) {
                        c += 1;

                        if (c == refereeNumber) {
                            break;
                        }
                    }
                }
            } else {
                right = mid - 1;
            }
        }

        for (boolean b : answer) {
            if (b) {
                sb.append(1);
            } else {
                sb.append(0);
            }
        }

        System.out.print(sb);
    }
}
