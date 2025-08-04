import java.io.*;
import java.util.*;

public class Main {
    static int maxNumber;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        maxNumber = Integer.parseInt(br.readLine());

        int left = (int) Math.ceil((double) maxNumber / 2);
        int right = maxNumber;

        for (int i = 0; i < maxNumber / 2; i++)
        {
            answer.append(left--).append(" ").append(right--).append(" ");
        }

        if (maxNumber % 2 == 1)
        {
            answer.append(left--);
        }

        System.out.println(answer);
    }
}
