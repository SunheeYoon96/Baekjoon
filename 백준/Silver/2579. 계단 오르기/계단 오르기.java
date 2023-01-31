import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static int[] floor; 
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		
		int dp[] = new int[N+1]; //방문기록(dp)
		floor = new int[N+1]; //계단정보 입력받기 (idx=0은 시작칸으로 둠)
		for(int i=1; i<=N; i++) {
			tokens = new StringTokenizer(input.readLine());
			floor[i] = Integer.parseInt(tokens.nextToken());
		}
		
		//System.out.println(Arrays.toString(floor));
		
		//계단이 한개일 때 모두 밟아야함.
		dp[1] = floor[1]; 
		
		
		if(N>=2) {
			//계단이 2개일때 모두 밟아야함.
			dp[2] = dp[1] + floor[2];
		}
		
		//계단이 3개 이상이면 연속3개를 밟지 못하게 된다.
		//맨 마지막 계단은 꼭 거쳐야하므로 그 앞을 방문하는지 안하는지 중에 최대값을 찾는다.
		for(int i=3; i<=N; i++) {
			dp[i] = Math.max(dp[i-2], dp[i-3]+floor[i-1]) +floor[i];
		}
		
		output.append(dp[N]);
		
		
		//이건 연속 3일 때를 예외처리하지 못한다. 
		/*
		int sum =0;
		int idx = floor.length-1;
		sum += floor[idx];
		
		while(idx>=1) {
			
			if(idx==1) {
				sum += floor[0];
				break;
				
			}else if(floor[idx-1] >= floor[idx-2]) {
				sum += floor[idx-1];
				idx = idx-1;
			}else if(floor[idx-1] < floor[idx-2]) {
				sum += floor[idx-2];
				idx = idx-2;
			}
			
			//System.out.println(idx);

		}
		*/

		System.out.println(output);
		
		

	}

}
