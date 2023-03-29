import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens ;
	
	static int N, map[][];
	static boolean visited[];
	static int minVal;
	
	public static void main(String[] args) throws IOException {
		
		//input = new BufferedReader(new StringReader(instr));
		
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		
		map = new int[N][N];
		visited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(input.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		//입력완

		//0번부터 시작할거니까 방문처리
		visited[0]=true;
		minVal = Integer.MAX_VALUE;
		
		//0번부터 외판원 순회 시작
		TSP(0,0,1,0);
		
		System.out.println(minVal);

	}

	
	private static void TSP(int start, int current, int cnt, int cost) { //시작, 현재위치, 이동횟수, 비용
		
		for(int i=0; i<N; i++) {
			//사이클을 다 돌고 돌아왔다면,
			if(map[current][i] > 0) {
				if(i==start && cnt==N) {
					cost += map[current][i];
					minVal = Math.min(minVal, cost);
					return;
				
				//방문하지 않은 곳이 남아있다면	
				}else if(!visited[i] && cnt<N) {
					//최적의 경로라면
					visited[i] = true;
					cost += map[current][i]; 
					TSP(start, i, cnt+1, cost);
					//최적의 경로가 아니면 다시 되돌리기.
					visited[i] = false;
					cost -= map[current][i]; 
				}
			}
		}
		
	}




	private static String instr ="4\r\n" + 
			"0 10 15 20\r\n" + 
			"5 0 9 10\r\n" + 
			"6 13 0 12\r\n" + 
			"8 8 9 0";

}