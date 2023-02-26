import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static Loc[] list;
	
	public static class Loc implements Comparable<Loc>{
		int x, y;

		public Loc(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Loc o) {
			if(this.x==o.x) {
				return Integer.compare(this.y, o.y);
			}
			return Integer.compare(this.x, o.x);
		}
	}
	

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		
		list = new Loc[N];
		
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine());
			int x = Integer.parseInt(tokens.nextToken());
			int y = Integer.parseInt(tokens.nextToken());
			list[i] = new Loc(x,y);
		}
		
		Arrays.sort(list);
		
		for(Loc l :list) {
			output.append(l.x).append(" ").append(l.y).append("\n");
		}
		
		System.out.println(output);

	}

}