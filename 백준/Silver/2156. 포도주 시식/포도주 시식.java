import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { // 포도주 시식
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static int[] wine;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		
		dp = new int[N+1];
		wine = new int[N+1];
		for(int i=1; i<=N; i++) {
			tokens = new StringTokenizer(input.readLine());
			wine[i] = Integer.parseInt(tokens.nextToken());
		}
		
		//입력확인
		//System.out.println(Arrays.toString(wine));
		
		dp[1] = wine[1];
		
		if(N>=2) {
			dp[2] = dp[1] +wine[2];
		}
		
		for(int i=3; i<=N; i++) {
			//마지막 포도주를 반드시 마셔야하는 조건이 없음
			//그리고 마지막 값을 더한 값이 반드시 크다고 확언할 수 없음
			//최종 최대로 포도주를 마신 것을 확인하려면 dp[N-1]도 비교하면서 최대를 구해야한다. 
			dp[i] = Math.max(dp[i-1], Math.max(dp[i-3]+wine[i-1] + wine[i], dp[i-2] + wine[i]));
			//System.out.println(dp[i]);
		}
		
		System.out.println(dp[N]);
	}
	

}
