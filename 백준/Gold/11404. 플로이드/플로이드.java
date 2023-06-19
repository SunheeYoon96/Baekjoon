import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N, M, cities[][], a,b,c;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		M = Integer.parseInt(input.readLine());
		
		cities = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(i==j) cities[i][j] = 0;
				else cities[i][j] = 987_654_321;
				
			}
			
		}
		
		for (int m = 0; m < M; m++) {
			tokens = new StringTokenizer(input.readLine());
			a = Integer.parseInt(tokens.nextToken())-1;
			b = Integer.parseInt(tokens.nextToken())-1;
			c = Integer.parseInt(tokens.nextToken());
			
			cities[a][b] = Math.min(cities[a][b], c);			
		}
		
		//경출도
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cities[i][j] = Math.min(cities[i][k]+cities[k][j], cities[i][j]);
				}
			}			
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(cities[i][j]==987_654_321) {
					output.append(0).append(" ");
				}else {
					output.append(cities[i][j]).append(" ");					
				}
			}
			output.append("\n");
		}
		System.out.println(output);

	}

}