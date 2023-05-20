import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N, M, u,v, depth, answer;
	static ArrayList<Integer>[] board;
	static int binGraph[];

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		board = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			board[i] = new ArrayList<Integer>();
		}
		 
		for (int i = 0; i < M; i++) {
			tokens = new StringTokenizer(input.readLine());
			u = Integer.parseInt(tokens.nextToken());
			v = Integer.parseInt(tokens.nextToken());
			board[u].add(v);
			board[v].add(u);
		}
		
		binGraph = new int [N+1];

		if(binGraphBFS()) { //이분그래프라면
			int red = 0;
			int blue=0;
			
			for (int i = 0; i < binGraph.length; i++) {
				if(binGraph[i]==1) red+=1;
				else if (binGraph[i]==2) blue +=1;
			}
			answer = red * blue *2;		
		}else { 
			//이분그래프가 아니라면 게임은 무조건 끝난다.
			answer = 0;
		}
		
		System.out.println(answer);
	}

	//이분그래프이면 true, 아니면 false
	private static boolean binGraphBFS() {
		Queue<Integer> que = new ArrayDeque<>(); 
		//1:빨강, 2:파랑
		que.offer(1);
		binGraph[1]=1; //1번 정점을 빨간색으로 칠함
		
		while (!que.isEmpty()) {
			int current = que.poll();
			
			for (int i = 0; i < board[current].size(); i++) {
				//현재색과 칠하려는 색이 같다면 이분그래프가 되지 않으므로 리턴
				if(binGraph[board[current].get(i)]==binGraph[current]) {
					return false;
				}else if(binGraph[board[current].get(i)]==0) { //아직 색이 안칠해져있다면=방문하지 않았다면
					binGraph[board[current].get(i)] = 3 - binGraph[current];
					que.offer(board[current].get(i));
				}
			}
		}
		
		return true;
	}
}