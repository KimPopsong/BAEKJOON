import java.io.*;
import java.util.*;

class Main {
	static int cityNumber, busNumber; // 도시의 개수, 버스의 개수
	static int startCity, arrivalCity; // 출발 도시, 도착 도시
	static Map<Integer, Map<Integer, Integer>> buses = new HashMap<>(); // 버스의 정보. { 출발 도시 : { 도착 도시 : 비용 }}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		cityNumber = Integer.parseInt(br.readLine());
		busNumber = Integer.parseInt(br.readLine());

		for (int i = 1; i <= cityNumber; i++) {
			buses.put(i, new HashMap<>());
		}

		for (int i = 0; i < busNumber; i++) { // 버스의 정보 입력
			st = new StringTokenizer(br.readLine());

			int city1 = Integer.parseInt(st.nextToken());
			int city2 = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());

			if (buses.get(city1).containsKey(city2)) { // 이미 버스가 있다면
				int p = buses.get(city1).get(city2);

				if (price < p) { // 새로 들어온 비용이 더 적다면
					buses.get(city1).put(city2, price); // 갱신
				}
			}

			else {
				buses.get(city1).put(city2, price);
			}
		}

		st = new StringTokenizer(br.readLine());

		startCity = Integer.parseInt(st.nextToken());
		arrivalCity = Integer.parseInt(st.nextToken());

		// 입력부 종료

		// startCity 기준으로 노드들의 거리 구하기
		PriorityQueue<City> pq = new PriorityQueue<>();
		boolean[] isVisit = new boolean[cityNumber + 1];

		isVisit[startCity] = true;

		for (int key : buses.get(startCity).keySet()) {
			pq.add(new City(key, buses.get(startCity).get(key), new ArrayList<>(), startCity));
		}

		while (!pq.isEmpty()) {
			City city = pq.remove();

			if (isVisit[city.cityNumber]) { // 이미 방문한 노드라면
				continue; // 다시 방문하지 않기
			}

			isVisit[city.cityNumber] = true; // 방문처리

			if (city.cityNumber == arrivalCity) { // 도착했다면
				city.parents.add(city.cityNumber);

				System.out.println(city.price);
				System.out.println(city.parents.size());

				for (int p : city.parents) {
					System.out.print(p + " ");
				}

				pq.clear();
				break;
			}

			for (int key : buses.get(city.cityNumber).keySet()) {
				pq.add(new City(key, buses.get(city.cityNumber).get(key) + city.price, city.parents, city.cityNumber));
			}
		}
	}

	static class City implements Comparable<City> {
		int cityNumber;
		int price;
		ArrayList<Integer> parents = new ArrayList<>();

		City(int cityNumber, int price, ArrayList<Integer> parents, int parent) {
			this.cityNumber = cityNumber;
			this.price = price;
			this.parents = new ArrayList<>(parents);
			this.parents.add(parent);
		}

		@Override
		public int compareTo(City city) {
			return this.price - city.price;
		}
	}
}
