import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 * link : https://www.acmicpc.net/problem/11659
 * perf(성능) :  KB	 /  ms
 * category :
 * note :
 * @author SSAFY
 *
 */

public class Main {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static int M;
	static int[] numbers;
	
	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		numbers = new int[N+1];
		
		tokens = new StringTokenizer(input.readLine());
		for(int i=1; i<=N; i++) {
			numbers[i] = numbers[i-1] + Integer.parseInt(tokens.nextToken());
		}
		
		for(int m=0; m<M; m++) {
			tokens = new StringTokenizer(input.readLine());
			int sidx = Integer.parseInt(tokens.nextToken())-1;
			int eidx = Integer.parseInt(tokens.nextToken());
			
			//System.out.println(numbers[eidx] - numbers[sidx]);
			output.append(numbers[eidx] - numbers[sidx]).append("\n");
		}
		System.out.println(output);
	}
	
	static String instr = "5 3\r\n" + 
			"5 4 3 2 1\r\n" + 
			"1 3\r\n" + 
			"2 4\r\n" + 
			"5 5";

}
