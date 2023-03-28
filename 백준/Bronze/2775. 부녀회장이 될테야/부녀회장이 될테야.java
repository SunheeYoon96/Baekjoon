import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	
	static int T, k, n, dp[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(input.readLine());
		
		for (int t = 1; t <= T; t++) {
			k = Integer.parseInt(input.readLine());
			n = Integer.parseInt(input.readLine());
			
			dp = new int[15][15];
			
			for (int i = 1; i <= 14; i++) {
	            dp[0][i] = i;  //0층 i호에는 무조건 i명이 산다
	        }

	        
	        for (int i = 1; i <= 14; i++) {
	            for (int j = 1; j <= 14; j++) {
	            	dp[i][j] = dp[i][j-1] + dp[i-1][j];
	            }
	        }
	        
	        System.out.println(dp[k][n]);
	    
		}
	}

}