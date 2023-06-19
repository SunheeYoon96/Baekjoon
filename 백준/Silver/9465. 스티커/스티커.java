import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [키워드]
 * 
 * [풀이과정]
 * 
 * [입력]
 * [출력] 
 * 
 * @author 윤선희
 * @since 
 * @see
 * @performance
 * @category #
 */

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int TC, N, dp[][], stickers[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		TC = Integer.parseInt(input.readLine());
		
		for (int tc = 0; tc < TC; tc++) {
			N = Integer.parseInt(input.readLine());
			
			stickers = new int[2][N+1];
			dp = new int[2][N+1];
			
			for (int i = 0; i < 2; i++) {
				tokens = new StringTokenizer(input.readLine());
				for (int j = 0; j < N; j++) {
					stickers[i][j] = Integer.parseInt(tokens.nextToken());
				}
			}
			
			dp[0][0] = stickers[0][0];
			dp[1][0] = stickers[1][0];
			
			if(N>1) {
				dp[0][1] = dp[1][0] + stickers[0][1];
				dp[1][1] = dp[0][0] + stickers[1][1];
				
				for (int i = 2; i < N; i++) {
					for (int j = 0; j < 2; j++) {
						if(j==0) {
							dp[j][i] = Math.max(dp[j+1][i-1]+stickers[j][i], dp[j+1][i-2]+stickers[j][i] );
						}else if(j==1) {
							dp[j][i] = Math.max(dp[j-1][i-1]+stickers[j][i], dp[j-1][i-2]+stickers[j][i] );
						}
					}
				}//
			}
//			for(int row[] : dp) {
//				System.out.println(Arrays.toString(row));
//			}
			
			output.append(Math.max(dp[0][N-1], dp[1][N-1])).append("\n");
			
		}
		
		System.out.println(output);

	}

}