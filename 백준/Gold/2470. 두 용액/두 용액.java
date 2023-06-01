import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, liquid[], answer1, answer2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		
		tokens = new StringTokenizer(input.readLine());
		liquid = new int[N];
		
		for (int i = 0; i < N; i++) {
			liquid[i] = Integer.parseInt(tokens.nextToken());			
		}
		
		Arrays.sort(liquid);
		
		int mixed = Integer.MAX_VALUE;
		
		int start = 0;
		int end = N-1;
		
		int sum=0;
		int tmp = 0;
		
		while (start <end) {
			sum = liquid[start]+liquid[end];
			tmp = Math.abs(sum);
			
			if(tmp < mixed) {
				mixed = tmp;
				answer1 = liquid[start];
				answer2 = liquid[end];
			}
			
			if(sum > 0) end--;
			else start++;
		}
		
		System.out.println(answer1  + " " + answer2);


	}

}