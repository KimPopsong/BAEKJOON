import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int gateNumber, airplaneNumber, answer;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        gateNumber = Integer.parseInt(br.readLine());
        airplaneNumber = Integer.parseInt(br.readLine());

        parent = new int[gateNumber + 1];

        for (int i = 1; i <= gateNumber; i++) {
            parent[i] = i;
        }

        for (int t = 0; t < airplaneNumber; t++) {
            int ap = Integer.parseInt(br.readLine());

            int p = findParent(ap);

            if (p == 0) {
                break;
            }

            parent[p] = p - 1;
            answer += 1;
        }

        System.out.print(answer);
    }

    static int findParent(int ap) {
        if (parent[ap] == ap) {
            return ap;
        }

        return parent[ap] = findParent(parent[ap]);
    }
}
