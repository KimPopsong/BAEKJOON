import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long stone = Long.parseLong(br.readLine());

		int left = (int) (stone % 7);

		if (left == 0 || left == 2) {
			System.out.println("CY");
		}

		else {
			System.out.println("SK");
		}
	}
}
