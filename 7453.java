import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class Main {
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        Long count = 0L;
        int length = Integer.parseInt(br.readLine());

        int[] arrA = new int[length];
        int[] arrB = new int[length];
        int[] arrC = new int[length];
        int[] arrD = new int[length];

        int[] sumAB = new int[length * length];
        int[] sumCD = new int[length * length];

        for (int i = 0; i < length; i++)
        {
            st = new StringTokenizer(br.readLine());
            arrA[i] = Integer.parseInt(st.nextToken());
            arrB[i] = Integer.parseInt(st.nextToken());
            arrC[i] = Integer.parseInt(st.nextToken());
            arrD[i] = Integer.parseInt(st.nextToken());
        }

        int nod = 0;
        for (int a : arrA)
        {
            for (int b : arrB)
            {
                sumAB[nod++] = a + b;
            }
        }

        nod = 0;
        for (int c : arrC)
        {
            for (int d : arrD)
            {
                sumCD[nod++] = c + d;
            }
        }

        Arrays.sort(sumAB);
        Arrays.sort(sumCD);

        int abNode = 0;
        int cdNode = length * length - 1;
        while (true)
        {
            int sumABCD = sumAB[abNode] + sumCD[cdNode];

            if (sumABCD > 0)
            {
                cdNode -= 1;
            }

            else if (sumABCD < 0)
            {
                abNode += 1;
            }

            else
            {
                int ab = 1;
                int cd = 1;

                while (true)
                {
                    abNode += 1;

                    if (abNode > length * length - 1)
                    {
                        break;
                    }

                    else if (sumAB[abNode] != sumAB[abNode - 1])
                    {
                        break;
                    }

                    else
                    {
                        ab += 1;
                    }
                }

                while (true)
                {
                    cdNode -= 1;

                    if (cdNode < 0)
                    {
                        break;
                    }

                    else if (sumCD[cdNode] != sumCD[cdNode + 1])
                    {
                        break;
                    }

                    else
                    {
                        cd += 1;
                    }
                }

                count += (long) ab * (long) cd;
            }

            if (abNode > length * length - 1 || cdNode < 0)
            {
                break;
            }
        }

        System.out.println(count);
    }
}
