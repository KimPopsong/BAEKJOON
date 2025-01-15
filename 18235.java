import java.io.*;
import java.util.*;

class Main {
	static int length, duckA, duckB, day = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().split(" ");

		length = Integer.parseInt(temp[0]);
		duckA = Integer.parseInt(temp[1]);
		duckB = Integer.parseInt(temp[2]);

		ArrayDeque<Integer> duckAPlace = new ArrayDeque<>();
		ArrayDeque<Integer> duckBPlace = new ArrayDeque<>();

		duckAPlace.add(duckA);
		duckBPlace.add(duckB);

		boolean flag = false;
		while (!duckAPlace.isEmpty() && !duckBPlace.isEmpty()) {
			int distance = (int) Math.pow(2, day);
			int[] isVisit = new int[length + 1];

			ArrayDeque<Integer> duckATemp = new ArrayDeque<>(duckAPlace);
			ArrayDeque<Integer> duckBTemp = new ArrayDeque<>(duckBPlace);

			duckAPlace.clear();
			duckBPlace.clear();

			while (!duckATemp.isEmpty()) {
				int duck = duckATemp.remove();

				int duckP = duck + distance;
				int duckM = duck - distance;

				if (duckP <= length) // 범위 안에 있고
				{
					if (isVisit[duckP] == 0) // 방문하지 않았다면
					{
						isVisit[duckP] = 1;
						duckAPlace.add(duckP);
					}
				}

				if (1 <= duckM) {
					if (isVisit[duckM] == 0) {
						isVisit[duckM] = 1;
						duckAPlace.add(duckM);
					}
				}
			}

			while (!duckBTemp.isEmpty()) {
				int duck = duckBTemp.remove();

				int duckP = duck + distance;
				int duckM = duck - distance;

				if (duckP <= length) // 범위 안에 있고
				{
					if (isVisit[duckP] == 0) // 방문하지 않았다면
					{
						isVisit[duckP] = 2;
						duckBPlace.add(duckP);
					}

					else if (isVisit[duckP] == 1) // 만났다면
					{
						duckAPlace.clear();
						duckBPlace.clear();
						duckATemp.clear();
						duckBTemp.clear();

						flag = true;

						break;
					}
				}

				if (1 <= duckM) {
					if (isVisit[duckM] == 0) {
						isVisit[duckM] = 1;
						duckBPlace.add(duckM);
					}

					else if (isVisit[duckM] == 1) // 만났다면
					{
						duckAPlace.clear();
						duckBPlace.clear();
						duckATemp.clear();
						duckBTemp.clear();

						flag = true;

						break;
					}
				}
			}

			day++;
		}

		if (flag == false) // 만약 만나지 못했을 경우
		{
			day = -1;
		}

		System.out.println(day);
	}
}
