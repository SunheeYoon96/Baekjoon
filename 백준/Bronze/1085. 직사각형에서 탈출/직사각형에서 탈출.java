
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int X;
	static int Y;
	static int Width;
	static int Height;
	static int minVal;
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		
		X = Integer.parseInt(tokens.nextToken());
		Y = Integer.parseInt(tokens.nextToken());
		Width = Integer.parseInt(tokens.nextToken());
		Height = Integer.parseInt(tokens.nextToken());
		
		minVal = Integer.MAX_VALUE;
		
		minVal = Math.min(minVal, Math.abs(X-0));
		minVal = Math.min(minVal, Math.abs(X-Width));
		minVal = Math.min(minVal, Math.abs(Y-0));
		minVal = Math.min(minVal, Math.abs(Y-Height));
		
		System.out.println(minVal);
		
		

	}

}
