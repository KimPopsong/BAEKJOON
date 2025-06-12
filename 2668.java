import java.util.*;
import java.io.*;

public class Main {
    static int number, maxSize;
    static boolean[] pickedIndex;
    static int[] numbers;
    static Set<Integer> pickedNumbers;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력부 시작

        number = Integer.parseInt(br.readLine());

        pickedIndex = new boolean[number + 1];
        numbers = new int[number + 1];
        pickedNumbers = new HashSet<>();

        for (int i = 1; i <= number; i++)
        {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        // 입력부 종료

        for (int i = 1; i <= number; i++)  // 사이클 발생 여부 확인
        {
            if (pickedIndex[i])
            {
                continue;
            }

            boolean[] isVisitIndex = pickedIndex.clone();
            Set<Integer> isPickedNumbers = new HashSet<>(pickedNumbers);

            int next = i;

            while (true)
            {
                isVisitIndex[next] = true;
                isPickedNumbers.add(numbers[next]);
                next = numbers[next];

                if (isVisitIndex[next])
                {
                    break;
                }
            }

            boolean flag = true;
            for (int j = 1; j <= number; j++)
            {
                if (isVisitIndex[j])
                {
                    if (!isPickedNumbers.contains(j))
                    {
                        flag = false;

                        break;
                    }
                }
            }

            if (flag)  // 사이클이 발생한다면
            {
                for (int j = 1; j <= number; j++)
                {
                    if (isVisitIndex[j])
                    {
                        pickedIndex[j] = true;
                        pickedNumbers.add(j);
                    }
                }
            }
        }

        ArrayList<Integer> answer = new ArrayList<>(pickedNumbers);
        Collections.sort(answer);

        sb.append(answer.size()).append("\n");
        for (int i : answer)
        {
            sb.append(i).append("\n");
        }

        System.out.print(sb);
    }
}
