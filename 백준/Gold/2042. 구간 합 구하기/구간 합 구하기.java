import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N, M, K; //N:수의 갯수 , M:갱신횟수 , K:구간합계산 횟수
	static long tree[], sumVal;
	static final int UPDATE=1, PARTSUM=2;
	
	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken()); // N:수의 갯수
		M = Integer.parseInt(tokens.nextToken()); // M:갱신횟수
		K = Integer.parseInt(tokens.nextToken()); // K:구간합계산 횟수
		
		//트리 초기화
		int h = (int) Math.ceil((Math.log(N) / Math.log(2))); //트리의 높이
		int start = (int) Math.pow(2, h);
		tree = new long[start*2];
		
		for (int s=start, e=start+N; s <e; s++) {
			tree[s] = Long.parseLong(input.readLine());
		}
		
		
		//자식을 이용해서 트리채우기
		for (int i = tree.length-1; i >=1; i--) {
				tree[i/2] += tree[i];
		}
		
		for (int i = 0; i < M+K ; i++) {
			tokens = new StringTokenizer(input.readLine()," ");
			sumVal = 1L;
			
			int a = Integer.parseInt(tokens.nextToken());
			//System.out.println(a);
			
			if(a==UPDATE) {
				int changeIdx = Integer.parseInt(tokens.nextToken())-1;
				long changeVal = Long.parseLong(tokens.nextToken());
				
				update(changeIdx+start, changeVal);
				
			}else if(a==PARTSUM) {
				int startIdx = Integer.parseInt(tokens.nextToken())-1;
				int endIdx = Integer.parseInt(tokens.nextToken())-1;
				
				sumVal = sum(startIdx+start, endIdx+start);
				System.out.println(sumVal);
			}
		
		}//for

	}
	
	private static long sum(int from, int to) {
		long sum = 0;
		
		while (from<=to) {
			if(from%2==0) {
				from/=2;
			} else {
				sum += tree[from];
				from = (from+1)/2;
			}
			
			if(to%2==0) {
				sum += tree[to];
				to = (to-1)/2;
			} else {
				to /= 2;
			}
		}
		
		return sum;
	}

	private static void update(int idx, long val) {
		long diff = val - tree[idx];
		for (int i = idx; i >=1 ; i/=2) {
			tree[i] += diff;
		}
		
	}


	private static String instr = "5 2 2\r\n" + 
			"1\r\n" + 
			"2\r\n" + 
			"3\r\n" + 
			"4\r\n" + 
			"5\r\n" + 
			"1 3 6\r\n" + 
			"2 2 5\r\n" + 
			"1 5 2\r\n" + 
			"2 3 5";

}