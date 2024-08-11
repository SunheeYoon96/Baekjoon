import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    static int N, M, K;
    static long arr[][];
    static String ans;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        K = Integer.parseInt(tokens.nextToken());

        arr = new long[N][M+1];
        ans = "";

        for (int i = 0; i < N; i++) {
            tokens = new StringTokenizer(input.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = arr[i][j-1] + Integer.parseInt(tokens.nextToken());
            }
        }

        loop: for (int j = 1; j <= M; j++) {
            for (int i = 0; i < N ; i++) {
                if(arr[i][j] >= K) {
                    ans = i+1 + " " + j;
                    break loop;
                }
            }
        }

        System.out.println(ans);

    }
}