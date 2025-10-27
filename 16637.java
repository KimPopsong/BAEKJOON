import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    static int answer = Integer.MIN_VALUE, length;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        length = Integer.parseInt(br.readLine());
        // char[] expression = ;

        ArrayDeque<String> expr = new ArrayDeque<>();

        for (char c : br.readLine().toCharArray()) {
            expr.add(Character.toString(c));
        }

        dfs(0, expr);

        System.out.println(answer);
    }

    static void dfs(int depth, ArrayDeque<String> expression) {
        if (expression.size() == 1) {
            answer = Math.max(answer, Integer.parseInt(expression.removeFirst()));

            return;
        }

        ArrayDeque<String> newExpr = new ArrayDeque<>(expression);

        // 괄호를 묶지 않고 계산

        int num1 = Integer.parseInt(newExpr.removeFirst());
        String sign = newExpr.removeFirst();
        int num2 = Integer.parseInt(newExpr.removeFirst());

        newExpr.addFirst(String.valueOf(calc(num1, sign, num2)));

        dfs(depth + 1, newExpr);

        // 뒤 수식에 괄호를 적용

        newExpr = new ArrayDeque<>(expression);

        if (newExpr.size() >= 5) {
            num1 = Integer.parseInt(newExpr.removeFirst());
            String sign1 = newExpr.removeFirst();
            num2 = Integer.parseInt(newExpr.removeFirst());
            String sign2 = newExpr.removeFirst();
            int num3 = Integer.parseInt(newExpr.removeFirst());

            newExpr.addFirst(String.valueOf(calc(num1, sign1, calc(num2, sign2, num3))));

            dfs(depth + 1, newExpr);
        }
    }

    static int calc(int num1, String sign, int num2) {
        if (sign.equals("+")) {
            num1 = num1 + num2;
        } else if (sign.equals("-")) {
            num1 = num1 - num2;
        } else {  // *
            num1 = num1 * num2;
        }

        return num1;
    }
}
