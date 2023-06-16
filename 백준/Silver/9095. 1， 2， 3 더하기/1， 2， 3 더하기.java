import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	
	static int TC, number, dp[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		TC = Integer.parseInt(input.readLine());
		
		dp = new int[12];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for (int tc = 0; tc < TC; tc++) {
			number = Integer.parseInt(input.readLine());
			
			for (int i = 4; i <= number; i++) {
				dp[i] = dp[i-3] + dp[i-2] +dp[i-1];
			}
			
			output.append(dp[number]).append("\n");
		}
        
		System.out.println(output);
	}

}