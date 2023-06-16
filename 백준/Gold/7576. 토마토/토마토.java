import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	static int R, C, tomatoes[][], minDays;
	static int deltas[][] = {{1,0},{-1,0},{0,1},{0,-1}};
	static Queue<Roc> que;
	static boolean visited[][];
	static final int RIPE=1, BLANK=-1, UNRIPE=0;
	
	static class Roc{
		int r, c;

		public Roc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		C = Integer.parseInt(tokens.nextToken());
		R = Integer.parseInt(tokens.nextToken());
		
		tomatoes = new int[R][C];
		que = new ArrayDeque<>();
		visited = new boolean[R][C];
		minDays = 0;
		
		for (int r = 0; r < R; r++) {
			tokens = new StringTokenizer(input.readLine());
			for (int c = 0; c < C; c++) {
				tomatoes[r][c] = Integer.parseInt(tokens.nextToken());
				
				if(tomatoes[r][c]==RIPE) {
					que.offer(new Roc(r, c));
					visited[r][c]=true;
				}
			}
		}
		
		bfs();
		
		if(!checkTomato()) {
			System.out.println(-1);			
		}else {
			System.out.println(minDays-1);
		}
	}

	private static boolean checkTomato() {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(tomatoes[r][c]==UNRIPE) return false;
			}
		}
		return true;
	}

	private static void bfs() {
		while (!que.isEmpty()) {
			int size = que.size();
//			System.out.println(size);
			
			while (size-- >0) {
				Roc now = que.poll();
				
				for (int d = 0; d < deltas.length; d++) {
					int nr = now.r + deltas[d][0];
					int nc = now.c + deltas[d][1];
					
					if(!isIn(nr, nc)) continue;
					
					if(tomatoes[nr][nc]==BLANK) continue;
					
					if(!visited[nr][nc] && tomatoes[nr][nc]==UNRIPE) {
						que.offer(new Roc(nr, nc));
						tomatoes[nr][nc] = RIPE;
						visited[nr][nc] = true; 
					}
				}
			}
			
			minDays++;
		}
		
	}
	
	private static boolean isIn(int nr, int nc) {
		if(nr>=0 && nr<R && nc>=0 && nc<C) return true;
		return false;
	}

	

}