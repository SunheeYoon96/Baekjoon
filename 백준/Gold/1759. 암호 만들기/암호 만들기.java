import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int C,L;
	static char alphas[];
	static String line;
	static String vowels = "aeiou";

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		L = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		
		alphas = new char[C];
		tokens = new StringTokenizer(input.readLine());
		
		for(char c=0; c<C; c++) {
			//토큰으로 문자열 받아오기
			alphas[c] = tokens.nextToken().charAt(0);
		}
		
		//오름차순으로 암호를 만든다고 했으니 조합 전에 미리 정렬해주자.
		Arrays.sort(alphas);
				
		makeCombinatoin(0,new char[L], 0);
		
		System.out.println(output);

	}

    
	// C개에서 L개추출(조합은 방문체크 X)
	private static void makeCombinatoin(int nthpick, char choosed[], int sIdx) {
		if(nthpick == L) {
			if(checkAlphabet(choosed)) {
				output.append(choosed).append("\n");
			}
			return;
		}
		
		for(int i=sIdx; i<alphas.length; i++) {
			choosed[nthpick] = alphas[i];
			makeCombinatoin(nthpick+1,choosed, i+1);
		}
		
	}
    
	
	//만든 조합이 최소한 모음1개 자음2개를 가진 배열인지 판단 
	private static boolean checkAlphabet(char choosed[]) {
		int mo = 0; //모음 갯수
		int ja = 0; //자음 갯수
		
		for(char c : choosed) {
			if(vowels.contains(c+"")) {
				mo++;
			}else {
				ja++;
			}
		}
		
		if( mo>=1 && ja>=2 ) return true;
		
		return false;
	}

}