import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++)
        {
            int count = 0;  // 뒷 걸음질 친 횟수
            String[] temp = br.readLine().split(" ");
            List<Integer> students = new ArrayList<>();

            for (int s = 1; s <= 20; s++)
            {
                int student = Integer.parseInt(temp[s]);

                for (int j = 0; j < students.size(); j++)
                {
                    if (students.get(j) > student)
                    {
                        count += 1;
                    }
                }

                students.add(student);
                Collections.sort(students);
            }

            sb.append(i).append(" ").append(count).append("\n");
        }

        System.out.println(sb);
    }
}

/*
points.sort(new Comparator<Point>() {
            @Override
            public int compare(Point point, Point t1)
            {
                return 0;
            }
        });
 */
