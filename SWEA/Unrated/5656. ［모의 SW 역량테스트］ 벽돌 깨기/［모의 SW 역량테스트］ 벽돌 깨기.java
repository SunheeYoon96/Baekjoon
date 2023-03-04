import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T, N, W, H, minVal;
	static int deltas[][] = {{1,0},{-1,0},{0,1},{0,-1}};
	
	static class Point {
		int r,c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(input.readLine());
		
		for (int t = 1; t <= T; t++) {
			output.append("#").append(t).append(" ");
			
			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			W = Integer.parseInt(tokens.nextToken());
			H = Integer.parseInt(tokens.nextToken());
			
			int map[][] = new int[H][W];
			for (int r = 0; r < H; ++r) {
				tokens = new StringTokenizer(input.readLine());
				for (int c = 0; c < W; ++c) {
					map[r][c] = Integer.parseInt(tokens.nextToken());
				}
			}	
			
			minVal = Integer.MAX_VALUE;
			play(0,map);
			output.append(minVal).append("\n");
		}
		System.out.println(output);
	}

	//구슬 한번 던지기
	private static boolean play(int count, int[][] map) {
		//벽돌 갯수 파악하기
		int resultBricks = getRemain(map);
		if(resultBricks==0){
			minVal = 0;
			return true;
		}
		
		if(count==N) {
			if(minVal>resultBricks) minVal = resultBricks;
			return false;
		}
		
		int newMap[][] = new int[H][W];
		
		//모든열에 구슬을 던져보자.
		for (int c = 0; c < W; c++) { //c : 구슬을 던지고자 하는 열
			
			//구슬에 처음 맞는 벽돌 찾기
			int r=0;
			while (r<H && map[r][c]==0) {
				++r;
			}
			
			//맞는 벽돌이 해당열에 없으면 다음 열에 던지기
			if(r==H) continue;
			
			//배열을 원본상태로 초기화하기
			copy(map, newMap);
			
			//벽돌 부수기
			boom(newMap,r,c);
			
			//벽돌내리기
			down(newMap);
			
			//다음 구슬 던지러 가기
			if(play(count+1, newMap)) {
				return true;
			}
		}
	
		return false;	
	}

	//벽돌 내리기
	private static Stack<Integer> stack = new Stack<>();
	private static void down(int[][] map) {
		//각 열에 대해 윗행부터 아래행까지 벽돌만 스택에 넣어두고 빼서 아래행부터 다시 채우기
		for (int c = 0; c < W; c++) {
			for (int r = 0; r < H; r++) {
				if(map[r][c]>0) {
					stack.push(map[r][c]);
					map[r][c]=0;
				}
			}
			
			int r=H-1;
			while (!stack.isEmpty()) {
				map[r--][c] = stack.pop();
			}
		}
	}

	//bfs로 벽돌 부수기
	private static void boom(int[][] map, int r, int c) {
		Queue<Point> queue = new ArrayDeque<>();
		if(map[r][c]>1) {
			queue.offer(new Point(r, c, map[r][c]));
		}
		map[r][c]=0; //방문체크 : 빈공간으로 만든다.
		
		Point current;
		while (!queue.isEmpty()) {
			current = queue.poll();
			
			//현 벽돌의 cnt-1 만큼 4방 체크
			for (int d = 0; d < deltas.length; d++) {
				int nr = current.r;
				int nc = current.c;
				for(int k=1; k<=current.cnt-1; k++) {
					nr += deltas[d][0];
					nc += deltas[d][1];
					
					if(isIn(nr, nc) && map[nr][nc]>0) {
						if(map[nr][nc]>1) {
							queue.offer(new Point(nr, nc, map[nr][nc]));
						}
						map[nr][nc]=0;
					}
				}
			}
		}
	}

	// 배열 복사
	private static void copy(int[][] map, int[][] newMap) {
		 for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				newMap[r][c] = map[r][c];
			}
		}
	}

	private static int getRemain(int[][] map) {
		int count = 0;
		 for (int r = 0; r < H; r++) {
				for (int c = 0; c < W; c++) {
					if(map[r][c]>0) count++;
				}
			}
		return count;
	}
	
	private static boolean isIn(int r, int c) {
		if(r>=0 && r<H && c>=0 && c<W) return true;
		return false;
	}
		
}