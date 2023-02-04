import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 17404 : RGB거리 2
public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N;
	static int[][] house;
	static int[][] dp;
	static int maxval = 10001; //한집 색칠비용의 최대가 1000이라고 해서 
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		int finish=Integer.MAX_VALUE; //마지막에 최소인 총비용을 비교하기 위해서
		
		dp = new int[N][3];
		house = new int[N][3];
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine());
			house[i][0] = Integer.parseInt(tokens.nextToken()); //red
			house[i][1] = Integer.parseInt(tokens.nextToken()); //green
			house[i][2] = Integer.parseInt(tokens.nextToken()); //blue
		}
		
		//첫번째 집부터 색칠하자.
		for(int i=0; i<3; i++) {
			//첫번째 집이 Red이면,
			if(i==0) {
				dp[0][0] = house[0][0]; //첫번째 집 비용을 dp에 저장
				dp[0][1] = maxval;      //나머지 집들은 임의로 최대값을 넣어둔다.
				dp[0][2] = maxval;
			}else if(i==1) {
				dp[0][0] = maxval; 
				dp[0][1] = house[0][1]; //첫번째 집 비용을 dp에 저장
				dp[0][2] = maxval;
			}else if(i==2) {
				dp[0][0] = maxval; 
				dp[0][1] = maxval;      
				dp[0][2] = house[0][2]; //첫번째 집 비용을 dp에 저장
			}
			
			for(int j=1; j<N; j++) {
				//그 다음 집부터 이전과 색을 비교해서 넣는다
				dp[j][0] = Math.min(dp[j-1][1], dp[j-1][2]) + house[j][0];
				dp[j][1] = Math.min(dp[j-1][0], dp[j-1][2]) + house[j][1];
				dp[j][2] = Math.min(dp[j-1][0], dp[j-1][1]) + house[j][2];
				
//				if(j==N-1) { //가장 마지막 집은 첫번째와 같지 않게 한다.
//					dp[j][i] = maxval; //첫번째와 같은 색일때 임의로 큰 값을 넣어줘서 색을 다르게함. 
//				}
			}
			
			//첫번째 집의 색에 따라 총비용이 최소인 값을 걸러줌
			for(int j = 0; j<3; j++) {
				if(i != j) {
					finish = Math.min(finish, dp[N-1][j]);
				}
	             
	        }
		}
		
		System.out.println(finish);

	}

}
