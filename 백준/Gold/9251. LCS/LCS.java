import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	
	static char str1[], str2[];
	static int dp[][];

	public static void main(String[] args) throws IOException {
		str1 = input.readLine().toCharArray();
		str2 = input.readLine().toCharArray();
		
		dp = new int[str1.length+1][str2.length+1];
		
		for (int i = 1; i <= str1.length; i++) {
			for (int j = 1; j <= str2.length; j++) {
				// 현재 위치의 두 문자가 같은경우 =  LCS가 증가함
				if(str1[i-1]==str2[j-1]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				//다른경우 이전값중 큰 값을 가져옴	
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		System.out.println(dp[str1.length][str2.length]);

	}

}