import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    static int N, M, soildShape[][], answer;
    static int deltas[][] = {{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        
        soildShape = new int[N][M];

        for (int i = 0; i < N; i++) {
            tokens = new StringTokenizer(input.readLine());
            for (int j = 0; j < M; j++) {
                soildShape[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }

        //윗면, 아랫면
        answer += 2*N*M;

        //4방향 겉넓이 확인
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                for (int d = 0; d < 4; d++) {
                    int nr = r + deltas[d][0];
                    int nc = c + deltas[d][1];

                    if(isIn(nr, nc)) { //중간에 볼록볼록한 부분
                        if(soildShape[nr][nc] < soildShape[r][c]){
                            answer += (soildShape[r][c] - soildShape[nr][nc]);
                        }
                    }else { //끝쪽이면
                        answer += soildShape[r][c];
                    }
                }
            }
        }

        System.out.println(answer);

    }

    private static boolean isIn(int nr, int nc) {
        if(nr<0 || nr>=N || nc<0 || nc>=M) return false;
        return true;
    }
}