import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;

    static int N, board[][], answer;
    static boolean visited[];

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(input.readLine());
        board = new int[N][N];
        answer = 0;

        for (int r = 0; r < N; r++) {
            tokens = new StringTokenizer(input.readLine());
            for (int c = 0; c < N; c++) {
                board[r][c] = Integer.parseInt(tokens.nextToken());
            }
        }//입력완료

        makePermutation(0);

        System.out.println(answer);



    }

    private static void makePermutation(int nthPick) {
        if(nthPick == 5) {
            findMax();
            return;
        }

        //밀어볼 배열 복사
        int copy[][] = new int[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                copy[r][c] = board[r][c];
            }
        }

        //4방향으로 게임 진행
        for (int i = 0; i < 4; i++) {
            move(i);
            makePermutation(nthPick+1);
            //바뀐 배열로 갱신
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    board[r][c] = copy[r][c];
                }
            }
        }
    }

    public static void move(int dir) {
        switch(dir) {
            case 0: //상
                for(int i = 0; i < N; i++) {
                    int index = 0;
                    int block = 0;
                    for(int j = 0; j < N; j++) {
                        if(board[j][i] != 0) {
                            if(block == board[j][i]) {
                                board[index - 1][i] = block * 2;
                                block = 0;
                                board[j][i] = 0;
                            }
                            else {
                                block = board[j][i];
                                board[j][i] = 0;
                                board[index][i] = block;
                                index++;
                            }
                        }
                    }
                }
                break;
            case 1: //하
                for(int i = 0; i < N; i++) {
                    int index = N - 1;
                    int block = 0;
                    for(int j = N - 1; j >= 0; j--) {
                        if(board[j][i] != 0) {
                            if(block == board[j][i]) {
                                board[index + 1][i] = block * 2;
                                block = 0;
                                board[j][i] = 0;
                            }
                            else {
                                block = board[j][i];
                                board[j][i] = 0;
                                board[index][i] = block;
                                index--;
                            }
                        }
                    }
                }
                break;
            case 2: //좌
                for(int i = 0; i < N; i++) {
                    int index = 0;
                    int block = 0;
                    for(int j = 0; j < N; j++) {
                        if(board[i][j] != 0) {
                            if(block == board[i][j]) {
                                board[i][index - 1] = block * 2;
                                block = 0;
                                board[i][j] = 0;
                            }
                            else {
                                block = board[i][j];
                                board[i][j] = 0;
                                board[i][index] = block;
                                index++;
                            }
                        }
                    }
                }
                break;
            case 3: //우
                for(int i = 0; i < N; i++) {
                    int index = N - 1;
                    int block = 0;
                    for(int j = N - 1; j >= 0; j--) {
                        if(board[i][j] != 0) {
                            if(block == board[i][j]) {
                                board[i][index + 1] = block * 2;
                                block = 0;
                                board[i][j] = 0;
                            }
                            else {
                                block = board[i][j];
                                board[i][j] = 0;
                                board[i][index] = block;
                                index--;
                            }
                        }
                    }
                }
                break;
        }
    }

    public static void findMax() {
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                answer = Math.max(answer, board[i][j]);
    }


}