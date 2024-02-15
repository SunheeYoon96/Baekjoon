import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;

    static int TC, N, coins[], dp[], target;

    public static void main(String[] args) throws IOException {
        TC = Integer.parseInt(input.readLine());

        for (int tc = 0; tc < TC; tc++) {
            N = Integer.parseInt(input.readLine());
            coins = new int[N];
            tokens = new StringTokenizer(input.readLine());
            for (int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(tokens.nextToken());
            }
            target = Integer.parseInt(input.readLine());

            dp = new int[target+1];
            dp[0] = 1; //0원을 만들 수 있는 방법은 무조건 1개 있다(아무것도 안내는 방법)
            for (int i = 0; i < N; i++) {
                int coin = coins[i];
                for (int j = coin; j <= target; j++) {
                    dp[j] += dp[j-coin];
                }
            }

            output.append(dp[target]).append("\n");
        }
        
        System.out.println(output);
    }
}