
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
	static int K;
	static int[] numbers;
	static int[] choosed; 

	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		
		while(true) {
			tokens = new StringTokenizer(input.readLine());
			
			K = Integer.parseInt(tokens.nextToken());
			if(K==0) { //마지막에는 0을 넣어준다고 했음
				break;
			}
			
			numbers = new int[K];
			for(int i=0; i<K; i++) {
				numbers[i] = Integer.parseInt(tokens.nextToken());
			}
			
			makeCombination(0, new int[6], 0);
			output.append("\n");

		}
		
		System.out.println(output);
		
	}
	
	public static void makeCombination(int nthpick, int[] choosed, int startIdx) {
		if(nthpick==choosed.length) {
			//System.out.println(Arrays.toString(choosed));
			for(int i=0; i<choosed.length; i++) {
				output.append(choosed[i]).append(" ");
			}
			output.append("\n");
			return;
		}
		
		for(int i=startIdx; i<numbers.length; i++) {
			choosed[nthpick] = numbers[i];
			makeCombination(nthpick+1, choosed, i+1);
		}
	}
	
	static String instr = "7 1 2 3 4 5 6 7\r\n" + 
			"8 1 2 3 5 8 13 21 34\r\n" + 
			"0";

}
