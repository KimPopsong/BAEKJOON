import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int problemNumber;
    static Map<Integer, Set<Problem>> problemsList = new HashMap<>();
    static PriorityQueue<Problem> problems = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력부 시작

        problemNumber = Integer.parseInt(br.readLine());

        for (int i = 0; i < problemNumber; i++) {
            st = new StringTokenizer(br.readLine());

            Problem p = new Problem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            problemsList.computeIfAbsent(p.deadLine, k -> new HashSet<>()).add(p);
        }

        // 입력부 종료

        for (int time = 1; time <= problemNumber; time++) {
            if (!problemsList.containsKey(time)) {
                continue;
            }

            problems.addAll(problemsList.get(time));

            while (problems.size() > time) {
                problems.remove();
            }
        }

        int sum = 0;
        while (!problems.isEmpty()) {
            sum += problems.remove().cupRamen;
        }

        System.out.println(sum);
    }

    static class Problem implements Comparable<Problem> {
        int deadLine, cupRamen;

        Problem(int deadLine, int cupRamen) {
            this.deadLine = deadLine;
            this.cupRamen = cupRamen;
        }

        @Override
        public int compareTo(Problem p) {
            return Integer.compare(this.cupRamen, p.cupRamen);
        }
    }
}
