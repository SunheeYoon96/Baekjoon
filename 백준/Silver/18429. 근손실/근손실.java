import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
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
		doWork(0, new boolean[N], new int[N]);
		System.out.println(cnt);
		

	}
	
	private static void doWork(int nthpick, boolean[] visited, int[] choosed) {
		
		if(nthpick == N && checkSum(choosed)) {
			cnt++;
			//System.out.println(Arrays.toString(choosed));
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				choosed[nthpick] = weightSet[i];
				doWork(nthpick+1, visited, choosed);	
				visited[i] = false;
			}
		}
	}

	private static boolean checkSum(int[] choosed) {
		int sum = 500;
		for(int i=0; i<choosed.length; i++) {
			sum += choosed[i];
			sum -= K;
			
			if(sum<500) {
				return false;
			}
		}
		return true;
		
	}

	static String instr = "3 4\r\n" + 
			"3 7 5";

}
