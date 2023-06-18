import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N, M;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		HashMap<String, String> hashMap = new HashMap<>();
		
		for (int i = 1; i <= N; i++) {
			String poketmon = input.readLine();
			String num = Integer.toString(i);
			hashMap.put(num, poketmon);
			hashMap.put(poketmon,num);
		}
		
		for (int i = 0; i < M; i++) {
			String target = input.readLine();
			
			output.append(hashMap.get(target)).append("\n");
			
		}
		
		System.out.println(output);

	}
	
	

}