import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	
	static int N;
	static Stack<Character> stack;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		
		for (int i = 0; i < N; i++) {
			
			String line = input.readLine();
			
			stack = new Stack<>();
			
			for (int j = 0; j < line.length(); j++) {
				char c = line.charAt(j);
				if('('== c) {
					stack.push(c);
				}else if (')' == c) {
					if(!stack.isEmpty()) {
						if(stack.peek()=='(') {
							stack.pop();
						}						
					}else {
						stack.push(c);
					}
				}
			}
			
			if(stack.isEmpty()) output.append("YES").append("\n");
			else output.append("NO").append("\n");
			
		}
		
		System.out.println(output);
		
		
	}

}