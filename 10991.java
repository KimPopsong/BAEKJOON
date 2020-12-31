import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        for (int line = 0; line < n - 1; line++)
        {
            for (int outerSpace = 0; outerSpace < n - line - 2; outerSpace++)
            {
                System.out.print(' ');
            }

            for (int star = 0; star <= line; star++)
            {
                System.out.print(" *");
            }

            System.out.println();
        }

        System.out.print('*');

        for (int lastLine = 0; lastLine < n - 1; lastLine++)
        {
            System.out.print(" *");
        }
    }
}
