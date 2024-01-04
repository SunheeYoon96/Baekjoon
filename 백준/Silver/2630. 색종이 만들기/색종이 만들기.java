import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;

    static int N, map[][], white, blue;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());
        map = new int[N][N];
        white = 0;
        blue = 0;

        for (int r = 0; r < N; r++) {
            tokens = new StringTokenizer(input.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(tokens.nextToken());
            }
        }

        divide(0,0,N);

        output.append(white).append("\n").append(blue);
        System.out.println(output);

    }

    private static void divide(int r, int c, int size){
        if (isFinish(r,c,size)){
            if(map[r][c]==0){
                white++;
            }else{
                blue++;
            }
            return; //다 분할했으니 종료
        }

        int half = size/2;
        divide(r,c,half);
        divide(r+half,c,half);
        divide(r,c+half,half);
        divide(r+half,c+half,half);
    }

    private static boolean isFinish(int sr, int sc, int size){
        int flag = map[sr][sc];
        for (int r = sr; r < sr+size; r++) {
            for (int c = sc; c < sc+size; c++) {
                if(flag != map[r][c]) return false;
            }
        }
        return true;
    }
}