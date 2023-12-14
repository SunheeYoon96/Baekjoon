import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(input.readLine());
		
		int dp[] = new int[N+1];
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i=2; i<=N; i++) {
			int min = Integer.MAX_VALUE;
			for(int j=1; j*j<=i ; j++) {
				min = Math.min(min, dp[i-j*j]); //8, 12..와 같이 예외인 경우를 포함하기 위해
			}
			dp[i] = min +1;
		}
		
		System.out.println(dp[N]);

	}

}