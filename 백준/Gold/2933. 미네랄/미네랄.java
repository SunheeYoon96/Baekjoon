import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int R,C, cnt, heights[], realFall;
	static char cave[][];
	static int deletas[][] = {{1,0},{0,1},{-1,0},{0,-1}};
	static final char MINERAL='x', BLANK='.';
	static boolean playerFlag;
	
	static class Loc {
		int r,c;

		public Loc(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Loc [r=" + r + ", c=" + c + "]";
		}
		
		
		
	}

	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		tokens = new StringTokenizer(input.readLine());
		
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		
		cave = new char[R][C];
		
		for (int r = 0; r < R; r++) {
			String line = input.readLine();
			for (int c = 0; c < C; c++) {
				cave[r][c] = line.charAt(c);
			}
		}
		
		//막대기 던지는 횟수
		cnt = Integer.parseInt(input.readLine());
		
		tokens = new StringTokenizer(input.readLine());
		
		//막대기를 던질 위치배열
		heights = new int[cnt];
		for (int i = 0; i < heights.length; i++) {
			heights[i] = Integer.parseInt(tokens.nextToken());
		}
		
		playerFlag = false;
		//싸움 start
		for (int i = 0; i < cnt; i++) {
			
			int nh = R-heights[i];
			
			//주어진 높이에서 미네랄 찾고 부시기
			findMineral(nh, playerFlag);

			downCluster();
			//플레이어 바꾸기
			playerFlag = !playerFlag;
			
		}
		
		//최종상태 출력하기
		for (int r = 0; r < cave.length; r++) {
			for (int c = 0; c < cave[0].length; c++) {
				System.out.print(cave[r][c]);
			}
			System.out.println();
		}

	}
	
	private static void downCluster() {
		//클러스터가 중력에 의해서 아래로 내려간다...
		//0,0부터 bfs를 돌면서 공중에 뜬 클러스터를 찾는데
		//큐에 담길 애가 하단에 0이면 얘는 맨 밑에 있는 클러스터이니까 
		//얘는 따로 리스트에 담아논다.
		//리스트에 담긴 클러스터들을 하단 바닥이나 다른 클러스트들 과의 최단거리를 구한다. 
		//그 거리 만큼 다 빼주면 되는데/....
		
		Queue<Loc> cluster = new ArrayDeque<>();
		ArrayList<Loc> downcluster = new ArrayList<>();
		ArrayList<Loc> bottomCluster = new ArrayList<>();
		boolean visited[][] = new boolean[R][C];
		
		//cluster.offer(new Loc(0, 0));
		//visited[0][0] = true;
		
		//바닥과 연결되어있는 클러스트들을 확인한다.
		for (int c = C-1; c >=0; c--) {
			if(cave[R-1][c]==MINERAL  && !visited[R-1][c]) {
				cluster.offer(new Loc(R-1, c));
				visited[R-1][c] = true;
				
				while (!cluster.isEmpty()) {
					Loc nowCluster = cluster.poll();
					//System.out.println(nowCluster);
					
					for (int d = 0; d < deletas.length; d++) {
						int nr = nowCluster.r + deletas[d][0];
						int nc = nowCluster.c + deletas[d][1];
						
						if(!isIn(nr, nc)) continue;
						if(visited[nr][nc]) continue;
						
						if(cave[nr][nc]==MINERAL) {
							cluster.offer(new Loc(nr, nc));
							visited[nr][nc] = true;
						}
					}
				}
			}
		}
		
//		for(boolean row[] : visited) {
//			System.out.println(Arrays.toString(row));
//		}
		
		//공중에 떠있는 클러스터 찾기
		for (int r = R-1; r >=0; r--) {
			for (int c = C-1; c >=0; c--) {
				if(!visited[r][c] && cave[r][c]==MINERAL) {
					downcluster.add(new Loc(r, c));
					
					if(r<R-2) {
						if(cave[r+1][c]==BLANK ) {
							bottomCluster.add(new Loc(r, c));
						}
					}
					
					//cave[r][c]=BLANK;
				}
			}
		}

		realFall = 10000;
		//하단미네랄들의 최단거리 구하기
		for (int i = 0; i < bottomCluster.size(); i++) {
			int fallHeight = 0;
			Loc nowBC = bottomCluster.get(i);
//			System.out.println(nowBC);
			
			for (int j = nowBC.r; j < R; j++) {

				if(isIn(j+1, nowBC.c) && visited[j+1][nowBC.c] && cave[j+1][nowBC.c]==MINERAL) {
					break;
				}
				
				if(j==R-1 && cave[j][nowBC.c]==BLANK) break;
				
				fallHeight+=1;
//				System.out.println(fallHeight);
			}
			
			realFall = Math.min(realFall, fallHeight);
			//System.out.println(realFall);
			
		}
		
//		System.out.println(realFall);
		//System.out.println(downcluster.size());
		
		//공백으로 만들어놓기
		for (int i = 0; i < downcluster.size(); i++) {
			Loc changeC = downcluster.get(i);
			cave[changeC.r][changeC.c]=BLANK;
		}
		
		//밑으로 내리기
		for (int i = 0; i < downcluster.size(); i++) {
			Loc changeC = downcluster.get(i);
			
			if(isIn(changeC.r+realFall, changeC.c)) {
				cave[changeC.r+realFall][changeC.c]=MINERAL;				
			}
		}
		
		
	}


	private static void findMineral(int height, boolean pFlag) {
		
		if(pFlag==false) {//창영 차례 왼쪽에서 시작
			for (int c = 0; c < cave[0].length; c++) {
				if(cave[height][c]==MINERAL) {
					cave[height][c]=BLANK;
				}else {
					continue;
				}
				
				return;
			}
		}else { //상근차례 오른쪽에서 시작
			for (int c = cave[0].length-1; c >=0; c--) {
				if(cave[height][c]==MINERAL) {
					cave[height][c]=BLANK;
				}else {
					continue;
				}
				return;
			}
		}
		
	}
	
	private static boolean isIn(int nr, int nc) {
		if(nr>=0 && nr<R && nc>=0 && nc<C) return true;
		return false;
	}

	private static String instr = "5 6\r\n" + 
			"......\r\n" + 
			"..xx..\r\n" + 
			"..x...\r\n" + 
			"..xx..\r\n" + 
			".xxxx.\r\n" + 
			"1\r\n" + 
			"3";

}