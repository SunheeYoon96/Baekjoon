import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int R,C, office[][], ans, blindSpot;
	static boolean visited[][][];
	static List<Cam> CCTV;
	
	//방향을 남서북동(0123)
	static int[][] deltas = {{1,0},{0,-1},{-1,0},{0,1}};
	static int[][][] camMode = { {{0}}, 
								 {{0},{1},{2},{3}}, //1번 CCTV
								 {{1,3}, {0,2}}, 	//2번 CCTV
								 {{2,3},{0,3},{0,1},{1,2}}, //3번 CCTV 
								 {{1,2,3},{0,2,3},{0,1,3},{0,1,2}}, //4번 CCTV 
								 {{0,1,2,3}} //5번 CCTV 
								}; 
	
	static final int WALL=6, CHECK=-1;
	
	//CCTV 카메라 클래스
	static class Cam{
		int r,c, type;

		public Cam(int r, int c, int type) {
			super();
			this.r = r;
			this.c = c;
			this.type = type;
		}
		
	}

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		
		office = new int[R][C];
		CCTV = new ArrayList<>();
		blindSpot=0;
		
		for (int r = 0; r < R; r++) {
			tokens = new StringTokenizer(input.readLine());
			for (int c = 0; c < C; c++) {
				office[r][c] = Integer.parseInt(tokens.nextToken());
				if(office[r][c]>0 && office[r][c]<6) {
					CCTV.add(new Cam(r, c, office[r][c]));
					
				}else if (office[r][c]==0) {
					blindSpot +=1; //감시되지 않는 공간 초기값 셋팅
				}
			}
		}
		//입력완
		
		ans = blindSpot;
		
		//cctv의 가능한 조합 만들기
		cctvCombination(0, CCTV.size(), office);

		System.out.println(ans);

	}

	private static void cctvCombination(int nthpick, int r, int[][] office) {
		if(nthpick==r) {
			int blindcnt = checkBlind(office);
			ans = Math.min(ans, blindcnt);
//			for(int row[] : office) {
//				System.out.println(Arrays.toString(row));
//			}
//			System.out.println();
			return;
		}
		
		int nowCctvType = CCTV.get(nthpick).type;
		int nowR = CCTV.get(nthpick).r;
		int nowC = CCTV.get(nthpick).c;
		
		for (int i = 0; i < camMode[nowCctvType].length; i++) {
			int copyMap[][] = copy(office);
			
			for (int j = 0; j < camMode[nowCctvType][i].length; j++) {
				int dir = camMode[nowCctvType][i][j];
				
				int nr = nowR + deltas[dir][0];
				int nc = nowC + deltas[dir][1];
				
				while (true) {
					//범위 밖이면 X
					if(!isIn(nr, nc)) break;
					//벽이면 X
					if(copyMap[nr][nc]==WALL) break;
					//다 아니면 감시체크하기
					copyMap[nr][nc]=CHECK;
					//현재방향으로 전진
					nr += deltas[dir][0];
					nc += deltas[dir][1];
				}
			}
			cctvCombination(nthpick+1, r, copyMap);
		}
	}
	
	
	//맵 복사하기
	private static int[][] copy(int map[][]) {
		int copyMap[][] = new int[R][C];
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				copyMap[r][c] = map[r][c];
			}
		}
		return copyMap;
	}

	//사각지대 갯수 확인
	private static int checkBlind(int[][] office) {
		int cnt = 0;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(office[r][c]==0) cnt+=1;
			}
		}
		return cnt;
	}
	
	private static boolean isIn(int nr, int nc) {
		if(nr>=0 && nr<R && nc>=0 && nc<C) return true;
		return false;
	}

}