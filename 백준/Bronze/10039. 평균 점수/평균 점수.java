import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int sum;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		for (int i = 0; i < 5; i++) {
			int x = Integer.parseInt(input.readLine());
			
			if(x<40) {
				x=40;
				sum+=x;
			}else {
				sum+=x;
			}
		}
		
		System.out.println(sum/5);
		
	}

}