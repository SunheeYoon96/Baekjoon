import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static int K;

	public static void main(String[] args) throws NumberFormatException, IOException {
		K = Integer.parseInt(input.readLine());
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		
		for (int i = 0; i < K; i++) {
			int now = Integer.parseInt(input.readLine());
			if(now != 0) {
				stack.push(now);
			}else {
				stack.pop();
			}
		}
		
		int answer = 0;
		
		while (!stack.isEmpty()) {
			answer += stack.pop();
		}
		
		System.out.println(answer);

	}

}