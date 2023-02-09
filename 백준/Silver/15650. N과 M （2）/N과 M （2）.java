import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static int M;
	
	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		
		Permu(0, new int[M], 1);

	}
	
	public static void Permu(int nthSelect,int[] choosed, int start) {
		boolean[] visited = new boolean[N+1];
		
		if(nthSelect == M) {
			for(int i=0; i<choosed.length; i++) {
				System.out.print(choosed[i]+ " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start; i<=N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				choosed[nthSelect] = i;
				Permu(nthSelect+1, choosed, i+1);
				visited[i] = false;
				
			}
			
		}
		
		
	}
	
	//static String instr = "4 2";

}
