import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int NA, NB, N, M, map[][], answer;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		NA = Integer.parseInt(tokens.nextToken());
		NB = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(input.readLine());
		
		N = Math.max(NA, NB);
		
		map = new int[N+1][N+1];
		flag = false;
		
		for (int m = 0; m < M; m++) {
			tokens = new StringTokenizer(input.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			map[a][b]= map[b][a] = 1;
		}
		
		answer = (NA/2) + (NB/2);
		
		//두 집합 모두 홀수일 경우
		if((NA%2==1) && (NB%2==1)) {
			for (int i = 1; i <= NA; i++) {
				for (int j = 1; j <= NB; j++) {
					//둘다 홀수인데 연결되어있다면?
					if((i%2==1) && (j%2==1) &&(map[i][j]==1)) {
						flag = true;
					}
				}
				
			}
		}
		
		if(flag) {
			System.out.println(answer+1);
		}else {
			System.out.println(answer);
		}
	}

}