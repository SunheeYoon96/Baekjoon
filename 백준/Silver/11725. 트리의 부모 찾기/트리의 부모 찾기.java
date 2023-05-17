import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N, parents[];
	static ArrayList<Integer> tree[]; //트리만들기
	static boolean visited[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		
		tree = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N-1; i++) {
			tokens = new StringTokenizer(input.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			tree[a].add(b);
			tree[b].add(a);
		}
		
		visited = new boolean[N+1];
		parents = new int[N+1];
		
		//끝까지 가기 = DFS
		dfs(1);
		
		for (int i = 2; i <=N; i++) {
			output.append(parents[i]).append("\n");
		}
		
		//부모찾기=끝까지간다.
		System.out.println(output);
	}

	private static void dfs(int current) {
		visited[current] = true; //시작할때 방문처리하기
		
		for(int vertex : tree[current]) {
			if(!visited[vertex]) {
				//자식노드들의 부모를 갱신해주기
				parents[vertex] = current;
				dfs(vertex);
			}
		}
	}

}