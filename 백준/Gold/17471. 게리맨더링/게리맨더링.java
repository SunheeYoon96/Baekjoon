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
	static int N, pick, adjList[][], sectors[], sum, populationSum;
	static boolean visited[], status[];
	static int min; 
	
	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		
		//구역의 인구정보 받기
		tokens = new StringTokenizer(input.readLine());
		sectors = new int[N];
		for (int i = 0; i < N; i++) {
			sectors[i] = Integer.parseInt(tokens.nextToken());
		}
		
		//연결상태를 인접행렬로 받기
		adjList = new int[N][N];
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(input.readLine());
			int c = Integer.parseInt(tokens.nextToken());
			for (int j = 0; j < c; j++) {
				adjList[i][Integer.parseInt(tokens.nextToken())-1] = 1;
			}
		}

		min = Integer.MAX_VALUE;
		
		//전체가 다 추출되는 경우는 제외되니까 n-1까지만 추출해봄
		for(int i=0; i<N; i++) {
			visited = new boolean[N];
			pick = i;
			makeSubset(0, 0);
		}
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}
	

	private static void makeSubset(int cnt, int start) {
		// 주어진 갯수를 다 뽑으면
		if(cnt==pick) {
			sum = Integer.MAX_VALUE; //최소를 찾기 위해
			//나눈 조합이 연결이 되어있는지 확인한다.
			//1.연결체크
			isLinked();
			//2.비용비교
			min = Math.min(min, sum);
			return;
		}
		
		
		for(int i=start; i<N; i++) {
			visited[i] = true;
			makeSubset(cnt+1, i+1);
			visited[i] = false;
			makeSubset(cnt+1, i+1);
		}
		
	}
	
	
	//두 정점이 이어져있는지 연결 체크
	private static void isLinked() {
		int choosed=0, unchoosed=0; //뽑힌 것과 안뽑힌것의 인구수 차이
		int[] parents = new int[N];
		status = new boolean[N];
		
		//부분집합을 뽑힌것과 아닌것으로 나눌 때 추출여부 체크
		for(int i=0; i<N; i++) {
			if(visited[i]) parents[i] = 1; //뽑힌 구역
			else parents[i] = 0; //안 뽑힌 구역
		}
		
		//1. 추출된 1인 구역들끼리 서로 연결되어있는지 확인
		for (int i = 0; i < N; i++) {
			// 추출되었으면서 방문전이면
			if(parents[i]==1 && !status[i]) {
				populationSum =0;
				findSet(i, parents);
				choosed = populationSum;
				break;
			}
			
		}
		
		//2. 안뽑힌 0인 구역들끼리 서로 연결되어있는지
		for (int i = 0; i < N; i++) {
			// 추출되지 않았으면서 방문전이면
			if(parents[i]==0 && !status[i]) {
				populationSum =0;
				findSet(i, parents);
				unchoosed = populationSum;
				break;
			}
			
		}
		
		// 3. 방문안된 구역 없는지 확인(하나라도 있다면 연결이 안된 것.)
		for (int i = 0; i < N; ++i) {
			if (!status[i]) return;
		}
		
		//3. 인구수 차이 계산
		sum = Math.abs(choosed - unchoosed);
		//System.out.println(sum);
		
	}
	
	
	//연결여부 확인해서 인구수 더하기
	private static void findSet(int x, int parents[]) {
		status[x] = true;
		populationSum += sectors[x]; //인구수 더하기
		for (int i = 0; i < N; i++) {
			//안뽑혔고 같은 그룹이고 인접한 행렬이면
			if(!status[i] && parents[i]==parents[x] && adjList[i][x]==1) {
				findSet(i, parents);
			}
			
		}
	}




	static String instr = "2\r\n" + 
			"3 4\r\n" + 
			"0\r\n" + 
			"0";

}