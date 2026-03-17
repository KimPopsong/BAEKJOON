import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    static int target, length = Integer.MAX_VALUE;
    static ArrayList<Integer> goldMinsu = new ArrayList<>();  // 금민수
    static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder printAnswer = new StringBuilder();

        target = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> findGoldMinsu = new ArrayDeque<>();
        findGoldMinsu.add(4);
        findGoldMinsu.add(7);

        while (!findGoldMinsu.isEmpty()) {
            int n = findGoldMinsu.removeFirst();

            goldMinsu.add(n);

            int n4 = n * 10 + 4;
            int n7 = n * 10 + 7;

            if (n4 <= target) {
                findGoldMinsu.addLast(n4);
            }

            if (n7 <= target) {
                findGoldMinsu.addLast(n7);
            }
        }

        boolean[] isVisit = new boolean[target + 1];
        ArrayDeque<Comb> bfs = new ArrayDeque<>();

        bfs.add(new Comb(0, new ArrayList<>()));
        while (!bfs.isEmpty()) {
            Comb comb = bfs.removeFirst();

            for (int num : goldMinsu) {
                if (comb.sum + num > target || isVisit[comb.sum + num]) {
                    continue;
                } else if (comb.sum + num < target) {
                    ArrayList<Integer> newNumbers = new ArrayList<>(comb.numbers);
                    newNumbers.add(num);

                    isVisit[comb.sum + num] = true;
                    bfs.addLast(new Comb(comb.sum + num, newNumbers));
                } else if (comb.sum + num == target) {
                    if (comb.numbers.size() + 1 < length) {
                        length = comb.numbers.size() + 1;
                        answer = new ArrayList<>(comb.numbers);
                        answer.add(num);
                    } else if (comb.numbers.size() + 1 == length) {
                        ArrayList<Integer> newNumbers = new ArrayList<>(comb.numbers);
                        newNumbers.add(num);

                        Collections.sort(answer);
                        Collections.sort(newNumbers);

                        for (int i = 0; i < length; i++) {
                            if (answer.get(i) > newNumbers.get(i)) {
                                answer = newNumbers;

                                break;
                            } else if (answer.get(i) < newNumbers.get(i)) {
                                break;
                            }
                        }
                    }
                }
            }
        }

        if (answer.isEmpty()) {
            printAnswer.append(-1);
        } else {
            for (int i : answer) {
                printAnswer.append(i).append(" ");
            }
        }

        System.out.print(printAnswer);
    }

    static class Comb {

        int sum;
        ArrayList<Integer> numbers;

        Comb(int sum, ArrayList<Integer> numbers) {
            this.sum = sum;
            this.numbers = numbers;
        }
    }
}
