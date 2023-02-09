
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T;
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		T = Integer.parseInt(tokens.nextToken());
		
		for(int t=1; t<=T; t++) {
			int[][] map = new int[t][t];
			int sr=0; 
			int sc=0;
			int er=t;
			int ec=t;
			//int cnt=1;
			
			for (int cnt = 1; cnt <= t * t;) {
				for (int c = sc; c < ec; c++) {
					map[sr][c] = cnt;
					//System.out.print(map[sr][c]);
					cnt++;
				}
				sr++;
				for (int r = sr; r < er; r++) {
					map[r][ec - 1] = cnt;
					//System.out.print(map[r][ec - 1]);
					cnt++;
				}
				
				ec--;
				for (int c = ec - 1; c >= sc; c--) {
					map[er - 1][c] = cnt;
					//System.out.print(map[er - 1][c]);
					cnt++;
				}
				er--;
				for (int r = er - 1; r >= sr; r--) {
					map[r][sc] =cnt;
					//System.out.print(map[r][sc]);
					cnt++;
				}
				sc++;
				//System.out.println();
			}
			//System.out.println();
			output.append("#").append(t).append("\n");
			for(int[] row: map) {
				for(int x : row) {
					output.append(x).append(" ");
				}
				output.append("\n");
			}
			
		
			
		}
		System.out.println(output);
		
	}

}
