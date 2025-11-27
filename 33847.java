import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int fishNumber, fishMealPrice, maxAppetite = 0;
    static long maxBenefit = 0;
    static ArrayList<Fish> fish = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        fishNumber = Integer.parseInt(br.readLine());
        fishMealPrice = Integer.parseInt(br.readLine());

        for (int i = 0; i < fishNumber; i++) {
            st = new StringTokenizer(br.readLine());

            int appetite = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            fish.add(new Fish(appetite, size, price));
            maxAppetite += appetite;
        }

        Collections.sort(fish);

        for (int T = 0; T <= maxAppetite; T++) {
            int t = T;
            long moneySum = -1L * T * fishMealPrice;

            for (int i = 0; i < fishNumber; i++) {
                Fish f = fish.get(i);

                if (f.appetite <= t) {
                    t -= f.appetite;
                    moneySum += f.price;
                }
            }

            if (moneySum > maxBenefit) {
                maxBenefit = moneySum;
            }
        }

        System.out.print(maxBenefit);
    }

    static class Fish implements Comparable<Fish> {
        int appetite, size, price;

        Fish(int appetite, int size, int price) {
            this.appetite = appetite;
            this.size = size;
            this.price = price;
        }

        @Override
        public int compareTo(Fish f) {
            return Integer.compare(f.size, this.size);
        }
    }
}
