import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        Set<Character> smallRainbow = new HashSet<>(Set.of('r', 'o', 'y', 'g', 'b', 'i', 'v'));
        Set<Character> largeRainbow = new HashSet<>(Set.of('R', 'O', 'Y', 'G', 'B', 'I', 'V'));

        int length = Integer.parseInt(br.readLine());
        String str = br.readLine();

        for (int i = 0; i < length; i++)
        {
            char c = str.charAt(i);

            smallRainbow.remove(c);
            largeRainbow.remove(c);
        }

        if (smallRainbow.isEmpty() && largeRainbow.isEmpty())
        {
            System.out.println("YeS");
        }

        else if (smallRainbow.isEmpty())
        {
            System.out.println("yes");
        }

        else if (largeRainbow.isEmpty())
        {
            System.out.println("YES");
        }

        else
        {
            System.out.println("NO!");
        }
    }
}
