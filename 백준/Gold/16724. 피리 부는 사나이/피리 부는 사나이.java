import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [키워드]
 * 방향을 따라가면서 세이프존을 만들어 사람들이 빠져나갈 수 있게 하자.
 * 방향을 따라나간다 -> 사이클이 생기면 세이프존 만들수 있다.
 * 즉 , 사이클의 갯수가 세이프존의 갯수
 * 
 */

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N,M, savezoneCnt;
	static char map[][];
	static int deltas[][] = {{-1,0},{1,0},{0,-1},{0,1}};
	static boolean visited[][], cyclevisited[][];

	public static void main(String[] args) throws IOException {
		//input  = new BufferedReader(new StringReader(instr));
		
		tokens = new StringTokenizer(input.readLine());
		
		N= Integer.parseInt(tokens.nextToken());
		M= Integer.parseInt(tokens.nextToken());
		
		map = new char[N][M];
		for (int r = 0; r < map.length; r++) {
			String line = input.readLine();
			for (int c = 0; c < map[0].length; c++) {
				map[r][c] = line.charAt(c);
			}
		}
		
		savezoneCnt = 0;
		
		visited = new boolean[N][M];
		cyclevisited = new boolean[N][M];
		
		//모든 점에 대해서 다 dfs로 싸이클을 확인한다.
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[0].length; c++) {
				if(!visited[r][c]) {
					dfs(r,c);
				}
			}
		}

		System.out.println(savezoneCnt);

	}
	
	private static void dfs(int r, int c) {
		visited[r][c] = true;
		
		int dir = -1;
		
		switch (map[r][c]) {
		case 'U':
			dir = 0;
			break;
		case 'D':
			dir = 1;
			break;
		case 'L':
			dir = 2;
			break;
		case 'R':
			dir = 3;
			break;
		}
		
		int nr = r + deltas[dir][0];
		int nc = c + deltas[dir][1];
		
		if(!visited[nr][nc]) {
			dfs(nr, nc);
		}else {
			//이미 방문을 한 곳인데 사이클이 아니라면 세이프존 만들고
			if(!cyclevisited[nr][nc]) savezoneCnt++;
		}
		
		//해당 루프를 싹다 사이클로 만듬.
		cyclevisited[r][c] = true;
		
		
	}

	private static String instr ="3 4\r\n" + 
			"DLLL\r\n" + 
			"DRLU\r\n" + 
			"RRRU";

}