import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    static int N, M, memories[], cost[], answer;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());

        memories = new int[N];
        cost = new int[N];

        tokens = new StringTokenizer(input.readLine());
        for (int i = 0; i < N; i++) {
            memories[i] = Integer.parseInt(tokens.nextToken());
        }
        tokens = new StringTokenizer(input.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(tokens.nextToken());
        }

        //메모리 dp 관리
        int dp[] = new int[10001];  //N*c 최대 10000
        Arrays.fill(dp, -1);

        for (int i = 0; i < N; i++) {
            int nowCost = cost[i];
            for (int j = 10000; j >=nowCost; j--) {
                if(dp[j-nowCost] != -1){
                    if(dp[j-nowCost] + memories[i] > dp[j]){
                        dp[j] = dp[j-nowCost] + memories[i];
                    }
                }
            }
            //특정비용에 해당하는 메모리가 업데이트 안되어있는 경우 업데이트함
            if(dp[nowCost] < memories[i]) {
                dp[nowCost] = memories[i];
            }
        }

        answer = 0;

        for (int i = 0; i <= 10000; i++) {
            if(dp[i] >= M){
                answer = i;
                break;
            }
        }

        System.out.println(answer);


    }
}