import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [키워드]
 * 가구가 놓여져 있는 칸은 이동할 수 없다.
 * 로봇은 같은 칸을 여러번 방문할 수 있다.
 * 더러운 칸의 갯수는 10개가 넘지 않는다. 
 * 
 * [풀이과정]
 * 1. 주어진 정보를 입력받는다.
 * 	-- 이때, 로봇청소기의 위치를 저장해두고 각 먼지의 위치도 따로 list에 추가해둔다.
 * 2. 로봇청소기와 더러운 곳의 거리를 구한다.
 * 3. 더러운 곳 끼리의 거리도 구한다. (현재더러운곳 청소후 다른더러운 곳으로 이동해야하기 때문에)
 * 	-- 단, 도달할 수 없는 곳이 있으면 -1을 리턴한다.
 * 4. 더러운 칸을 가는 순서를 정해서 실행한다
 * 	-- 10개를 넘지 않는다고 했으므로 순열을 구할 수 있음. 
 * 
 * [입력]
 * [출력] 
 * @since 
 * @see
 * @performance
 * @category #
 */

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M, distance[][], answer, dirtyCnt;
	static char room[][];
	static int deltas[][] = {{1,0},{0,1},{-1,0},{0,-1}};
	static Dirty[] dirtyThings;
	static boolean visited[][], isSelected[];
	
	//더러운칸 위치 클래스
	static class Dirty {
		int r, c;

		public Dirty(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		
		while (true) {
			tokens = new StringTokenizer(input.readLine());
			M = Integer.parseInt(tokens.nextToken()); //열
			N = Integer.parseInt(tokens.nextToken()); //행
			
			//종료조건
			if(N==0 && M==0) break;
			
			//로봇청소기위치 와 더러운칸들 정보가 담길 리스트
			dirtyThings = new Dirty[11]; //10개를 안넘음
			distance = new int[11][11];
			room = new char[N][M];
			dirtyCnt = 1; //더러운칸 인덱스
			
			answer = Integer.MAX_VALUE; //최대fh 초기화(최솟값을 구할꺼니까)
			
			 for (int r = 0; r < N; r++) {
				 char line[] = input.readLine().toCharArray();
				 for (int c = 0; c < M; c++) {
					 //방 현황
					 room[r][c] = line[c];
					 
					 //로봇 & 더러운칸 위치 저장0
					 if(room[r][c]=='o') {
						 //로봇청소기 위치에서부터 탐색할꺼임
						 dirtyThings[0] = new Dirty(r, c);
					 }else if (room[r][c]=='*'){
						 dirtyThings[dirtyCnt++] = new Dirty(r, c);
					 }
				}
			}
			// 입력완료
			 			
			 
			isSelected = new boolean[dirtyCnt]; 
			
			//4. 더러운 칸을 가는 순서를 정해서 실행한다
			if(canGo()) {
				makePermutation(0, 0, 0);
				output.append(answer).append("\n");
			}else {
				output.append(-1).append("\n");
			}
			
		}//end while
		
		System.out.println(output);
		
	}
	
	
	//더러운 칸까지 이동여부 & 이동거리 구하기 
	private static boolean canGo() {
		for(int i=0; i<dirtyCnt; i++) {
			for (int j = i+1; j < dirtyCnt; j++) {
				
				//2. 로봇청소기와 더러운 곳의 거리 & 더러운곳 더러운곳 거리
				//이동시작 ~ 이동 끝위치 를 각각 bfs로 최소거리 구함
				int dist = bfs(dirtyThings[i], dirtyThings[j]);
				
				if(dist==-1) {
					return false;
				}else {
					distance[i][j] = distance[j][i] = dist;
				}
			}
		}
		
		return true;
	}
	
	
	//목적지로 가는 최단거리
	private static int bfs(Dirty start, Dirty end) {
		//1. 준비물
		Queue<Dirty> que = new ArrayDeque<>();
		visited = new boolean[N][M];
		
		//2. 초기화
		que.add(start);
		visited[start.r][start.c] = true;
		int dist = 0;
		
		while (!que.isEmpty()) {
			int size = que.size();
			dist += 1;
			
			while (size-- > 0) {
				Dirty current = que.poll();
				
				for(int d=0; d<deltas.length; d++) {
					int nr = current.r + deltas[d][0];
					int nc = current.c + deltas[d][1];
					
					if(!isIn(nr, nc)) continue;
					
					if(visited[nr][nc]) continue;
					
					if(room[nr][nc]=='x') continue;
					
					if(nr==end.r && nc==end.c) {
						return dist;
					}
					
					visited[nr][nc] = true;
					que.add(new Dirty(nr, nc));
				}
			}		
		}
		return -1;
	}
	
	
	//청소 순서
	private static void makePermutation(int current, int nthpick, int sumDist ) {
		
		if(nthpick == dirtyCnt-1) {// 로봇청소기는 빼고
			answer = Math.min(answer, sumDist);
			return;
		}
		
		for(int i=1; i<dirtyCnt; i++) { 
			if(!isSelected[i]) {
				isSelected[i] = true;
				makePermutation(i, nthpick+1, sumDist + distance[current][i]);
				isSelected[i] = false;
			}
		}
	}
	
	private static boolean isIn(int nr, int nc) {
		if(nr>=0 && nr<N && nc>=0 && nc<M) return true;
		return false;
	}
	
	

}