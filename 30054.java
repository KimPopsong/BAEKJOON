import java.io.*;
import java.util.*;

class Main {
	static int customerNumber, maxWaitTime = 0; // 손님의 수, 가장 오래 기다린 시간
	static Customer[] customerInfo = new Customer[200001]; // 인덱스 -> 에약한 시간
	static boolean[] isVisit = new boolean[200001]; // 방문했는지

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		customerNumber = Integer.parseInt(br.readLine());

		// 도착 순으로 정렬. 동시 도착시 예약 순으로 정렬
		PriorityQueue<Customer> customers = new PriorityQueue<>(new Comparator<Customer>() {
			@Override
			public int compare(Customer c1, Customer c2) {
				if (c1.arrivalTime == c2.arrivalTime) {
					return c1.reserveTime - c2.reserveTime;
				}

				else {
					return c1.arrivalTime - c2.arrivalTime;
				}
			}
		});

		for (int i = 0; i < customerNumber; i++) {
			st = new StringTokenizer(br.readLine()); // 예약 시간, 도착 시간 순으로 입력

			int reserve = Integer.parseInt(st.nextToken());
			int arrival = Integer.parseInt(st.nextToken());

			Customer customer = new Customer(reserve, arrival);

			customerInfo[reserve] = customer;
			customers.add(customer);
		}

		for (int t = 1;; t++) {
			if (t <= 200000 && customerInfo[t] != null && customerInfo[t].arrivalTime <= t) { // t시간에 예약한 손님이 늦지않았다면
				if (isVisit[t] == false) { // 손님이 들어가지 않았다면
					isVisit[t] = true;

					maxWaitTime = Math.max(maxWaitTime, t - customerInfo[t].arrivalTime);

					continue;
				}
			}

			if (customers.isEmpty()) { // 남은 손님이 없다면
				break;
			}

			if (customers.peek().arrivalTime > t) { // 손님이 아직 도착 이전이라면
				continue; // 넘어가기
			}

			Customer customer = customers.remove();

			if (isVisit[customer.reserveTime] == false) {
				isVisit[customer.reserveTime] = true;

				maxWaitTime = Math.max(maxWaitTime, t - customer.arrivalTime);
			}

			else { // 이미 방문한 사람이라면
				t -= 1;
			}
		}

		System.out.println(maxWaitTime);
	}

	static class Customer {
		int reserveTime; // 예약 시간
		int arrivalTime; // 도착 시간

		Customer(int reserveTime, int arrivalTime) {
			this.reserveTime = reserveTime;
			this.arrivalTime = arrivalTime;
		}
	}
}
