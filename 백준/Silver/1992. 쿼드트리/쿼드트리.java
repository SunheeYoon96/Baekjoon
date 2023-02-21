import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static int N;
	static char[][] quardMap;
	
	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		N = Integer.parseInt(input.readLine());
		
		String line = "";

		quardMap = new char[N][N];
		for(int r=0; r<N; r++) {
			line = input.readLine();
			for(int c=0; c<N; c++) {
				quardMap[r][c] = line.charAt(c);
			}
		}
		//분할비교
		cutQuard(0,0,N);
		System.out.println(output);

	}
	
	private static void cutQuard(int r, int c, int size) {
		int sum=0;
		//분할비교를 위해 각 공간의 값을 누적으로 더해놓기
		for(int i=r, rEnd=r+size; i<rEnd; i++) {
			for(int j=c, cEnd=c+size; j<cEnd; j++) {
				sum += quardMap[i][j]-'0';
			}
		}
        
		//모든 칸에 1이 들어있는 경우
		if(sum==size*size) {
			output.append(1);
		//모든 칸이 0이 있는 경우
		}else if (sum==0) {
			output.append(0);
		//섞여있는 경우
		}else {
			//분할이 시작되면 괄호를 시작해서 묶기
			output.append("(");
			int half = size/2;
			cutQuard(r, c, half);
			cutQuard(r, c+half, half);
			cutQuard(r+half, c, half);
			cutQuard(r+half, c+half, half);
			output.append(")");
		}
	}

	static String instr = "8\r\n" + 
			"11110000\r\n" + 
			"11110000\r\n" + 
			"00011100\r\n" + 
			"00011100\r\n" + 
			"11110000\r\n" + 
			"11110000\r\n" + 
			"11110011\r\n" + 
			"11110011";

}
