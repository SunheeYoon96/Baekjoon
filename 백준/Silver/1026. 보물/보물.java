import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	static int N, arrA[], arrB[], answer;
	
	static class Pair implements Comparable<Pair>{
		int value, idx;

		public Pair(int value, int idx) {
			this.value = value;
			this.idx = idx;
		}

		@Override
		public int compareTo(Pair o) {
			return Integer.compare(this.value, o.value)*-1;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		N = Integer.parseInt(input.readLine());
		
		answer = 0;
		arrA = new int[N];
		arrB = new int[N];
		
		tokens = new StringTokenizer(input.readLine());
		for (int i = 0; i < N; i++) {
			arrA[i] = Integer.parseInt(tokens.nextToken());
		}
		
		tokens = new StringTokenizer(input.readLine());
		for (int i = 0; i < N; i++) {
			arrB[i] = Integer.parseInt(tokens.nextToken());
		}
		
		int copyA[] = Arrays.copyOf(arrA, N);
		Arrays.sort(copyA);
		
		int result[] = new int[N];
		
		//pq에 담아서 값이 큰 순서대로 뽑아내기
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			pq.offer(new Pair(arrB[i], i));
		}
		
		for (int i = 0; i < N; i++) {
			Pair now = pq.poll();
			result[now.idx] = copyA[i];
		}
		
//		System.out.println(Arrays.toString(result));
		
		for (int i = 0; i < N; i++) {
			answer += (result[i]*arrB[i]);
		}

		System.out.println(answer);
		
		
		
		

	}

}