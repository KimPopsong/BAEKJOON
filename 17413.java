import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        String origin = br.readLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();

        boolean tagFlag = false;
        for (int i = 0; i < origin.length(); i++) {
            char c = origin.charAt(i);

            if (c == '<') {
                while (!stack.isEmpty()) {
                    answer.append(stack.removeLast());
                }

                answer.append(c);
                tagFlag = true;
            } else if (c == '>') {
                answer.append(c);
                tagFlag = false;
            } else if (c == ' ') {
                while (!stack.isEmpty()) {
                    answer.append(stack.removeLast());
                }
                answer.append(" ");
            } else {
                if (tagFlag) {
                    answer.append(c);
                } else {
                    stack.addLast(c);
                }
            }
        }

        while (!stack.isEmpty()) {
            answer.append(stack.removeLast());
        }

        System.out.print(answer);
    }
}
