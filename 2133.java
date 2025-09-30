import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static int size;
    static int[] tiles = new int[31];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        size = Integer.parseInt(br.readLine());

        if (size % 2 == 1) {
            System.out.println(0);
        } else {
            tiles[2] = 3;
            tiles[4] = 11;

            for (int i = 6; i <= size; i += 2) {
                tiles[i] = tiles[i - 2] * 4 - tiles[i - 4];
            }

            System.out.println(tiles[size]);
        }
    }
}
