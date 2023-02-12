import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static String cmd;
	static ArrayDeque<Integer> deq;

	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		
		int val=0;
		deq = new ArrayDeque<Integer>();
		
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine());
			cmd = tokens.nextToken();
			if(tokens.hasMoreTokens()) {
				val = Integer.parseInt(tokens.nextToken());
			}
			
			switch (cmd) {
			case "push_front":
				deq.offerFirst(val);
				break;
				
			case "push_back":
				deq.offerLast(val);
				break;
				
			case "pop_front":
				if(!deq.isEmpty()) {
					System.out.println(deq.pollFirst());
				}else {
					System.out.println(-1);
				}
				break;
				
			case "pop_back":
				if(!deq.isEmpty()) {
					System.out.println(deq.pollLast());
				}else {
					System.out.println(-1);
				}
				break;
				
			case "size":
				System.out.println(deq.size());
				break;
			case "empty":
				if(deq.isEmpty()) {
					System.out.println(1);
				}else {
					System.out.println(0);;
				}
				break;
			case "front":
				if(!deq.isEmpty()) {
					System.out.println(deq.peekFirst());
				}else {
					System.out.println(-1);
				}
				break;
			case "back":
				if(!deq.isEmpty()) {
					System.out.println(deq.peekLast());
				}else {
					System.out.println(-1);
				}
				break;

			
			}
			
		}

	}
	
	static String instr = "15\r\n" + 
			"push_back 1\r\n" + 
			"push_front 2\r\n" + 
			"front\r\n" + 
			"back\r\n" + 
			"size\r\n" + 
			"empty\r\n" + 
			"pop_front\r\n" + 
			"pop_back\r\n" + 
			"pop_front\r\n" + 
			"size\r\n" + 
			"empty\r\n" + 
			"pop_back\r\n" + 
			"push_front 3\r\n" + 
			"empty\r\n" + 
			"front";

}
