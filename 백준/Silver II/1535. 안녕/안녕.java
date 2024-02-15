import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    static int N, cost[], happy[];

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());

        cost = new int[N+1];
        happy = new int[N+1];

        tokens = new StringTokenizer(input.readLine());
        for (int i = 1; i <= N; i++) {
            cost[i] = Integer.parseInt(tokens.nextToken());
        }

        tokens = new StringTokenizer(input.readLine());
        for (int i = 1; i <= N; i++) {
            happy[i] = Integer.parseInt(tokens.nextToken());
        }

        int power = 99;
        int dp[][] = new int[N+1][power+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= power; j++) {
                if(cost[i] <=  j){
                    dp[i][j] = Math.max(dp[i-1][j-cost[i]]+happy[i], dp[i-1][j]);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[N][power]);

    }
}