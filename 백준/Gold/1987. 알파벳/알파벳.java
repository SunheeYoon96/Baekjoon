
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int R, C, cnt, maxVal;
	static char board[][];
	static String line = "";
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
	static boolean[] visitAlpha;
	
	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		
		
		board = new char[R][C];
		for(int r=0; r<R; r++) {
			line = input.readLine();
			for(int c=0; c<C; c++) {
				board[r][c] = line.charAt(c);
			}
		}
		
		cnt=0;
		maxVal = 0;
		visitAlpha = new boolean[26];
		
		char start = board[0][0];
		visitAlpha[start-'A'] = true;
		dfs(0, 0, 1);
		System.out.println(maxVal);

	}
	
	public static void dfs(int r, int c, int cnt) {
		for(int d=0; d<deltas.length; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			
			if(isIn(nr, nc)) {
				char nextC = board[nr][nc];
				
				if(!visitAlpha[nextC - 'A']) { //방문하지 않았다면
					//방문체크 하고 dfs
					visitAlpha[nextC - 'A'] = true;
					dfs(nr, nc, cnt+1);
					visitAlpha[nextC - 'A'] = false; //이걸해야 백트래킹이라는데..
				}
			}
		}
		
		maxVal = Math.max(maxVal, cnt);
	}
	
	public static boolean isIn(int nr, int nc) {
		if(nr<0 || nr>=R || nc<0 || nc>=C) return false;
		return true;
	}
	
	static String instr = "2 4\r\n" + 
			"CAAB\r\n" + 
			"ADCB";

}
