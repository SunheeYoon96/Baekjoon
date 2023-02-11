import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static int[][] map;
	static int rx,ry;
	
	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		
		map = new int[101][101];
		int cnt=0;
		
		//색종이를 숫자로 채우고 0이 아닌것만 카운팅해서 넓이를 구한다. 
		for(int i=1; i<=N; i++) {
			tokens = new StringTokenizer(input.readLine());
			rx = Integer.parseInt(tokens.nextToken());
			ry = Integer.parseInt(tokens.nextToken());
			
			for(int r=rx; r<rx+10; r++) {
				for(int c=ry; c<ry+10; c++) {
					map[r][c] = i;
				}
			}//
		}
		
		for(int r=1; r<=100; r++) {
			for(int c=1; c<=100; c++) {
				if(map[r][c]!=0) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);

	}
	
	static String instr = "3\r\n" + 
			"3 7\r\n" + 
			"15 7\r\n" + 
			"5 2";

}
