import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int fieldNumber;
    static long priceSum = 0;
    static boolean[] isWater;
    static int[] parent, wellPrice;
    static int[][] fieldPrice;
    static PriorityQueue<Field> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력부 시작

        fieldNumber = Integer.parseInt(br.readLine());

        isWater = new boolean[fieldNumber];
        parent = new int[fieldNumber];
        wellPrice = new int[fieldNumber];
        fieldPrice = new int[fieldNumber][fieldNumber];

        for (int i = 0; i < fieldNumber; i++) {
            parent[i] = i;
            wellPrice[i] = Integer.parseInt(br.readLine());
        }

        for (int r = 0; r < fieldNumber; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < fieldNumber; c++) {
                fieldPrice[r][c] = Integer.parseInt(st.nextToken());

                if (r < c) {
                    pq.add(new Field(r, c, fieldPrice[r][c]));
                }
            }
        }

        // 입력부 종료

        while (!pq.isEmpty()) {  // 논 연결
            Field f = pq.remove();

            int p1 = findParent(f.f1);
            int p2 = findParent(f.f2);

            if (p1 == p2) {  // 부모가 같다면 생략
                continue;
            }

            if (f.price + Math.min(wellPrice[p1], wellPrice[p2]) > wellPrice[p1] + wellPrice[p2]) {  // 연결하는 비용이, 우물을 따로 파는 것보다 비싸다면
                continue;
            }

            union(p1, p2);
            priceSum += f.price;
        }

        for (int i = 0; i < fieldNumber; i++) {
            int parent = findParent(i);

            if (!isWater[parent]) {  // 논에 물이 없다면
                int minPrice = Integer.MAX_VALUE;
                // 우물을 파는 비용이 가장 싼 곳을 찾고, 우물 파기
                for (int j = 0; j < fieldNumber; j++) {  // parent가 부모인 모든 논을 찾아서
                    if (findParent(j) == parent) {
                        minPrice = Math.min(minPrice, wellPrice[j]);
                    }
                }

                priceSum += minPrice;
                isWater[parent] = true;
            }
        }

        System.out.println(priceSum);
    }

    static int findParent(int f) {
        if (parent[f] == f) {
            return f;
        }

        return parent[f] = findParent(parent[f]);
    }

    static boolean union(int f1, int f2) {
        int p1 = findParent(f1);
        int p2 = findParent(f2);

        if (p1 == p2) {
            return false;
        }

        if (wellPrice[p1] < wellPrice[p2]) {  // 우물 파는 비용이 적은 쪽이 부모
            parent[p2] = p1;
        } else {
            parent[p1] = p2;
        }

        return true;
    }

    static class Field implements Comparable<Field> {
        int f1, f2, price;

        Field(int f1, int f2, int price) {
            this.f1 = f1;
            this.f2 = f2;
            this.price = price;
        }

        @Override
        public int compareTo(Field f) {
            return Integer.compare(this.price, f.price);
        }
    }
}
