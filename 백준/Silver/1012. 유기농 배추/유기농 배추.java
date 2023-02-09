import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T; //테케 횟수
	static int N; //행 (세로길이)
	static int M; //열 (가로길이)
	static int K; // 심어진 배추의 갯수
	static int[][] map;
	static boolean[][] visited; //방문확인
	static int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1}};
	static int worms; //배추지렁이
	
	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		tokens = new StringTokenizer(input.readLine());
		T = Integer.parseInt(tokens.nextToken());
		
		for(int t=1; t<=T; t++) {
			tokens = new StringTokenizer(input.readLine());
			M = Integer.parseInt(tokens.nextToken()); //
			N = Integer.parseInt(tokens.nextToken());
			K = Integer.parseInt(tokens.nextToken());
			
			map = new int[M][N];
			visited = new boolean[M][N];
			for(int k=0; k<K; k++) {
				tokens = new StringTokenizer(input.readLine());
				int cx = Integer.parseInt(tokens.nextToken());
				int cy = Integer.parseInt(tokens.nextToken());
				map[cx][cy] = 1; //해당위치는 배추가 심어져있는 곳 
			}
			
			worms=0;
			for(int r=0; r<M; r++) {
				for(int c=0; c<N; c++) {
					//배추가 심어져있고 방문한 적이 없으면 DFS를 수행한다.
					if(map[r][c]==1 && !visited[r][c]){
						dfs(r, c); 
						//DFS가 완료 == 연결된 1이 종료 == 한 덩어리 만들어짐  ==지렁이 1마리
						worms++;
					}
				}
			}
			System.out.println(worms);
		}//end test

	}//
	
	//일단 dfs로 풀어보자. 
	public static void dfs(int x, int y) {
		//방문체크
		visited[x][y] = true;
		//상하좌우 돌면서 DFS 수행
		for(int d=0; d<deltas.length; d++ ) {
			int dx = x+ deltas[d][0];
			int dy = y+ deltas[d][1];
			
			
			if(isIn(dx, dy)) {	//1. 범위내에 존재하고
				if(!visited[dx][dy] && map[dx][dy]==1) { //2. 방문한적 없으면서 배추가 심어져 있는 곳 
					dfs(dx,dy);
				}
				
			}
		}
	}
	
	//범위내에 있는지 확인
	public static boolean isIn(int x, int y) {
		return x>=0 && x<M && y>=0 && y<N ;
	}
	
	static String instr = "2\r\n" + 
			"10 8 17\r\n" + 
			"0 0\r\n" + 
			"1 0\r\n" + 
			"1 1\r\n" + 
			"4 2\r\n" + 
			"4 3\r\n" + 
			"4 5\r\n" + 
			"2 4\r\n" + 
			"3 4\r\n" + 
			"7 4\r\n" + 
			"8 4\r\n" + 
			"9 4\r\n" + 
			"7 5\r\n" + 
			"8 5\r\n" + 
			"9 5\r\n" + 
			"7 6\r\n" + 
			"8 6\r\n" + 
			"9 6\r\n" + 
			"10 10 1\r\n" + 
			"5 5";

}
