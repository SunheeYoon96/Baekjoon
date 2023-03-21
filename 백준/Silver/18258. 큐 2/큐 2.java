import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int N;
	static ArrayDeque<Integer> queue;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		
		queue = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(input.readLine());
			String cmd = tokens.nextToken();
			
			switch (cmd) {
			case "push":
				int x = Integer.parseInt(tokens.nextToken());
				queue.offer(x);
				break;
			case "pop":
				if(!queue.isEmpty()) {
					output.append(queue.poll()).append("\n");
				}else {
					output.append(-1).append("\n");
				}
				break;
			case "size":
				output.append(queue.size()).append("\n");
				break;
			case "empty":
				if(!queue.isEmpty()) {
					output.append(0).append("\n");
				}else {
					output.append(1).append("\n");
				}

				break;
			case "front":
				if(!queue.isEmpty()) {
					output.append(queue.peekFirst()).append("\n");
				}else {
					output.append(-1).append("\n");
				}
				break;
			case "back":
				if(!queue.isEmpty()) {
					output.append(queue.peekLast()).append("\n");
				}else {
					output.append(-1).append("\n");
				}

				break;

			}

		}
		
		System.out.println(output);

	}

}