import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int stone = Integer.parseInt(br.readLine());

		if (stone % 2 == 1) {
			System.out.println("CY");
		}

		else {
			System.out.println("SK");
		}
	}
}
