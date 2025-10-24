import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int size, maxBishop = 0;
    static boolean[] dl, dr;  // 비숍의 배치 위치 확인. dl -> 1, 7시 방향 확인. (r + c). dr -> 4시, 10시 방향 확인. |(r - c)|
    static List<int[]> white, black;  // 흰 색, 검은 색 분리

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        size = Integer.parseInt(br.readLine());
        dl = new boolean[size * 2 + 1];
        dr = new boolean[size * 2 + 1];
        white = new ArrayList<>();
        black = new ArrayList<>();

        for (int r = 0; r < size; r++) {  // 체스판 입력
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < size; c++) {
                int t = Integer.parseInt(st.nextToken());

                if (t == 1) {
                    if ((r + c) % 2 == 1)  // 홀수 일 경우 white
                    {
                        white.add(new int[]{r, c});
                    } else {
                        black.add(new int[]{r, c});
                    }
                }
            }
        }

        Collections.sort(white, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return Integer.compare(o1[1], o2[1]);
                }

                return Integer.compare(o1[0], o2[0]);
            }
        });

        Collections.sort(black, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return Integer.compare(o1[1], o2[1]);
                }

                return Integer.compare(o1[0], o2[0]);
            }
        });

        System.out.print(dfs(white, 0, 0) + dfs(black, 0, 0));
    }

    static int dfs(List<int[]> board, int index, int sum) {
        int temp = sum;

        for (int i = index; i < board.size(); i++) {
            int r = board.get(i)[0];
            int c = board.get(i)[1];

            if (!dl[r + c] && !dr[r - c + size]) {
                dl[r + c] = true;
                dr[r - c + size] = true;

                temp = Math.max(temp, dfs(board, i + 1, sum + 1));

                dl[r + c] = false;
                dr[r - c + size] = false;
            }
        }

        return temp;
    }
}
