import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, parents[], E, vcnt;
	static double answer;
	static Point stars[];
	static Edge edgeList[];
	
	static class Point {
		double x,y;
		int vertex;
		
		public Point(double x, double y, int vertex) {
			this.x = x;
			this.y = y;
			this.vertex = vertex;
		}
	}
	
	static class Edge implements Comparable<Edge>{
		int from, to;
		double weight;
		
		public Edge(int from ,int to, double weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.weight, o.weight);
		}
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		//모든점사이의 간선 수
		E = N*(N-1)/2;
		
		//모든 별의 집합
		stars = new Point[N];
		
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(input.readLine());
			double x = Double.parseDouble(tokens.nextToken());
			double y = Double.parseDouble(tokens.nextToken());
			stars[i] = new Point(x, y, i);
		}
		
		edgeList = new Edge[E];
		int idx=0;
		
		//모든 점사이의 간선 만들기
		for (int i = 0; i < N; i++) {
			Point from = stars[i];
			for (int j = i+1; j < N; j++) {
				Point to = stars[j];
				double eWeight = calcDist(from, to);
				edgeList[idx++] = new Edge(from.vertex, to.vertex, eWeight);
			}
		}
		
		Arrays.sort(edgeList);

		makeSet();
		
		answer = 0.0;
		vcnt = 0;
		
		for(Edge e : edgeList) {
			if(union(e.from, e.to)) {
				vcnt++;
				answer += e.weight;
				
				if(vcnt==N-1) break;
			}
		}
		
		System.out.printf("%.2f", answer);

	}
	
	
	public static void makeSet() {
		parents = new int[N];
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	
	public static int findSet(int a) {
		if(a==parents[a]) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	public static boolean union(int a, int b) {
		int aBoss = findSet(a);
		int bBoss = findSet(b);
		
		if(aBoss == bBoss) return false;
		parents[bBoss] = aBoss;
		return true;
		
	}
	
	
	public static double calcDist(Point a, Point b) {
		double dist = 0.0;
		dist = Math.sqrt(Math.pow(a.x-b.x, 2) + Math.pow(a.y-b.y, 2));
		return dist;
		
	}

}