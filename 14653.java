import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int peopleNumber, messageNumber, messageTarget;
    static Set<Character> people = new HashSet<>();
    static ArrayList<Message> messages = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        peopleNumber = Integer.parseInt(st.nextToken());
        messageNumber = Integer.parseInt(st.nextToken());
        messageTarget = Integer.parseInt(st.nextToken());

        for (int i = 66; i < 65 + peopleNumber; i++) {
            people.add((char) i);
        }

        for (int i = 0; i < messageNumber; i++) {
            st = new StringTokenizer(br.readLine());

            int notRead = Integer.parseInt(st.nextToken());
            char sender = st.nextToken().charAt(0);

            messages.add(new Message(sender, notRead));
        }

        if (messages.get(messageTarget - 1).notRead == 0) {  // 모두 읽었다면
            answer.append(-1);
        } else {
            int start = messageTarget - 1;

            while (0 < start && messages.get(start - 1).notRead == start) {
                start -= 1;
            }

            for (int i = start; i < messageNumber; i++) {
                people.remove(messages.get(i).sender);
            }

            if (people.isEmpty()) {
                answer.append(-1);
            } else {
                for (char c : people) {
                    answer.append(c).append(" ");
                }
            }
        }

        System.out.print(answer);
    }

    static class Message {

        char sender;
        int notRead;

        public Message(char sender, int notRead) {
            this.sender = sender;
            this.notRead = notRead;
        }
    }
}
