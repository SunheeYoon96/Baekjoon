import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, sr,sc,w,h;
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		int map[][] = new int[1001][1001];
		int paper[] = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			tokens = new StringTokenizer(input.readLine());
			sr = Integer.parseInt(tokens.nextToken());
			sc = Integer.parseInt(tokens.nextToken());
			w = Integer.parseInt(tokens.nextToken());
			h = Integer.parseInt(tokens.nextToken());
			for(int r=sr ; r<sr+w; r++) {
				for(int c = sc; c<sc+h; c++) {
					map[r][c] = i;
				}
			}
		}
		
		for(int r=0; r<map.length; r++) {
			for(int c=0; c<map[r].length; c++) {
				paper[map[r][c]]++;
			}
		}
		for(int z =1; z<paper.length; z++) {
			System.out.println(paper[z]);
		}

		
	}
	

}
