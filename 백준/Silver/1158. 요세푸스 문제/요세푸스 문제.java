import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main { //요세푸스 (실버)
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static int K;
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			queue.add(i+1);
		}
		
		//System.out.println(queue.toString());
		
		output.append("<");
		
		//큐에 한개만 남을 때까지 진행 
		while(queue.size()>1) {
			for(int i=0; i<K-1; i++) { 
				//K번째 순서가 올 때까지 앞에 있는 것은 꺼내지 않을 것이므로 순서대로 뒤로 넣는다.
				queue.offer(queue.poll());
			}
			//K번째에 도착하면 꺼내서 출력물에 넣는다.
			output.append(queue.poll()).append(", ");
		}
		
		//마지막엔 쉼표가 아닌 꺽쇄를 찍기 때문에 따로 뺌. 
		output.append(queue.poll()).append(">");
		
		System.out.println(output);
		
		

	}

}
