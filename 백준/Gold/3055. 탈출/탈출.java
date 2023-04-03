
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, M, sr, sc, er, ec, answer;
	static int deltas[][] = {{1,0},{0,1},{-1,0},{0,-1}};
	static char forest[][];
	static final char START='S', END='D', WATER='*'; 
	static Queue<Loc> waterQue;
	static Queue<Loc> beaverQue;
	
	static class Loc {
		int r,c, time;

		public Loc(int r, int c, int time) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
		}
		
	}

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		forest = new char[N][M];
		waterQue = new ArrayDeque<>();
		beaverQue = new ArrayDeque<>();
		
		for (int r = 0; r < forest.length; r++) {
			String line = input.readLine();
			for (int c = 0; c < forest[r].length; c++) {
				forest[r][c] = line.charAt(c);
				
				if(forest[r][c] == WATER) {
					waterQue.offer(new Loc(r, c, 0));
				}else if(forest[r][c] == 'S') {
					beaverQue.offer(new Loc(r, c, 0));
				}
				
			}
		}
		
		
		answer = escape();
		
		if(answer==-1) {
			System.out.println("KAKTUS");
		}else {
			System.out.println(answer);
		}
		

	}
	
	private static void fillWater(){
		int size = waterQue.size();
		
		while (size-- > 0) {
			Loc cwater = waterQue.poll();
			
			for (int d = 0; d < deltas.length; d++) {
				int nr = cwater.r +deltas[d][0];
				int nc = cwater.c +deltas[d][1];
				
				if(!isIn(nr, nc))continue;
				
				if(forest[nr][nc]=='.' || forest[nr][nc]=='S') {
					forest[nr][nc]=WATER;
					waterQue.offer(new Loc(nr, nc, 0));					
				}
			}
		}
	}
	
	private static int fillBeaver(){
		int size = beaverQue.size();
		
		while (size-- > 0) {
			Loc cbeaver = beaverQue.poll();
			
			for (int d = 0; d < deltas.length; d++) {
				int nr = cbeaver.r +deltas[d][0];
				int nc = cbeaver.c +deltas[d][1];
				int ctime = cbeaver.time;
				
				if(!isIn(nr, nc))continue;
				
				if(forest[nr][nc]==END) return ctime+1;
				
				if(forest[nr][nc]=='.') {
					forest[nr][nc]='S';
					beaverQue.offer(new Loc(nr, nc, ctime+1));					
				}
			}
		}
		
		return -1;
	}

	private static int escape() {
		int result = -1;
		
		while (!(waterQue.isEmpty() && beaverQue.isEmpty())) {
			
			fillWater();
			
			result = fillBeaver();
			
			if(result!=-1) {
				break;
			}
		}
		return result;
	}
	
	private static boolean isIn(int nr, int nc) {
		if(nr>=0 && nr<N && nc>=0 && nc<M) return true;
		return false;
	}

}




