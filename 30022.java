import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int stuffNumber, dongha, jiwon;  // 상품의 개수, 동하, 지원
        double price = 0;
        PriorityQueue<Stuff> greedy = new PriorityQueue<>();  // 상품의 가격 차이 순으로 정렬

        String[] temp = br.readLine().split(" ");  // 입력

        stuffNumber = Integer.parseInt(temp[0]);
        dongha = Integer.parseInt(temp[1]);
        jiwon = Integer.parseInt(temp[2]);

        for (int i = 0; i < stuffNumber; i++)  // 상품 정보 입력
        {
            temp = br.readLine().split(" ");

            greedy.add(new Stuff(Integer.parseInt(temp[0]), Integer.parseInt(temp[1])));
        }

        while (!greedy.isEmpty())  // 계산
        {
            Stuff stuff = greedy.poll();

            if (dongha == 0)  // 동하가 상품을 살 수 없으면
            {
                price += stuff.jiwon;

                jiwon -= 1;
            }

            else if (jiwon == 0)  // 지원이가 상품을 살 수 없으면
            {
                price += stuff.dongha;

                dongha -= 1;
            }

            else  // 더 저렴한 상품 구매
            {
                if (stuff.dongha > stuff.jiwon)
                {
                    price += stuff.jiwon;

                    jiwon -= 1;
                }

                else if (stuff.dongha == stuff.jiwon)  // 같다면
                {
                    price += stuff.dongha;  // 상품 가격만 추가
                }

                else
                {
                    price += stuff.dongha;

                    dongha -= 1;
                }
            }
        }

        System.out.printf("%.0f", price);
    }

    public static class Stuff implements Comparable<Stuff> {
        int dongha, jiwon;
        int gap;

        Stuff(int dongha, int jiwon)
        {
            this.dongha = dongha;
            this.jiwon = jiwon;

            this.gap = dongha - jiwon;

            if (gap > 0)  // 항상 음수가 되도록
            {
                gap *= -1;
            }
        }

        @Override
        public int compareTo(Stuff s)
        {
            return this.gap - s.gap;
        }
    }
}
