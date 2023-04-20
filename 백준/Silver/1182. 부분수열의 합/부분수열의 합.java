import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	static int N, S, arr[], answer;
//	static boolean visited[];

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		S = Integer.parseInt(tokens.nextToken());
		
		arr = new int[N];

		tokens = new StringTokenizer(input.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		
		makeCombination(0, 0, 0);
		
		if(S==0) {
			answer-=1;
		}

		System.out.println(answer);

	}

	private static void makeCombination(int nthpick, int sum, int start) {
		
		if(sum==S) {
			answer+=1;
		}
		
		if(nthpick==N) return;
		
		for (int i = start; i < N; i++) {
			makeCombination(nthpick+1, sum+arr[i], i+1);
//			System.out.println(sum);
			
		}
		
		
	}

}