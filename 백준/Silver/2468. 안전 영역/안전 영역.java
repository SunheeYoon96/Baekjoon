import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N, M, map[][], copymap[][], cnt, answer;
	static HashSet<Integer> hashSet;
	static boolean visited[][];
	static int deltas[][] = {{1,0},{0,1},{-1,0},{0,-1}};
	

	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		
		N = Integer.parseInt(input.readLine());
		
		map = new int[N][N];
		copymap = new int[N][N];
		hashSet = new HashSet<>(N*N);
		
		for (int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
				hashSet.add(map[r][c]);
			}
		}
		
		answer = 1;
		
		//비에 침수되는 땅 정하기
		for (int iter : hashSet) {
			int rain = iter;
			copymap = copy(map);
			
			visited = new boolean[N][N];
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(rain >= copymap[r][c]) {
						copymap[r][c] = -1;
					}
				}
			}//
			
			cnt = 0;
			//안전구역 몇개인지 체크하러 가즈아.
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(copymap[r][c]!=-1) {
						if(!visited[r][c]) {
							dfs(r,c);
							cnt++;
						}
					}		
				}
			}//
			
			answer = Math.max(answer, cnt);
		}
		System.out.println(answer);

	}
	
	private static void dfs(int r, int c) {
		visited[r][c] = true;
		
		for (int d = 0; d < deltas.length; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			
			if(!isIn(nr, nc)) continue;
			
			if(!visited[nr][nc] && copymap[nr][nc]!=-1) {
				dfs(nr,nc);
			}
			
		}
		
	}

	private static int[][] copy(int arr[][]){
		int copy[][] = new int[N][N];
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				copy[r][c] = map[r][c];
			}
		}
		
		return copy;
	}
	
	private static boolean isIn(int nr, int nc) {
		if(nr>=0 && nr<N && nc>=0 && nc<N) return true;
		return false;
	}
	
	private static String instr = "5\r\n" + 
			"6 8 2 6 2\r\n" + 
			"3 2 3 4 6\r\n" + 
			"6 7 3 3 2\r\n" + 
			"7 2 5 3 6\r\n" + 
			"8 9 5 2 7";

}