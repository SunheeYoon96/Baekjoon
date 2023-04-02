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
	
	static char maze[][];
	static int N, M, answer;
	static final char START='0', END='1';
	static int sr,sc, er,ec;
	static int deltas[][] = {{1,0},{0,1},{-1,0},{0,-1}};
	static boolean visited[][][];
	
	static class Loc{
		int x,y, cnt, key;

		public Loc(int x, int y, int cnt, int key) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.key = key;
		}
	}

	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		maze = new char[N][M];
		
		
		
		for (int i = 0; i < N; i++) {
			String line = input.readLine();
			for (int j = 0; j < M; j++) {
				maze[i][j] = line.charAt(j);
				if(START==maze[i][j]) {
					sr = i;
					sc = j;
					maze[i][j]='.';
				}
			}
		}
		
		answer = bfs();
		
		System.out.println(answer);

	}
	
	private static int bfs() {
		Queue<Loc> que = new ArrayDeque<>();
		visited = new boolean[N][M][64];
		que.offer(new Loc(sr, sc, 0, 0));
		visited[sr][sc][0]=true;
	
		while (!que.isEmpty()) {
			Loc current = que.poll();
			int x = current.x;
			int y = current.y;
			int cnt = current.cnt;
			int key = current.key;
			
			if(maze[x][y]=='1') return cnt;
			
			for (int d = 0; d < deltas.length; d++) {
				int nx = x + deltas[d][0];
				int ny = y + deltas[d][1];
				
				if(!isIn(nx, ny)) continue;
				
				if(visited[nx][ny][key] ||maze[nx][ny]=='#') continue;
				
				if("abcdef".contains(maze[nx][ny]+"")) {
					int n = "abcdef".indexOf(maze[nx][ny]+"");
					int findKey = (1<<n) | key;
					
					if(!visited[nx][ny][findKey]) {
						visited[nx][ny][findKey] = true;
						visited[nx][ny][key] = true;
						que.offer(new Loc(nx, ny, cnt+1, findKey));
					}
					
				}else if("ABCDEF".contains(maze[nx][ny]+"")) {
					int n = "ABCDEF".indexOf(maze[nx][ny]+"");
					int findDoor = 1<<n;
					findDoor = key & findDoor;
					
					if(findDoor > 0) {
						if(!visited[nx][ny][key]) {
							visited[nx][ny][key] = true;
							que.offer(new Loc(nx, ny, cnt+1, key));
						}
					}
					
				}else if(!visited[nx][ny][key]) {
					visited[nx][ny][key] = true;
					que.offer(new Loc(nx, ny, cnt+1, key));
				}
				
			}
		}
		
		return -1;
	}
	
	private static boolean isIn(int nx, int ny) {
		if(nx>=0 && nx<N && ny>=0 && ny<M) return true;
		return false;
	}

	private static String instr ="7 8\r\n" + 
			"a#c#eF.1\r\n" + 
			".#.#.#..\r\n" + 
			".#B#D###\r\n" + 
			"0....F.1\r\n" + 
			"C#E#A###\r\n" + 
			".#.#.#..\r\n" + 
			"d#f#bF.1";
	// 답이 55가 나와야한다. 
}