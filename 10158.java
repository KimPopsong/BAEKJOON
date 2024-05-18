import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int width, height;
        int antX, antY;
        int time;

        String[] temp = br.readLine().split(" ");
        width = Integer.parseInt(temp[0]);
        height = Integer.parseInt(temp[1]);

        temp = br.readLine().split(" ");
        antX = Integer.parseInt(temp[0]);
        antY = Integer.parseInt(temp[1]);

        time = Integer.parseInt(br.readLine());

        int t = time;
        t = t % (width * 2);
        if (width - antX < t)
        {
            t = t - (width - antX);
            antX = width;

            if (t > width)
            {
                antX = t - width;
            }

            else
            {
                antX = width - t;
            }
        }

        else
        {
            antX = antX + t;
        }

        t = time;
        t = t % (height * 2);
        if (height - antY < t)
        {
            t = t - (height - antY);
            antY = height;

            if (t > height)
            {
                antY = t - height;
            }

            else
            {
                antY = height - t;
            }
        }

        else
        {
            antY = antY + t;
        }

        sb.append(antX).append(" ").append(antY);
        System.out.println(sb);
    }
}
