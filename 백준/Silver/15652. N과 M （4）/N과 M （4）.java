import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N, M, numbers[];

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		numbers = new int[N];
		for (int i = 1; i <= N; i++) {
			numbers[i-1] = i;
		}
		
		makeDuplicatePermutation(0,0, new int[M]);
		System.out.println(output);

	}

	private static void makeDuplicatePermutation(int nthpick,int start, int[] choosed) {
		
		if(nthpick==M) {
			for (int i = 0; i < choosed.length; i++) {
				output.append(choosed[i]).append(" ");
			}
			output.append("\n");
			return;
		}
		
		for (int j = start; j < N; j++) {
			choosed[nthpick] = numbers[j];
			makeDuplicatePermutation(nthpick+1, j, choosed);
			choosed[nthpick] = numbers[j];
		}
		
	}

}