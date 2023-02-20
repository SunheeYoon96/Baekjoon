import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N; //크기가 N*N인도시
	static int M; //도시에 존재하는 치킨집은 최대 M개
	static int[][] map;
	static ArrayList<Loc> houses;
	static ArrayList<Loc> chickens;
	static int cityRoad;     //도시의 치킨거리
	static int chickenRoad;  //각 집의 치킨거리	
	static int minVal;
	
	//위치정보클래스
	public static class Loc{
		int x;
		int y;
		
		public Loc(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		map = new int[N][N];
		houses = new ArrayList<Loc>();
		chickens = new ArrayList<Loc>();
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
				
				//집 정보 저장
				if(map[r][c] == 1) {
					houses.add(new Loc(r,c));
				}
				//치킨가게 정보 저장
				if(map[r][c] == 2) {
					chickens.add(new Loc(r,c));
				}
			}
		}//
		
		minVal = Integer.MAX_VALUE;
		
		findRoad(0, new boolean[chickens.size()], 0);
		System.out.println(minVal);
		

	}
	
	public static void findRoad(int nthpick, boolean[] visited,  int start) {
		
		if(nthpick == M) {
			cityRoad = 0; //도시의 치킨거리
			
			for(int h=0; h<houses.size(); h++) {
				chickenRoad = Integer.MAX_VALUE; //각 집의 최소치킨거리
				for(int c=0; c<chickens.size(); c++) {
					if(visited[c]) {			
						//각집과 치킨집의 최단거리
						int distance = Math.abs(houses.get(h).x - chickens.get(c).x) + Math.abs(houses.get(h).y - chickens.get(c).y);
						chickenRoad = Math.min(chickenRoad, distance);
					}
				}
				cityRoad += chickenRoad;
			}
			minVal = Math.min(cityRoad, minVal); 
			return;
			
		}
			
			
		for(int i=start; i<chickens.size(); i++) {
			if(!visited[i]) {
				visited[i] = true;
				findRoad(nthpick+1, visited, i+1);
				visited[i] = false;
			}
		}
		
	}

}
