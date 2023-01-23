import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		int A = Integer.parseInt(tokens.nextToken());
		int B = Integer.parseInt(tokens.nextToken());
		
		boolean isOk = true;
		
		if(A==0 && B==0) {
			isOk = false;
		}else {
			output.append(A+B).append("\n");
		}
		
		
		while(isOk) {
			tokens = new StringTokenizer(input.readLine());
			A = Integer.parseInt(tokens.nextToken());
			B = Integer.parseInt(tokens.nextToken());
			
			if(A==0 && B==0) {
				isOk = false;
				break;
			}
			output.append(A+B).append("\n");
		}
		
		System.out.println(output);
		
	}

}
