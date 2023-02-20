import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static int N=9;
	static int dwarf=7;
	static int[] nums;	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//input = new BufferedReader(new StringReader(instr));
		
		nums = new int[N];
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(input.readLine());
		}
		
		makeCombination(0, new int[dwarf], 0);
		System.out.println(output);

	}
	
	public static void makeCombination(int nthpick, int[] choosed, int start) {
		if(nthpick == choosed.length) {
			int sum=0;
			for(int i=0; i<choosed.length; i++) {
				sum += choosed[i];
			}
			if(sum==100) {
				for(int i=0; i<choosed.length; i++) {
					output.append(choosed[i]).append("\n");
				}
			}
			return;
		}
		
		for(int i=start; i<nums.length; i++) {
    		choosed[nthpick] = nums[i];
    		//System.out.println(i);
    		makeCombination(nthpick+1, choosed, i+1);
    	}
	}
	
	static String instr = "7\r\n" + 
			"8\r\n" + 
			"10\r\n" + 
			"13\r\n" + 
			"15\r\n" + 
			"19\r\n" + 
			"20\r\n" + 
			"23\r\n" + 
			"25";

}
