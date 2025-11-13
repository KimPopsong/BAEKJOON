import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int turn = 0, size, pieceNumber;
    static int[][] chessMap;
    static ArrayList<Piece> pieceList = new ArrayList<>();
    static List[][] pieceMap;

    static int[] dr = {0, 0, -1, 1}, dc = {1, -1, 0, 0};  // 좌, 우, 상, 하

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        pieceNumber = Integer.parseInt(st.nextToken());

        chessMap = new int[size][size];
        pieceMap = new List[size][size];

        for (int r = 0; r < size; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < size; c++) {
                chessMap[r][c] = Integer.parseInt(st.nextToken());  // 0 : 흰색, 1 : 빨간색, 2 : 파란색
            }
        }

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                pieceMap[r][c] = new ArrayList<>();
            }
        }

        for (int i = 0; i < pieceNumber; i++) {  // 체스 말 저장
            st = new StringTokenizer(br.readLine());

            Piece piece = new Piece(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);

            pieceList.add(piece);
            pieceMap[piece.r][piece.c].add(piece);
        }

        while (turn <= 1001) {
            boolean flag = false;
            turn += 1;

            for (Piece piece : pieceList) {  // 1번 기물부터 이동
                int index = pieceMap[piece.r][piece.c].indexOf(piece);

                List<Piece> tempList = new ArrayList<>(pieceMap[piece.r][piece.c].subList(index, pieceMap[piece.r][piece.c].size()));
                pieceMap[piece.r][piece.c].subList(index, pieceMap[piece.r][piece.c].size()).clear();

                int rr = piece.r + dr[piece.direction];
                int cc = piece.c + dc[piece.direction];

                if (0 <= rr && rr < size && 0 <= cc && cc < size) {
                    if (chessMap[rr][cc] == 0) {  // 흰색칸
                        for (Piece p : tempList) {
                            p.r = rr;
                            p.c = cc;
                        }
                        pieceMap[rr][cc].addAll(tempList);
                    } else if (chessMap[rr][cc] == 1) {  // 빨간칸
                        for (Piece p : tempList) {
                            p.r = rr;
                            p.c = cc;
                        }
                        Collections.reverse(tempList);  // 뒤집기
                        pieceMap[rr][cc].addAll(tempList);
                    } else {  // 파란칸
                        if (piece.direction == 0) {  // 방향 반대로
                            piece.direction = 1;
                        } else if (piece.direction == 1) {
                            piece.direction = 0;
                        } else if (piece.direction == 2) {
                            piece.direction = 3;
                        } else {
                            piece.direction = 2;
                        }

                        rr = piece.r + dr[piece.direction];
                        cc = piece.c + dc[piece.direction];

                        if (rr < 0 || rr >= size || cc < 0 || cc >= size || chessMap[rr][cc] == 2) {  // 다시 이동할 장소가 맵을 벗어나거나 파란 칸이라면
                            pieceMap[piece.r][piece.c].addAll(tempList);
                            continue;  // 아무 일도 없음
                        } else {
                            if (chessMap[rr][cc] == 0) {  // 흰색칸
                                for (Piece p : tempList) {
                                    p.r = rr;
                                    p.c = cc;
                                }
                                pieceMap[rr][cc].addAll(tempList);
                            } else if (chessMap[rr][cc] == 1) {  // 빨간칸
                                for (Piece p : tempList) {
                                    p.r = rr;
                                    p.c = cc;
                                }
                                Collections.reverse(tempList);  // 뒤집기
                                pieceMap[rr][cc].addAll(tempList);
                            }
                        }
                    }
                } else {  // 범위를 벗어나면 파란 칸과 동일
                    if (piece.direction == 0) {  // 방향 반대로
                        piece.direction = 1;
                    } else if (piece.direction == 1) {
                        piece.direction = 0;
                    } else if (piece.direction == 2) {
                        piece.direction = 3;
                    } else {
                        piece.direction = 2;
                    }

                    rr = piece.r + dr[piece.direction];
                    cc = piece.c + dc[piece.direction];

                    if (rr < 0 || rr >= size || cc < 0 || cc >= size || chessMap[rr][cc] == 2) {  // 다시 이동할 장소가 맵을 벗어나거나 파란 칸이라면
                        pieceMap[piece.r][piece.c].addAll(tempList);
                        continue;  // 아무 일도 없음
                    } else {
                        if (chessMap[rr][cc] == 0) {  // 흰색칸
                            for (Piece p : tempList) {
                                p.r = rr;
                                p.c = cc;
                            }
                            pieceMap[rr][cc].addAll(tempList);
                        } else if (chessMap[rr][cc] == 1) {  // 빨간칸
                            for (Piece p : tempList) {
                                p.r = rr;
                                p.c = cc;
                            }
                            Collections.reverse(tempList);  // 뒤집기
                            pieceMap[rr][cc].addAll(tempList);
                        }
                    }
                }

                if (pieceMap[piece.r][piece.c].size() >= 4) {
                    flag = true;

                    break;
                }
            }

            if (flag) {
                break;
            }
        }

        if (turn > 1000) {
            System.out.println(-1);
        } else {
            System.out.println(turn);
        }
    }

    static class Piece {
        int r, c, direction;

        public Piece(int r, int c, int direction) {
            this.r = r;
            this.c = c;
            this.direction = direction;
        }
    }
}
