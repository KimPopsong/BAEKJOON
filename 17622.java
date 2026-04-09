import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int boardSize, chance, minMove = Integer.MAX_VALUE;
    static boolean[][] isVisit;
    static int[][] board;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        boardSize = Integer.parseInt(st.nextToken());
        chance = Integer.parseInt(st.nextToken());
        isVisit = new boolean[boardSize][boardSize];
        board = new int[boardSize][boardSize];

        for (int r = 0; r < boardSize; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < boardSize; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        isVisit[0][0] = true;
        if (chance >= 1) {
            if (board[0][0] == 1) {
                dfs(1, 0, 0, chance);

                board[0][0] = 5;
                dfs(1, 0, 0, chance - 1);

                board[0][0] = 1;
            } else if (board[0][0] == 5) {
                dfs(1, 0, 0, chance);

                board[0][0] = 1;
                dfs(1, 0, 0, chance - 1);

                board[0][0] = 5;
            } else {
                board[0][0] = 1;
                dfs(1, 0, 0, chance - 1);

                board[0][0] = 5;
                dfs(1, 0, 0, chance - 1);
            }
        } else {
            if (board[0][0] == 1 || board[0][0] == 5) {
                dfs(1, 0, 0, chance);
            }
        }

        if (minMove == Integer.MAX_VALUE) {
            System.out.print(-1);
        } else {
            System.out.print(minMove);
        }
    }

    static void dfs(int move, int nowR, int nowC, int leftChance) {
        if (move >= minMove) {
            return;
        }

        if (nowR == boardSize - 1 && nowC == boardSize - 1) {  // 마지막 칸 도착
            int now = board[nowR][nowC];

            if (now == 2 || now == 5) {
                if (leftChance == 0) {
                    minMove = Math.min(minMove, move);
                } else {
                    for (int r = 0; r < boardSize; r++) {
                        for (int c = 0; c < boardSize; c++) {
                            if (!isVisit[r][c]) {
                                minMove = Math.min(minMove, move);

                                return;
                            }
                        }
                    }
                }
            }

            return;
        }

        if (leftChance >= 1) {  // 타일 교체 가능
            if (board[nowR][nowC] == 0) {
                if (nowR + 1 < boardSize) {
                    if (!isVisit[nowR + 1][nowC]) {
                        int temp = board[nowR + 1][nowC];
                        int[] tile = {2, 3, 4};

                        for (int t : tile) {
                            if (t == temp) {
                                continue;
                            }

                            board[nowR + 1][nowC] = t;
                            isVisit[nowR + 1][nowC] = true;
                            dfs(move + 1, nowR + 1, nowC, leftChance - 1);
                            isVisit[nowR + 1][nowC] = false;
                        }

                        board[nowR + 1][nowC] = temp;
                    }
                }

                if (nowC + 1 < boardSize) {
                    if (!isVisit[nowR][nowC + 1]) {
                        int temp = board[nowR][nowC + 1];
                        int[] tile = {1, 3, 5};

                        for (int t : tile) {
                            if (t == temp) {
                                continue;
                            }

                            board[nowR][nowC + 1] = t;
                            isVisit[nowR][nowC + 1] = true;
                            dfs(move + 1, nowR, nowC + 1, leftChance - 1);
                            isVisit[nowR][nowC + 1] = false;
                        }

                        board[nowR][nowC + 1] = temp;
                    }
                }
            } else if (board[nowR][nowC] == 1) {
                int rr = nowR + 1, cc = nowC;

                if (rr < boardSize) {
                    if (!isVisit[rr][cc]) {
                        int temp = board[rr][cc];
                        int[] tile = {2, 3, 4};

                        for (int t : tile) {
                            if (t == temp) {
                                continue;
                            }

                            board[rr][cc] = t;
                            isVisit[rr][cc] = true;
                            dfs(move + 1, rr, cc, leftChance - 1);
                            isVisit[rr][cc] = false;
                        }

                        board[rr][cc] = temp;
                    }
                }

                rr = nowR;
                cc = nowC - 1;

                if (0 <= cc) {
                    if (!isVisit[rr][cc]) {
                        int temp = board[rr][cc];
                        int[] tile = {0, 2, 5};

                        for (int t : tile) {
                            if (t == temp) {
                                continue;
                            }

                            board[rr][cc] = t;
                            isVisit[rr][cc] = true;
                            dfs(move + 1, rr, cc, leftChance - 1);
                            isVisit[rr][cc] = false;
                        }

                        board[rr][cc] = temp;
                    }
                }
            } else if (board[nowR][nowC] == 2) {
                int rr = nowR, cc = nowC + 1;

                if (cc < boardSize) {
                    if (!isVisit[rr][cc]) {
                        int temp = board[rr][cc];
                        int[] tile = {1, 3, 5};

                        for (int t : tile) {
                            if (t == temp) {
                                continue;
                            }

                            board[rr][cc] = t;
                            isVisit[rr][cc] = true;
                            dfs(move + 1, rr, cc, leftChance - 1);
                            isVisit[rr][cc] = false;
                        }

                        board[rr][cc] = temp;
                    }
                }

                rr = nowR - 1;
                cc = nowC;

                if (0 <= rr) {
                    if (!isVisit[rr][cc]) {
                        int temp = board[rr][cc];
                        int[] tile = {0, 1, 4};

                        for (int t : tile) {
                            if (t == temp) {
                                continue;
                            }

                            board[rr][cc] = t;
                            isVisit[rr][cc] = true;
                            dfs(move + 1, rr, cc, leftChance - 1);
                            isVisit[rr][cc] = false;
                        }

                        board[rr][cc] = temp;
                    }
                }
            } else if (board[nowR][nowC] == 3) {
                int rr = nowR, cc = nowC - 1;

                if (0 <= cc) {
                    if (!isVisit[rr][cc]) {
                        int temp = board[rr][cc];
                        int[] tile = {0, 2, 5};

                        for (int t : tile) {
                            if (t == temp) {
                                continue;
                            }

                            board[rr][cc] = t;
                            isVisit[rr][cc] = true;
                            dfs(move + 1, rr, cc, leftChance - 1);
                            isVisit[rr][cc] = false;
                        }

                        board[rr][cc] = temp;
                    }
                }

                rr = nowR - 1;
                cc = nowC;

                if (0 <= rr) {
                    if (!isVisit[rr][cc]) {
                        int temp = board[rr][cc];
                        int[] tile = {0, 1, 4};

                        for (int t : tile) {
                            if (t == temp) {
                                continue;
                            }

                            board[rr][cc] = t;
                            isVisit[rr][cc] = true;
                            dfs(move + 1, rr, cc, leftChance - 1);
                            isVisit[rr][cc] = false;
                        }

                        board[rr][cc] = temp;
                    }
                }
            } else if (board[nowR][nowC] == 4) {
                int rr = nowR + 1, cc = nowC;

                if (rr < boardSize) {
                    if (!isVisit[rr][cc]) {
                        int temp = board[rr][cc];
                        int[] tile = {2, 3, 4};

                        for (int t : tile) {
                            if (t == temp) {
                                continue;
                            }

                            board[rr][cc] = t;
                            isVisit[rr][cc] = true;
                            dfs(move + 1, rr, cc, leftChance - 1);
                            isVisit[rr][cc] = false;
                        }

                        board[rr][cc] = temp;
                    }
                }

                rr = nowR - 1;

                if (0 <= rr) {
                    if (!isVisit[rr][cc]) {
                        int temp = board[rr][cc];
                        int[] tile = {0, 1, 4};

                        for (int t : tile) {
                            if (t == temp) {
                                continue;
                            }

                            board[rr][cc] = t;
                            isVisit[rr][cc] = true;
                            dfs(move + 1, rr, cc, leftChance - 1);
                            isVisit[rr][cc] = false;
                        }

                        board[rr][cc] = temp;
                    }
                }
            } else {
                int rr = nowR, cc = nowC - 1;

                if (0 <= cc) {
                    if (!isVisit[rr][cc]) {
                        int temp = board[rr][cc];
                        int[] tile = {0, 2, 5};

                        for (int t : tile) {
                            if (t == temp) {
                                continue;
                            }

                            board[rr][cc] = t;
                            isVisit[rr][cc] = true;
                            dfs(move + 1, rr, cc, leftChance - 1);
                            isVisit[rr][cc] = false;
                        }

                        board[rr][cc] = temp;
                    }
                }

                cc = nowC + 1;

                if (cc < boardSize) {
                    if (!isVisit[rr][cc]) {
                        int temp = board[rr][cc];
                        int[] tile = {1, 3, 5};

                        for (int t : tile) {
                            if (t == temp) {
                                continue;
                            }

                            board[rr][cc] = t;
                            isVisit[rr][cc] = true;
                            dfs(move + 1, rr, cc, leftChance - 1);
                            isVisit[rr][cc] = false;
                        }

                        board[rr][cc] = temp;
                    }
                }
            }
        }

        if (board[nowR][nowC] == 0) {
            int rr = nowR + 1, cc = nowC;

            if (rr < boardSize) {
                if (!isVisit[rr][cc]) {
                    if (board[rr][cc] == 2 || board[rr][cc] == 3 || board[rr][cc] == 4) {
                        isVisit[rr][cc] = true;
                        dfs(move + 1, rr, cc, leftChance);
                        isVisit[rr][cc] = false;
                    }
                }
            }

            rr = nowR;
            cc = nowC + 1;

            if (cc < boardSize) {
                if (!isVisit[rr][cc]) {
                    if (board[rr][cc] == 1 || board[rr][cc] == 3 || board[rr][cc] == 5) {
                        isVisit[rr][cc] = true;
                        dfs(move + 1, rr, cc, leftChance);
                        isVisit[rr][cc] = false;
                    }
                }
            }
        } else if (board[nowR][nowC] == 1) {
            int rr = nowR + 1, cc = nowC;

            if (rr < boardSize) {
                if (!isVisit[rr][cc]) {
                    if (board[rr][cc] == 2 || board[rr][cc] == 3 || board[rr][cc] == 4) {
                        isVisit[rr][cc] = true;
                        dfs(move + 1, rr, cc, leftChance);
                        isVisit[rr][cc] = false;
                    }
                }
            }

            rr = nowR;
            cc = nowC - 1;

            if (0 <= cc) {
                if (!isVisit[rr][cc]) {
                    if (board[rr][cc] == 0 || board[rr][cc] == 2 || board[rr][cc] == 5) {
                        isVisit[rr][cc] = true;
                        dfs(move + 1, rr, cc, leftChance);
                        isVisit[rr][cc] = false;
                    }
                }
            }
        } else if (board[nowR][nowC] == 2) {
            int rr = nowR, cc = nowC + 1;

            if (cc < boardSize) {
                if (!isVisit[rr][cc]) {
                    if (board[rr][cc] == 1 || board[rr][cc] == 3 || board[rr][cc] == 5) {
                        isVisit[rr][cc] = true;
                        dfs(move + 1, rr, cc, leftChance);
                        isVisit[rr][cc] = false;
                    }
                }
            }

            rr = nowR - 1;
            cc = nowC;

            if (0 <= rr) {
                if (!isVisit[rr][cc]) {
                    if (board[rr][cc] == 0 || board[rr][cc] == 1 || board[rr][cc] == 4) {
                        isVisit[rr][cc] = true;
                        dfs(move + 1, rr, cc, leftChance);
                        isVisit[rr][cc] = false;
                    }
                }
            }
        } else if (board[nowR][nowC] == 3) {
            int rr = nowR - 1, cc = nowC;

            if (0 <= rr) {
                if (!isVisit[rr][cc]) {
                    if (board[rr][cc] == 0 || board[rr][cc] == 1 || board[rr][cc] == 4) {
                        isVisit[rr][cc] = true;
                        dfs(move + 1, rr, cc, leftChance);
                        isVisit[rr][cc] = false;
                    }
                }
            }

            rr = nowR;
            cc = nowC - 1;

            if (0 <= cc) {
                if (!isVisit[rr][cc]) {
                    if (board[rr][cc] == 0 || board[rr][cc] == 2 || board[rr][cc] == 5) {
                        isVisit[rr][cc] = true;
                        dfs(move + 1, rr, cc, leftChance);
                        isVisit[rr][cc] = false;
                    }
                }
            }
        } else if (board[nowR][nowC] == 4) {
            int rr = nowR + 1, cc = nowC;

            if (rr < boardSize) {
                if (!isVisit[rr][cc]) {
                    if (board[rr][cc] == 2 || board[rr][cc] == 3 || board[rr][cc] == 4) {
                        isVisit[rr][cc] = true;
                        dfs(move + 1, rr, cc, leftChance);
                        isVisit[rr][cc] = false;
                    }
                }
            }

            rr = nowR - 1;
            cc = nowC;

            if (0 <= rr) {
                if (!isVisit[rr][cc]) {
                    if (board[rr][cc] == 0 || board[rr][cc] == 1 || board[rr][cc] == 4) {
                        isVisit[rr][cc] = true;
                        dfs(move + 1, rr, cc, leftChance);
                        isVisit[rr][cc] = false;
                    }
                }
            }
        } else {
            int rr = nowR, cc = nowC - 1;

            if (0 <= cc) {
                if (!isVisit[rr][cc]) {
                    if (board[rr][cc] == 0 || board[rr][cc] == 2 || board[rr][cc] == 5) {
                        isVisit[rr][cc] = true;
                        dfs(move + 1, rr, cc, leftChance);
                        isVisit[rr][cc] = false;
                    }
                }
            }

            cc = nowC + 1;

            if (cc < boardSize) {
                if (!isVisit[rr][cc]) {
                    if (board[rr][cc] == 1 || board[rr][cc] == 3 || board[rr][cc] == 5) {
                        isVisit[rr][cc] = true;
                        dfs(move + 1, rr, cc, leftChance);
                        isVisit[rr][cc] = false;
                    }
                }
            }
        }
    }
}
