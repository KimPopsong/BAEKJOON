import java.io.*;
import java.util.*;

public class Main {
    static boolean[] primeNumbers = new boolean[100001];

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        getErathos();  // 에라토스테네스의 채로 소수 먼저 구하기

        st = new StringTokenizer(br.readLine());
        int min = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());

        int underPrime = 0;

        for (int number = min; number <= max; number++)
        {
            int count = primeFactorization(number);

            if (primeNumbers[count])
            {
                underPrime += 1;
            }
        }

        System.out.println(underPrime);
    }

    static int primeFactorization(int number)  // 소인수분해
    {
        int count = 0;

        for (int node = 2; node <= number; node++)
        {
            if (primeNumbers[node])  // 나누려는 수가 소수이고
            {
                if (number % node == 0)  // 소인수분해가 된다면
                {
                    count += 1;

                    number = number / node;
                    node = 1;
                }
            }
        }

        return count;
    }

    static void getErathos()  // 1부터 100000까지의 숫자 중 소수 구하기
    {
        Arrays.fill(primeNumbers, true);

        primeNumbers[0] = false;
        primeNumbers[1] = false;

        for (int i = 2; i <= 100000; i++)
        {
            if (primeNumbers[i] == false)
            {
                continue;
            }

            else
            {
                int node = 2;

                while (i * node <= 400)
                {
                    primeNumbers[i * node] = false;

                    node += 1;
                }
            }
        }
    }
}
