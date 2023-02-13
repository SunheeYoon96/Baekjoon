
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static int N;
	static Stack<Character> stack ;
	static int isVaild;
	static String origin;
	
	//stack을 써야하는 이유: 가장 최근에 나온 괄호와 비교대상이 비교되어야하기 때문에 
	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		
		for(int t=1; t<=10; t++) {
			isVaild = 1; //1:유효함, 0: 유효하지 않음.
			
			stack = new Stack<>();
			N = Integer.parseInt(input.readLine());
			origin = input.readLine();
			
			for(int i=0; i<N; i++) {
				//우선 여는 괄호는 다 모아서 스택에 넣어둠.
				if("([{<".contains(""+origin.charAt(i))) {
					stack.add(origin.charAt(i));
				}else if(origin.charAt(i)==')') {
					//1. 닫는 소괄호가 나왔을때 스택에 (이 있으면 스택에서 꺼낸다.
					if(stack.peek()=='(') {
						stack.pop();
					}else {
						isVaild = 0;
						break;
					}
				}else if(origin.charAt(i)=='}') {
					if(stack.peek()=='{') {
						stack.pop();
					}else {
						isVaild=0; 
						break;
					}
				}else if(origin.charAt(i)==']') {
					if(stack.peek()=='[') {
						stack.pop();
					}else {
						isVaild=0;
						break;
					}
				}else if(origin.charAt(i)=='>') {
					if(stack.peek()=='<') {
						stack.pop();
					}else {
						isVaild=0;
						break;
					}
				}
			}//end origin
			
			if(!stack.isEmpty()) {
				isVaild=0;
			}
			
			output.append("#").append(t).append(" ").append(isVaild).append("\n");
			
		}
		System.out.println(output);
		

	}//end main
	
}
