import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, K;
	static String cmd;
	static Stack<Integer> stack = new Stack<>();

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());

		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(input.readLine());
			cmd = tokens.nextToken();
			if (tokens.hasMoreElements()) {
				K = Integer.parseInt(tokens.nextToken());
			}
			
			stack_execution(cmd, K);
		}

		
		System.out.println(output);
	}

	private static void stack_execution(String cmd, int k) {
		switch (cmd) {
		case "push":
			stack.push(K);
			break;
		case "pop":
			if(stack.isEmpty()) {
				output.append(-1).append("\n");
			}else {
				output.append(stack.pop()).append("\n");				
			}
			break;
		case "size":
			output.append(stack.size()).append("\n");
			break;
		case "empty":
			if(stack.isEmpty()) {
				output.append(1).append("\n");
			}else {
				output.append(0).append("\n");
			}
			break;
		case "top":
			if(stack.isEmpty()) {
				output.append(-1).append("\n");
			}else {
				output.append(stack.peek()).append("\n");
			}

			break;
		}
		
	}
	

}