import java.util.*;
import java.io.*;

public class Main {
    static int studentNumber, answer;
    static boolean[] isDone, isVisit;
    static int[] students;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < testCase; tc++)
        {
            // 입력 및 초기화 시작

            studentNumber = Integer.parseInt(br.readLine());
            answer = 0;
            isDone = new boolean[studentNumber + 1];
            isVisit = new boolean[studentNumber + 1];
            students = new int[studentNumber + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= studentNumber; i++)
            {
                students[i] = Integer.parseInt(st.nextToken());
            }

            // 입력 및 초기화 끝

            for (int s = 1; s <= studentNumber; s++)  // 1번 학생부터 탐색
            {
                dfs(s);
            }

            sb.append(studentNumber - answer).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int student)
    {
        if (isVisit[student])
        {
            return;
        }

        isVisit[student] = true;
        int nextStudent = students[student];

        if (!isVisit[nextStudent])
        {
            dfs(nextStudent);
        }

        else if (!isDone[nextStudent])
        {
            answer += 1;

            for (int i = nextStudent; i != student; i = students[i])
            {
                answer += 1;
            }
        }

        isDone[student] = true;
    }
}
