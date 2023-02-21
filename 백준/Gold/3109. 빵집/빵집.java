import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int R, C, cnt;
	static char[][] map;
	//어떤 방향이 가장 최선의 탐색인가?
	//최대한 밑에 있는 것에 대해서 공간을 확보해주는 것
	//델타를 정하는 것이 중요함!!
	static int[][] deltas = {{-1,1},{0,1},{1,1}};

	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		
		tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		
		map = new char[R][C];
		String line = "";
		for(int r=0; r<R; r++) {
			line = input.readLine();
			for(int c=0; c<C; c++) {
				map[r][c] = line.charAt(c); 
			}
		}
		
		cnt =0;
		for(int r=0; r<R; r++) {
			if(dfs(r,0)) {
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}
	
	public static boolean dfs(int r, int c) {
		if(c==C-1) {
			return true;
		}
		
		for(int d=0; d<deltas.length; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			
			if(isIn(nr, nc)) {
				if(map[nr][nc]=='.') {
					map[nr][nc]='x';
					if(dfs(nr,nc)) return true;
				}
			}
		}
		return false;
		
	}

	
	public static boolean isIn(int nr, int nc) {
		if(nr<0 || nc<0 || nr>R-1 || nc>C-1) return false;
		return true;
	}
	
	static String instr = "6 10\r\n" + 
			"..x.......\r\n" + 
			".....x....\r\n" + 
			".x....x...\r\n" + 
			"...x...xx.\r\n" + 
			"..........\r\n" + 
			"....x.....";

}
