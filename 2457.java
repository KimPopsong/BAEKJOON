import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int flowerNumber;
    static ArrayList<Flower> flowers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        flowerNumber = Integer.parseInt(br.readLine());

        for (int i = 0; i < flowerNumber; i++) {
            st = new StringTokenizer(br.readLine());

            int startM = Integer.parseInt(st.nextToken());
            int startD = Integer.parseInt(st.nextToken());
            int endM = Integer.parseInt(st.nextToken());
            int endD = Integer.parseInt(st.nextToken());

            if (endM > 11) {
                endM = 12;
                endD = 01;
            }

            if (startM < 3) {
                startM = 3;
                startD = 1;
            }

            flowers.add(new Flower(startM, startD, endM, endD));
        }

        Collections.sort(flowers);

        boolean flag = true;
        ArrayDeque<Flower> selectFlowers = new ArrayDeque<>();

        for (Flower flower : flowers) {
            if (!selectFlowers.isEmpty()) {
                if (selectFlowers.peekFirst().start > flower.end) {
                    flag = false;

                    break;
                } else if (selectFlowers.peekFirst().start <= flower.start) {
                    continue;
                }

                while (selectFlowers.size() >= 2) {
                    Flower firstFlower = selectFlowers.removeFirst();
                    Flower secondFlower = selectFlowers.peekFirst();

                    if (secondFlower.start > flower.end) {
                        selectFlowers.addFirst(firstFlower);

                        break;
                    }
                }
            }

            selectFlowers.addFirst(flower);
        }

        if (selectFlowers.peekFirst().start == 301 && selectFlowers.peekLast().end == 1201 && flag) {
            System.out.print(selectFlowers.size());
        } else {
            System.out.print(0);
        }
    }

    static class Flower implements Comparable<Flower> {
        int start, end;

        Flower(int startM, int startD, int endM, int endD) {
            this.start = startM * 100 + startD;
            this.end = endM * 100 + endD;
        }

        @Override
        public int compareTo(Flower f) {
            if (this.end == f.end) {
                return Integer.compare(this.start, f.start);
            }

            return Integer.compare(f.end, this.end);
        }
    }
}
