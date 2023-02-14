import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	//static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		
		//공백을 기준으로 문자열(토큰)의 갯수를 센다. 
		int cnt = tokens.countTokens();
		
		System.out.println(cnt);
	}
	

}
