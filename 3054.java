import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String word;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        word = br.readLine();

        printFirstLine();
        printSecondLine();
        printMiddleLine();
        printSecondLine();
        printFirstLine();

        System.out.print(sb);
    }

    static void printFirstLine() {
        sb.append("..");

        for (int i = 1; i <= word.length(); i++) {
            if (i % 3 == 0) {
                sb.append("*");
            } else {
                sb.append("#");
            }

            if (i != word.length()) {
                sb.append("...");
            }
        }

        sb.append("..").append("\n");
    }

    static void printSecondLine() {
        for (int i = 1; i <= word.length(); i++) {
            if (i % 3 == 0) {
                sb.append(".*.*");
            } else {
                sb.append(".#.#");
            }
        }

        sb.append(".").append("\n");
    }

    static void printMiddleLine() {
        sb.append("#.");
        boolean needLeadingDot = false;

        for (int i = 1; i <= word.length(); i++) {
            if (needLeadingDot) {
                sb.append('.');
            }

            sb.append(word.charAt(i - 1));

            if (i % 3 == 0) {
                sb.append(".*");
                needLeadingDot = true;
            } else if (i == word.length()) {
                sb.append(".#");
                needLeadingDot = false;
            } else if (i % 3 == 2) {
                sb.append(".*.");
                needLeadingDot = false;
            } else {
                sb.append(".#.");
                needLeadingDot = false;
            }
        }

        sb.append("\n");
    }
}
