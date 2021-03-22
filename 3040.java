import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dwarf = new int[9];
        int sum = 0;
        int idx1 = 0, idx2 = 0;
        boolean flag = false;

        for (int i = 0; i < 9; i++)
        {
            int temp = sc.nextInt();
            dwarf[i] = temp;
            sum += temp;
        }

        for (int i = 0; i < 8; i++)
        {
            for (int j = i + 1; j < 9; j++)
            {
                if (sum - dwarf[i] - dwarf[j] == 100)
                {
                    idx1 = i;
                    idx2 = j;

                    flag = true;
                    break;
                }
            }

            if (flag)
            {
                break;
            }
        }

        for(int i = 0; i < 9; i++)
        {
            if(i == idx1 || i == idx2)
            {
                continue;
            }

            else
            {
                System.out.println(dwarf[i]);
            }
        }
    }
}
