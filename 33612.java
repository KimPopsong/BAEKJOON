import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        if (n == 1)
        {
            System.out.println("2024 8");
        }

        else if (n == 2)
        {
            System.out.println("2025 3");
        }

        else if (n == 3)
        {
            System.out.println("2025 10");
        }

        else if (n == 4)
        {
            System.out.println("2026 5");
        }

        else
        {
            System.out.println("2026 12");
        }
    }
}
