import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int T, N, M, adj[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		

			N = Integer.parseInt(input.readLine());
			//M = Integer.parseInt(input.readLine());
			
			adj = new int[N+1][N+1];
			
			int a,b;
			for (int i = 1; i <=N; i++) {
				tokens = new StringTokenizer(input.readLine());
				for (int j = 1; j <=N; j++) {
					adj[i][j] = Integer.parseInt(tokens.nextToken());
				}				
			}
			
			//플로이드 워셜
			for (int k = 1; k <= N; k++) { //경유
				for (int i = 1; i <=N; i++) { //출발
					
					if(i==k || adj[i][k]==0) continue; //경유효과 없다. 알수 있는 관계가 없기 때문이다.||i와k의 관계가 없어서 경유불가
					for (int j = 1; j <=N; j++) { //도착
						//i < k < j : 학생i보다 학생 k가 키가 크고 학생k보다 학생j가 키가 크면 
						//고로 학생 i보다 학생j가 키가 크다. 
						
						if(adj[i][j]==1) continue; //이미 관계를 알고있는 경우
						
						//둘다 같은 결과임
						//adj[i][j] = adj[i][k] & adj[k][j];
						adj[i][j] = adj[k][j];
						
					}
				}
			}
			
			for (int i = 1; i <=N; i++) {
				for (int j = 1; j <=N; j++) {
					System.out.print(adj[i][j]+" ");
				}
				System.out.println();
				
			}
			

	}

}