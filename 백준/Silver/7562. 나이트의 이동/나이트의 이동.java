import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output  = new StringBuilder();
	static StringTokenizer tokens;
	
	static int T, N, mincnt;
	static Loc start, end;
	static boolean visited[][];
	static int deltas[][] = {{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};
	
	static class Loc {
		int r,c, cnt;
		
		public Loc(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Loc [r=" + r + ", c=" + c + "]";
		}
		
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		//input = new BufferedReader(new StringReader(instr));
		
		T = Integer.parseInt(input.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(input.readLine());
			
			tokens = new StringTokenizer(input.readLine());
			int sr = Integer.parseInt(tokens.nextToken());
			int sc = Integer.parseInt(tokens.nextToken());
			start = new Loc(sr, sc,0);
			
			tokens = new StringTokenizer(input.readLine());
			int er = Integer.parseInt(tokens.nextToken());
			int ec = Integer.parseInt(tokens.nextToken());
			end = new Loc(er, ec,0);
			
			mincnt = bfs(start, end);
			
			output.append(mincnt).append("\n");
		}
		
		System.out.println(output);
	}
	
	private static int bfs(Loc start, Loc end) {
		Queue<Loc> que = new ArrayDeque<>();
		visited = new boolean[N][N];
		que.offer(start);
		visited[start.r][start.c] = true;
		
		while (!que.isEmpty()) {
			Loc current = que.poll();
//			System.out.println(current);
			
			if(current.r==end.r && current.c==end.c) {
				return current.cnt;
			}
			
			for (int d = 0; d < deltas.length; d++) {
				int nr = current.r + deltas[d][0];
				int nc = current.c + deltas[d][1];
				
				if(!isIn(nr, nc)) continue;
				
				if(!visited[nr][nc]) {
					que.offer(new Loc(nr, nc, current.cnt+1));
					visited[nr][nc] = true;
				}
			}
			
		}
		return -1;
		
	}

	private static boolean isIn(int nr, int nc) {
		if(nr>=0 && nr<N && nc>=0 && nc<N) return true;
		return false;
	}
	
	private static String instr = "3\r\n" + 
			"8\r\n" + 
			"0 0\r\n" + 
			"7 0\r\n" + 
			"100\r\n" + 
			"0 0\r\n" + 
			"30 50\r\n" + 
			"10\r\n" + 
			"1 1\r\n" + 
			"1 1";

}