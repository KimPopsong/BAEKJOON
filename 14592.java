import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int participantsNumber = Integer.parseInt(br.readLine());
        PriorityQueue<Result> pq = new PriorityQueue<>();

        for (int i = 1; i <= participantsNumber; i++) {
            st = new StringTokenizer(br.readLine());

            pq.add(new Result(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        System.out.print(pq.remove().id);
    }

    static class Result implements Comparable<Result> {
        int id, score, submit, upload;

        Result(int id, int score, int submit, int upload) {
            this.id = id;
            this.score = score;
            this.submit = submit;
            this.upload = upload;
        }

        @Override
        public int compareTo(Result r) {
            if (this.score == r.score) {
                if (this.submit == r.submit) {
                    return Integer.compare(this.upload, r.upload);
                }

                return Integer.compare(this.submit, r.submit);
            }

            return Integer.compare(r.score, this.score);
        }
    }
}
