import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N, numbers[], result[]; 
	
	static class Pack implements Comparable<Pack>{
		int value, idx;

		public Pack(int value, int idx) {
			this.value = value;
			this.idx = idx;
		}

		@Override
		public int compareTo(Pack o) {
			return Integer.compare(this.value, o.value);
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		
		tokens = new StringTokenizer(input.readLine());
		numbers = new int[N];
		
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(tokens.nextToken()); 
		}
		
		PriorityQueue<Pack> pq = new PriorityQueue<>();
		
		//pq에 담음으로써 자동으로 정렬시킴
		for (int i = 0; i < N; i++) {
			pq.offer(new Pack(numbers[i], i));
		}
		
		result = new int[N];
		int compressedVal = 0;
		int before=pq.peek().value;
		
		for (int i = 0; i < N; i++) {
			Pack now = pq.poll();
			if(before<now.value) {
				compressedVal++;
				result[now.idx] = compressedVal;
				before = now.value;
			}else {
				result[now.idx] = compressedVal;
			}
		}

		for(int x : result) {
			output.append(x).append(" ");
		}
		
		System.out.println(output);

	}
	
	private static String instr = "5\r\n" + 
			"2 4 -10 4 -9";
	
	

}