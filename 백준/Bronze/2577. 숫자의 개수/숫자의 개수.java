import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[] numbers;
	
	public static void main(String[] args) throws IOException {
		//tokens = new StringTokenizer(input.readLine());
		int value = 1;
		
		for(int i=0; i<3; i++) {
			tokens = new StringTokenizer(input.readLine());
			value*= Integer.parseInt(tokens.nextToken());
		}
		
		numbers = new int[10];
		String str = value+"";
		
		for(int i=0; i<str.length(); i++) {
			numbers[str.charAt(i)-'0']++;
		}
		
		for(int x : numbers) {
			output.append(x).append("\n");
		}
		System.out.println(output);
		
		//System.out.println(Arrays.toString(numbers));
		
		

	}

}
