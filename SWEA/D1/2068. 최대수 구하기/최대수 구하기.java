import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[] nums;
	static int T;
	static int maxVal = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		tokens = new StringTokenizer(input.readLine());
		T = Integer.parseInt(tokens.nextToken());
		
		nums = new int[10];
		for(int t=1; t<=T; t++) {
			maxVal = 0;
			
			tokens = new StringTokenizer(input.readLine());
			for(int i=0; i<10; i++) {
				nums[i] = Integer.parseInt(tokens.nextToken());
				maxVal = Math.max(maxVal, nums[i]);
			}
			
			output.append("#").append(t).append(" ").append(maxVal).append("\n");
		}
		System.out.println(output);

	}
	
	static String instr = "3\r\n" + 
			"3 17 1 39 8 41 2 32 99 2\r\n" + 
			"22 8 5 123 7 2 63 7 3 46\r\n" + 
			"6 63 2 3 58 76 21 33 8 1\r\n" + 
			"";

}
