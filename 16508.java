import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int bookNumber, price = Integer.MAX_VALUE;
    static char[] targetString;
    static int[] target = new int[26];
    static ArrayList<Book> books = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        targetString = br.readLine().toCharArray();
        for (char c : targetString) {
            target[c - 'A'] += 1;
        }

        bookNumber = Integer.parseInt(br.readLine());

        for (int i = 0; i < bookNumber; i++) {
            st = new StringTokenizer(br.readLine());

            int price = Integer.parseInt(st.nextToken());
            char[] bookName = st.nextToken().toCharArray();

            Book book = new Book(price, bookName);

            books.add(book);
        }

        for (int pick = 1; pick <= bookNumber; pick++) {
            bruteforce(pick, 0, 0, 0, target);
        }

        if (price == Integer.MAX_VALUE) {
            System.out.print(-1);
        } else {
            System.out.print(price);
        }
    }

    static void bruteforce(int maxDepth, int depth, int index, int sumPrice, int[] tA) {
        if (maxDepth == depth) {
            boolean flag = true;

            for (int i : tA) {
                if (i > 0) {
                    flag = false;

                    break;
                }
            }

            if (flag) {
                price = Math.min(price, sumPrice);
            }
            return;
        }

        for (int i = index; i < bookNumber; i++) {
            int[] newTA = tA.clone();
            Book book = books.get(i);

            for (int j = 0; j < 26; j++) {
                newTA[j] = Math.max(0, newTA[j] - book.alphabets[j]);
            }

            bruteforce(maxDepth, depth + 1, i + 1, sumPrice + book.price, newTA);
        }
    }

    static class Book {
        int price;
        int[] alphabets = new int[26];

        Book(int price, char[] bookName) {
            this.price = price;

            for (char c : bookName) {
                alphabets[c - 'A'] += 1;
            }
        }
    }
}
