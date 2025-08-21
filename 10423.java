import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int cityNumber, cableNumber, powerStationNumber;
    static long sumPrice;
    static boolean[] powerStations;
    static int[] parent;
    static PriorityQueue<Cable> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력부 시작

        st = new StringTokenizer(br.readLine());
        cityNumber = Integer.parseInt(st.nextToken());
        cableNumber = Integer.parseInt(st.nextToken());
        powerStationNumber = Integer.parseInt(st.nextToken());

        powerStations = new boolean[cityNumber + 1];
        parent = new int[cityNumber + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < powerStationNumber; i++) {
            powerStations[Integer.parseInt(st.nextToken())] = true;
        }

        for (int i = 0; i < cableNumber; i++) {
            st = new StringTokenizer(br.readLine());

            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            pq.add(new Cable(c1, c2, p));
        }

        for (int i = 1; i <= cityNumber; i++) {
            parent[i] = i;
        }

        // 입력부 종료

        int count = 0;
        while (!pq.isEmpty() && count < cityNumber - powerStationNumber) {
            Cable c = pq.remove();

            if (union(c.city1, c.city2)) {
                count += 1;
                sumPrice += c.price;
            }
        }

        System.out.println(sumPrice);
    }

    static int find(int c) {
        if (parent[c] == c) {
            return c;
        }

        return parent[c] = find(parent[c]);
    }

    static boolean union(int c1, int c2) {
        int p1 = find(c1);
        int p2 = find(c2);

        if (p1 == p2) {
            return false;
        } else if (powerStations[p1] && powerStations[p2]) {
            return false;
        }

        if (powerStations[p1]) {
            parent[p2] = p1;
        } else {
            parent[p1] = p2;
        }

        return true;
    }

    static class Cable implements Comparable<Cable> {
        int city1, city2, price;

        Cable(int city1, int city2, int price) {
            this.city1 = city1;
            this.city2 = city2;
            this.price = price;
        }

        @Override
        public int compareTo(Cable c) {
            return Integer.compare(this.price, c.price);
        }
    }
}
