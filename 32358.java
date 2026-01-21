import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int queryNumber, now = 0;
    static long moveDistance = 0L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        queryNumber = Integer.parseInt(br.readLine());

        ArrayList<Integer> trashes = new ArrayList<>();

        for (int i = 0; i < queryNumber; i++) {
            st = new StringTokenizer(br.readLine());

            int command = Integer.parseInt(st.nextToken());

            if (command == 1) {  // 쓰레기 버리기
                trashes.add(Integer.parseInt(st.nextToken()));

            } else {  // 쓰레기 줍기
                ArrayDeque<Integer> leftQueue = new ArrayDeque<>();  // 현재 위치보다 작거나 같은 쓰레기 저장
                ArrayDeque<Integer> rightQueue = new ArrayDeque<>();  // 현재 위치보다 큰 쓰레기 저장

                Collections.sort(trashes);

                for (int t : trashes) {
                    if (t <= now) {
                        leftQueue.addLast(t);
                    } else {
                        rightQueue.addLast(t);
                    }
                }

                trashes = new ArrayList<>();

                while (!leftQueue.isEmpty() || !rightQueue.isEmpty()) {
                    if (leftQueue.isEmpty()) {
                        moveDistance += rightQueue.peekLast() - now;
                        now = rightQueue.peekLast();

                        break;
                    } else if (rightQueue.isEmpty()) {
                        moveDistance += now - leftQueue.peekFirst();
                        now = leftQueue.peekFirst();

                        break;
                    }

                    int l = leftQueue.peekLast();
                    int r = rightQueue.peekFirst();

                    if (now - l <= r - now) {  // 왼쪽이 더 가깝다면
                        moveDistance += now - l;
                        now = l;
                        leftQueue.removeLast();
                    } else {
                        moveDistance += r - now;
                        now = r;
                        rightQueue.removeFirst();
                    }
                }
            }
        }

        System.out.print(moveDistance);
    }
}
