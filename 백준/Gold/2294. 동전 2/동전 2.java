import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, K, coins[], dp[];

	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		
		tokens = new StringTokenizer(input.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		coins = new int[N];
		
		for (int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(input.readLine());
		}
		
		dp = new int[K+1];
		Arrays.fill(dp, Integer.MAX_VALUE -1);
		dp[0]=0;
		
		for(int i=1; i<=K; i++) {
			for(int j=0; j<coins.length; j++) {
				if(i-coins[j]>=0) {
					dp[i] = Math.min(dp[i-coins[j]]+1, dp[i]);					
				}
			}
			
		}
		
		//System.out.println(Arrays.toString(dp));
		if(dp[K] == Integer.MAX_VALUE-1) {
			System.out.println(-1);
		}else {
			
			System.out.println(dp[K]);
		}

	}
	
	private static String instr = "3 15\r\n" + 
			"1\r\n" + 
			"5\r\n" + 
			"12";

}