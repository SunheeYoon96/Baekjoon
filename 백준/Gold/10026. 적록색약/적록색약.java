import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [키워드]
 * R, G,B 색에 따른 구역 분리, 적록색약은 R=G라고 봄, 구역의 수 구하기
 * [풀이과정]
 * 1. 적록색약이 아닌 사람이 보는 그리드 = 주어진 그리드
 * 2. DFS로 구역 찾기
 * 3. 적록색약인 사람이 보는 그리드 = R==G인 그리드로 만들기
 * 4. DFS로 구역 찾기
 * 
 * [입력]
 * 그리드 N*N (1 ≤ N ≤ 100)
 * 
 * [출력] 
 * 적록색약이 아닌 사람이 봤을 때의 구역의 개수와 적록색약인 사람이 봤을 때의 구역의 수를 공백으로 구분해 출력
 * 
 * @author 윤선희
 * @see https://www.acmicpc.net/problem/10026
 * @performance #그래프 #DFS #BFS
 * @category 
 */

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N ;
	static String line;
	static char normal[][], colorWeak[][];
	static boolean nV[][], cV[][];
	static int nCnt, cCnt;
	static int[][]  deltas = {{1,0},{-1,0},{0,1},{0,-1}};

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		
		line = "";
		normal = new char[N][N];
		colorWeak = new char[N][N];
		
		for(int i=0; i<N; i++) {
			line = input.readLine();
			for(int j=0; j<N; j++) {
				normal[i][j] = line.charAt(j);
				colorWeak[i][j] = normal[i][j];
				
				//적록색약은 G도 R로 받자
				if(normal[i][j]=='G') {
					colorWeak[i][j] = 'R';
				}
			}
		}//
		
		nV = new boolean[N][N];
		cV = new boolean[N][N];
		nCnt=0;
		cCnt=0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!nV[i][j]) {
					char nowColor = normal[i][j];
					dfs(i,j,nV, normal, nowColor);
					nCnt++;
				}
				
				if(!cV[i][j]) {
					char nowColor = colorWeak[i][j];
					dfs(i,j,cV, colorWeak, nowColor);
					cCnt++;				
				}
			}
		}
		
		System.out.println(nCnt + " " + cCnt);
		
		
		
//		for(char row[] : normal) {
//			for(char c : row) {
//				System.out.print(c +" ");
//			}
//			System.out.println();
//		}
//		
//		System.out.println();
//		
//		for(char row[] : colorWeak) {
//			for(char c : row) {
//				System.out.print(c +" ");
//			}
//			System.out.println();
//		}

	}

	private static void dfs(int r, int c, boolean[][] visited, char[][] map, char nowColor) {
		visited[r][c] = true;
		
		for(int d=0; d<deltas.length; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			
			if(nr>=0 && nr<N && nc>=0 && nc<N) {
				if(!visited[nr][nc] && map[nr][nc]==nowColor) {
					visited[r][c] = true;
					dfs(nr, nc, visited, map, map[nr][nc]);
				}
			}
		}
		
		
	}
	


}





























