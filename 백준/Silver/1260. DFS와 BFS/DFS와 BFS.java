import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N; //노드의 갯수
	static int M; //간선의 갯수
	static int V; //시작지점
	
	public static boolean[] visitedD;
	public static boolean[] visitedB;
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	
	public static void DFS(int x) {
		//현재 노드 방문처리
		visitedD[x] = true;
		System.out.print(x+" ");
		//현재 노드와 연결된 다른 노드를 재귀적으로 방문.
		for(int i=0; i<graph.get(x).size(); i++) {
			int y = graph.get(x).get(i);
			if(!visitedD[y]) {
				DFS(y);
			}
		}
	}
	
	public static void BFS(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		//현재 노드를 방문처리
		visitedB[start] = true;
		
		//큐가 빌때까지 반복
		while(!q.isEmpty()) {
			//큐에서 원소 하나를 뽑아서 출력
			int x = q.poll();
			System.out.print(x+ " ");
			
			//해당 원소와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입
			for(int i=0; i<graph.get(x).size(); i++) {
				int y = graph.get(x).get(i);
				if(!visitedB[y]) {
					q.offer(y);
					visitedB[y] = true;
				}
			}
		}
		
		
		
	}
	

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		V = Integer.parseInt(tokens.nextToken());
		
		visitedD = new boolean[N+1];
		visitedB = new boolean[N+1];
		
		//그래프 초기화 
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		//그래프 정보담기
		for(int i=0; i<M; i++) {
			tokens = new StringTokenizer(input.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		// 이동 경우의 수가 다수 존재할 경우 작은 정점부터 이동해야 하므로 인접 리스트를 오름차순 정렬
		for(int i=1;i<=N;i++) {
			Collections.sort(graph.get(i));
		}
		
		DFS(V);
		System.out.println();
		BFS(V);
		

	}

}
