import java.util.*;
import java.io.*;

public class Main {
    static int switchNumber, studentNumber;
    static int[] switches;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder answer = new StringBuilder();

        switchNumber = Integer.parseInt(br.readLine());  // 스위치 개수 입력
        switches = new int[switchNumber + 1];

        st = new StringTokenizer(br.readLine());  // 스위치 입력
        for (int i = 1; i <= switchNumber; i++)
        {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        studentNumber = Integer.parseInt(br.readLine());
        for (int student = 0; student < studentNumber; student++)
        {
            st = new StringTokenizer(br.readLine());

            int gender = Integer.parseInt(st.nextToken());
            int givenSwitch = Integer.parseInt(st.nextToken());

            if (gender == 1)  // 남자일 경우
            {
                for (int i = 1; givenSwitch * i <= switchNumber; i++)  // 배수마다 상태 전환환
                {
                    if (switches[givenSwitch * i] == 0)
                    {
                        switches[givenSwitch * i] = 1;
                    }

                    else
                    {
                        switches[givenSwitch * i] = 0;
                    }
                }
            }

            else  // 여자일 경우
            {
                int left = givenSwitch - 1;
                int right = givenSwitch + 1;

                while (true)
                {
                    if (left <= 0)
                    {
                        break;
                    }

                    if (right >= switchNumber + 1)
                    {
                        break;
                    }

                    if (switches[left] == switches[right])
                    {
                        left -= 1;
                        right += 1;
                    }

                    else
                    {
                        break;
                    }
                }

                for (int i = left + 1; i < right; i++)
                {
                    if (switches[i] == 1)
                    {
                        switches[i] = 0;
                    }

                    else
                    {
                        switches[i] = 1;
                    }
                }
            }
        }

        for (int i = 1; i <= switchNumber; i++)
        {
            answer.append(switches[i]).append(" ");

            if (i % 20 == 0)
            {
                answer.append("\n");
            }
        }

        System.out.print(answer);
    }
}
