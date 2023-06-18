import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int TC, A,B;
	
	static class Register{
		int num;
		String cmd;
		
		public Register(int num, String cmd) {
			this.num = num;
			this.cmd = cmd;
		}
		
		int D() { //2배
			return (num*2)%10000;
		}
		
		int S() { //-1
			if(num==0) return 9999;
			else return num-1;
		}
		
		int L() { // 왼쪽 쉬프트
			return num%1000*10 + num/1000;
		}
		
		int R() { //오른쪽 쉬프트
			return num/10 + num%10*1000;
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		TC = Integer.parseInt(input.readLine());
		
		for (int i = 0; i < TC; i++) {
			tokens = new StringTokenizer(input.readLine());
			A = Integer.parseInt(tokens.nextToken());
			B = Integer.parseInt(tokens.nextToken());
			
			Queue<Register> que = new ArrayDeque<>();
			boolean visited[] = new boolean[10000];
			que.offer(new Register(A, ""));
			visited[A]=true;
			
			while (!que.isEmpty()) {
				Register now = que.poll();
				int nD = now.D();
				int nS = now.S();
				int nL = now.L();
				int nR = now.R();
				
				if(now.num == B) {
					output.append(now.cmd).append("\n");
				}
				
				if(!visited[nD]) {
					que.add(new Register(nD, now.cmd+"D"));
					visited[nD] = true;
				}
				
				if(!visited[nS]) {
					que.add(new Register(nS, now.cmd+"S"));
					visited[nS] = true;
				}
				
				if(!visited[nL]) {
					que.add(new Register(nL, now.cmd+"L"));
					visited[nL] = true;
				}
				
				if(!visited[nR]) {
					que.add(new Register(nR, now.cmd+"R"));
					visited[nR] = true;
				}
				
			}
			
		}//end tc
		
		System.out.println(output);

	}

}