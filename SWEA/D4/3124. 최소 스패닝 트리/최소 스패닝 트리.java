import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [키워드]
 * 최소 스패닝 트리를 구하는 프로그램을 작성
 * [풀이과정]
 * 
 * [입력]
 * [출력] 
 * 
 * @author SSAFY
 * @see
 * @performance
 * @category 
 */

public class Solution {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T, V, E;
	//static long cost[];
	static Edge[] edgeList;
	static int parents[];
	
	
	//간선 클래스
	static class Edge implements Comparable<Edge>{
		int from , to, weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight , o.weight);
		}
	}

	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		T = Integer.parseInt(input.readLine());
		
		for (int t = 1; t <=T; t++) {
			output.append("#").append(t).append(" ");
			
			tokens = new StringTokenizer(input.readLine());
			V = Integer.parseInt(tokens.nextToken());
			E = Integer.parseInt(tokens.nextToken());
			
			edgeList = new Edge[E];
			
			for (int i = 0; i < E; i++) {
				tokens = new StringTokenizer(input.readLine());
				int from = Integer.parseInt(tokens.nextToken())-1;
				int to = Integer.parseInt(tokens.nextToken())-1;
				int weight = Integer.parseInt(tokens.nextToken());
				
				edgeList[i] = new Edge(from, to, weight);
			}
			
			Arrays.sort(edgeList);
			
			makeSet();
			
			long minCost = 0; //신장트리 최소비용
			int cnt = 0 ; // 사용된 간선의 갯수
			
			for(Edge e : edgeList) {
				if(union(e.from, e.to)) {
					cnt++;
					minCost += e.weight;
					
					if(cnt == V-1) break;
				}
			}
			
			output.append(minCost).append("\n");
			
		}
		
		System.out.println(output);

	}
	
	//< 크루스칼 알고리즘
	static void makeSet() {
		parents = new int[V];
		for(int i=0; i<V; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int a) {
		if(a==parents[a]) return a;
		return parents[a]= findSet(parents[a]);
	}
	
	static boolean union(int a,int b) {
		int aJjang = findSet(a);
		int bJjang = findSet(b);
		
		if(aJjang == bJjang) return false;
		
		parents[bJjang] = aJjang;
		return true;
	}
	
	// 크루스칼 알고리즘>
	
	//< 프림 알고리즘
	// 프림 알고리즘 >
	
	static String instr = "1\r\n" + 
			"3 3\r\n" + 
			"1 2 1\r\n" + 
			"2 3 2\r\n" + 
			"1 3 3\r\n" + 
			"";

}