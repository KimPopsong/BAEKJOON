import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number, prime;
        long exponent = 0;

        String[] temp = br.readLine().split(" ");

        number = Integer.parseInt(temp[0]);
        prime = Integer.parseInt(temp[1]);

        while (number > 0)
        {
            number /= prime;
            exponent += number;
        }

        System.out.println(exponent);
    }
}
