import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        boolean flag;
        int[] color;
        ArrayList<Integer>[] lines;

        for (int tc = 0; tc < testCase; tc++)
        {
            int circleNumber, lineNumber;

            st = new StringTokenizer(br.readLine());

            circleNumber = Integer.parseInt(st.nextToken());
            lineNumber = Integer.parseInt(st.nextToken());

            flag = true;
            color = new int[circleNumber + 1];
            lines = new ArrayList[circleNumber + 1];

            for (int i = 1; i <= circleNumber; i++)
            {
                lines[i] = new ArrayList<>();
            }

            for (int i = 0; i < lineNumber; i++)
            {
                st = new StringTokenizer(br.readLine());

                int c1 = Integer.parseInt(st.nextToken());
                int c2 = Integer.parseInt(st.nextToken());

                lines[c1].add(c2);
                lines[c2].add(c1);
            }

            for (int circle = 1; circle <= circleNumber && flag; circle++)
            {
                if (color[circle] != 0)  // 이미 색상이 칠해져 있다면 생략
                {
                    continue;
                }

                ArrayDeque<Integer> bfs = new ArrayDeque<>();

                bfs.add(circle);
                color[circle] = 1;

                while (!bfs.isEmpty() && flag)
                {
                    int c = bfs.removeFirst();

                    for (int cc : lines[c])
                    {
                        if (color[cc] == 0)
                        {
                            color[cc] = -color[c];
                            bfs.addLast(cc);
                        }

                        else if (color[cc] == color[c])
                        {
                            flag = false;

                            break;
                        }
                    }
                }
            }

            if (flag)
            {
                answer.append("possible").append("\n");
            }

            else
            {
                answer.append("impossible").append("\n");
            }
        }

        System.out.print(answer);
    }
}
