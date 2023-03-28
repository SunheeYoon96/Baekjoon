import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [키워드]
 * 
 * 
 * [풀이과정]
 * 
 *
 * [입력]
 * 
 * 
 * [출력] 
 * 
 *
 * @author 
 * @since 2023. 
 * @see 
 * @performance 
 * @category #
 */

public class Main {
	static BufferedReader input  = new BufferedReader(new InputStreamReader(System.in));
	
	static int N, dp[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		
		dp = new int[N+1];
		
		if(N<3) {
			dp[N]=N;
		}
		
		else{
			dp[1]=1;
			dp[2]=2;
			
			for(int i=3; i<=N; i++) {
				dp[i] = (dp[i-2] + dp[i-1])%10007;
			}
			
		}
		
		System.out.println(dp[N]);

	}

}