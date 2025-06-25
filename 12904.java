import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        String start = br.readLine();
        String target = br.readLine();

        while (start.length() != target.length())
        {
            char alpha = target.charAt(target.length() - 1);

            if (alpha == 'A')
            {
                target = target.substring(0, target.length() - 1);
            }

            else  // B일 경우
            {
                target = target.substring(0, target.length() - 1);
                target = new StringBuilder(target).reverse().toString();
            }
        }

        if (start.equals(target))
        {
            System.out.println(1);
        }

        else
        {
            System.out.println(0);
        }
    }
}
