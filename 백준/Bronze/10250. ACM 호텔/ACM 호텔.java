
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T;
	static int width;
	static int height;
	static int target;
	static int[][] hotel;

	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		tokens = new StringTokenizer(input.readLine());
		T = Integer.parseInt(tokens.nextToken());
		
		for(int t=0; t<T; t++) {
			tokens = new StringTokenizer(input.readLine());
			height = Integer.parseInt(tokens.nextToken());
			width = Integer.parseInt(tokens.nextToken());
			target = Integer.parseInt(tokens.nextToken());
			
			int cnt=1;
			int room = 0;
			hotel = new int[height][width];
			
			for(int c=0; c<width; c++) {
				for(int r=height-1; r>=0; r--) {
					hotel[r][c] = cnt;
					cnt++;
				}
			}
			
			for(int c=0; c<width; c++) {
				for(int r=height-1; r>=0; r--) {
					if(target == hotel[r][c]) {
						room = (height-1-r+1)*100 + c+1;
					}
				}
			}
			output.append(room).append("\n");
        }
		System.out.println(output);

	}
	
	static String instr = "2\r\n" + 
			"6 12 10\r\n" + 
			"30 50 72";

}
