import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

/**
 * [키워드]
 * 바꿔야하는 정사각형의 최소갯수 -> Math.min
 * 체스판의 경우는 시작이 흰색인 경우, 시작이 검정색인 경우 2가지 경우뿐이다.
 * 주어진 수가 작고 제한시간이 2초이므로 완탐 ㄱ
 * 
 * [풀이과정]
 * 주어진 격자를 입력받는다. 
 * 반복문을 돌면서 8X8 체스판으로 쪼갠다.
 * 체스판을 체크하면서 수정해야한 칸을 센다
 * 값을 비교하면서 최솟값으로 갱신한다. 
 *
 * [입력]
 * 
 * [출력] 
 * 8<= N,M <=50
 * 제한시간 2초
 */

public class Main {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N, M, minval;
	static char map[][];
	
	
	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		tokens = new StringTokenizer(input.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		map = new char[N][M];
		
		String line="";
		
		for(int r=0; r<N; r++) {
			line = input.readLine();
			for(int c=0; c<M; c++) {
				map[r][c] = line.charAt(c);
			}
		}
		
		minval = Integer.MAX_VALUE;
		
		for(int r=0; r<=N-8; r++) {
			for(int c=0; c<=M-8; c++) {
				checkChess(r,c);
			}
		}
		
		System.out.println(minval);

	}
	

	//8X8 체스판 만들어서 칸 확인하기
	private static void checkChess(int r, int c) {
		int cnt=0;
		char firstColor = map[r][c];
		
		for(int x=r; x<r+8; x++) {
			for(int y=c; y<c+8; y++) {
				
				if(map[x][y]!=firstColor ) {
					cnt++;
				}
				//비교할때마다 색 변경
				if(firstColor=='W') {
					firstColor='B';
				}else {
					firstColor='W';
				}
			}
			//다음행의 시작
			if(firstColor=='W') {
				firstColor='B';
			}else {
				firstColor='W';
			}
		}
		
		cnt = Math.min(cnt, 64-cnt);
		
		minval = Math.min(cnt, minval);

	}



	static String instr = "8 8\r\n" + 
			"WBWBWBWB\r\n" + 
			"BWBWBWBW\r\n" + 
			"WBWBWBWB\r\n" + 
			"BWBBBWBW\r\n" + 
			"WBWBWBWB\r\n" + 
			"BWBWBWBW\r\n" + 
			"WBWBWBWB\r\n" + 
			"BWBWBWBW";

}