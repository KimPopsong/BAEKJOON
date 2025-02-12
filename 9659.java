import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long stone = Long.parseLong(br.readLine());

		if (stone % 2 == 0) {
			System.out.println("CY");
		}

		else {
			System.out.println("SK");
		}
	}
}
