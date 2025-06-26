import java.util.*;
import java.io.*;

public class Main {
    static int boardSize, answer;
    static int[][] board;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력부 시작

        boardSize = Integer.parseInt(br.readLine());

        board = new int[boardSize][boardSize];

        for (int r = 0; r < boardSize; r++)
        {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < boardSize; c++)
            {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        // 입력부 종료

        dfs(0, board);

        System.out.println(answer);
    }

    /**
     * dfs로 탐색하는 함수
     *
     * @param depth    5가 되면 확인 후 탈출
     * @param oldBoard 이전에 쓰였던 보드판
     */
    static void dfs(int depth, int[][] oldBoard)
    {
        if (depth == 5)  // 5번 이동시켰다면
        {
            findMaxNumber(oldBoard);

            return;
        }

        for (int d = 0; d < 4; d++)
        {
            int[][] newBoard = new int[boardSize][boardSize];

            for (int r = 0; r < boardSize; r++)  // 보드판 복사
            {
                for (int c = 0; c < boardSize; c++)
                {
                    newBoard[r][c] = oldBoard[r][c];
                }
            }

            if (d == 0)  // 위로 이동
            {
                moveUp(newBoard);
            }

            else if (d == 1)
            {
                moveDown(newBoard);
            }

            else if (d == 2)
            {
                moveLeft(newBoard);
            }

            else
            {
                moveRight(newBoard);
            }

            dfs(depth + 1, newBoard);
        }
    }

    static void moveUp(int[][] oldBoard)  // 위로 스와이프
    {
        for (int c = 0; c < boardSize; c++)  // 왼쪽 열부터 계산
        {
            ArrayDeque<Integer> queue = new ArrayDeque<>();

            for (int r = 0; r < boardSize; r++)  // 위에서 아래로
            {
                if (oldBoard[r][c] != 0)
                {
                    queue.addLast(oldBoard[r][c]);  // 큐에 넣고
                    oldBoard[r][c] = 0;  // 숫자 제거
                }
            }

            for (int r = 0; r < boardSize && !queue.isEmpty(); r++)
            {
                if (queue.size() >= 2)  // 두 개 이상 남았다면
                {
                    int n1 = queue.removeFirst();
                    int n2 = queue.removeFirst();

                    if (n1 == n2)  // 같은 수라 합쳐진다면
                    {
                        oldBoard[r][c] = n1 + n2;  // 합쳐서 저장
                    }

                    else  // 다른 수라면
                    {
                        oldBoard[r][c] = n1;  // 숫자 입력

                        queue.addFirst(n2);  // 기존 숫자는 다시 넣어두기
                    }
                }

                else  // 한 개 남았다면
                {
                    oldBoard[r][c] = queue.removeFirst();
                }
            }
        }
    }

    static void moveDown(int[][] oldBoard)  // 아래로 스와이프
    {
        for (int c = 0; c < boardSize; c++)  // 왼쪽 열부터 계산
        {
            ArrayDeque<Integer> queue = new ArrayDeque<>();

            for (int r = boardSize - 1; r >= 0; r--)  // 아래에서 위로
            {
                if (oldBoard[r][c] != 0)
                {
                    queue.addLast(oldBoard[r][c]);  // 큐에 넣고
                    oldBoard[r][c] = 0;  // 숫자 제거
                }
            }

            for (int r = boardSize - 1; r >= 0 && !queue.isEmpty(); r--)
            {
                if (queue.size() >= 2)  // 두 개 이상 남았다면
                {
                    int n1 = queue.removeFirst();
                    int n2 = queue.removeFirst();

                    if (n1 == n2)  // 같은 수라 합쳐진다면
                    {
                        oldBoard[r][c] = n1 + n2;  // 합쳐서 저장
                    }

                    else  // 다른 수라면
                    {
                        oldBoard[r][c] = n1;  // 숫자 입력

                        queue.addFirst(n2);  // 기존 숫자는 다시 넣어두기
                    }
                }

                else  // 한 개 남았다면
                {
                    oldBoard[r][c] = queue.removeFirst();
                }
            }
        }
    }

    static void moveLeft(int[][] oldBoard)  // 왼쪽으로 스와이프
    {
        for (int r = 0; r < boardSize; r++)  // 위쪽 행부터 계산
        {
            ArrayDeque<Integer> queue = new ArrayDeque<>();

            for (int c = 0; c < boardSize; c++)
            {
                if (oldBoard[r][c] != 0)
                {
                    queue.addLast(oldBoard[r][c]);  // 큐에 넣고
                    oldBoard[r][c] = 0;  // 숫자 제거
                }
            }

            for (int c = 0; c < boardSize && !queue.isEmpty(); c++)
            {
                if (queue.size() >= 2)  // 두 개 이상 남았다면
                {
                    int n1 = queue.removeFirst();
                    int n2 = queue.removeFirst();

                    if (n1 == n2)  // 같은 수라 합쳐진다면
                    {
                        oldBoard[r][c] = n1 + n2;  // 합쳐서 저장
                    }

                    else  // 다른 수라면
                    {
                        oldBoard[r][c] = n1;  // 숫자 입력

                        queue.addFirst(n2);  // 기존 숫자는 다시 넣어두기
                    }
                }

                else  // 한 개 남았다면
                {
                    oldBoard[r][c] = queue.removeFirst();
                }
            }
        }
    }

    static void moveRight(int[][] oldBoard)  // 오른쪽으로 스와이프
    {
        for (int r = 0; r < boardSize; r++)  // 위쪽 행부터 계산
        {
            ArrayDeque<Integer> queue = new ArrayDeque<>();

            for (int c = boardSize - 1; c >= 0; c--)
            {
                if (oldBoard[r][c] != 0)
                {
                    queue.addLast(oldBoard[r][c]);  // 큐에 넣고
                    oldBoard[r][c] = 0;  // 숫자 제거
                }
            }

            for (int c = boardSize - 1; c >= 0 && !queue.isEmpty(); c--)
            {
                if (queue.size() >= 2)  // 두 개 이상 남았다면
                {
                    int n1 = queue.removeFirst();
                    int n2 = queue.removeFirst();

                    if (n1 == n2)  // 같은 수라 합쳐진다면
                    {
                        oldBoard[r][c] = n1 + n2;  // 합쳐서 저장
                    }

                    else  // 다른 수라면
                    {
                        oldBoard[r][c] = n1;  // 숫자 입력

                        queue.addFirst(n2);  // 기존 숫자는 다시 넣어두기
                    }
                }

                else  // 한 개 남았다면
                {
                    oldBoard[r][c] = queue.removeFirst();
                }
            }
        }
    }

    /**
     * 보드에서 가장 큰 값을 찾는 함수
     *
     * @param oldBoard 보드 판
     */
    static void findMaxNumber(int[][] oldBoard)
    {
        for (int r = 0; r < boardSize; r++)
        {
            for (int c = 0; c < boardSize; c++)
            {
                answer = Math.max(answer, oldBoard[r][c]);
            }
        }
    }
}
