
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[][] map;
	static int maxval;
	static int x,y;
	
	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		
		maxval = Integer.MIN_VALUE;
		x=0; y=0;
		map = new int [10][10];
		for(int r=1; r<=9; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=1; c<=9; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
				maxval = Math.max(maxval, map[r][c]);
			}
		}
		
		for(int r=1; r<=9; r++) {
			for(int c=1; c<=9; c++) {
				if(maxval == map[r][c]) {
					x=r;
					y=c;
				}
				
			}
		}
		
		output.append(maxval).append("\n").append(x).append(" ").append(y);
		System.out.println(output);
	}
	
	static String instr = "3 23 85 34 17 74 25 52 65\r\n" + 
			"10 7 39 42 88 52 14 72 63\r\n" + 
			"87 42 18 78 53 45 18 84 53\r\n" + 
			"34 28 64 85 12 16 75 36 55\r\n" + 
			"21 77 45 35 28 75 90 76 1\r\n" + 
			"25 87 65 15 28 11 37 28 74\r\n" + 
			"65 27 75 41 7 89 78 64 39\r\n" + 
			"47 47 70 45 23 65 3 41 44\r\n" + 
			"87 13 82 38 31 12 29 29 80";

}
