import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
		tokens = new StringTokenizer(input.readLine());
		
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(tokens.nextToken());
		}
		
		Arrays.sort(numbers);
		
		makePermutation(0, new int[M], new boolean[N]);
		
		System.out.println(output);

	}

	private static void makePermutation(int nthpick, int[] choosed, boolean[] visited) {
		
		if(nthpick==M) {
			//System.out.println(Arrays.toString(choosed));
			for (int i = 0; i < M; i++) {
				output.append(choosed[i]).append(" ");
			}
			output.append("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(!visited[i]) {
				choosed[nthpick] = numbers[i];
				visited[i] = true;
				makePermutation(nthpick+1, choosed, visited);
				visited[i] = false;
			}
			
		}
	}

}