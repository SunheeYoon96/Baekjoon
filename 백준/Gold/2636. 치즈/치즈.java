import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [키워드]
 * 가운에 비어있는 부분은 뚫리기 전까지는 녹지 않는다.
 * 치즈의 테두리만 녹여나간다.
 * 치즈가 모두 녹는 시간과 다 녹기 1시간전에 남아있는 치즈의 갯수를 구하라
 * 
 * [풀이과정]
 * 0,0 부터 BFS를 진행하면서 1을 만나면 가장 먼저만난 1이니까 외곽에 있는 치즈라고 생각할것
 * 0을 만날때마다 큐에 담으면서 BFS를 진행하면 가운데 뚤린 곳의 0을 가장자리 치즈보다 먼저가지 않을 것
 * 
 * [입력]
 * 가로 세로 최대 100칸
 * 치즈O :1 치즈X:0
 * 
 * [출력] 
 * 첫째 줄에는 치즈가 모두 녹아서 없어지는 데 걸리는 시간을 출력하고
 * 둘째 줄에는 모두 녹기 한 시간 전에 남아있는 치즈조각이 놓여 있는 칸의 개수를 출력한다
 * 
 * @author 윤선희
 * @since 2023.04.02
 * @see https://www.acmicpc.net/problem/2636
 * @performance
 * @category #BFS #시뮬레이션
 */

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, M, map[][];
	static int deletas[][] = {{1,0},{0,1},{-1,0},{0,-1}};
	static int cheese, time;
	static boolean visited[][];
	
	static class Loc{
		int r,c;

		public Loc(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}

	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		
		tokens = new StringTokenizer(input.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		map = new int[N][M];
		cheese = 0;
		
		for (int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
				if (map[r][c]==1) {
					cheese++;
				}
			}
		}
		
		int currentCheese=0; //현재 치즈
		time=0;
		
		while (cheese>0) {
			//현재 남아있는 치즈
			currentCheese = cheese;
			//시간계산
			time++;
			//가장자리 치즈 녹이기
			visited = new boolean[N][M];
			meltBFS();
		}
		
		System.out.println(time);
		System.out.println(currentCheese);
	}
	
	private static void meltBFS() {
		Queue<Loc> que = new ArrayDeque<>();
		que.offer(new Loc(0, 0));
		visited[0][0] = true;
		
		while (!que.isEmpty()) {
			Loc current = que.poll();
			
			for (int d = 0; d < deletas.length; d++) {
				int nr = current.r + deletas[d][0];
				int nc = current.c + deletas[d][1];
				
				if(!isIn(nr, nc)) continue;
				
				//처음 만난 치즈라면 녹이고 
				//치즈가 아니면 큐에 담아서 다음 탐색을 이어가게 한다.
				if(!visited[nr][nc]) {
					visited[nr][nc] = true;
					if(map[nr][nc]==1) {
						cheese--;
						map[nr][nc]=0;
					}else {
						que.offer(new Loc(nr, nc));
					}
				}
				
			}
			
			
			
		}
		
	}
	
	private static boolean isIn(int nr, int nc) {
		if(nr>=0 && nr<N && nc>=0 && nc<M) return true;
		return false;
	}

	private static String instr = "13 12\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 1 1 0 0 0\r\n" + 
			"0 1 1 1 0 0 0 1 1 0 0 0\r\n" + 
			"0 1 1 1 1 1 1 0 0 0 0 0\r\n" + 
			"0 1 1 1 1 1 0 1 1 0 0 0\r\n" + 
			"0 1 1 1 1 0 0 1 1 0 0 0\r\n" + 
			"0 0 1 1 0 0 0 1 1 0 0 0\r\n" + 
			"0 0 1 1 1 1 1 1 1 0 0 0\r\n" + 
			"0 0 1 1 1 1 1 1 1 0 0 0\r\n" + 
			"0 0 1 1 1 1 1 1 1 0 0 0\r\n" + 
			"0 0 1 1 1 1 1 1 1 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0";

}