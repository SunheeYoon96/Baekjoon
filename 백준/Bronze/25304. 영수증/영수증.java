import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int total;
	static int N;
	
	public static void main(String[] args) throws IOException {
		total = 0;
		N = 0;
		
		tokens = new StringTokenizer(input.readLine());
		total = Integer.parseInt(tokens.nextToken());
		
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine());
			int val = Integer.parseInt(tokens.nextToken());
			int cnt = Integer.parseInt(tokens.nextToken());
			
			total -= val*cnt;
		}
		
		if(total==0) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}

	}

}












