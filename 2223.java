import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int time = Integer.parseInt(st.nextToken());
        int canPickPerTime = Integer.parseInt(st.nextToken());
        int monsterNumber = Integer.parseInt(st.nextToken());
        int maxTime = Integer.MAX_VALUE;
        int coin = 0;

        for (int i = 0; i < monsterNumber; i++) {
            st = new StringTokenizer(br.readLine());

            double distance = Double.parseDouble(st.nextToken());
            double speed = Double.parseDouble(st.nextToken());

            if (distance <= speed) {
                System.out.println(0);

                return;
            }

            maxTime = Math.min(maxTime, (int) Math.ceil(distance / speed));
        }

        if (time > maxTime - 1) {
            coin += canPickPerTime * (maxTime - 1);
            time -= maxTime - 1;

            coin += canPickPerTime * (time / 2);
        } else {
            coin += canPickPerTime * time;
        }

        System.out.print(coin);
    }
}
