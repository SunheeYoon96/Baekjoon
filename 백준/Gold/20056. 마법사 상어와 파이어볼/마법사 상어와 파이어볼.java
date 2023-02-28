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
	static StringTokenizer tokens;
	static int N, M, K, ans;
	static int visited[][];
	static int deltas[][] = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}}; //01234567 8방향 순서대로
	static List<FireBall> fireBalls;
	
	static class FireBall {
		int r,c;
		int m; //무게
		int s; //속력
		int d; //방향
		
		public FireBall(int r, int c, int m, int s, int d) {
			super();
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}

		@Override
		public String toString() {
			return "FireBall [r=" + r + ", c=" + c + ", m=" + m + ", d=" + d + ", s=" + s + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken()); //격자크기
		M = Integer.parseInt(tokens.nextToken()); //초기 파이어볼 갯수
		K = Integer.parseInt(tokens.nextToken()); //마법 시행 횟수
		
		//초기 파이어볼 정보 입력받기
		visited = new int[N][N];
		fireBalls = new ArrayList<FireBall>();
		
		for(int m=0; m<M; m++) {
			tokens = new StringTokenizer(input.readLine());
			int r = Integer.parseInt(tokens.nextToken())-1;
			int c = Integer.parseInt(tokens.nextToken())-1;
			int mass = Integer.parseInt(tokens.nextToken());
			int s = Integer.parseInt(tokens.nextToken());
			int d = Integer.parseInt(tokens.nextToken());
			
			fireBalls.add(new FireBall(r, c, mass, s, d));
			visited[r][c]++;
		}
		
		//마법 횟수만큼 반복문 시행
		for(int k=0; k<K; k++) {
			//1. 파이어볼 이동
			moveFireBall();
			//2. 겹치는 파이어볼 합치기 및 생성
			combineFireBall();
		}
		
		//3. 최종 파이어볼 총질량
		calcFireBalls();
		System.out.println(ans);


	}
	
	
	private static void calcFireBalls() {
		for (int i = 0; i < fireBalls.size(); i++) {
			FireBall fireBall = fireBalls.get(i);
			//System.out.println(fireBall);
			ans += fireBall.m;
		}
	}


	//겹치는 파이어볼 합치기
	private static void combineFireBall() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				int totalM = 0;
				int totalS = 0;
				boolean odd = true, even = true; //방향비교 플래그
				
				// 1. //겹치는 파이어볼이 2개 이상이면 결합
				if(visited[r][c]>=2) { 
					for(int i=fireBalls.size()-1; i>=0; i--) {
						FireBall f = fireBalls.get(i);
						
						if(f.r==r && f.c==c) {
							totalM += f.m; //질량합
							totalS += f.s; //속력합
							//removeIdx.add(i);
							
							//방향비교
							if(f.d%2==0) even=false;
							else odd = false;
						
							fireBalls.remove(i);						
						}
					}

					// 2. 새로운 4개의 파이어볼 생성 및 리스트에 추가
					int newM = totalM/5; //새 질량
					int newS = totalS/visited[r][c]; //새 속력
					//visited[r][c]=0;
					
					//질량이 0인 파이어볼은 소멸한다.
					if(newM==0) {
						visited[r][c]=0;
						continue;
					}
					
					//결합된 모든 파이어볼의 방향이 짝수거나 홀수면 0246
					if(odd | even) {
						for(int d=0; d<deltas.length; d+=2) {
							fireBalls.add(new FireBall(r, c, newM, newS, d));
							visited[r][c]=4;
						}
						
					}
					//그게 아니라면 1357
					else {
						for(int d=1; d<deltas.length; d+=2) {
							fireBalls.add(new FireBall(r, c, newM, newS, d));
							visited[r][c]=4;
						}
					}
					
				}else {
					//파이어볼 방문 초기화
					//visited[r][c]=0;
				}
				
				
			}
			
		}
		
	}

	//파이어볼 이동
	private static void moveFireBall() {
		for(int i=0; i<fireBalls.size(); i++) {
			FireBall currentBall = fireBalls.get(i);
			visited[currentBall.r][currentBall.c]--;
			
			int s = currentBall.s%N; //사이클을 형성하니까 다 이동할 필요없음
			
			int nr = (currentBall.r + deltas[currentBall.d][0]*s +N) %N;
			int nc = (currentBall.c + deltas[currentBall.d][1]*s +N) %N;
			
			visited[nr][nc]++; //이동위치에 방문체크
			currentBall.r = nr;
			currentBall.c = nc;
		}
	}

	static String instr = "4 2 1\r\n" + 
			"1 1 5 2 2\r\n" + 
			"1 4 7 1 6";

}