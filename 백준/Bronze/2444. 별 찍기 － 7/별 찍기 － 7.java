import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N;

	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		
		//백준 2444 : 별 찍기 - 7
		//상단
		for(int i=0; i<N; i++) {
			for(int j=0; j<N-i-1; j++) {
				System.out.print(" ");
			}
			for(int j=0; j<2*i+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		//하단
		for(int i=0; i<N-1; i++) {
			for(int j=0; j<i+1; j++) {
				System.out.print(" ");
			}
			for(int j=0; j<2*(N-1-i)-1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		

	}

}
