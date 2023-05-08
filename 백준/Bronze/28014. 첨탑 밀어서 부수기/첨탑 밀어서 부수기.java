import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [키워드]
 * 
 * [풀이과정]
 * 
 * [입력]
 * [출력] 
 * 
 * @author 윤선희
 * @since 
 * @see
 * @performance
 * @category #
 */

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N, tops[],breakCnt;
	static boolean visited[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		
		tops = new int[N];
		visited = new boolean[N];
		tokens = new StringTokenizer(input.readLine());
		
		for (int i = 0; i < N; i++) {
			tops[i] = Integer.parseInt(tokens.nextToken());
		}
		
		breakCnt = 0;
		
		for (int i = 0; i < N-1; i++) {
			if(tops[i]>tops[i+1]) {
				breakCnt++;
			}
		}
		
		
		
		System.out.println(N-breakCnt);

	}

}