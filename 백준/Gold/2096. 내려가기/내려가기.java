import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;

    static int N, board[][], dpMax[][], dpMin[][];

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());

        board = new int[N][3];
        dpMax = new int[N][3];
        dpMin = new int[N][3];

        for (int i = 0; i < N; i++) {
           tokens = new StringTokenizer(input.readLine());
            for (int j = 0; j < 3; j++) {
                board[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }

//        for (int i = 0; i < 3; i++) {
//            System.out.println(Arrays.toString(board[i]));
//        }

        //dpMax 초기화
        dpMax[0][0] = board[0][0];
        dpMax[0][1] = board[0][1];
        dpMax[0][2] = board[0][2];
        //dpMin 초기화
        dpMin[0][0] = board[0][0];
        dpMin[0][1] = board[0][1];
        dpMin[0][2] = board[0][2];

        for (int i = 1; i < N; i++) {
            dpMax[i][0] = Math.max( dpMax[i-1][0], dpMax[i-1][1] ) + board[i][0];
            dpMax[i][1] = Math.max( Math.max(dpMax[i-1][0], dpMax[i-1][1]), dpMax[i-1][2] ) + board[i][1];
            dpMax[i][2] = Math.max( dpMax[i-1][1], dpMax[i-1][2] ) + board[i][2];

//            System.out.println(dpMax[i][0] +"," + dpMax[i][1]+"," + dpMax[i][2]);
        }

        output.append(Math.max(Math.max(dpMax[N-1][0], dpMax[N-1][1]), dpMax[N-1][2])).append(" ");

        for (int i = 1; i < N; i++) {
            dpMin[i][0] = Math.min( dpMin[i-1][0], dpMin[i-1][1] ) + board[i][0];
            dpMin[i][1] = Math.min( Math.min(dpMin[i-1][0], dpMin[i-1][1]), dpMin[i-1][2] ) + board[i][1];
            dpMin[i][2] = Math.min( dpMin[i-1][1], dpMin[i-1][2] ) + board[i][2];

//            System.out.println(dpMin[i][0] +"," + dpMin[i][1]+"," + dpMin[i][2]);
        }

        output.append(Math.min(Math.min(dpMin[N-1][0], dpMin[N-1][1]), dpMin[N-1][2]));

        System.out.println(output);



    }
}