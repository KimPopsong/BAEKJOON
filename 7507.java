import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int testCase;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        testCase = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= testCase; tc++) {
            int gameNumber = Integer.parseInt(br.readLine());
            ArrayList<Game> games = new ArrayList<>();

            for (int i = 0; i < gameNumber; i++) {
                st = new StringTokenizer(br.readLine());

                int day = Integer.parseInt(st.nextToken());
                int startTime = Integer.parseInt(st.nextToken());
                int endTime = Integer.parseInt(st.nextToken());

                games.add(new Game(day * 10000 + startTime, day * 10000 + endTime));
            }

            Collections.sort(games);

            int count = 0, endTime = 0;

            for (Game game : games) {
                if (game.startTime >= endTime) {
                    endTime = game.endTime;
                    count += 1;
                }
            }

            answer.append("Scenario #").append(tc).append(":").append("\n").append(count)
                .append("\n\n");
        }

        System.out.print(answer);
    }

    static class Game implements Comparable<Game> {

        int startTime, endTime;

        Game(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Game g) {
            if (this.endTime == g.endTime) {
                return Integer.compare(g.startTime, this.startTime);
            }

            return Integer.compare(this.endTime, g.endTime);
        }
    }
}
