import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long number = Long.parseLong(br.readLine());

        long nod = 0;
        long n = 0;

        while (n <= number)
        {
            nod += 1;
            n += nod;
        }

        System.out.println(nod - 1);
    }
}
