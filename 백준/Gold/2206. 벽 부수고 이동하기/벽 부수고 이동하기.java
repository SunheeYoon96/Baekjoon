import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int map[][], N, M;
	static boolean visited[][][];
	static int deltas[][] = {{1,0},{0,-1},{-1,0},{0,1}};
	
	static class Loc{
		int r,c, cnt;
		boolean breakWall;

		public Loc(int r, int c, int cnt, boolean breakWall) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.breakWall = breakWall;
		}
	}

	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		map = new int[N][M];
		
		for (int r = 0; r < N; r++) {
			String str = input.readLine();
			for (int c = 0; c < M; c++) {
				int val = str.charAt(c)-'0';
				map[r][c] = val;
			}
		}
        
		bfs();
	}

	private static void bfs() {
		Queue<Loc> que = new ArrayDeque<>();
		visited = new boolean[N][M][2];
		que.offer(new Loc(0, 0, 1, false));
		
		while (!que.isEmpty()) {
			Loc current = que.poll();
			int curR = current.r;
			int curC = current.c;
			int curCnt = current.cnt;
			boolean canBreak = current.breakWall;
			
			if(curR==N-1 && curC==M-1) {
				System.out.println(current.cnt);
				return;
			}
			
			for (int d = 0; d < deltas.length; d++) {
				int nr = curR + deltas[d][0];
				int nc = curC + deltas[d][1];
				
				if(!isIn(nr, nc)) continue;
				
				if(map[nr][nc]==0) {
					//지금까지 벽을 부신적이 없다면
					if(!canBreak && !visited[nr][nc][0]) {
						que.offer(new Loc(nr, nc, curCnt+1, false));
						visited[nr][nc][0] = true;
					}
					//벽을 이미 부셨다면
					else if(canBreak && !visited[nr][nc][1]) {
						que.offer(new Loc(nr, nc, curCnt+1, true));
						visited[nr][nc][1] = true;
					}
				}else if(map[nr][nc]==1) {
					//벽을 만났는데 벽을 한번도 부신적이 없다면 부시고 이동하자.
					if(!canBreak) {
						que.offer(new Loc(nr, nc, curCnt+1, true));
						visited[nr][nc][1] =true;
					}
				}
			}
			
		}
		//종료지점까지 갈 수 없다면.
		System.out.println(-1);
		
	}
	
	private static boolean isIn(int nr, int nc) {
		if(nr<0 || nr>=N || nc<0 || nc>=M) return false;
		return true;
	}
	
	private static String instr = "6 4\r\n" + 
			"0100\r\n" + 
			"1110\r\n" + 
			"1000\r\n" + 
			"0000\r\n" + 
			"0111\r\n" + 
			"0000";
	
	//답 : 15

}