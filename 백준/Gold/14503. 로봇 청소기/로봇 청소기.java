import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, M, room[][], answer;
	static int deltas[][] = {{-1,0},{0,1},{1,0},{0,-1}}; //북서남동 (반시계)
	static Loc start;
	
	static class Loc {
		int r,c,dir;

		public Loc(int r, int c, int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Loc [r=" + r + ", c=" + c + ", dir=" + dir + "]";
		}
		
	}

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		room = new int[N][M];
		
		tokens = new StringTokenizer(input.readLine());
		int sr = Integer.parseInt(tokens.nextToken());
		int sc = Integer.parseInt(tokens.nextToken());
		int sdir = Integer.parseInt(tokens.nextToken());
		
		start = new Loc(sr, sc, sdir);
		
		for (int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for (int c = 0; c < M; c++) {
				room[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		answer = 0;
		bfs();
		
		System.out.println(answer);
	}

	private static void bfs() {
		Queue<Loc> que = new ArrayDeque<>();
		que.offer(start);
		room[start.r][start.c] = -1; //청소하기(방문처리)
		answer++;
		
		while(!que.isEmpty()){
			Loc  cur = que.poll();
	        
	        // 1. 현재 위치 청소하기
	        if(room[cur.r][cur.c]==0){
	        	room[cur.r][cur.c]=-1;
	            answer++;
	        }
	        
	        // 2. 반시계 90도 회전
	        boolean isDust = false;
	        int newd = cur.dir;
	        
	        for(int i=0; i<4; i++){
	        	newd = changeDir(newd);
	            
	            int nr = cur.r + deltas[newd][0];
	            int nc = cur.c + deltas[newd][1];
	            
	            //범위내에 없거나
//	            if(!isIn(nr, nc)) continue;
	            //이미 방문했거나
	            if(room[nr][nc]==-1) continue;
	            //벽이면
	            if(room[nr][nc]== 1) continue;
	            
	            //4방향 중 청소가 안되어있는 곳을 만나면 큐에 넣기
	            que.offer(new Loc(nr, nc, newd));
	            isDust = true;
	            break; //1번으로 돌아감
	        }
	        
	        // 4방향 모두 청소할 곳이 없는 경우
	        if(!isDust){
	            //후진
	            int bd = backDir(cur.dir);
	            
	            int nr = cur.r + deltas[bd][0];
	            int nc = cur.c + deltas[bd][1];
	            
//	            if(!isIn(nr, nc)) continue;
	            
	            if(room[nr][nc] != 1){
	            	que.offer(new Loc(nr, nc, cur.dir)); //원래방향유지
	                continue;
	            }
	            //벽이면 후진 못함
	            else{
	                return;
	            }
	        }
	    }
		
		
	}
	
	//뒤로 후진
	public static int backDir(int d) {
		return (d+2)%4;
	}
	
	//반시계방향으로 90도 회전
	public static int changeDir(int d) {
		if(d==0) return 3;
		else return d-1;
	}
	
	private static boolean isIn(int nr, int nc) {
		if(nr>=0 && nr<N && nc>=0 && nc<M) return true;
		return false;
	}

}