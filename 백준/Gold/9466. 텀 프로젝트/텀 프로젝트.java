import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [키워드]
 * 학생들이 팀을 같이 하고 싶은 사람을 선택한다 -> 사이클이 만들어지면 한팀이 된다.
 * 사이클에 포함되지 않은 애들이 총 몇명인지 출력하라.
 * 
 * [풀이과정]
 * 
 * [입력]
 * 학생의 수가 정수 n (2 ≤ n ≤ 100,000)
 * 제한시간 3초
 * 
 * [출력] 
 * 
 * @author 윤선희
 * @since 2023.04.05
 * @see https://www.acmicpc.net/problem/9466
 * @performance
 * @category #unionFind #그래프 
 */

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int T, N, applyList[], repres[], cycleCnt;
	static boolean visited[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//input = new BufferedReader(new StringReader(instr));
		
		T = Integer.parseInt(input.readLine());
		
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(input.readLine());
			
			tokens = new StringTokenizer(input.readLine());
			applyList = new int[N];
			cycleCnt=0;
			
			for (int i = 0; i < N; i++) {
				applyList[i] = Integer.parseInt(tokens.nextToken())-1;
			}
			
			//초기화
			makeSet();
			visited = new boolean[N];
								
			for (int i = 0; i < N; i++) {
				union(i, applyList[i]);
			}
			
			output.append(N-cycleCnt).append("\n");
			
		}
		System.out.println(output);
		
	}
	
	
	private static boolean union(int a, int b) {
		a = findSet(a);
		b = findSet(b);
		
		if(a==b) { //사이클 형성됨.
			//그점을 가지고 원본데이터에 가서 사이클의 길이를 찾자.
			bfs(a);
			return true;
		}else {  
			repres[a] = b;  //a학생이 b를 선택했으니까 a의 대표자를 b로 선택한다. 
		}
		
		return false;
	}

	
	private static void bfs(int a) {
		Queue<Integer> que = new ArrayDeque<>();
		
		int start = a; //a부터 사이클 시작!
		que.offer(a);
		visited[a] = true;
		cycleCnt++;
		
		while (!que.isEmpty()) {
			int now = que.poll();
//			System.out.println(now);
			
			if(!visited[applyList[now]]) {
				que.offer(applyList[now]);
				visited[applyList[now]] = true;
				cycleCnt++;
			}
		}
		
	}



	private static int findSet(int a) {
		if(repres[a]==a) return a;
		return repres[a] = findSet(repres[a]);
	}


	private static void makeSet() {
		repres = new int[N];
		for (int i = 0; i < N; i++) {
			repres[i] = i;
		}
	}



	private static String instr = "2\r\n" + 
			"7\r\n" + 
			"3 1 3 7 3 4 6\r\n" + 
			"8\r\n" + 
			"1 2 3 4 5 6 7 8";

}