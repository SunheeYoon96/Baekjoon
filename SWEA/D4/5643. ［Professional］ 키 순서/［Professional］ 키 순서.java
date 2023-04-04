import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int T, N, M, totalCnt;
	static List<Integer>[] students;
	static int connected[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(input.readLine());
		
		for (int t = 1; t <= T; t++) {
			output.append("#").append(t).append(" ");
			
			N = Integer.parseInt(input.readLine());
			M = Integer.parseInt(input.readLine());
			
			students = new LinkedList[N+1];
			for (int i = 1; i <= N; i++) {
				students[i] = new LinkedList<>();
			}
			
			for (int i = 0; i < M; i++) {
				tokens = new StringTokenizer(input.readLine());
				int from = Integer.parseInt(tokens.nextToken());
				int to = Integer.parseInt(tokens.nextToken());
				students[from].add(to);

			}
			
			connected = new int[N+1];
			
			int answer = 0;
			answer = countFriends();
			
			output.append(answer).append("\n");
		}

		System.out.println(output);
	}

	private static int countFriends() {
		Queue<Integer> que = new ArrayDeque<>();
		for (int x = 1; x <=N; x++) {
			
			boolean visited[] = new boolean[N+1];
			que.offer(x);
			visited[x] = true;
			
			while (!que.isEmpty()) {
				int current = que.poll();
				
				connected[x]++;
				
				for (int i = 0; i < students[current].size(); i++) {
					//선택된 학생과 연결된 학생들을 큐에 담으면서 횟수세기
					int connetFriend = students[current].get(i);
					
					if(!visited[connetFriend]) {
						que.offer(connetFriend);
						visited[connetFriend] = true;
						connected[connetFriend]++;
					}
				}
			}
			
		}
		
		totalCnt=0;
		
		for (int i = 1; i <=N; i++) {
			//System.out.println(connected[i]);
			if(connected[i]==N) {
				totalCnt +=1;
			}
			
		}

		return totalCnt;
		
	}

}