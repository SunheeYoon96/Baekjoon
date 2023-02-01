import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N;
	static int[][] house; 
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		house = new int[N+1][3]; //순서대로 RGB
		
		for(int i=1; i<=N; i++) {
			tokens = new StringTokenizer(input.readLine());
			house[i][0] = Integer.parseInt(tokens.nextToken()); //Red = 0
			house[i][1] = Integer.parseInt(tokens.nextToken()); //Green = 1
			house[i][2] = Integer.parseInt(tokens.nextToken()); //Blue = 2
		} 

		//매 회차마다 모든 경우의 수를 생각해서 최소 비용일 때마다 그 위치에 누적 저장한다. 
		for(int i=2; i<=N; i++) {
			house[i][0] += Math.min(house[i-1][1], house[i-1][2]); //1. 이번에 red를 선택하려면 이전에 green과 blue중 최솟값을 선택했어야한다.
			house[i][1] += Math.min(house[i-1][0], house[i-1][2]); //2. 이번에 green를 선택하려면 이전에 red과 blue중 최솟값을 선택했어야한다.
			house[i][2] += Math.min(house[i-1][0], house[i-1][1]); //3. 이번에 blue를 선택하려면 이전에 green과 red중 최솟값을 선택했어야한다.
		}
		
		//마지막회차에서 그동안 계산해온 RGB누적값 중 총 비용이 가장 작은 것을 선택한다. 
		int finish =  Math.min(Math.min(house[N][0], house[N][1]) ,  house[N][2]);
		
		System.out.println(finish);

	}

}
