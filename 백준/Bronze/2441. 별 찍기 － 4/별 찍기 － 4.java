import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	//백준 2440번 : 별 찍기 - 4
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		
		for(int i=0; i<N; i++) {
			
			for(int j=0; j<i; j++) {
				System.out.print(" ");
			}
			for(int j=0; j<N-i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
