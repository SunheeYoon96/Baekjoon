import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int n,c, answer, dp[][];
	static final int div = 10007;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		n = Integer.parseInt(tokens.nextToken());
		c = Integer.parseInt(tokens.nextToken());
		
		dp = new int[n+1][c+1];
		
		answer = dodo(n,c);
		
		System.out.println(answer);
	
	}
	
	public static int dodo(int n, int c) {
		
		if(dp[n][c] > 0) return dp[n][c];
		
		if(c==0 || n==c) return dp[n][c] = 1;
		
		return dp[n][c] = ( dodo(n-1, c-1) + dodo(n-1, c) )%div; 
	}
	
	

}