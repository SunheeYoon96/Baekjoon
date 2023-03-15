import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * [키워드]
 * 무방향 그래프
 * 양의 가중치가 있으며 1~N까지 최단거리 -> 다익스트라
 * 특정 정점 2개를 지나야한다.
 * - 시작 ->v1 ->v2 -> 끝
 * - 시작 ->v2 ->v1 -> 끝
 * 간선이 주어짐 ->인접리스트로 풀자.
 * 
 * [풀이과정]
 * 
 * [입력]
 * 정점의 개수 N과 간선의 개수 E (2 ≤ N ≤ 800, 0 ≤ E ≤ 200,000)
 * 두 개의 서로 다른 정점 번호 v1과 v2
 * 
 * [출력] 
 * 
 * @author 윤선희
 * @since 
 * @see
 * @performance
 * @category #
 */

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N,E, V1, V2, answer;
	static final int INF = 200_000_000; //연산 중 오버플로우가 날 수 있었음... ㅜ 1000*200000
	static ArrayList<Node> graph[];
	
	static class Node implements Comparable<Node>{
		int vertex; // 연결된 정점
		int dist;   // 길이(가중치)
		
		public Node(int vertex, int dist) {
			super();
			this.vertex = vertex;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			return this.dist - o.dist;
		}
		
	}

	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		tokens = new StringTokenizer(input.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		E = Integer.parseInt(tokens.nextToken());
		
		//인접리스트 초기화
		//N+1개의 정점을 가진 배열안에 arrylist로 연결된 간선정보
		graph = new ArrayList[N+1]; //정점 1부터 시작
		for(int i=0; i<N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		//인접리스트 정보 입력
		for(int i=0; i<E; i++) {
			tokens = new StringTokenizer(input.readLine());
			int from = Integer.parseInt(tokens.nextToken());
			int to = Integer.parseInt(tokens.nextToken());
			int dist = Integer.parseInt(tokens.nextToken());
			
			//graph의 인덱스는 시작정점 , 그안의 값이 연결된 간선정보(목적노드와 가중치)
			//무방향이니까 양쪽으로 더해줌
			graph[from].add(new Node(to, dist));
			graph[to].add(new Node(from, dist));
		}
		
		//주어진 정점 정보
		tokens = new StringTokenizer(input.readLine());
		V1 = Integer.parseInt(tokens.nextToken());
		V2 = Integer.parseInt(tokens.nextToken());
		
		// 특정 정점 2개를 지나는 최단거리 -> 다익스트라 실행
		findMinDist();
		
		//최단거리 출력
		System.out.println(answer);

	}
	
	private static void findMinDist() {
		int way1=0;
		int way2=0;
		
		//- 시작 ->v1 ->v2 -> 끝
		way1 += dijkstra(1, V1);
		way1 += dijkstra(V1, V2);
		way1 += dijkstra(V2, N);
		
		//- 시작 ->v2 ->v1 -> 끝
		way2 += dijkstra(1, V2);
		way2 += dijkstra(V2, V1);
		way2 += dijkstra(V1, N);
		
		if(way1 >= INF && way2 >= INF) {
			answer = -1;
			//return;
		}else {
			answer = Math.min(way1, way2);
		}
	}

	private static int dijkstra(int start, int end) {
		int distance[] = new int[N+1]; //출발 정점에서 목적지까지 오는데 걸리는 비용
		Arrays.fill(distance, INF); //거리비용 최대로 초기화
		distance[start]=0; //자기자신으로의 거리 비용은 0
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		
		while (!pq.isEmpty()) {
			Node current = pq.poll();
			int vertex = current.vertex;
			int dist = current.dist;
			
			//현재보다 이전 경로가 더 최소면 갱신할 필요없음
			if(distance[vertex] < dist) continue;
			
			//현재 정점과 연결된 인접정점들 중
			for (int i = 0; i < graph[vertex].size(); i++) {
				int endVertex = graph[vertex].get(i).vertex;
				int endDist = graph[vertex].get(i).dist + dist;
				
				//더 최단거리인 것이 있으면 갱신
				if(distance[endVertex] > endDist) {
					distance[endVertex] = endDist;
					pq.add(new Node(endVertex, endDist));
				}
				
			}
		}
		
		
		return distance[end];
	}
	
	private static String instr = "4 6\r\n" + 
			"1 2 3\r\n" + 
			"2 3 3\r\n" + 
			"3 4 1\r\n" + 
			"1 3 5\r\n" + 
			"2 4 5\r\n" + 
			"1 4 4\r\n" + 
			"2 3";

}