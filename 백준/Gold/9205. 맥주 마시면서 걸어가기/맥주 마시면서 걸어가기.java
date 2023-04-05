import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int T, N;
	static Loc start , end;
	static ArrayList<Loc> convi;
	
	static class Loc {
		int r, c, id;

		public Loc(int r, int c, int id) {
			super();
			this.r = r;
			this.c = c;
			this.id = id;
		}

		@Override
		public String toString() {
			return "Loc [r=" + r + ", c=" + c + ", id=" + id + "]";
		}	
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(input.readLine());
		
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(input.readLine());
			convi = new ArrayList<>();
			
			//시작점
			tokens = new StringTokenizer(input.readLine());
			int x = Integer.parseInt(tokens.nextToken());
			int y = Integer.parseInt(tokens.nextToken());
			start = new Loc(x, y, 0);
			//convi.add(start);
		
			//편의점 입력받기
			
			for (int i = 1; i <= N; i++) {
				tokens = new StringTokenizer(input.readLine());
				x = Integer.parseInt(tokens.nextToken());
				y = Integer.parseInt(tokens.nextToken());
				convi.add(new Loc(x, y, i));
			}
			
			
			//종료점
			tokens = new StringTokenizer(input.readLine());
			x = Integer.parseInt(tokens.nextToken());
			y = Integer.parseInt(tokens.nextToken());
			end = new Loc(x, y, N+1);
			convi.add(end);
			//System.out.println(convi);
			
			if(go()) {
				System.out.println("happy");
			}else {
				System.out.println("sad");
			}
			

			
		}

	}
	
	private static boolean go() {
		boolean visited[] = new boolean[N+2];
		Queue<Loc> que = new ArrayDeque<>();
		que.offer(start);
		//visited[start.id] = true;
		
		while (!que.isEmpty()) {
			Loc now = que.poll();
			
			for(Loc l : convi) {
				int dist = makeDist(now, l);
				
				if(!visited[l.id] && dist<=1000) {
					visited[l.id] = true;
					que.offer(l);
				}
			}
			
		}
		return visited[N+1];

	}

	private static int makeDist(Loc v1, Loc v2) {
		return Math.abs(v1.r-v2.r) + Math.abs(v1.c-v2.c);	
	}
	
	

}