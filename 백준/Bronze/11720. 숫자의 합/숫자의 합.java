import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	
	static int N, sum;
	static String line;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		
		line = input.readLine();
		
		for (int i = 0; i < line.length(); i++) {
			sum += (line.charAt(i)-'0');
		}
		
		System.out.println(sum);
		

	}

}