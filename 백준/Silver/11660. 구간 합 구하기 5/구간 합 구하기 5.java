import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;

    static int N, M;
    static long map[][];

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());

        map = new long[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            tokens = new StringTokenizer(input.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = map[i][j-1] + map[i-1][j] - map[i-1][j-1] + Long.parseLong(tokens.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            tokens = new StringTokenizer(input.readLine());
            int x1 = Integer.parseInt(tokens.nextToken());
            int y1 = Integer.parseInt(tokens.nextToken());
            int x2 = Integer.parseInt(tokens.nextToken());
            int y2 = Integer.parseInt(tokens.nextToken());
            long sum = 0L;
            sum = map[x2][y2] - map[x1-1][y2] - map[x2][y1-1] + map[x1-1][y1-1];
            output.append(sum).append("\n");
        }

        System.out.println(output);

    }
}