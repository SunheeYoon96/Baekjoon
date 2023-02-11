
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
	static int num1, num2;
	static int[] numbers;
	static int[] newNumbers;

	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		
		numbers = new int [N];
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine());
			numbers[i] = Integer.parseInt(tokens.nextToken());
		}
		//System.out.println(Arrays.toString(numbers));
		
		for(int n=0; n<N; n++) {
			for(int i=0; i<N-1; i++) {
				int temp=0;
				if(numbers[i+1]<=numbers[i]) {
					temp = numbers[i];
					numbers[i] = numbers[i+1];
					numbers[i+1] = temp;
				}
				
			}
		}
		
		for(int x:numbers) {
			System.out.println(x);
		}
				

	}
	
	static String instr = "5\r\n" + 
			"5\r\n" + 
			"2\r\n" + 
			"3\r\n" + 
			"4\r\n" + 
			"1";

}
