import java.util.*;
import java.io.*;

public class Main {
    static int answer = 0, number;
    static ArrayList<Number> numbers = new ArrayList<>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        number = Integer.parseInt(br.readLine());

        for (int i = 0; i < number; i++)
        {
            numbers.add(new Number(Integer.parseInt(br.readLine()), i));
        }

        Collections.sort(numbers, new Comparator<Number>() {
            @Override
            public int compare(Number n1, Number n2)
            {
                return Integer.compare(n1.number, n2.number);
            }
        });

        for (int i = 0; i < number; i++)
        {
            Number num = numbers.get(i);

            answer = Math.max(answer, num.index - i);
        }

        System.out.println(answer + 1);
    }

    static class Number {
        int number, index;

        Number(int number, int index)
        {
            this.number = number;
            this.index = index;
        }
    }
}
