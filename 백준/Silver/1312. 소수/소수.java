import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int A, B, N, answer, cnt;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		A = Integer.parseInt(tokens.nextToken());
		B = Integer.parseInt(tokens.nextToken());
		N = Integer.parseInt(tokens.nextToken());

		cnt=N;
		answer = A%B; //초기값셋팅
		
		while (--cnt >0) { //소수N번째까지 계속 나눠줌
			answer *= 10; //자릿수 하나 늘리는것 
			answer %=B;
		}// 소수점 N-1까지 구해놈
		
		
		answer = answer*10/B; 
		
		System.out.println(answer);

	}

}