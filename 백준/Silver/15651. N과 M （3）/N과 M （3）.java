import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N, M;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		makePermutation(0, new int[N]);
		
		System.out.println(output);
	}

	private static void makePermutation(int nthpick, int choosed[]) {
		if(nthpick==M) {
			for (int i = 0; i < choosed.length; i++) {
				if(choosed[i]!=0) {
					output.append(choosed[i]).append(" ");
				}
			}
			output.append("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			choosed[nthpick]=i+1;
			makePermutation(nthpick+1, choosed);
		}
		
		
	}

}