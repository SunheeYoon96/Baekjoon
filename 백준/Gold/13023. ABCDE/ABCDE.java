import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 * [키워드]
 * 친구 관계 -> 관계 -> 그래프-> 인접리스트, 번호가 매겨져있는 사람
 * 
 * [풀이과정]
 * 1. 주어진 정보를 인접리스트로 저장
 * 2. 각 정점에서 DFS로 간선을 따라간다. 
 * 3. 간선 4개가 이어짐 depth==4 -> ABCDE관계 존재 
 * 
 * [입력]
 * 사람의 수 N (5 ≤ N ≤ 2000)
 * 친구 관계의 수 M (1 ≤ M ≤ 2000)
 * M개의 줄에는 정수 a와 b가 친구 (0 ≤ a, b ≤ N-1, a ≠ b) 
 * 단, 같은 관계가 두번 이상 주어지는 경우는 없다.
 * 
 * [출력] 
 * ABCDE 관계가 존재하면 1, 없으면 0
 * 
 * @author SSAFY
 * @see
 * @performance
 * @category 
 */

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N , M, depth, ans; // 정점 N개, 간선M개
	static Node[] AdjList;
	static boolean[] visited;
	
	//노드 클래스
	public static class Node {
		int vertex;
		Node link;
		
		public Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + "]";
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		AdjList = new Node[N];
		
		int from, to;
		
		for(int i=0; i<M; i++) {
			tokens = new StringTokenizer(input.readLine());
			from = Integer.parseInt(tokens.nextToken());
			to = Integer.parseInt(tokens.nextToken());
			
			AdjList[from] = new Node(to, AdjList[from]);
			AdjList[to] = new Node(from, AdjList[to]);
		}
//		for(Node n : AdjList) {
//			System.out.println(n);
//			
//		}
		
		depth=0;
		ans = Integer.MIN_VALUE;
		
		for(int i=0; i<N; i++) {
			visited = new boolean[N];
			dfs(i,0);			
		}
		
		//System.out.println(ans);
		if(ans>=4) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
		
	}
	
	private static void dfs(int now, int depth) {
		visited[now] = true;
		ans = Math.max(depth, ans); //
		
		if(ans>=4) return;
		
		for(Node tmp = AdjList[now]; tmp !=null; tmp =tmp.link) {
			if(!visited[tmp.vertex]) {
				visited[tmp.vertex] = true;
				dfs(tmp.vertex, depth+1);
				visited[tmp.vertex] = false;
			}
		}
	}

	static String instr = "5 5\r\n" + 
			"0 1\r\n" + 
			"1 3\r\n" + 
			"1 4\r\n" + 
			"4 3\r\n" + 
			"3 2";
}