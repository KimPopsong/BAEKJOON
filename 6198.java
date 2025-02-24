import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int buildingNumber = Integer.parseInt(br.readLine());
        int[] buildings = new int[buildingNumber];
        int[] canSee = new int[buildingNumber];
        ArrayDeque<Building> buildingStack = new ArrayDeque<>();

        for (int i = 0; i < buildingNumber; i++)
        {
            buildings[i] = Integer.parseInt(br.readLine());
        }

        for (int i = buildingNumber - 1; i >= 0; i--)  // 뒤부터 탐색
        {
            int sum = 0;

            while (true)
            {
                if (buildingStack.isEmpty())
                {
                    canSee[i] = sum;
                    buildingStack.addLast(new Building(buildings[i], i));

                    break;
                }

                else
                {
                    if (buildings[i] <= buildingStack.peekLast().height)
                    {
                        canSee[i] = sum;
                        buildingStack.addLast(new Building(buildings[i], i));

                        break;
                    }

                    else
                    {
                        sum += canSee[buildingStack.removeLast().index] + 1;
                    }
                }
            }
        }

        long sum = 0;
        for (int i : canSee)
        {
            sum += i;
        }

        System.out.println(sum);
    }

    static class Building {
        int height;
        int index;

        public Building(int height, int index)
        {
            this.height = height;
            this.index = index;
        }
    }
}
