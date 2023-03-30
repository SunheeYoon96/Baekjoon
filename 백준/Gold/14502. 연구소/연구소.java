import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [키워드]

 * 
 * [풀이과정]
 * 
 * [입력]
 * (3 ≤ N, M ≤ 8)
 * 0은 빈 칸, 1은 벽, 2는 바이러스가 있는 위치이다. 2의 개수는 2보다 크거나 같고, 10보다 작거나 같은 자연수
 * 빈 칸의 개수는 3개 이상
 * 
 * [출력] 
 * 0
 * @author 윤선희
 * @since 2023.03.29
 * @see https://www.acmicpc.net/problem/14502
 * @performance 
 * @category #dfs #dp 
 */

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, M, map[][], tmpMap[][], wallCnt, answer;
	static int deltas[][] = {{1,0},{0,1},{-1,0},{0,-1}};
	static final int BLANK=0, WALL=1, VIRUS=2;

	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		map = new int[N][M];
		tmpMap = new int[N][M];
		
		for (int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		wallCnt=0;
		answer=-1;
		
		//시뮬시작
		simulate(0);
		
		System.out.println(answer);

	}
	
	private static void simulate(int cnt) {
		//answer=0;
		if(wallCnt==3) {
			//3. 벽을 3칸 모두 구했으면 바이러스 퍼뜨리기
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					tmpMap[r][c] = map[r][c];
				}
			}
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (tmpMap[r][c]==2) {
						spreadVirus(r, c);
					}
				}
			}
			
			//4.안전영역을 구할 때마다 max값으로 갱신하기 
			answer= Math.max(answer, countSafeSpace());
			return;
		}
		
		//1. 벽을 세울 칸을 구하기
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if(map[r][c]==0) {
					//2. 벽 세우기
					map[r][c] = 1;
					wallCnt +=1;
					simulate(wallCnt);
					// 2-2. 시뮬 다 확인하고 오면 다시 되돌리기
					map[r][c] = 0;
					wallCnt -=1;
				}
			}
		}
		
	}

	private static int countSafeSpace() {
		int safeCnt=0;
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if(tmpMap[r][c]==0) safeCnt+=1;	
			}
		}
		
		return safeCnt;
	}

	private static void spreadVirus(int x, int y) {
		for (int d = 0; d < deltas.length; d++) {
			int nr = x + deltas[d][0];
			int nc = y + deltas[d][1];
			
			if(isIn(nr, nc)) {
				if(tmpMap[nr][nc]==0) {
					tmpMap[nr][nc]=2;
					spreadVirus(nr, nc);
				}				
			}
			
		}
		
	}
	
	private static boolean isIn(int nr, int nc) {
		if(nr>=0 && nr<N && nc>=0 && nc<M) return true;
		return false;
	}

	private static String instr = "7 7\r\n" + 
			"2 0 0 0 1 1 0\r\n" + 
			"0 0 1 0 1 2 0\r\n" + 
			"0 1 1 0 1 0 0\r\n" + 
			"0 1 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 1 1\r\n" + 
			"0 1 0 0 0 0 0\r\n" + 
			"0 1 0 0 0 0 0";

}