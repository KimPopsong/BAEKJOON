import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static StringBuilder sb;

    static int testCase;
    static char[] mathSign = {' ', '+', '-'};  // ASCII 순서에 따라 출력

    static List<Character> expressions = new ArrayList<>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++)
        {
            int test = Integer.parseInt(br.readLine());

            for (int j = 0; j < 3; j++)
            {
                expressions.clear();
                expressions.add((char) 1);
                BruteForce(test, 2, j);
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void BruteForce(int maxLevel, int level, int sign)
    {
        expressions.add(mathSign[sign]);
        expressions.add((char) level);

        if (level == maxLevel)
        {
            if (Calc())
            {
                Print();
            }
        }

        else
        {
            BruteForce(maxLevel, level + 1, 0);
            expressions.remove(expressions.size() - 1);
            expressions.remove(expressions.size() - 1);

            BruteForce(maxLevel, level + 1, 1);
            expressions.remove(expressions.size() - 1);
            expressions.remove(expressions.size() - 1);

            BruteForce(maxLevel, level + 1, 2);
            expressions.remove(expressions.size() - 1);
            expressions.remove(expressions.size() - 1);
        }
    }

    static boolean Calc()
    {
        int sum = 0;
        int temp = 0;
        boolean flag = true;  // true == '+', false == '-'

        for (int i = 0; i < expressions.size(); i++)
        {
            if (expressions.get(i) == ' ')  // 수식일 시
            {
                temp *= 10;
            }

            else if (expressions.get(i) == '+')
            {
                if (flag)
                {
                    sum += temp;
                }

                else
                {
                    sum -= temp;
                }

                flag = true;
                temp = 0;
            }

            else if (expressions.get(i) == '-')
            {
                if (flag)
                {
                    sum += temp;
                }

                else
                {
                    sum -= temp;
                }

                flag = false;
                temp = 0;
            }

            else  // 숫자일 시
            {
                temp += (int) expressions.get(i);
            }
        }

        if (flag)
        {
            sum += temp;
        }

        else
        {
            sum -= temp;
        }

        if (sum == 0)
        {
            return true;
        }

        else
        {
            return false;
        }
    }

    static void Print()
    {
        for (Character character : expressions)
        {
            if (character == ' ' || character == '+' || character == '-')
            {
                sb.append(character);
            }

            else
            {
                sb.append((int) character);
            }
        }
        sb.append("\n");
    }
}
