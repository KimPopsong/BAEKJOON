import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        Stone start = new Stone(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
            Integer.parseInt(st.nextToken()));
        sortStone(start);

        boolean flag = false;
        ArrayDeque<Stone> stones = new ArrayDeque<>();
        Set<String> isVisit = new HashSet<>();

        stones.add(start);
        isVisit.add(start.s1 + " " + start.s2 + " " + start.s3);

        while (!stones.isEmpty()) {
            Stone stone = stones.removeFirst();

            if (stone.s1 == stone.s2 && stone.s2 == stone.s3) {
                flag = true;

                break;
            }

            if (stone.s1 != stone.s2) {  // 1번 2번 돌
                Stone newStone = new Stone(stone.s1 * 2, stone.s2 - stone.s1, stone.s3);
                sortStone(newStone);

                if (!isVisit.contains(newStone.s1 + " " + newStone.s2 + " " + newStone.s3)) {
                    stones.add(newStone);
                    isVisit.add(newStone.s1 + " " + newStone.s2 + " " + newStone.s3);
                }
            }

            if (stone.s2 != stone.s3) {  // 2번 3번 돌
                Stone newStone = new Stone(stone.s1, stone.s2 * 2, stone.s3 - stone.s2);
                sortStone(newStone);

                if (!isVisit.contains(newStone.s1 + " " + newStone.s2 + " " + newStone.s3)) {
                    stones.add(newStone);
                    isVisit.add(newStone.s1 + " " + newStone.s2 + " " + newStone.s3);
                }
            }

            if (stone.s3 != stone.s1) {  // 1번 3번 돌
                Stone newStone = new Stone(stone.s1 * 2, stone.s2, stone.s3 - stone.s1);
                sortStone(newStone);

                if (!isVisit.contains(newStone.s1 + " " + newStone.s2 + " " + newStone.s3)) {
                    stones.add(newStone);
                    isVisit.add(newStone.s1 + " " + newStone.s2 + " " + newStone.s3);
                }
            }
        }

        if (flag) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static void sortStone(Stone stone) {
        int min = Math.min(stone.s1, Math.min(stone.s2, stone.s3));
        int max = Math.max(stone.s1, Math.max(stone.s2, stone.s3));
        int mid = stone.s1 + stone.s2 + stone.s3 - min - max;

        stone.s1 = min;
        stone.s2 = mid;
        stone.s3 = max;
    }

    static class Stone {

        int s1, s2, s3;

        Stone(int s1, int s2, int s3) {
            this.s1 = s1;
            this.s2 = s2;
            this.s3 = s3;
        }
    }
}
