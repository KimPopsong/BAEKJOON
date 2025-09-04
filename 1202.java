import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int jewelNumber, bagNumber;
    static long sumValue;
    static int[] bags;
    static PriorityQueue<Jewel> jewelsByWeight;  // 무게 낮은 순으로 정렬

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력부 시작

        st = new StringTokenizer(br.readLine());

        jewelNumber = Integer.parseInt(st.nextToken());
        bagNumber = Integer.parseInt(st.nextToken());

        bags = new int[bagNumber];
        jewelsByWeight = new PriorityQueue<>(new Comparator<Jewel>() {
            @Override
            public int compare(Jewel o1, Jewel o2) {
                return Integer.compare(o1.weight, o2.weight);
            }
        });

        for (int i = 0; i < jewelNumber; i++) {
            st = new StringTokenizer(br.readLine());

            jewelsByWeight.add(new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        for (int i = 0; i < bagNumber; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        // 입력부 종료

        Arrays.sort(bags);
        PriorityQueue<Jewel> jewelsByValue = new PriorityQueue<>(new Comparator<Jewel>() {
            @Override
            public int compare(Jewel o1, Jewel o2) {
                return Integer.compare(o2.value, o1.value);
            }
        });

        for (int bag : bags) {
            while (!jewelsByWeight.isEmpty() && jewelsByWeight.peek().weight <= bag) {
                jewelsByValue.add(jewelsByWeight.remove());
            }

            if (jewelsByValue.isEmpty()) {
                continue;
            }

            sumValue += jewelsByValue.remove().value;
        }

        System.out.println(sumValue);
    }

    static class Jewel {
        int weight, value;

        Jewel(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}
