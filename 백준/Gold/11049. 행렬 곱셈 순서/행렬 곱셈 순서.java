import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [키워드]
 * 곱셈의 연산 수는 행렬을 곱하는 순서에 따라 달라진다
 * 단, 행렬의 순서를 변경할 수 없다.
 * 곱셈연산 횟수의 최솟값을 구하시오
 * 행렬곱셈연산 -> 순서변경X -> 같은 연산반복 -> dp에 저장
 * 
 * (i번 ~ k번) 행렬의 최소연산 + (k ~ j) 최소 + 이 둘을 곱함(a*b*c)
 * 1. i~i 행렬곱셈 = 0
 * 2. 2개 행렬 곱셈
 * 3. 3개 행렬 곱셈
 * .....
 * N. N개행렬 곱셈
 * -> 순차적으로 DP에 저장 
 * -> 순서가 변경될 수 없니까 상삼각행렬만 구하면 된다.
 * 
 * [풀이과정]
 * 1) 각 행렬 정보입력받기
 * 2-1) 반복문을 돌면서 2차원배열안에 대각라인은 자기자신이므로 0
 * 2-2) 나머지는 최대값(INF)로 초기화
 * 3) 반복문을 돌면서 i~k 곱셈연산 * k+1~j 곱셈연산 값을 하면서 최솟값으로 갱신해주기. 
 * 
 * [입력]
 * 행렬의 개수 N(1 ≤ N ≤ 500)
 * 행렬의 크기 r과 c가 주어진다. (1 ≤ r, c ≤ 500)
 * 
 * [출력] 
 * 
 * @since 2023.03.08
 * @see https://www.acmicpc.net/problem/11049
 * @performance
 * @category #DP
 */

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N , matrix[][];
	static long dp[][];
	static final int row=0, col=1, INF=Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//input = new BufferedReader(new StringReader(instr));
		N = Integer.parseInt(input.readLine());
		
		matrix = new int[N][2];
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine());
			matrix[i][row] = Integer.parseInt(tokens.nextToken()); 
			matrix[i][col] = Integer.parseInt(tokens.nextToken()); 
		}
		
		dp = new long[N][N];
		
		//DP초기화
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(r==c) {
					//대각라인
					dp[r][c]=0;
				}
				else {
					//나머지 위치들의 비용(값)
					dp[r][c] = INF;
				}
			}
		}
		
		//곱셈연산의 행렬수가 작은것부터 계산
		//0,1 -> 1,2 -> 2,2 
		for(int j=1; j<N; j++) {
			for(int i=0; i+j<N; i++) {
				minCalc(i, i+j);
			}
		}
		System.out.println(dp[0][N-1]);
	}
	
	private static void minCalc(int a, int b) {
		for(int k=a; k<b; k++) {
			long multiVal = dp[a][k] + dp[k+1][b] + matrix[a][row]*matrix[k][col]*matrix[b][col]; 
			dp[a][b] = Math.min(multiVal, dp[a][b]);
		}
		
	}

	static String instr ="3\r\n" + 
			"5 3\r\n" + 
			"3 2\r\n" + 
			"2 6";

}