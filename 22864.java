import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int fatigue, work, restFatigue, maxFatigue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        fatigue = Integer.parseInt(st.nextToken());
        work = Integer.parseInt(st.nextToken());
        restFatigue = Integer.parseInt(st.nextToken());
        maxFatigue = Integer.parseInt(st.nextToken());

        int fatigueNow = 0, workDone = 0;
        for (int time = 0; time < 24; time++) {
            if (fatigueNow + fatigue <= maxFatigue) {
                fatigueNow += fatigue;
                workDone += 1;
            } else {
                fatigueNow = Math.max(0, fatigueNow - restFatigue);
            }
        }

        System.out.print(work * workDone);
    }
}
