import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N, sequence[], numbers[];
	static ArrayDeque<Integer> stack; //스택 선언 
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		
		stack = new ArrayDeque<>();
		int start=0; 
		
		while(N-- >0) {
			int current = Integer.parseInt(input.readLine());
			
			//수열 해당위치 값이 나올 때까지 push
			if(current > start) {
				for(int i=start+1; i<=current; i++) {
					stack.push(i);
					output.append("+").append("\n");
				}
				//현위치부터 다시 시작
				start = current;
			}
			
			//해당값이 들어가면 pop
			if(stack.peek()==current) {
				stack.pop();
				output.append("-").append("\n");
			//없다면 수열이 불가능한 것이므로 no를 출력하고 실행종료함
			}else {
				System.out.println("NO");
				return;
			}
		}
		
		System.out.println(output);
	}

	
	

}