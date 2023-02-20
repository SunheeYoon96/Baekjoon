import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static PriorityQueue<Integer> pq;
	static int N;
	static int num;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		
		//우선 순위 큐 초기화
		pq = new PriorityQueue<>((o1, o2) -> {
			int abs1 = Math.abs(o1);
			int abs2 = Math.abs(o2);

			if(abs1 == abs2) return o1 > o2 ? 1 : -1;
			return abs1 - abs2;
		});
		
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine());
			num = Integer.parseInt(tokens.nextToken());
			if(num!=0) {
				pq.add(num);
			}else {
				if(pq.isEmpty()) {
					output.append(0).append("\n");
				}else {
					output.append(pq.poll()).append("\n");
				}
				
			}
			
		}
		
		System.out.println(output);

	}

}
