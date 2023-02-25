import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int n,c;
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		n = Integer.parseInt(tokens.nextToken());
		c = Integer.parseInt(tokens.nextToken());
		
		int answer = factorial(n)/(factorial(c)*factorial(n-c));
		System.out.println(answer);
		
	}

	private static int factorial(int i) {
		if(i<=1) {
			return 1;
		}
		
		return i * factorial(i-1);
		
	}
	
	

}
