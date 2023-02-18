import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T;
	static ArrayList<String> strs = new ArrayList<String>();
	static int cntO;
	static int total;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		T = Integer.parseInt(tokens.nextToken());
		
		for(int t=0; t<T; t++) {
			tokens = new StringTokenizer(input.readLine());
			strs.add(t, tokens.nextToken());
		}
		
		for(int t=0; t<T; t++) {
			char c = 'X';
			total = 0;
			cntO = 0;
			
			for(int i=0; i<strs.get(t).length(); i++) {
				c = strs.get(t).charAt(i);
				if(c == 'O') {
					cntO++;
				}else {
					cntO =0;
				}
				total += cntO;
			}
			
			output.append(total).append("\n");
		}
		System.out.println(output);
		
		

	}

}
