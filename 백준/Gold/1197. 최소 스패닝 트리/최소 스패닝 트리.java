import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int V, E;
	static Edge[] edgeList;
	static int result, vcnt, parents[];
	
	static class Edge implements Comparable<Edge>{
		int from , to, weight;
		
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
			

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		V = Integer.parseInt(tokens.nextToken());
		E = Integer.parseInt(tokens.nextToken());
		
		edgeList = new Edge[E];
		
		for (int e = 0; e < E; e++) {
			tokens = new StringTokenizer(input.readLine());
			int from = Integer.parseInt(tokens.nextToken());
			int to = Integer.parseInt(tokens.nextToken());
			int weight = Integer.parseInt(tokens.nextToken());
			edgeList[e] = new Edge(from, to, weight);
		}
		
		result = 0;
		vcnt=0;
		
		Arrays.sort(edgeList); //가장 작은 가중치 부터 정렬해야함.
		makeSet();
		
		for(Edge e : edgeList) {
			if(union(e.from, e.to)) {
				vcnt++;
				result += e.weight;
				
				if(vcnt==V-1) break;
			}
		}
		
		System.out.println(result);
	}
	
	public static void makeSet() {
		parents = new int[V+1];
		for (int i = 0; i <= V; i++) {
			parents[i] = i;
		}
	}
	
	public static int findSet(int a) {
		if(a == parents[a]) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	public static boolean union(int a, int b) {
		int aBoss = findSet(a);
		int bBoss = findSet(b);
		
		if(aBoss==bBoss) return false; //사이클이 형성되면 안된다.
		
		parents[bBoss]= aBoss;
		return true;
	}

}