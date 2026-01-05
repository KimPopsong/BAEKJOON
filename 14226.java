import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {

    static int target;
    static int[][] isVisit = new int[2001][2001];
    static ArrayDeque<Emoticon> bfs = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        target = Integer.parseInt(br.readLine());

        for (int i = 0; i <= 2000; i++) {
            Arrays.fill(isVisit[i], 100000);
        }

        bfs.add(new Emoticon(1, 0, 0));
        isVisit[1][0] = 0;

        while (!bfs.isEmpty()) {
            Emoticon emoticon = bfs.removeFirst();

            if (emoticon.length == target) {
                System.out.print(emoticon.time);
                
                return;
            }

            if (emoticon.clipboard > 0) {
                if (emoticon.length + emoticon.clipboard <= 2000 && emoticon.time + 1 < isVisit[
                    emoticon.length + emoticon.clipboard][emoticon.clipboard]) {
                    isVisit[emoticon.length + emoticon.clipboard][emoticon.clipboard] =
                        emoticon.time + 1;
                    bfs.addLast(
                        new Emoticon(emoticon.length + emoticon.clipboard, emoticon.clipboard,
                            emoticon.time + 1));
                }
            }

            if (emoticon.length - 1 >= 0) {
                if (emoticon.time + 1 < isVisit[emoticon.length - 1][emoticon.clipboard]) {
                    isVisit[emoticon.length - 1][emoticon.clipboard] = emoticon.time + 1;
                    bfs.addLast(
                        new Emoticon(emoticon.length - 1, emoticon.clipboard, emoticon.time + 1));
                }
            }

            if (emoticon.length != emoticon.clipboard) {
                if (emoticon.time + 1 < isVisit[emoticon.length][emoticon.length]) {
                    isVisit[emoticon.length][emoticon.length] = emoticon.time + 1;
                    bfs.addLast(new Emoticon(emoticon.length, emoticon.length, emoticon.time + 1));
                }
            }
        }
    }

    static class Emoticon {

        int length, clipboard, time;

        Emoticon(int length, int clipboard, int time) {
            this.length = length;
            this.clipboard = clipboard;
            this.time = time;
        }
    }
}
