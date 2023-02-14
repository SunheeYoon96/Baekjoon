
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static ArrayDeque<Top> stack;
	static int N;
	
	//스택에 top의 정보를 객체로 넣을꺼다. 
	public static class Top {
		int loc;
		int val;
		
		public Top(int loc, int val) {
			super();
			this.loc = loc;
			this.val = val;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		
		ArrayDeque<Top> stack = new ArrayDeque<Top>();
		
		tokens = new StringTokenizer(input.readLine());
		for(int i=1; i<=N; i++) { //탑이 1번부터 시작하니까. 
			int start = Integer.parseInt(tokens.nextToken()); //지금 기준으로 두고 비교하고싶은 탑의 높이
			while(true) {
				if(!stack.isEmpty()) { //스택에 탑이 있으면
					Top top = stack.peek(); 
					int loc = top.loc;
					int val = top.val;
					
					//맨위에 있는 탑 정보가 현재 내 탑보다 크면 
					if(val >= start) {
						//그 정보를 답에 추가하고 내 정보는 스택에 담는다. 
						output.append(loc).append(" ");
						stack.push(new Top(i, start));
						break;
					}else {
						//꺼낸 탑이 나보다 작으면 그냥 버림
						stack.pop();
					}
				}else {//탑이 비어있으면 더이상 비교할게없으므로 0을 넣고 내 탑정보는 스택에 담는다. 
					output.append(0).append(" ");
					stack.push(new Top(i, start));
					break;
				}
			}
		}
		
		System.out.println(output);
		
		
		
		
	}

}
