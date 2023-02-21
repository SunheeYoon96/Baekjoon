import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M, map[][]; //2차원 배열의 정보
	static int K, x,y,i,j;  //누적합의 정보

	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		map = new int[N+1][M+1];
		for(int r=1; r<=N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=1; c<=M; c++) {
				int current = Integer.parseInt(tokens.nextToken());
				if(r==0 && c==0) {
					map[0][0] = current;
				}
				else {
					map[r][c] = map[r][c-1] + map[r-1][c] + current - map[r-1][c-1];					
				}
			}
		}
		
		tokens = new StringTokenizer(input.readLine());
		K = Integer.parseInt(tokens.nextToken());
		
		for(int k=0; k<K; k++) {
			tokens = new StringTokenizer(input.readLine());
			x = Integer.parseInt(tokens.nextToken());
			y = Integer.parseInt(tokens.nextToken());
			i = Integer.parseInt(tokens.nextToken());
			j = Integer.parseInt(tokens.nextToken());
			
			int ans = map[i][j] - map[x-1][j] - map[i][y-1] + map[x-1][y-1];
			output.append(ans).append("\n");
		}
		
		System.out.println(output);
	}
	
	static String instr = "2 3\r\n" + 
			"1 2 4\r\n" + 
			"8 16 32\r\n" + 
			"3\r\n" + 
			"1 1 2 3\r\n" + 
			"1 2 1 2\r\n" + 
			"1 3 2 3";

}
