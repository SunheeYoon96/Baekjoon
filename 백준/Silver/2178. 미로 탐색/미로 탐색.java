
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N;
	static int M;
	static char[][] map;
	static int[][] deltas = {{1,0},{0,-1},{0,1},{-1,0}}; //우좌하상
	static int[][] dist; //bfs를 탐색하면서 계속 지나온 거리를 저장함.
	
	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		map = new char[N][M];
		dist = new int[N][M];
		for(int r=0; r<N; r++) {
			String s = input.readLine();
			for(int c=0; c<M; c++) {
				map[r][c] = s.charAt(c); //데이터가 공백 없이 들어옴 -> 문자열 인덱스로 하나씩 뽑아오기
				dist[r][c] = -1; //거리배열 초기화
			}
		}
		
		Queue<Loc> q = new LinkedList<Loc>();
		
		//인접한 위치를 가는 것이므로 BFS를 선택했다.
		q.offer(new Loc(0,0));
		dist[0][0] = 0; 
		
		while(!q.isEmpty()) {
			//큐에서 좌표하나 꺼내기
			Loc loc = q.poll();
			
			//상하좌우를 돌면서 거리를 탐색하자.
			for(int d=0; d<deltas.length; d++) {
				int nx = loc.x +deltas[d][0];
				int ny = loc.y +deltas[d][1];
				
				
				//범위내에 존재하지 않으면 패스
				if(!isIn(nx, ny)) {
					continue;
				}
				
				//길이 아니거나 이미 방문한 적이 있으면 패스
				if(map[nx][ny]== '0' || dist[nx][ny]!= -1) { //map을 char로 만들었으니까 비교할 때 '0'인 것 까먹지 말자
					continue;
				}
				
				//이제 이동가능한 좌표를 큐에 넣어준다.
				q.offer(new Loc(nx, ny));
				//큐에 넣었다는 것은 방문한 좌표라는 것
				dist[nx][ny] = dist[loc.x][loc.y] +1;
			}
		}
		//마지막 목적지까지 거리를 출력한다.
		//-1로 초기화해놨으므로 +1한다. 
		System.out.println(dist[N-1][M-1] +1);

	}
	
	public static boolean isIn(int nx, int ny) {
		return nx>=0 && nx<N && ny>=0 && ny<M;
	}
	
	
	//위치를 x,y 좌표로 받으니까 클래스로 묶어서 큐에 담아보자.
	//라고 힌트를 받음
	public static class Loc{
		int x;
		int y;
		
		public Loc(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	static String instr = "4 6\r\n" + 
			"101111\r\n" + 
			"101010\r\n" + 
			"101011\r\n" + 
			"111011";

}
