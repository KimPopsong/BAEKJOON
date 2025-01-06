import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int number = Integer.parseInt(br.readLine());  // 숫자의 개수
        int sumNumber = 0;  // 숫자의 합
        PriorityQueue<Integer> pqP = new PriorityQueue<>(Collections.reverseOrder());  // 양수
        PriorityQueue<Integer> pqM = new PriorityQueue<>();  // 0이하의 수

        for (int i = 0; i < number; i++)
        {
            int temp = Integer.parseInt(br.readLine());

            if (temp == 1)  // 1일 경우만 따로 계산
            {
                sumNumber += 1;
            }

            else if (temp > 0)
            {
                pqP.add(temp);
            }

            else
            {
                pqM.add(temp);
            }
        }

        while (!pqP.isEmpty())  // 양수 먼저 계산
        {
            int num1 = pqP.remove();

            if (pqP.isEmpty())  // pqP가 비었다면
            {
                sumNumber += num1;

                break;
            }

            else
            {
                int num2 = pqP.remove();

                sumNumber += (num1 * num2);
            }
        }

        while (!pqM.isEmpty())
        {
            int num1 = pqM.remove();

            if (pqM.isEmpty())
            {
                sumNumber += num1;

                break;
            }

            else
            {
                int num2 = pqM.remove();

                if (num1 * num2 >= 0)  // 곱해서 숫자가 커진다면
                {
                    sumNumber += num1 * num2;
                }

                else
                {
                    sumNumber += num1;

                    pqM.add(num2);
                }
            }
        }

        System.out.println(sumNumber);
    }
}
