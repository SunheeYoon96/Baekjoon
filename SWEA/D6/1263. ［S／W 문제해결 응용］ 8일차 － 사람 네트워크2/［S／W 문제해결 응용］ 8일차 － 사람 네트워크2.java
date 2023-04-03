import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int T, N, pNetwork[][];
	static final int INF = 987_654_321;

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(input.readLine());
		
		for (int t = 1; t <= T; t++) {
			output.append("#").append(t).append(" ");
			
			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			
			pNetwork = new int[N][N];
			
			for (int r = 0; r < pNetwork.length; r++) {
				for (int c = 0; c < pNetwork[r].length; c++) {
					pNetwork[r][c] = Integer.parseInt(tokens.nextToken());
					if(r!=c && pNetwork[r][c]==0) {
						pNetwork[r][c] = INF;
					}
				}
			}
			
//			for(int row[]: pNetwork) {
//				System.out.println(Arrays.toString(row));
//			}
			
			for (int k = 0; k < pNetwork.length; k++) {
				for (int i = 0; i < pNetwork.length; i++) {
					for (int j = 0; j < pNetwork.length; j++) {
						pNetwork[i][j] = Math.min(pNetwork[i][j], pNetwork[i][k]+pNetwork[k][j]);
					}
				}
			}
			
			int minVal = INF;
			int[] rows = new int[N];
			
			for (int r = 0; r < pNetwork.length; r++) {
				for (int c = 0; c < pNetwork.length; c++) {
					rows[r] += pNetwork[r][c];
				}
				minVal = Math.min(minVal, rows[r]);
			}

			
			output.append(minVal).append("\n");
			
//			for(int row[]: pNetwork) {
//				System.out.println(Arrays.toString(row));
//			}
			
			
			
		}
		System.out.println(output);
	}

}