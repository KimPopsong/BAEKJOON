import java.util.*;
import java.io.*;

public class Main {
    static int lectureNumber, bluerayNumber;
    static int[] lectures;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        lectureNumber = Integer.parseInt(st.nextToken());
        bluerayNumber = Integer.parseInt(st.nextToken());

        lectures = new int[lectureNumber];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < lectureNumber; i++)
        {
            lectures[i] = Integer.parseInt(st.nextToken());
        }

        // 입력부 종료

        int leftNode = 1;
        int rightNode = 0;

        for (int i : lectures)
        {
            leftNode = Math.max(leftNode, i);
            rightNode += i;
        }

        while (leftNode <= rightNode)
        {
            int mid = (leftNode + rightNode) / 2;

            int count = 1;
            int partSum = 0;

            for (int i : lectures)
            {
                if (partSum + i > mid)
                {
                    count += 1;
                    partSum = i;
                }

                else
                {
                    partSum += i;
                }
            }

            if (count <= bluerayNumber)
            {
                rightNode = mid - 1;
            }

            else
            {
                leftNode = mid + 1;
            }
        }

        System.out.println(leftNode);
    }
}
