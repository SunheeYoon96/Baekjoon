import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, tri[][], dp[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		
		tri = new int[N][N];
		dp = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(input.readLine());
			for (int j = 0; j < i+1; j++) {
				tri[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		dp[0][0] = tri[0][0];

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i+1; j++) {
				if(j==0) {
					dp[i][0] = dp[i-1][0]+tri[i][0];
				}else if(j==i) {
					dp[i][j] = dp[i-1][j-1]+tri[i][j];
				}else {
					dp[i][j] = Math.max(dp[i-1][j-1]+tri[i][j], dp[i-1][j]+tri[i][j]);
				}
			}
		}
		
		int maxVal = -1;
		for(int x : dp[N-1]) {
			if(x>maxVal) maxVal = x;
		}
		
		System.out.println(maxVal);

	}

}