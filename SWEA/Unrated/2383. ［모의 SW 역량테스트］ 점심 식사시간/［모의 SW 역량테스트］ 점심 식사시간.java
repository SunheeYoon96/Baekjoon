import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int T, N,idx,ans;
	static Stair[] stairs; //계단
	static int[][] map;

	static boolean[] selected;
	static LinkedList<Point> peoples;
	
	static class Stair {
		int r,c, len, cnt; //계단의 위치, 계단의 길이 , 해당 계단에 올라가 있는 사람의 명수
		
		public Stair(int r, int c, int len, int cnt) {
			this.r = r;
			this.c = c;
			this.len = len;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Stair [r=" + r + ", c=" + c + ", len=" + len + ", curPCnt=" + cnt + "]";
		}
		
		
	}
	
	static class Point{
		int dist,stairN,stairLen; //계단까지의 거리, 몇 번째 계단인지, 계단 길이
		Point(int dir,int stairN, int stairLen){
			this.dist = dir;
			this.stairN = stairN;
			this.stairLen= stairLen;
		}	
	}

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(input.readLine());
		for(int tc=1; tc<=T; tc++) {
			
			N = Integer.parseInt(input.readLine());
			map = new int[N][N];
			stairs = new Stair[2]; //계단
			
			idx = 0;
			ans = 100000;
			int s = 0;
			for(int i=0; i<N; i++) {
				tokens = new StringTokenizer(input.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(tokens.nextToken());
					
					if(map[i][j] > 1) { //계단인경우
						stairs[s++] = new Stair(i,j,map[i][j],0);
					}
					else if(map[i][j] == 1){ //사람인경우
						idx++;
					}
				}
			}
			
			selected = new boolean[idx]; //각 사람이 0번(T) 계단인지 1번(F) 계단인지 체크
			powerset(0);
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	
	static void powerset(int cnt) {
		if(cnt == idx){
			peoples = new LinkedList<>();
			int stairN = 0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] == 1) {
						
						if(selected[stairN++]) { //true면 0번 계단
							int dir = Math.abs(stairs[0].r-i)+ Math.abs(stairs[0].c-j);
							//계단 올라가도 한칸 더 기다려야 하니까
							peoples.add(new Point((dir+1),0,stairs[0].len));
						}
						else { //false면 1번 계단
							int dir = Math.abs(stairs[1].r-i)+ Math.abs(stairs[1].c-j);
							peoples.add(new Point((dir+1),1,stairs[1].len));
						}
					}
				}
			}
			
			//계단을 다 선택했으면 사람 수만큼 시뮬을 돌려서 최단시간을 구하기
			simul(idx);
			return;
		}
		
		selected[cnt] = true;
		powerset(cnt+1);
		selected[cnt] = false;
		powerset(cnt+1);
	}
	
	static void simul(int idx) {
		int time = 0;
		
		while(!peoples.isEmpty()) {
			time++;
			int stair0 = 0;
			int stair1 = 0; 
			
			//1. 이미 계단에 있는 사람들 이동
			for(int i=0; i<idx; i++) {
				Point p = peoples.get(i);
				
				if(p.dist == 0){
					// 1-1. 아직 계단을 내려가지 못하고 기다리고 있는사람이라면 더 기다려
					if(p.stairLen == stairs[p.stairN].len) continue;

					//1-2. 계단을 내려가는 중이면 내려가
					if((p.stairLen > 0) && (p.stairLen < stairs[p.stairN].len)) {
						p.stairLen -= 1;
					}
					
					//1-3. 계단을 다 내려갔으면 나가
					if(p.stairLen == 0) {
						if(p.stairN == 0) stair0++;
						else stair1++;
						
						peoples.remove(p);
						i--; //arraylist는 제거해주면 인덱스가 줄어들어서 한번 더 이전으로 가서 탐색해야함
						idx--;
					}
				}
			}
			
			//2. 계단에 있지 않은 사람들 이동
			for(int i=0; i<idx; i++) {
				Point p = peoples.get(i);
				
				//계단에 도착하지도 못했으면
				if(p.dist > 0) {
					p.dist -= 1;
				}
				//도착해있는 사람들중 빈자리가 나서 갈 수 있다면
				else if((p.dist == 0) && (p.stairLen == stairs[p.stairN].len) && (stairs[p.stairN].cnt < 3)){
					stairs[p.stairN].cnt += 1;
					p.stairLen -= 1;
				}
			}
			stairs[0].cnt -= stair0;
			stairs[1].cnt -= stair1;
		}
		
		ans = Math.min(ans, time);
	}

	
	
}