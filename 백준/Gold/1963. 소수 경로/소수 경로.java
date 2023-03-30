import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [키워드] 
 * 소수를 찾아라 최소한의 변경으로 소수->소수로 바꿔라 
 * 4자리수 1~9999 까지도 소수가 1300여개 니까 1000~9999까지는 더 적을 듯 
 * 순열 X
 * BFS 
 * 
 * [풀이과정]
 * 
 * [입력] [출력]
 */

public class Main {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int N;
	static int origin[], goal[];
	static boolean tmp[];
	static List<Integer> prime;

	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));

		N = Integer.parseInt(input.readLine());
		
		origin = new int[N];
		goal = new int[N];

		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(input.readLine());
			origin[i] = Integer.parseInt(tokens.nextToken());
			goal[i] = Integer.parseInt(tokens.nextToken());
		}

		tmp = new boolean[10000];
		prime = new ArrayList<>();
		
		makePrime();
		
//		for(int x : prime) {
//			System.out.println(x);
//		}
		
		for(int i=0; i<origin.length; i++) {
			changePass(origin[i], goal[i]);
		}
		
		System.out.println(output);

	}

	private static void changePass(int oriItem, int goalItem) {
			Queue<Integer> queue = new ArrayDeque<>();
			HashMap<Integer, Integer> changedHM = new HashMap<>(); //key:바꾼 숫자 , value:변경횟수
			queue.offer(oriItem);
			changedHM.put(oriItem, 0);
			
			while (!queue.isEmpty()) {
				int current = queue.poll();
				int changedCnt = changedHM.get(current);
				
				if(current == goalItem) {
					output.append(changedCnt).append("\n");
					return;
				}else {
					int pass[] = {current/1000 , (current/100)%10, (current/10)%10, current%10};
					//System.out.println(Arrays.toString(pass));
					
					for (int i = 0; i < pass.length; i++) {
						for (int j = 0; j < 10; j++) {
							//첫째자리는 0이 오면 안된다.
							if(i==0 && j==0) continue;
							
							int temp = pass[i];
							pass[i] = j; //숫자 한개 바꾸기
							int next = makeInteger(pass);
							pass[i] = temp; //바꾼거 다시 돌려놓기
							
							if(!prime.contains(next)) continue;
							
							if(!changedHM.containsKey(next)) {
								queue.offer(next);
								changedHM.put(next, changedCnt+1);
							}
						}
					}
				}
				
				
			}
			output.append("Impossible").append("\n");
			return;
			
 			
	}

	private static int makeInteger(int[] pass) {
		int num = pass[0]*1000 + pass[1]*100 + pass[2]*10 + pass[3];
		return num;
	}


	private static void makePrime() {
		// false일 경우 소수라고 초기화했다고 가정하자.

		tmp[0] = tmp[1] = true; // 0,1은 소수가 아니다.

		for (int i = 2; i < 10000; i++) {
			if (tmp[i])continue;

			for (int j = i * i; j < 10000; j+=i) {
				tmp[j] = true;
			}
		}

		for (int i = 0; i < tmp.length; i++) {
			if(!tmp[i]) prime.add(i);
		}
	}

	private static String instr = "3\r\n" + "1033 8179\r\n" + "1373 8017\r\n" + "1033 1033";

}