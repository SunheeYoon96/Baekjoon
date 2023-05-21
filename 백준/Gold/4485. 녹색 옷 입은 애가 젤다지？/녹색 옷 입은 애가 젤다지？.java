import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

import com.sun.java_cup.internal.runtime.virtual_parse_stack;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();;
	static StringTokenizer tokens;
	
	static int N, map[][], loseRupee[][], minVal;
	static int deltas[][] = {{1,0},{0,1},{-1,0},{0,-1}};
	
	static class Loc implements Comparable<Loc>{
		 int r,c, rupee;
		 
		 public Loc(int r, int c, int rupee) {
			 this.r = r;
			 this.c = c;
			 this.rupee = rupee;
		 }
		 
		@Override
		public int compareTo(Loc o) {
			return Integer.compare(this.rupee, o.rupee);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		int tc=1;
		while (true) {
			N = Integer.parseInt(input.readLine());
			if(N==0) break;
			output.append("Problem " + tc++ +": ");
			
			map = new int[N][N];
			loseRupee = new int[N][N];
			minVal = 0;
			
			for (int r = 0; r < N; r++) {
				tokens = new StringTokenizer(input.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(tokens.nextToken());
					loseRupee[r][c] = Integer.MAX_VALUE; //초기셋팅
				}
			}
			
			PriorityQueue<Loc>pq = new PriorityQueue<>();
			pq.offer(new Loc(0, 0, map[0][0]));
			loseRupee[0][0] = map[0][0];
			
			while (!pq.isEmpty()) {
				Loc current = pq.poll();
				int curR = current.r;
				int curC = current.c;
				
				for (int d = 0; d < deltas.length; d++) {
					int nr = curR + deltas[d][0];
					int nc = curC + deltas[d][1];

					if(!isIn(nr, nc)) continue;
					
					if(loseRupee[nr][nc] > loseRupee[curR][curC] + map[nr][nc]) {
						loseRupee[nr][nc] = loseRupee[curR][curC] + map[nr][nc];
						pq.offer(new Loc(nr, nc, loseRupee[nr][nc]));
					}
				}
			}
			
			minVal = loseRupee[N-1][N-1];
			
			output.append(minVal).append("\n");
		}
		System.out.println(output);
		
	}



	private static boolean isIn(int nr, int nc) {
		if(nr>=0 && nr<N && nc>=0 && nc<N) return true;
		return false;
	}

}