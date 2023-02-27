import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M , map[][], magics[][];
	static boolean visited[][];
	static final int di=0, si=1; //d:방향, s:거리
	static List<Loc> clouds;
	static int[][] deltas = {{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};
	static int[][] copydeltas = {{1,1},{-1,1},{1,-1},{-1,-1}};
	//위치 클래스
	public static class Loc {
		int x,y;
		
		public Loc(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	

	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken()); //격자크기
		M = Integer.parseInt(tokens.nextToken()); //마법명령횟수
		
		//맵정보
		map = new int[N][N];
		
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		magics = new int[M][2];
		for(int i=0; i<M; i++) {
			tokens = new StringTokenizer(input.readLine());
			magics[i][di] = Integer.parseInt(tokens.nextToken())-1;
			magics[i][si] = Integer.parseInt(tokens.nextToken());
		}
		
		//초기 구름 생성
		clouds = new ArrayList<Loc>();
		clouds.add(new Loc(N-1, 0));
		clouds.add(new Loc(N-1, 1));
		clouds.add(new Loc(N-2, 0));
		clouds.add(new Loc(N-2, 1));
		
		//마법명령을 M번시행
		for(int m=0; m<M; m++) {
			int dir = magics[m][di]; //방향
			int s = magics[m][si];  //거리
			
			//방문체크는 매번 새로 만들어주자 -> true false 실수를 막기 위해
			visited = new boolean[N][N];
		
			// 1. 구름이 주어진 정보만큼 이동한다.
			moveCloud(dir, s);
			// 2. 구름이 사라진다. 
			// 3. 2에서 생성된 구름칸의 대각선거리가 1인 곳 중 물이 있는 바구니의 갯수 만큼 물이 증가
			copyWater();
			// 4. 물양이 2이상인 곳에 새로운 구름을 만든다.
			newCloudMake();
		}
		//5. 모든 마법 수행후 남은 물의 양
		System.out.println(countWater());
	}


	private static void moveCloud(int dir, int s) {
		s = s%N;
		
		for(int c=0; c<clouds.size(); c++ ) {
			int x = clouds.get(c).x;
			int y = clouds.get(c).y;
			
			x = (x + deltas[dir][0]*s +N) % N;
			y = (y + deltas[dir][1]*s +N) % N;
			
			//구름이 있는 곳에 비내리기(물 추가)
			map[x][y]++;
			//구름이 있는 곳은 방문처리함
			visited[x][y] = true;
			//이동된 위치 다시 넣어주기
			clouds.get(c).x = x;
			clouds.get(c).y = y;
		}	
	}
	
	
	private static void copyWater() {
		for(int c=0; c<clouds.size(); c++) {
			int cnt=0;
			for(int d=0; d<copydeltas.length; d++) {
				int nr = clouds.get(c).x + copydeltas[d][0];
				int nc = clouds.get(c).y + copydeltas[d][1];
				
				if(isIn(nr, nc) && map[nr][nc]>0) {
					cnt++;
				}
			}
			map[clouds.get(c).x][clouds.get(c).y] += cnt;
		}
		clouds.clear();
	}
	
	
	private static void newCloudMake() {
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(!visited[r][c] && map[r][c]>=2 ) {
					map[r][c] -=2;
					clouds.add(new Loc(r, c));
				}
			}
		}
		
	}
	
	private static int countWater() {
		int total=0;
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				total += map[r][c];
			}
		}
		return total;
	}

	//범위체크
	public static boolean isIn(int r, int c) {
		if(r>=0 && r<N && c>=0 && c<N) return true;
		return false;
	}

	static String instr = "5 4\r\n" + 
			"0 0 1 0 2\r\n" + 
			"2 3 2 1 0\r\n" + 
			"4 3 2 9 0\r\n" + 
			"1 0 2 9 0\r\n" + 
			"8 8 2 1 0\r\n" + 
			"1 3\r\n" + 
			"3 4\r\n" + 
			"8 1\r\n" + 
			"4 8";

}