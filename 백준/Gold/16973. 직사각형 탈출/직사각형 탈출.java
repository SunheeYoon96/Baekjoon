import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int[][] map;
	static int N, M, H, W, sr, sc, fr, fc, cnt; // s는 시작, f는 마지막
	static int[][] deltas = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static boolean[][] visited;

	// 위치정보 클래스
	//위치정보 클래스
	public static class Loc{
		int x, y,count;

		public Loc(int x, int y,int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}

	public static void main(String[] args) throws IOException {
		// input = new BufferedReader(new StringReader(instr));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());

		map = new int[N][M];
		for (int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}

		tokens = new StringTokenizer(input.readLine());
		H = Integer.parseInt(tokens.nextToken());
		W = Integer.parseInt(tokens.nextToken());
		sr = Integer.parseInt(tokens.nextToken());
		sc = Integer.parseInt(tokens.nextToken());
		fr = Integer.parseInt(tokens.nextToken());
		fc = Integer.parseInt(tokens.nextToken());

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == 1) {
					int wallr = r - H;
					int wallc = c - W;

					for (int i = r; i > wallr && i>=0; i--) {
						for (int j = c; j > wallc && j>=0; j--) {
							map[i][j] = 1;
						}
					}
				}
			}
		}
		
		cnt = -1;
		bfs(new Loc(sr-1, sc-1, 0));
		System.out.println(cnt);

//		for(int row[] : map) {
//			for(int x : row) {
//				System.out.print(x + " ");
//			}
//			System.out.println();
//		}

	}

	public static void bfs(Loc start) {
		Queue<Loc> que = new ArrayDeque<Loc>();
		visited = new boolean[N][M];

		que.offer(start);
		visited[start.x][start.y] = true;
		
		while(!que.isEmpty()) {
			Loc current = que.poll();
			
			if(current.x==fr-1 && current.y==fc-1) {
				cnt = current.count;
				break;
			}
			
			if(fr+H-1>N || fc+W-1>M) {
				cnt = -1;
				break;
				
			}

			for(int d=0; d<deltas.length; d++) {
				int nr = current.x +deltas[d][0];
				int nc = current.y +deltas[d][1];
				
				if(nr<0 || nr>=N || nc <0 || nc>=M) continue;
				if(visited[nr][nc]) continue;
				
				if(nr>=0 && nr<N-H+1 && nc>=0 && nc<M-W+1 && map[nr][nc]==0 && !visited[nr][nc]) {
					que.offer(new Loc(nr, nc, current.count+1));
					visited[nr][nc] = true;
				}
			}
		}
		
	}

	public static boolean isIn(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= M)
			return false;
		return true;
	}

}
