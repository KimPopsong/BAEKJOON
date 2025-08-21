import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int planetNumber;
    static int[] parent;
    static long priceSum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        // 입력부 시작

        planetNumber = Integer.parseInt(br.readLine());

        parent = new int[planetNumber];
        for (int i = 0; i < planetNumber; i++) {
            parent[i] = i;
        }

        for (int r = 0; r < planetNumber; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < planetNumber; c++) {
                if (r == c) {
                    st.nextToken();

                    continue;
                }

                pq.add(new Edge(r, c, Long.parseLong(st.nextToken())));
            }
        }

        // 입력부 종료

        int count = 0;
        boolean[] isVisit = new boolean[planetNumber];

        while (!pq.isEmpty() && count < planetNumber - 1) {
            Edge e = pq.remove();

            if (union(e.planet1, e.planet2)) {
                priceSum += e.price;
                count++;
            }
        }

        System.out.println(priceSum);
    }

    static int find(int p) {
        if (parent[p] == p) {
            return p;
        }

        return parent[p] = find(parent[p]);
    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) {
            return false;
        }

        parent[b] = a;

        return true;
    }

    static class Edge implements Comparable<Edge> {
        int planet1, planet2;
        long price;

        Edge(int planet1, int planet2, long price) {
            this.planet1 = planet1;
            this.planet2 = planet2;
            this.price = price;
        }

        @Override
        public int compareTo(Edge e) {
            return Long.compare(this.price, e.price);
        }
    }
}
