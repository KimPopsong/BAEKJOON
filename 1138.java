import java.util.*;
import java.io.*;

public class Main {
    static int humanNumber;
    static int[] humans, answer;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        humanNumber = Integer.parseInt(br.readLine());

        humans = new int[humanNumber];
        answer = new int[humanNumber];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < humanNumber; i++)
        {
            humans[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < humanNumber; i++)
        {
            int node = humans[i];

            for (int j = 0; j < humanNumber; j++)
            {
                if (answer[j] == 0)
                {
                    if (node == 0)
                    {
                        answer[j] = i + 1;

                        break;
                    }

                    else
                    {
                        node -= 1;
                    }
                }
            }
        }

        for (int i : answer)
        {
            sb.append(i).append(' ');
        }

        System.out.println(sb);
    }
}
