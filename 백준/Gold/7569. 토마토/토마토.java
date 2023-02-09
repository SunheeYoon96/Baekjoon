
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	//static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N; //행(가로)
	static int M; //열(세로)
	static int H; //높이
	static int[][][] box; //토마토 보관 박스
	static Queue<Tomato> q;
	static int days;
	//상하좌우위아래 (여기서 위아래는 Z축을 의미)
	static int[] dx = {0,0,0,0,1,-1};
	static int[] dy = {0,0,-1,1,0,0};
	static int[] dz = {-1,1,0,0,0,0};
	
	//토마토의 3차원 정보를 클래스로 저장
	public static class Tomato{
			int x; //x좌표
			int y; //y좌표
			int z; //z좌표
			
			public Tomato(int x,int y, int z) {
				this.x = x;
				this.y = y;
				this.z = z;
			}
		}
	
	public static boolean isIn(int x,int y, int z) {
		return x>=0 && x<M && y>=0 && y<N && z>=0 && z<H;
	}
	
	//인접한 토마토들을 익혀 나감 => BFS
	public static void BFS () {
		while(!q.isEmpty()) {
			Tomato t = q.poll();
			
			int x = t.x;
			int y = t.y;
			int z = t.z;
			
			for(int d=0; d<6; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				int nz = z + dz[d];
				//토마토가 범위내에 존재하고,
				if(isIn(nx, ny, nz)) {
					//토마토가 안익었으면.
					if(box[nx][ny][nz]==0) {
						//익은토마토에 인접했으니까 상태가 변한다고 생각하고 큐에 담기
						q.offer(new Tomato(nx, ny, nz));
						//익는 날짜를 세기 (+1 하루가 경과해야지 익으니까)
						box[nx][ny][nz] = box[x][y][z] +1;
					}
				}
				
			}
		}
		
		days = Integer.MIN_VALUE;
		
		for(int h=0; h<H; h++) {
			for(int c=0; c<N; c++) {
				for(int r=0; r<M; r++) {
					//System.out.print(box[r][c][h]);
					if(box[r][c][h]==0) {
						days = -1;
						return; //BFS를 다 했는데도 안익은 토마토가 있으면 -1 반환
					}
					
					//날짜비교하기
					days = Math.max(days, box[r][c][h]);
				}
			}
		}
		
		//처음부터 토마토가 모두 익은 경우
		if(days == 1) {
			days = 0;
		}else { 
			//최종 일수는 day-1
			days -= 1;
		}
		//return;		
	}
	
	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		tokens = new StringTokenizer(input.readLine());
		M = Integer.parseInt(tokens.nextToken());
		N = Integer.parseInt(tokens.nextToken());
		H = Integer.parseInt(tokens.nextToken());
		
		box =  new int[M][N][H]; //토마토 상자
		q = new LinkedList<Tomato>(); //익은 토마토를 넣을 큐
		
		for(int h=0; h<H; h++) {
			for(int c=0; c<N; c++) {
				//h*N 만큼의 입력이 있음.
				tokens = new StringTokenizer(input.readLine());
				for(int r=0; r<M; r++) {
					box[r][c][h] = Integer.parseInt(tokens.nextToken());
					//배열을 채우면서 익은토마토(1)가 있으면 큐에 담아둔다 ->나중에 BFS할때 꺼내 쓸꺼다. 
					if(box[r][c][h]==1) {
						q.offer(new Tomato(r, c, h));
					}
				}
			}
		}
		BFS();
		System.out.println(days);	

	}
	
	
	
	static String instr = "5 3 1\r\n" + 
			"0 -1 0 0 0\r\n" + 
			"-1 -1 0 1 1\r\n" + 
			"0 0 0 1 1";

}
