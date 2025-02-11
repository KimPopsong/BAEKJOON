import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int materialNumber = Integer.parseInt(br.readLine());
		int armorNeed = Integer.parseInt(br.readLine());
		int count = 0;
		int[] materials = new int[materialNumber];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < materialNumber; i++) {
			materials[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < materialNumber - 1; i++) {
			int materialA = materials[i];

			for (int j = i + 1; j < materialNumber; j++) {
				if (materialA + materials[j] == armorNeed) {
					count += 1;
				}
			}
		}

		System.out.println(count);
	}
}
