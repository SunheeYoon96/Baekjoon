import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준 17144 - 미세먼지 안녕!
public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T; //시행시간 
	static int R; //행
	static int C; //열
	static int[][] map; //집 상태
	static int[] airCleaner; //공기청정기
	static int deltas[][] = {{1,0},{-1,0},{0,1},{0,-1}};
	

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		T = Integer.parseInt(tokens.nextToken());
		map = new int[R][C]; //map 선언 까먹지 말기 ㅜ
		airCleaner = new int[2];
		int i=0;
		
		//주어진 정보 담기
		for(int r=0; r<R; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<C; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
				
				if(map[r][c]==-1) { //값이 -1이면 공기청정기라는 것을 airCleaner에 담아 기억해두기
					airCleaner[i++] = r;
				}
			}
		}
		
		while(T > 0) {
			//1. 미세먼지 확산
			map = dustSpread();

			//2. 공기청정기 순환
			airClean();
			
			T--;
		}
		//3. 총 남은 미세먼지 합
		System.out.println(calcDust());
	}
	
	//배열의 범위 내에 존재하는지 확인하는 함수
	static boolean isIn(int r, int c) {
		return r>=0 && r<R && c>=0 && c<C;
	}
	
	//미세먼지 확산
	public static int[][] dustSpread() { 
		int [][] mapcopy = new int[50][50];
		int dust = 0;
		
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(map[r][c]==-1) {
					mapcopy[r][c] = -1; //공기청정기 위치 먼저 넣어주기
					continue;
				}
				
				int cntD =0;
				for(int d=0; d<deltas.length; d++) {
					int nr = r + deltas[d][0];
					int nc = c + deltas[d][1];
					if(isIn(nr, nc) && map[nr][nc]!=-1) {
						dust = map[r][c];
						mapcopy[nr][nc] += dust/5; 
						cntD++;
					}
						
				}
				mapcopy[r][c] += dust-(dust/5)*cntD;
				
			}
		}
		map = mapcopy;
		return map;
	}
	
	//공기청정기 작동
	public static void airClean() {
		//처음에는 하나씩 미는걸로 생각했으나 그럼 계속 다음걸 기억에 둬야해서
		//공기청정기쪽으로 하나씩 끌어 당기는 로직으로 구현
		
		//공기청정기 기준 상단 (반시계)
		for(int r=airCleaner[0]-1; r>0; r--) { //왼쪽 위 ->아래 (반시계) 
			map[r][0] = map[r-1][0];
		}
		for(int c=0; c<C-1; c++ ) { // <- 방향
			map[0][c] = map[0][c+1];
		}
		for(int r=0; r<airCleaner[0]; r++) {// 오른쪽 아래 ->위 (반시계)
			map[r][C-1] = map[r+1][C-1];
		}
		for(int c=C-1; c>1; c--) {// -> 방향
			map[airCleaner[0]][c] = map[airCleaner[0]][c-1];
		}	
		
		map[airCleaner[0]][1] = 0 ; // 다 밀어줘서 맨 마지막 공간이 비면 0을 넣어준다 (공기가 정화된 것)
		
		//공기청정기 기준 하단 (시계)
		for (int r= airCleaner[1]+1; r < R-1; r++) { //왼쪽 아래 -> 위
            map[r][0] = map[r + 1][0];
        }
        for (int c = 0; c < C-1; c++) { // <-방향
            map[R-1][c] = map[R-1][c + 1];
        }
        for (int r = R-1; r > airCleaner[1]; r--) { //오른 쪽 위 ->아래
            map[r][C-1] = map[r - 1][C-1];
        }
        for (int c = C-1; c > 1; c--) { // ->방향
            map[airCleaner[1]][c] = map[airCleaner[1]][c - 1];
        }
        map[airCleaner[1]][1] = 0; // 다 밀어줘서 맨 마지막 공간이 비면 0을 넣어준다 (공기가 정화된 것)
	}
	
	public static int calcDust() { //미세먼지 계산 
		int sumDust =0;
		
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(map[r][c]!=-1) {
					sumDust += map[r][c];
				}
			}
		}
		return sumDust;
	}

}
