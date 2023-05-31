import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	static int N, M, cards[], maxval;
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		cards = new int[N];
		
		tokens = new StringTokenizer(input.readLine());
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(tokens.nextToken());
		}
		
		maxval = -1;
		
		makeCombination(0, 0, 0);
		
		System.out.println(maxval);

	}

	private static void makeCombination(int nthpick, int start, int sum) {
		
		if(nthpick==3) {
			if(M>= sum) {
				maxval = Math.max(maxval, sum);
			}
			return;
		}
		
		for (int i = start; i < N; i++) {
			sum += cards[i];
			makeCombination(nthpick+1, i+1, sum);
			sum -= cards[i];
		}
	}

}