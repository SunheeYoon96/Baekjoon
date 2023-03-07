import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N;
	static long liquid[], minval, sum, absoluteVal, answer[];

	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		N = Integer.parseInt(input.readLine());
		
		tokens = new StringTokenizer(input.readLine());
		
		liquid = new long[N];
		answer = new long[3];
		for(int i=0; i<N; i++) {
			liquid[i] = Integer.parseInt(tokens.nextToken());
		}
		
		Arrays.sort(liquid);
		// System.out.println(Arrays.toString(liquid));
		minval = Long.MAX_VALUE;
		
		for(int i=0; i<N; i++) {
			int low = i+1;
			int high = liquid.length-1;
			sum = 0L;
			
			while (low < high) {
				// 세용액의 합
				sum = liquid[i] + liquid[low] + liquid[high];
				
				//세 용액의 절대값
				absoluteVal = Math.abs(sum);
				
				//절댓값비교
				if(minval>absoluteVal) {
					answer[0] = liquid[i];
					answer[1] = liquid[low];
					answer[2] = liquid[high];
					minval = absoluteVal;	
				}
				
				if(sum > 0) high -=1;
				else if(sum<0) low +=1;
				else if(sum==0) break;
				
			}
		}
		output.append(answer[0]).append(" ").append(answer[1]).append(" ").append(answer[2]);
		System.out.println(output);
	}
	
	static String instr = "5\r\n" + 
			"-2 6 -97 -6 98";

}