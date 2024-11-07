import java.io.*;

public class Main {
    static int number, minSum;
    static int[] numbers = new int[100010];

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int minTime = Integer.MAX_VALUE;

        String[] temp = br.readLine().split(" ");

        number = Integer.parseInt(temp[0]);
        minSum = Integer.parseInt(temp[1]);

        temp = br.readLine().split(" ");

        for (int i = 0; i < number; i++)
        {
            numbers[i] = Integer.parseInt(temp[i]);
        }

        int startNode = 0;
        int endNode = 0;
        int tempSum = numbers[0];

        while (startNode <= number && endNode <= number && startNode <= endNode)
        {
            if (tempSum >= minSum)
            {
                if (minTime > endNode - startNode + 1)
                {
                    minTime = endNode - startNode + 1;
                }

                tempSum -= numbers[startNode];
                startNode += 1;
            }

            else
            {
                endNode += 1;
                tempSum += numbers[endNode];
            }
        }

        if (minTime == Integer.MAX_VALUE)
        {
            System.out.println(0);
        }

        else
        {
            System.out.println(minTime);
        }
    }
}
