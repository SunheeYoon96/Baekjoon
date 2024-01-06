import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    static int N, dp[];

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());

        dp = new int[1000+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i-1]%10007 + (2*dp[i-2])%10007)%10007;
        }

        System.out.println(dp[N]);

    }
}