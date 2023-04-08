import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N, map[][], num, cnt;
	static ArrayList<Integer> towns;
	static boolean visited[][];
	static int deltas[][] = {{1,0},{0,1},{-1,0},{0,-1}};

	public static void main(String[] args) throws NumberFormatException, IOException {
		//input = new BufferedReader(new StringReader(instr));
		
		N = Integer.parseInt(input.readLine());
		
		map = new int[N][N];
		
		for (int r = 0; r <N; r++) {
			String line = input.readLine();
			for (int c = 0; c <N; c++) {
				map[r][c] = line.charAt(c) - '0';
			}
		}
		
		num = 2;
		towns = new ArrayList<>();
		visited = new boolean[N][N];
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(!visited[r][c] && map[r][c]==1) {
					map[r][c] = num;
					dfs(r,c, num);
					num++;
				}
			}
		}

		output.append(num-2).append("\n");
		
		for (int i = 2; i <num; i++) {
			cnt=0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(map[r][c]==i) {
						cnt++;
					}
				}
			}
			towns.add(cnt);
		}
		
		Collections.sort(towns);
		
		for(int i : towns) {
			output.append(i).append("\n");
		}
	
		System.out.println(output);

	}
	
	private static void dfs(int r, int c, int townnum) {
		visited[r][c] = true;
		
		for (int d = 0; d < deltas.length; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			
			if(!isIn(nr, nc)) continue;
			
			if(!visited[nr][nc] && map[nr][nc]==1) {
				visited[nr][nc] = true;
				map[nr][nc] = num;
				cnt++;
				dfs(nr, nc, num);
			}
		}
		
	}

	private static boolean isIn(int nr, int nc) {
		if(nr>=0 && nr<N && nc>=0 && nc<N) return true;
		return false;
	}
	
	private static String instr = "7\r\n" + 
			"0110100\r\n" + 
			"0110101\r\n" + 
			"1110101\r\n" + 
			"0000111\r\n" + 
			"0100000\r\n" + 
			"0111110\r\n" + 
			"0111000";

}