import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N,M, cnt;
	static Node[] computers;
	
	static class Node {
		int i;
		Node pre;
		public Node(int i, Node pre) {
			super();
			this.i = i;
			this.pre = pre;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		//input = new BufferedReader(new StringReader(instr));
		N = Integer.parseInt(input.readLine());
		M = Integer.parseInt(input.readLine());
		
		computers = new Node[N+1];
		for(int m=0; m<M; m++) {
			tokens = new StringTokenizer(input.readLine());
			int from = Integer.parseInt(tokens.nextToken());
			int to = Integer.parseInt(tokens.nextToken());
			computers[from] = new Node(to, computers[from]);
			computers[to] = new Node(from, computers[to]);
		}
		
		bfs();
		System.out.println(cnt);
		

	}
	
	private static void bfs() {
		Queue<Node> que = new ArrayDeque<>();
		boolean visited[] = new boolean[N+1];
		
		que.offer(new Node(1, null));
		visited[1]=true;
		
		while (!que.isEmpty()) {
			Node current = que.poll();
			
			for(Node child =computers[current.i]; child!=null; child = child.pre ) {
				if(!visited[child.i]) {
					que.offer(new Node(child.i, child)); 
					visited[child.i] = true;
					cnt++;
				}
			}
		}
		
	}

	static String instr = "7\r\n" + 
			"6\r\n" + 
			"1 2\r\n" + 
			"2 3\r\n" + 
			"1 5\r\n" + 
			"5 2\r\n" + 
			"5 6\r\n" + 
			"4 7";

}