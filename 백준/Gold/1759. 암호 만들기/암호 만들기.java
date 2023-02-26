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
		//line = input.readLine();
		tokens = new StringTokenizer(input.readLine());
		
		for(char c=0; c<C; c++) {
			alphas[c] = tokens.nextToken().charAt(0);
		}
		
		Arrays.sort(alphas);
		//System.out.println(alphas);
				
		makeCombinatoin(0,new char[L], 0);
		
		System.out.println(output);

	}

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
	
	private static boolean checkAlphabet(char choosed[]) {
		int mo = 0;
		int ja = 0;
		
		for(char c : choosed) {
			//System.out.println(c);
			if(vowels.contains(c+"")) {
				mo++;
			}else {
				ja++;
			}
		}
		//System.out.println(ja);
		if( mo>=1 && ja>=2 ) return true;
		
		return false;
	}

}