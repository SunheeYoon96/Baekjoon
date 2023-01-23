import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		int arr[][] = new int[N][2];
		
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine());
			arr[i][0] = Integer.parseInt(tokens.nextToken());
			arr[i][1] = Integer.parseInt(tokens.nextToken());
			//System.out.printf("CASE #%d: %d + %d = %d", i, A, B, A+B);
		}
		
		for(int i=0; i<N; i++) {
			System.out.printf("Case #%d: %d + %d = %d", i+1, arr[i][0], arr[i][1], arr[i][0]+arr[i][1]);
			System.out.println();
		}
		

	}

}















