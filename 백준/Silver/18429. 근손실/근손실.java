import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N,K,cnt, weightSet[];

	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		tokens = new StringTokenizer(input.readLine());
		
		weightSet = new int[N];
		for(int i=0; i<N; i++) {
			weightSet[i] = Integer.parseInt(tokens.nextToken());
		}
		
		cnt=0;
		doWork(0, new boolean[N], 500);
		System.out.println(cnt);
	}
	
	private static void doWork(int nthpick, boolean[] visited, int sum) {
		if(nthpick == N) {
			cnt++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				sum += weightSet[i]-K;
				//일일 중량이 500을 넘으면 다음 선택을 하는 것으로 가지치기
				if(sum >= 500) {
					doWork(nthpick+1, visited, sum);
				}
				//안넘으면 다시 뒤로 돌림
				visited[i] = false;
				sum -= weightSet[i]-K;
			}	
		}
	}

	static String instr = "3 4\r\n" + 
			"3 7 5";

}
