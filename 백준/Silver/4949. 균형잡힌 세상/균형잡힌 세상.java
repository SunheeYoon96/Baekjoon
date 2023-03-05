import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

/**
 * [키워드]
 * . 은 종료조건
 * . 한개만 있어도 균형잡힌 문자열이라고판단함.
 * 
 */

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String line, answer;

	public static void main(String[] args) throws IOException {
		
		while (true) {
			line = input.readLine();
			
			//종료조건
			if(line.equals(".")) {
				break;
			}
			
			answer = solve(line);
			output.append(answer).append("\n");
		}
		
		System.out.println(output);
	}

	private static String solve(String line) {
		ArrayDeque<Character> stack = new ArrayDeque<>();
		
		for(int i=0; i<line.length(); i++){
			char c = line.charAt(i);
			
			//여는 괄호를 보면 스택에 push
			if(c=='(' || c=='[') {
				stack.push(c);
			//닫는 소괄호 인데 직전이 여는 소괄호가 아니면 pop
			}else if(c==')') {
				if(stack.isEmpty() || stack.peek()!='(') {
					return "no";
				}else {
					stack.pop();
				}
			//	닫는 대괄호 인데 직전이 여는 대괄호가 아니면 pop
			}else if(c==']') {
				if(stack.isEmpty() || stack.peek()!='[') {
					return "no";
				}else {
					stack.pop();
				}
			}
		}
		
		//모두 짝이 맞아서 스택이 비어있으면 균형있는 문자열
		if(stack.isEmpty()) {
			return "yes";
		//짝이 안맞아서 남는 요소가 있으면 불균형
		}else {
			return "no";
		}
		
	}

}