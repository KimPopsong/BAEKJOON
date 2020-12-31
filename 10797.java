import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int day = scanner.nextInt();

        int count = 0;

        for(int i = 0; i < 5; i++)
        {
            int temp = scanner.nextInt();

            if (temp == day)
            {
                count++;
            }
        }

        System.out.println(count);

        scanner.close();
    }
}
