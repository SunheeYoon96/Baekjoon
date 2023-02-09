import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T;
	static int N; //원본배열
	static int M; //잡으려는 구역
	static int[][] map;
	static int maxval;
	
	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		tokens = new StringTokenizer(input.readLine());
		T = Integer.parseInt(tokens.nextToken());
		
		for(int t=1; t<=T; t++) {
			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			M = Integer.parseInt(tokens.nextToken());
			
			map = new int[N][N];
			for(int r=0; r<N; r++) {
				tokens = new StringTokenizer(input.readLine());
				for(int c=0; c<N; c++) {
					map[r][c] = Integer.parseInt(tokens.nextToken());
				}
			}
			
			maxval = Integer.MIN_VALUE;
			
			//N<=15 , 15^4 = 50,625 => 반복문 4개 써도 얼마 안된다. 
			for(int r=0; r<N-M+1; r++) { //M사이즈만한 배열이 생성되니까 최대폭이 N-M+1로 설정 
				for(int c=0; c<N-M+1; c++) {
					int fly=0; //파리 총합 초기화
					//작은 2차원 배열안에 있는 파리를 합하고 최댓값 갱신해줌
					for(int i=0; i<M; i++) {
						for(int j=0; j<M; j++) {
							fly += map[r+i][c+j]; 
						}
					}
					maxval = Math.max(maxval, fly);
				}
				
			}
			output.append("#").append(t).append(" ").append(maxval).append("\n");
			
		}//end testcase
		System.out.println(output);
	}
	
	static String instr = "10\r\n" + 
			"5 2\r\n" + 
			"1 3 3 6 7\r\n" + 
			"8 13 9 12 8\r\n" + 
			"4 16 11 12 6\r\n" + 
			"2 4 1 23 2\r\n" + 
			"9 13 4 7 3\r\n" + 
			"6 3\r\n" + 
			"29 21 26 9 5 8\r\n" + 
			"21 19 8 0 21 19\r\n" + 
			"9 24 2 11 4 24\r\n" + 
			"19 29 1 0 21 19\r\n" + 
			"10 29 6 18 4 3\r\n" + 
			"29 11 15 3 3 29\r\n" + 
			"7 5\r\n" + 
			"17 24 11 29 18 21 11\r\n" + 
			"8 5 14 0 19 15 17\r\n" + 
			"18 25 29 1 29 16 16\r\n" + 
			"3 26 27 20 6 2 27\r\n" + 
			"20 13 19 8 13 29 15\r\n" + 
			"8 22 8 23 21 7 6\r\n" + 
			"14 9 9 27 16 23 29\r\n" + 
			"8 6\r\n" + 
			"5 27 4 27 24 9 17 27\r\n" + 
			"22 3 2 17 23 15 16 20\r\n" + 
			"27 27 24 27 9 15 29 26\r\n" + 
			"9 8 4 3 8 15 28 28\r\n" + 
			"27 25 24 7 16 29 20 20\r\n" + 
			"17 6 22 14 2 14 8 27\r\n" + 
			"19 13 6 4 11 10 6 10\r\n" + 
			"14 12 13 4 8 2 25 4\r\n" + 
			"9 5\r\n" + 
			"8 11 16 28 11 15 27 9 15\r\n" + 
			"12 22 10 18 15 5 20 0 27\r\n" + 
			"16 17 4 6 14 25 19 21 11\r\n" + 
			"12 15 26 10 27 18 26 19 4\r\n" + 
			"5 28 22 23 15 9 4 22 4\r\n" + 
			"14 25 17 22 10 8 29 19 0\r\n" + 
			"14 7 5 28 20 16 20 25 9\r\n" + 
			"9 25 12 26 21 12 26 24 23\r\n" + 
			"14 5 27 4 22 1 17 11 16\r\n" + 
			"10 8\r\n" + 
			"2 1 10 12 14 8 14 9 14 6\r\n" + 
			"5 28 6 9 7 16 17 29 18 27\r\n" + 
			"4 3 6 29 15 3 20 13 2 13\r\n" + 
			"28 7 27 22 11 8 19 11 6 2\r\n" + 
			"24 5 22 27 15 11 9 3 25 18\r\n" + 
			"10 11 3 21 13 14 13 13 24 17\r\n" + 
			"19 17 12 18 12 20 8 17 16 22\r\n" + 
			"10 0 14 17 29 1 3 11 28 28\r\n" + 
			"27 25 16 29 19 7 7 19 1 3\r\n" + 
			"6 20 26 23 8 10 21 12 6 0\r\n" + 
			"11 3\r\n" + 
			"15 9 11 16 2 12 10 26 28 0 28\r\n" + 
			"23 28 24 17 10 1 11 23 10 15 16\r\n" + 
			"5 18 6 9 18 29 0 2 9 13 14\r\n" + 
			"14 12 1 6 11 17 15 0 13 13 6\r\n" + 
			"24 3 10 27 27 9 12 25 7 6 1\r\n" + 
			"25 14 14 13 6 13 12 11 23 28 25\r\n" + 
			"4 6 23 4 1 15 11 12 16 11 4\r\n" + 
			"13 19 17 25 3 15 0 11 4 15 20\r\n" + 
			"21 11 3 25 25 12 22 1 17 26 10\r\n" + 
			"8 21 11 6 22 27 7 4 14 21 2\r\n" + 
			"6 15 15 1 27 10 19 28 24 0 17\r\n" + 
			"12 8\r\n" + 
			"1 17 11 27 26 0 16 10 25 12 6 12\r\n" + 
			"0 7 0 4 18 28 8 1 4 3 2 22\r\n" + 
			"3 22 7 25 19 19 26 19 1 0 7 29\r\n" + 
			"0 10 0 16 5 8 2 14 3 1 28 14\r\n" + 
			"3 26 17 16 27 23 24 4 6 26 17 20\r\n" + 
			"18 14 29 7 12 25 16 0 27 2 5 13\r\n" + 
			"25 24 5 0 27 10 15 3 23 4 1 11\r\n" + 
			"28 13 9 19 29 27 22 2 2 6 13 20\r\n" + 
			"4 24 4 3 16 23 3 1 13 11 28 18\r\n" + 
			"13 29 26 21 14 11 6 23 29 25 13 6\r\n" + 
			"7 12 6 21 20 21 4 24 8 4 16 10\r\n" + 
			"14 19 20 18 24 2 3 0 17 23 13 13\r\n" + 
			"13 3\r\n" + 
			"9 14 5 19 19 28 26 17 7 23 1 17 19\r\n" + 
			"1 22 3 22 20 25 21 1 18 18 0 7 0\r\n" + 
			"25 2 22 24 25 18 25 29 19 7 25 27 29\r\n" + 
			"2 14 23 15 4 25 16 29 29 0 22 13 29\r\n" + 
			"10 11 1 18 13 23 7 10 14 29 2 10 4\r\n" + 
			"15 5 12 29 25 25 2 20 12 29 25 12 9\r\n" + 
			"21 19 3 16 6 27 24 25 29 7 5 4 26\r\n" + 
			"29 28 6 18 18 16 26 13 13 23 16 9 4\r\n" + 
			"2 20 13 23 19 12 22 27 26 12 21 29 2\r\n" + 
			"21 0 7 29 25 6 24 27 27 19 3 28 6\r\n" + 
			"7 15 8 13 19 5 29 11 16 12 25 3 17\r\n" + 
			"4 27 3 28 0 24 3 28 13 18 24 6 22\r\n" + 
			"24 6 20 8 2 7 29 13 3 20 29 0 23\r\n" + 
			"14 9\r\n" + 
			"19 27 28 26 4 28 23 14 7 9 27 27 17 21\r\n" + 
			"7 12 29 19 10 5 17 18 19 15 13 13 1 9\r\n" + 
			"2 0 14 7 22 8 8 20 7 10 7 23 19 21\r\n" + 
			"6 5 8 6 24 27 9 17 19 24 25 17 0 19\r\n" + 
			"18 8 18 26 8 24 8 11 15 18 0 23 26 7\r\n" + 
			"17 7 12 15 1 27 24 24 7 24 2 1 19 10\r\n" + 
			"6 18 2 15 21 5 24 11 11 17 24 28 0 6\r\n" + 
			"3 8 12 6 23 6 2 3 7 9 6 18 21 25\r\n" + 
			"14 3 27 11 0 21 27 27 3 29 28 28 6 4\r\n" + 
			"20 3 15 14 13 28 6 4 2 2 14 22 16 7\r\n" + 
			"10 17 1 5 26 22 18 17 8 19 11 3 20 5\r\n" + 
			"11 13 15 14 22 2 25 13 29 5 14 4 27 17\r\n" + 
			"15 10 9 18 0 16 4 25 17 1 6 12 6 20\r\n" + 
			"24 1 24 2 12 7 3 21 10 21 19 29 0 5\r\n" + 
			"";

}
