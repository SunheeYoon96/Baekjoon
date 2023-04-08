import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, M, cnt;
	static ArrayList<Integer>[] link;
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		link = new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) {
			link[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			tokens = new StringTokenizer(input.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			//무방향
			link[a].add(b);
			link[b].add(a);
		}
		
		//오름차순 정렬 - 순서대로 방문하기 위해서
//		for (int i = 1; i <=N; i++) {
//			Collections.sort(link[i]);
//		}
		
		cnt =0;
		visited = new boolean[N+1];
		
		for (int i = 1; i <=N; i++) {
			if(!visited[i]) {
				DFS(i);
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}
	
	private static void DFS(int a) {
		visited[a] = true;
		
		for (int i : link[a]) {
			if(!visited[i]) {
				DFS(i);
			}
		}
	}
	
	private static String instr = "6 5\r\n" + 
			"1 2\r\n" + 
			"2 5\r\n" + 
			"5 1\r\n" + 
			"3 4\r\n" + 
			"4 6";

}