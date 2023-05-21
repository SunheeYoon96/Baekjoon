import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, M, start, end, answer;
	static ArrayList<ArrayList<Node>> adjList; //인접리스트
	static int distance[];
	static boolean visited[];
	static final int INF=987_654_321;
	
	static class Node implements Comparable<Node>{
		int vertex, weight;
		
		public Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine()); //도시의 갯수 = 정점 수 
		M = Integer.parseInt(input.readLine()); //연결해주는 버스의 갯수 = 간선 수
		
		adjList = new ArrayList<>();
		distance = new int[N+1];
		
		
		Arrays.fill(distance, INF); //최소를 구할꺼니까 거리륻 최대로 다 바꿔놈
		
		for (int i = 0; i <= N; i++) {
			adjList.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			tokens = new StringTokenizer(input.readLine());
			int from = Integer.parseInt(tokens.nextToken());
			int to = Integer.parseInt(tokens.nextToken());
			int weight = Integer.parseInt(tokens.nextToken());
			//인접리스트 만들기
			adjList.get(from).add(new Node(to, weight));
		}
		
		tokens = new StringTokenizer(input.readLine());
		start = Integer.parseInt(tokens.nextToken());
		end = Integer.parseInt(tokens.nextToken());
		
		//다익스트라알고리즘으로 시작점과 정점을 잇는 최소비용 구하기
		answer = dijkstra();
		
		System.out.println(answer);

	}

	private static int dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		visited = new boolean[N+1];
		distance[start] = 0;
		
		while (!pq.isEmpty()) {
			Node currentNode = pq.poll();
			int currentVertex = currentNode.vertex;
			
			if(!visited[currentVertex]) {
				visited[currentVertex] = true;
				
				//현재정점과 인접한 노드들 중 최소 비용
				for(Node n : adjList.get(currentVertex)) {
					if(!visited[n.vertex] && distance[n.vertex] > distance[currentVertex] + n.weight) {
						distance[n.vertex] = distance[currentVertex] + n.weight;
						pq.offer(new Node(n.vertex, distance[n.vertex]));
					}
				}
			}
		}
		return distance[end];
	}

}