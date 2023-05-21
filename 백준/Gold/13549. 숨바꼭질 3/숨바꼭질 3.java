import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, K, answer;
	static boolean visited[];
	static final int INF = Integer.MAX_VALUE;
	
	static class Node implements Comparable<Node>{
		int vertex, time;
		
		public Node(int vertex, int time) {
			this.time = time;
			this.vertex = vertex;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.time, o.time);
		}
	}

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		answer = 0;
		bfs(N, K);
		
		System.out.println(answer);
	}

	private static void bfs(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		visited = new boolean[100001];
		pq.offer(new Node(start, 0));
		
		while (!pq.isEmpty()) {
			Node current = pq.poll();
			int nPos = current.vertex;
			visited[current.vertex] = true;
			
			if(current.vertex==K) {
				answer = current.time;
				break;
			}
			
			//순간이동 시간적으로 이득인 순간이동부터 pq에 넣어야한다. 
			if(nPos*2<=100000 && !visited[nPos*2]) {
				pq.offer(new Node(nPos*2, current.time));
			}
			//+1
			if(nPos+1<=100000 && !visited[nPos+1]) {
				pq.offer(new Node(nPos+1, current.time+1));
			}
			//-1
			if(nPos-1>=0 && !visited[nPos-1]) {
				pq.offer(new Node(nPos-1, current.time+1));
			}
		}
		
	}

}