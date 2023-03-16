import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * [키워드]
 * 친구관계는 트리로 표현함 (부모-자식 관계)
 * 1명의 상태는 2가지 (얼리어답터이거나, 얼리어답터가 아니거나)
 * 얼리어답터 X가 정보를 받아들이기 위해서
 * -> 연결된 모든친구가 얼리어답터O여야한다.
 * 가능한 최소한의 얼리어답터 수
 * 
 * [풀이과정]
 * 1. 모든관계를 노드객체로 입력받고 연결한다.
 * 2-1. 부모가 얼리어답터 X -> 모든 자식은 얼리어답터O
 * 2-2. 부모가 얼리어답터 O -> 자식은 얼리어답터O이거나 X거나 둘다 가능
 * 3. 단말노드부터 하나씩 위로 올라가면서 최소 얼리어답터수를 갱신한다.
 * 
 * [입력]
 * 1~N 까지의 정점 (2<= N <=1,000,000)
 * N-1의 간선
 * 
 * [출력] 
 * 
 * @author 윤선희
 * @since 2023.03.17
 * @see https://www.acmicpc.net/problem/2533
 * @performance
 * @category #트리 #dp
 */

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N;
	static int dp[][];
	static boolean visited[];
	static final int EA_O=1, EA_X=0;
	static ArrayList<Integer> SNS[];
	

	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		
		SNS = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for (int i = 1; i <= N; i++) {
			SNS[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N-1; i++) {
			tokens = new StringTokenizer(input.readLine());
			int from = Integer.parseInt(tokens.nextToken());
			int to = Integer.parseInt(tokens.nextToken());
			SNS[from].add(to);
			SNS[to].add(from);
		}
		
		dp = new int[N+1][2];
		
		//System.out.println(Arrays.toString(SNS));
		findEA(1);
		System.out.println(Math.min(dp[1][EA_O], dp[1][EA_X]));

	}
	
	private static void findEA(int i) {
		visited[i] = true;
		dp[i][EA_O] = 1; //내가 얼리어답터인 경우 카운트 하고 시작
		dp[i][EA_X] = 0; //내가 얼리어답터가 아닌경우
		
		for(int child : SNS[i]) {
			if(visited[child]) continue;
			findEA(child);
			dp[i][EA_X] += dp[child][EA_O]; //내가 얼리어답터가 아니면 자식은 무조건 얼리어답터여야함
			dp[i][EA_O] += Math.min(dp[child][EA_O], dp[child][EA_X]); //내가 얼리어답터면 자식은 얼리어답터일 수도 아닐수도
		}
	}

	private static String instr ="8\r\n" + 
			"1 2\r\n" + 
			"1 3\r\n" + 
			"1 4\r\n" + 
			"2 5\r\n" + 
			"2 6\r\n" + 
			"4 7\r\n" + 
			"4 8";

}