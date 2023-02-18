import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[][] triangles;
	static int maxVal;
	
	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		
		while(true) {
			tokens = new StringTokenizer(input.readLine());
			int x = Integer.parseInt(tokens.nextToken());
			int y = Integer.parseInt(tokens.nextToken());
			int z = Integer.parseInt(tokens.nextToken());
			
			if(x==0 && y==0 && z==0) break;
			
			if( x*x + y*y == z*z ) {
				output.append("right").append("\n");
			}else if( z*z + y*y == x*x ) {
				output.append("right").append("\n");
			}else if( x*x + z*z == y*y ) {
				output.append("right").append("\n");
			}else {
				output.append("wrong").append("\n");
			}
		}
		
		System.out.println(output);


	}
	
	static String instr = "6 8 10\r\n" + 
			"25 52 60\r\n" + 
			"5 12 13\r\n" + 
			"0 0 0";

}
