import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, map[][], dp[][][];
	static final int GARO=0, SERO=1, DAE=2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		
		map = new int[N][N];
		
		for (int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		dp = new int[N][N][3];
		dp[0][1][GARO] = 1;
		
		for (int r = 0; r < N; r++) {
			for (int c = 1; c < N; c++) {
				//벽이 있으면 갈 수 없다.
				if(map[r][c]==1) continue;
				dp[r][c][GARO] += dp[r][c-1][GARO] + dp[r][c-1][DAE];
				
				if(r==0) continue;
				dp[r][c][SERO] += dp[r-1][c][DAE] + dp[r-1][c][SERO]; 
				
				if(map[r-1][c]==1 || map[r][c-1]==1) continue;
				dp[r][c][DAE] += dp[r-1][c-1][GARO] + dp[r-1][c-1][SERO] + dp[r-1][c-1][DAE];
			}
		}
		
		
		
		System.out.println(dp[N-1][N-1][GARO] + dp[N-1][N-1][SERO] + dp[N-1][N-1][DAE]);
	}
	
}