
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Solution {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T;
	static int K;
	static int weight;
	static int[] things;
	static int maxVal;

	
	//2개를 추출해서 최대값을 만들자.
	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		
		tokens = new StringTokenizer(input.readLine());
		T = Integer.parseInt(tokens.nextToken());
		
		for(int t=1; t<=T; t++) {
			tokens = new StringTokenizer(input.readLine());
			K = Integer.parseInt(tokens.nextToken());
			weight = Integer.parseInt(tokens.nextToken());
			
			tokens = new StringTokenizer(input.readLine());
			things = new int[K];
			for(int k=0; k<K; k++) {
				things[k] = Integer.parseInt(tokens.nextToken());
			}
			
			maxVal = -1;
			//주어진 조건에서 중복없이 2개를 뽑는 조합 실ㅎㅐㅇ
			makeCombination(0, new int[2], 0);
			output.append("#").append(t).append(" ").append(maxVal).append("\n");

		}
		System.out.println(output);

	}
	
	public static void makeCombination(int nthpick, int[] choosed, int startIdx) {
		
		if(nthpick == choosed.length) {
			int sum = 0;
			sum = choosed[0]+ choosed[1];
			if(sum <= weight) {
				maxVal = Math.max(maxVal, sum);
			}
			//System.out.println(Arrays.toString(choosed));
			
			return;
		}
		
		for(int i=startIdx; i<things.length; i++) {
			choosed[nthpick] = things[i];
			makeCombination(nthpick+1, choosed, i+1);
		}
	}
	
	static String instr = "4\r\n" + 
			"3 45\r\n" + 
			"20 20 20\r\n" + 
			"6 10\r\n" + 
			"1 2 5 8 9 11\r\n" + 
			"4 100\r\n" + 
			"80 80 60 60\r\n" + 
			"4 20\r\n" + 
			"10 5 10 16\r\n" + 
			""; 

}

