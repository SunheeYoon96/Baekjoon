import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	
	public static void main(String[] args) throws Exception, IOException {
		N = Integer.parseInt(input.readLine());
		int Answer=0;
		
		Queue<Integer> queue = new LinkedList<>(); //int형 큐
		int tmp = 0;
		int result = 0;
		
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine());
			String command = tokens.nextToken();
			int in=0;
			
			if(tokens.hasMoreElements()) {
				in = Integer.parseInt(tokens.nextToken());
			}
			
			//이걸 스위치 문으로 바꿔야한다. 
			if(command.equals("push")) {
				queue.add(in);
				//result = in;
				tmp = in;
			}else if(command.equals("pop")) {
				if(queue.size()==0) {
					result = -1;
				}else {
					result = queue.peek();
					queue.poll();
				}
				Answer = result;
				
			}else if(command.equals("size")) {
				result = queue.size();
				Answer = result;
				
			}else if(command.equals("empty")) {
				if(queue.size() == 0) {
					result = 1;
				}else {
					result = 0;
				}
				Answer = result;
				
			}else if(command.equals("front")) {
				if(queue.size()==0) {
					result = -1;
				}else {
					result = queue.peek();
				}
				Answer = result;
				
			}else if(command.equals("back")) {
				if(queue.size()==0) {
					result = -1;
				}else {
					result = tmp;
				}
				Answer = result;
			}
			if(!command.equals("push")) {
				output.append(Answer).append("\n");
			}
			
		}
		System.out.println(output);

	}

}
