import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static Map<Integer, Long> factorials = new HashMap<>();
    static final int DIV = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        factorials.put(0, 1L);
        for (int i = 1; i <= n; i++)  // 팩토리얼 구하기
        {
            factorials.put(i, factorials.get(i - 1) * i % DIV);
        }

        long nn = (factorials.get(n) * getSquare(factorials.get(k), DIV - 2) % DIV) * getSquare(factorials.get(n - k), DIV - 2) % DIV;

        System.out.println(nn);
    }

    static long getSquare(long a, long n)  // 분할 정복으로 a의 n제곱 구하기
    {
        long result;

        if (n == 0) {
            result = 1;
        } else if (n == 1) {
            result = a;
        } else if (n % 2 == 1)  // n이 홀수
        {
            long half = getSquare(a, n / 2) % DIV;

            result = (a * half % DIV) * half % DIV;
        } else  // n이 짝수
        {
            long half = getSquare(a, n / 2) % DIV;

            result = half * half % DIV;
        }

        return result;
    }
}
