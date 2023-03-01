import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [키워드]
 * 비상연락망으로 연락, 다자간 통화가능, 가장 나중에 연락을 받게 되는 사람 중 번호가 가장 큰 사람
 * 방향 그래프
 * 이미 연락받은사람은 제외함 -> 방문체크
 * 
 * [풀이과정]
 * 
 * [입력]
 * 연락인원 최대 100명, 중간에 비어있는 번호 존재, 다자간 통화로 동시전달
 * 
 * [출력] 
 * 가장 나중에 연락을 받게 되는 사람 중 번호가 가장 큰 사람을 구하시오
 * 
 * @author 윤선희
 * @since 2023.03.01
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15B1cKAKwCFAYD
 * @performance
 * @category #그래프 #BFS
 */

public class Solution {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T, start, strlen, answer;
	static boolean adjMatrix[][];

	public static void main(String[] args) throws IOException {
		T = 10;
		
		for (int t = 1; t <= T; t++) {
			output.append("#").append(t).append(" ");
			
			tokens = new StringTokenizer(input.readLine());
			strlen = Integer.parseInt(tokens.nextToken());
			start = Integer.parseInt(tokens.nextToken());
			
			tokens = new StringTokenizer(input.readLine());
			adjMatrix = new boolean[101][101]; //1이상 100이하의 번호
			
			for(int i=0; i<strlen/2; i++) { //from to가 한쌍
				int from = Integer.parseInt(tokens.nextToken());
				int to = Integer.parseInt(tokens.nextToken());
				adjMatrix[from][to] = true;
			}
			
			answer = bfs();
			output.append(answer).append("\n");
		}
		System.out.println(output);

	}

	
	private static int bfs() {
		int depth = 0;
		
		boolean[] visited = new boolean[101]; //방문체크할 정점배열(1~100)
		int size = 0; //큐 크기
		
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(start);
		visited[start] = true;
		
		while (!que.isEmpty()) {
			//큐 시작하자마자 사이즈를 체크해둔다.
			size = que.size();
			int maxNum = 0; //동시에 연락간 사람들 중 최대 번호
			
			//같은 깊이의 정점들이 다 빠질때 까지
			while (--size >= 0) {
				int current = que.poll();
				
				for(int i=1; i<=100; i++) {
					//현재번호와 연결도ㅣ어있고 방문하지 않았으면 큐에 담고 방문처리
					if(adjMatrix[current][i] && !visited[i]) {
						que.offer(i);
						visited[i] = true;
						
						if(maxNum<i) {
							maxNum = i;
						}
						
					}
				}
			}
			
			if(maxNum >0) {
				depth = maxNum; //깊이 탐색 끝날때마다 깊이 갱신
			}
		}//end que
		
		return depth;
	}

}