import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int honeySize;

        honeySize = Integer.parseInt(br.readLine().strip());
        int[] honey = new int[honeySize];
        String[] temp = br.readLine().split(" ");

        for (int i = 0; i < honeySize; i++)
        {
            honey[i] = Integer.parseInt(temp[i]);
        }

        // 벌통이 맨 오른쪽에 있을 경우
        int maxHoneyLeft = 0;
        for (int b = 2; b < honeySize; b++)  // 맨 왼쪽 두 칸 빼고 모든 칸을 더해주고
        {
            maxHoneyLeft += honey[b];
        }
        maxHoneyLeft *= 2;

        int tLeft = maxHoneyLeft;
        for (int b = 2; b < honeySize - 1; b++)  // 두 번째 벌이 한 칸씩 우측으로 이동하면서 값이 더 커지는지 확인
        {
            tLeft = tLeft + honey[b - 1] - 2 * honey[b];  // 이동시마다 이동 전 자리를 더해주고, 이동 한 자리는 2배만큼 빼줌

            if (maxHoneyLeft <= tLeft)
            {
                maxHoneyLeft = tLeft;
            }
        }

        // 벌통이 맨 왼쪽에 있을 경우
        int maxHoneyRight = 0;
        for (int b = 0; b < honeySize - 2; b++)
        {
            maxHoneyRight += honey[b];
        }
        maxHoneyRight *= 2;

        int tRight = maxHoneyRight;
        for (int b = honeySize - 3; b >= 1; b--)  // 벌이 한 칸씩 좌측으로 이동하면서 값이 커지는지 확인
        {
            tRight = tRight + honey[b + 1] - 2 * honey[b];

            if (maxHoneyRight <= tRight)
            {
                maxHoneyRight = tRight;
            }
        }

        // 벌통이 가운데 있을 경우
        int maxHoneyMiddle = honey[1];
        for (int b = 1; b < honeySize - 1; b++)
        {
            maxHoneyMiddle += honey[b];
        }

        for (int beeHive = 2; beeHive <= honeySize - 2; beeHive++)
        {
            int t = maxHoneyMiddle;

            t = t + honey[beeHive] - honey[beeHive - 1];

            if (t > maxHoneyMiddle)
            {
                maxHoneyMiddle = t;
            }
        }

        sb.append(Math.max(Math.max(maxHoneyLeft, maxHoneyRight), maxHoneyMiddle));
        System.out.println(sb);
    }
}
