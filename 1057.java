import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int wholeRound, kim, lim;
        int round = 1;

        wholeRound = scanner.nextInt();
        kim = scanner.nextInt();
        lim = scanner.nextInt();

        if (kim > lim)  // Swap
        {
            int temp = kim;
            kim = lim;
            lim = temp;
        }

        while (true)
        {
            if (kim % 2 == 1)
            {
                if (kim + 1 == lim)
                {
                    System.out.println(round);

                    return;
                }
            }

            if (kim % 2 == 1)
            {
                kim = kim / 2 + 1;
            }

            else
            {
                kim /= 2;
            }

            if (lim % 2 == 1)
            {
                lim = lim / 2 + 1;
            }

            else
            {
                lim /= 2;
            }

            round += 1;
        }
    }
}
