import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int TC, N;
	static String cmd;

	public static void main(String[] args) throws NumberFormatException, IOException {
		TC = Integer.parseInt(input.readLine());
		
		for (int tc = 0; tc < TC; tc++) {
			
			cmd = input.readLine();
			N = Integer.parseInt(input.readLine());
			tokens = new StringTokenizer(input.readLine(),"[],");

			ArrayDeque<Integer> deq = new ArrayDeque<>();
			
			while (tokens.hasMoreTokens()) {
				deq.offer(Integer.parseInt(tokens.nextToken()));
			}
			
			makeAC(cmd, deq);			
			
		}
		System.out.println(output);

	}

	private static void makeAC(String cmd, ArrayDeque<Integer> deq) {
		boolean reverse = false; //방향변경여부
		boolean isError = false;
		
		for(char c : cmd.toCharArray()) {
			
			if(c=='R') {
				reverse = !reverse;
			}else {
				if(deq.isEmpty()) {
					isError = true;
					break;
				}else {
					if(reverse) {
						//역방향이라면 뒤에서 빼기
						deq.pollLast();
					}else {
						deq.pollFirst();
					}
				}
				
			}
			
		}
		
		makeOutput(deq, reverse, isError);
		
	}

	private static void makeOutput(ArrayDeque<Integer> deq, boolean reverse, boolean error) {
		
		if(!deq.isEmpty()) {
			output.append("[");
			if(!reverse) {
				output.append(deq.pollFirst());
				while (!deq.isEmpty()) {
					output.append(",").append(deq.pollFirst());
				}
			}else {
				output.append(deq.pollLast());
				while (!deq.isEmpty()) {
					output.append(",").append(deq.pollLast());
				}
			}
			
			output.append("]").append("\n");
		}else {
			if(error) {
				output.append("error").append("\n");
			}else {
				output.append("[]").append("\n");				
			}
		}
		
		
	}

}