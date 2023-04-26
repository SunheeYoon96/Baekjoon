import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N, M, alphas, check, rememberCnt;
//	static String words[];
	static int words[];

	public static void main(String[] args) throws IOException {		
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
//		words = new String[N];
		words = new int[N];
		
		for (int i = 0; i < N; i++) {
			//words[i] = input.readLine();
			String line = input.readLine();
			char c = ' ';
			for (int j = 0; j < line.length(); j++) {
				//입력받을때 단어의 알파벳을 비트마스킹으로 체크해두기
				words[i] |= (1 << (line.charAt(j)-97));				
			}
		}	
		
		//처음에는 다 기억하고 있음.
		alphas = (1<<27)-1;
		
		for (int i = 0; i < M; i++) {
			tokens = new StringTokenizer(input.readLine());
			int n = Integer.parseInt(tokens.nextToken());
			String str = tokens.nextToken();
			char c = str.charAt(0);
			check = c-97;
			
			rememberCnt = 0;
			
			if(n==1) { //해당 알파벳 까먹기
				alphas = alphas & ~(1<<check); 
			}else if(n==2) { //알파벳 기억하기
				alphas = alphas | (1<<check);
			}
			
			for (int j = 0; j < words.length; j++) {
				//word[i]의 알파벳이상으로 가지고 있으면 카운팅
				if((alphas&words[j]) >= words[j]) {
					rememberCnt +=1;
				}
			}
			output.append(rememberCnt).append("\n");
		}
		System.out.println(output);
	}
	
	public static String instr = "5 10\r\n" + 
			"apple\r\n" + 
			"actual\r\n" + 
			"banana\r\n" + 
			"brick\r\n" + 
			"courts\r\n" + 
			"1 l\r\n" + 
			"1 b\r\n" + 
			"1 c\r\n" + 
			"1 n\r\n" + 
			"2 l\r\n" + 
			"2 b\r\n" + 
			"1 s\r\n" + 
			"2 c\r\n" + 
			"2 s\r\n" + 
			"2 n";

}