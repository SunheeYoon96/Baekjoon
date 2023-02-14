
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N; //N행
	static int M; //M열
	static int[][] map; //주어진 배열
	static int rotateCnt; //회전 횟수

	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		rotateCnt = Integer.parseInt(tokens.nextToken());
		
		map = new int[N][M];
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		int block = Math.min(N, M)/2;
		
		for(int b=0; b<block; b++) {// 회전하는 줄의 횟수
			int smallRotate = rotateCnt % (2*((N-b*2)-1 +(M-b*2)-1));
			int sr=0+b, sc=0+b;
			int er=N-1-b, ec=M-1-b;
			//int smallRotate = 1;
			for(int s=0; s<smallRotate; s++) {
				int tmp = map[sr][sc];
				for(int c=sc+1; c<=ec; c++) {
					map[sr][c-1] = map[sr][c]; 
				}
				for(int r=sr+1; r<=er; r++) {
					map[r-1][ec] = map[r][ec];
				}
				for(int c=ec-1; c>=sc; c--) {
					map[er][c+1] = map[er][c];
				}
				for(int r=er-1; r>=sr; r--) {
					map[r+1][sc] = map[r][sc];
				}
				map[sr+1][sc] = tmp;
			}
			
		}

		for(int[] row : map) {
			for(int x : row) {
				output.append(x +" ");
			}
			output.append("\n");
		}
		
		System.out.println(output);
		

	}
	
	static String instr = "4 4 2\r\n" + 
			"1 2 3 4\r\n" + 
			"5 6 7 8\r\n" + 
			"9 10 11 12\r\n" + 
			"13 14 15 16";

}
