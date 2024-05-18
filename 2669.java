import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int area = 0;
        int[][] planes = new int[101][101];

        for (int i = 0; i < 4; i++)
        {
            String[] temp = br.readLine().split(" ");

            for (int r = Integer.parseInt(temp[0]); r < Integer.parseInt(temp[2]); r++)
            {
                for (int c = Integer.parseInt(temp[1]); c < Integer.parseInt(temp[3]); c++)
                {
                    planes[r][c] = 1;
                }
            }
        }

        for (int i = 0; i < 101; i++)
        {
            for (int j = 0; j < 101; j++)
            {
                area += planes[i][j];
            }
        }

        System.out.println(area);
    }
}
