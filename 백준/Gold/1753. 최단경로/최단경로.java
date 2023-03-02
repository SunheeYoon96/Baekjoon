import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * [키워드]
 * 방향그래프에서 시작점에서 다른 모든 정점으로의 최단경로
 * 양의 가중치 존재
 * 
 * [풀이과정]
 * start ~~~ 경유지 ->도착점
 * 몇개의 정점을 지나는 지가 중요한게아님 , 최소 비용으로 가는 것이 중요함
 * 
 * [입력]
 * [출력] 
 * 
 * 
 * @author SSAFY
 * @see
 * @performance
 * @category #그래프 #다익스트라 #PriorityQueue 
 * pq안쓰면 메모리 초과남
 */

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int V, E, start;
	static int distance[]; //주어진 점까지의 최단거리
	static final int INF = Integer.MAX_VALUE;
	static PriorityQueue<Point>[] pq;
	
	static class Point implements Comparable<Point>{
		int vertex, weight;

		public Point(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.weight, o.weight);
		}
		
	}

	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		tokens = new StringTokenizer(input.readLine());
		V = Integer.parseInt(tokens.nextToken());
		E = Integer.parseInt(tokens.nextToken());
		start = Integer.parseInt(input.readLine());
		
		pq = new PriorityQueue[V+1];
		for(int i=0; i<=V; i++) {
			pq[i] = new PriorityQueue<Point>();
		}
				
		for(int e=0; e<E; e++) {
			tokens = new StringTokenizer(input.readLine());
			int from = Integer.parseInt(tokens.nextToken());
			int to = Integer.parseInt(tokens.nextToken());
			int weight = Integer.parseInt(tokens.nextToken());
			pq[from].add(new Point(to, weight));
		}
		//입력 완

		int[] distance = new int[V+1]; // 출발 정점에서 자신까지 오는데 걸리는 비용
		
		Arrays.fill(distance, INF); // 최소값 갱신 로직을 반영해야하므로 큰값으로 초기화
		distance[start] = 0; // 출발지-출발지의 길은 없으니까

		while (!pq[start].isEmpty()) {
			Point current = pq[start].poll();
			int curV = current.vertex;
			int weight = current.weight;
			
			//이미확인한 정점이면 최소이니까 건너 뛰기
			if(distance[curV] != INF) continue;
			
			distance[curV] = weight;
			
			//방문한 정점에서 갈 수 있는 최소거리
			for (Point p : pq[curV]) {
				pq[start].add(new Point(p.vertex, weight + p.weight));
			}
			
		}
		
		for(int v=1; v<=V; v++) {
			if(distance[v]==INF) {
				output.append("INF").append("\n");
			}else {
				output.append(distance[v]).append("\n");
			}
		}
		
		
		System.out.println(output);
		

	}
	
	static String instr = "5 6\r\n" + 
			"1\r\n" + 
			"5 1 1\r\n" + 
			"1 2 2\r\n" + 
			"1 3 3\r\n" + 
			"2 3 4\r\n" + 
			"2 4 5\r\n" + 
			"3 4 6";

}