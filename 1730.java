import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        String[][] canvas = new String[size][size];
        String[] command = br.readLine().split("");

        for (int r = 0; r < size; r++)  // 캔버스 초기화
        {
            for (int c = 0; c < size; c++)
            {
                canvas[r][c] = ".";
            }
        }

        int r = 0, c = 0;  // 로봇 팔의 좌표
        for (String com : command)  // 로봇 팔 움직이기
        {
            if (Objects.equals(com, "U"))  // 상
            {
                if (r - 1 < 0)  // 범위를 벗어나면 무시
                {
                    continue;
                }

                drawVertical(canvas, r, c);

                r -= 1;

                drawVertical(canvas, r, c);
            }

            else if (Objects.equals(com, "D"))  // 하
            {
                if (r + 1 >= size)
                {
                    continue;
                }

                drawVertical(canvas, r, c);

                r += 1;

                drawVertical(canvas, r, c);
            }

            else if (Objects.equals(com, "L"))  // 좌
            {
                if (c - 1 < 0)
                {
                    continue;
                }

                drawHorizontal(canvas, r, c);

                c -= 1;

                drawHorizontal(canvas, r, c);
            }

            else if (Objects.equals(com, "R")) // 우
            {
                if (c + 1 >= size)
                {
                    continue;
                }

                drawHorizontal(canvas, r, c);

                c += 1;

                drawHorizontal(canvas, r, c);
            }
        }

        for (int rr = 0; rr < size; rr++)
        {
            for (int cc = 0; cc < size; cc++)
            {
                System.out.printf(canvas[rr][cc]);
            }
            System.out.println();
        }
    }

    public static void drawVertical(String[][] canvas, int r, int c)  // 수직선 그리기
    {
        if (canvas[r][c].equals("."))
        {
            canvas[r][c] = "|";
        }

        else if (canvas[r][c].equals("-"))
        {
            canvas[r][c] = "+";
        }
    }

    public static void drawHorizontal(String[][] canvas, int r, int c)  // 수평선 그리기
    {
        if (canvas[r][c].equals("."))
        {
            canvas[r][c] = "-";
        }

        else if (canvas[r][c].equals("|"))
        {
            canvas[r][c] = "+";
        }
    }
}
