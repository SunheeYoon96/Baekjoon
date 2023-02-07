import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class  Solution {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[][] ladder;
	static int[][] deltas = {{0,-1},{0,1},{-1,0}};
	static int endr;
	static int endc;

	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		for(int t=1; t<=10; t++) {
			input.readLine(); //첫줄 버리기
			endr=0; endc=0;
			
			ladder = new int[100][100];
			for(int r=0; r<100; r++) {
				tokens = new StringTokenizer(input.readLine());
				for(int c=0; c<100; c++) {
					ladder[r][c] = Integer.parseInt(tokens.nextToken());
	
					if(ladder[r][c] == 2) {
						endr = r;
						endc = c;
					}
				}
			}//end r
			
			while(endr !=0) { //사다리 역으로 타고 올라가기
				for(int d=0; d<deltas.length; d++) {
					int nr = endr+deltas[d][0];
					int nc = endc+deltas[d][1];
					
					if(isIn(nr, nc) && ladder[nr][nc]==1) {
						ladder[endr][endc]=0;
						endr = nr;
						endc = nc;
						break;
					}
				}
			}//end while
			//어떤열에서 시작한지 구해야한다. 
			output.append("#").append(t).append(" ").append(endc).append("\n");
		}//end tc
		System.out.println(output);

	}
	
	public static boolean isIn(int r, int c) {
		return r>=0 && r<100 && c>=0 && c<100; //true
	}
	
}
