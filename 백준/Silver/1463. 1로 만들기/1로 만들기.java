import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	
	static int N, dp[];
	//static int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		
		dp = new int[N+4];
		
		//Arrays.fill(dp, INF);
		
		dp[1]=0;
		dp[2]=1;
		dp[3]=1;
		
		for(int i=4; i<=N; i++) {
			//세 경우의 수 중 최솟값으로 갱신 
			
			dp[i] = dp[i-1]+1;
										
			//2의 배수일 경우
			if(i%2==0) {
				dp[i] = Math.min(dp[i/2]+1 , dp[i]);
			}

			//3의 배수일 경우
			if(i%3==0) {
				dp[i] = Math.min(dp[i/3]+1 , dp[i]);
			}
			
		}
		//System.out.println(Arrays.toString(dp));
		System.out.println(dp[N]);

	}

}