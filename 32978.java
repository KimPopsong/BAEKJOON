import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int ingredientNumber = Integer.parseInt(br.readLine());
        Set<String> ingredients = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            ingredients.add(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            ingredients.remove(st.nextToken());
        }

        for (String ing : ingredients) {
            System.out.print(ing);
        }
    }
}
