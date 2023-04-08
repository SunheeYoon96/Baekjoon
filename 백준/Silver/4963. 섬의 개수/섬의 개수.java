import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N, M, map[][], cnt;
	static boolean visited[][];
	static int deltas[][] = {{1,0},{0,1},{-1,0},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
	
	static class Loc {
		int r,c;

		public Loc(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}

	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		
		String line = " ";
		
		while (!(line = input.readLine()).equals("0 0")) {
			tokens = new StringTokenizer(line);
			
			M = Integer.parseInt(tokens.nextToken());
			N = Integer.parseInt(tokens.nextToken());
			
			map = new int[N][M];
			for (int r = 0; r < N; r++) {
				tokens = new StringTokenizer(input.readLine());
				for (int c = 0; c < M; c++) {
					map[r][c] = Integer.parseInt(tokens.nextToken());
				}
			}
			
			cnt = 0;
			visited = new boolean[N][M];
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if(!visited[r][c] && map[r][c]==1) {
						cnt++;
						dfs(r,c);
						//bfs(r,c);
					}
					
				}
				
			}
			output.append(cnt).append("\n");
		}
		System.out.println(output);

	}
	
	private static void dfs(int sr, int sc) {
		visited[sr][sc] = true;
		
		for (int d = 0; d < deltas.length; d++) {
			int nr = sr + deltas[d][0];
			int nc = sc + deltas[d][1];
			
			if(isIn(nr, nc) && !visited[nr][nc] && map[nr][nc]==1) {
				dfs(nr, nc);
			}
		}
		
	}
	
	public static void bfs(int sr, int sc) {
		Queue<Loc> que = new ArrayDeque<>();
		que.offer(new Loc(sr, sc));
		visited[sr][sc] = true;
		
		while (!que.isEmpty()) {
			Loc current = que.poll();
			
			for (int d = 0; d < deltas.length; d++) {
				int nr = current.r + deltas[d][0];
				int nc = current.c + deltas[d][1];
				
				if(isIn(nr, nc) && !visited[nr][nc] && map[nr][nc]==1) {
					que.offer(new Loc(nr, nc));
					visited[nr][nc] = true;
				}
			}
		}
	}
	
	private static boolean isIn(int nr, int nc) {
		if(nr>=0 && nr<N && nc>=0 && nc<M) return true;
		return false;
	}

	private static String instr = "1 1\r\n" + 
			"0\r\n" + 
			"2 2\r\n" + 
			"0 1\r\n" + 
			"1 0\r\n" + 
			"3 2\r\n" + 
			"1 1 1\r\n" + 
			"1 1 1\r\n" + 
			"5 4\r\n" + 
			"1 0 1 0 0\r\n" + 
			"1 0 0 0 0\r\n" + 
			"1 0 1 0 1\r\n" + 
			"1 0 0 1 0\r\n" + 
			"5 4\r\n" + 
			"1 1 1 0 1\r\n" + 
			"1 0 1 0 1\r\n" + 
			"1 0 1 0 1\r\n" + 
			"1 0 1 1 1\r\n" + 
			"5 5\r\n" + 
			"1 0 1 0 1\r\n" + 
			"0 0 0 0 0\r\n" + 
			"1 0 1 0 1\r\n" + 
			"0 0 0 0 0\r\n" + 
			"1 0 1 0 1\r\n" + 
			"0 0";

}