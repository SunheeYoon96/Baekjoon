import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, childrenPosition[];
	static int maxVal;
	
	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		
		N = Integer.parseInt(input.readLine());
		
		childrenPosition = new int[N+1];
		
		tokens = new StringTokenizer(input.readLine());
		
		for (int i = 1; i <= N; i++) {
			int now = Integer.parseInt(tokens.nextToken());
			childrenPosition[now] = i;
		}
		
		int cnt =1;
		maxVal = Integer.MIN_VALUE;
		
		for (int i = 1; i <=N; i++) {
			if(childrenPosition[i]>childrenPosition[i-1]) {
				cnt+=1;
			}else {
				cnt=1;
			}
			
			maxVal = Math.max(maxVal, cnt);
			
		}
		
		if(N==1) {
			System.out.println(0);
		}else {
			System.out.println(N-maxVal);
			
		}
		

		
		
		
	}
	
	public static String instr = "5\r\n" + 
			"5 2 4 1 3";

}