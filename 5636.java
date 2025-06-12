import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        // 입력부 시작

        int studentNumber = Integer.parseInt(br.readLine());
        ArrayList<Student> students = new ArrayList<>();

        for (int i = 0; i < studentNumber; i++)
        {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());

            students.add(new Student(name, year, month, day));
        }

        // 입력부 종료

        students.sort(new Comparator<>() {
            @Override
            public int compare(Student s1, Student s2)
            {
                if (s1.year == s2.year)
                {
                    if (s1.month == s2.month)
                    {
                        return Integer.compare(s1.day, s2.day);
                    }

                    else
                    {
                        return Integer.compare(s1.month, s2.month);
                    }
                }

                else
                {
                    return Integer.compare(s1.year, s2.year);
                }
            }
        });

        sb.append(students.get(studentNumber - 1).name).append("\n").append(students.get(0).name);

        System.out.print(sb);
    }

    static class Student {
        String name;
        int year, month, day;

        Student(String name, int year, int month, int day)
        {
            this.name = name;
            this.year = year;
            this.month = month;
            this.day = day;
        }
    }
}
