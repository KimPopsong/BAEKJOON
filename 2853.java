import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static int day, shipCount = 0;
    static int[] days;
    static Set<Integer> checkDays = new HashSet<>();
    static Set<Integer> daysSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        day = Integer.parseInt(br.readLine());
        days = new int[day];
        for (int i = 0; i < day; i++) {
            days[i] = Integer.parseInt(br.readLine());
            daysSet.add(days[i]);
        }

        for (int s = 1; s < day; s++) {
            if (checkDays.contains(days[s])) {
                continue;
            }

            shipCount += 1;

            int gap = days[s] - 1;

            while (true) {
                if (daysSet.contains(days[s] + gap)) {
                    checkDays.add(days[s] + gap);
                    gap += days[s] - 1;
                } else {
                    break;
                }
            }
        }

        System.out.print(shipCount);
    }
}
