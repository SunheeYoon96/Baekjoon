import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	static int N, M, indegree[];
	static Node[] adjList;

	static class Node implements Comparable<Node> {
		int vertex;
		Node link;

		public Node() {
		};

		public Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}

		@Override
		public int compareTo(Node o) {
			return this.vertex - o.vertex;
		}
	}

	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));

		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken()); // 문제갯수
		M = Integer.parseInt(tokens.nextToken()); // 정보갯수

		adjList = new Node[N + 1];
		indegree = new int[N + 1];

		int from, to;

		for (int i = 0; i < M; i++) {
			tokens = new StringTokenizer(input.readLine());
			from = Integer.parseInt(tokens.nextToken());
			to = Integer.parseInt(tokens.nextToken());
			adjList[from] = new Node(to, adjList[from]);
			indegree[to]++;
		}

		ArrayList<Integer> list = topologySort();
		
		//항상 문제를 풀 수 있는 경우만 입력으로 주어지므로 사이클이 생길 걱정X
		if(list.size()==N) { //위상정렬 완성
			for(Integer vertex : list) {
				System.out.print(vertex + " ");
			}
		}

	}

	private static ArrayList<Integer> topologySort() {
		ArrayList<Integer> orderList = new ArrayList<>();

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) // 진입차수가 0인 정점 우선순위큐에 넣기
				pq.offer(i);
		} 

		while (!pq.isEmpty()) {
			int cur = pq.poll();
			orderList.add(cur);

			// 현재 문제번호을 기준으로 먼저 풀어야하는 연결된 문제를 처리한다. 
			for (Node temp = adjList[cur]; temp != null; temp = temp.link) {
				if (--indegree[temp.vertex] == 0) {
					pq.offer(temp.vertex);
				}
			}
		}

		return orderList;
	}

	private static String instr = "4 2\r\n" + "4 2\r\n" + "3 1";

}