import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
	//백준 - 13335 : 트럭
public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N; //총 트럭의 갯수
	static int W; //다리 길이
	static int L; //다리가 버틸 수 있는 최대 하중
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		W = Integer.parseInt(tokens.nextToken());
		L = Integer.parseInt(tokens.nextToken());
		
		tokens = new StringTokenizer(input.readLine());
		Queue<Integer> trucks = new LinkedList<>(); //트럭을 담을 큐 선언
		//트럭의 순서가 정해져 있다 -> 순서대로 꺼내야한다 -> 큐를 쓰자
		for(int i=0; i<N; i++){
			trucks.add(Integer.parseInt(tokens.nextToken())); 
		}
		
		int time = 0;
		int bridgeOK = 0;
		Queue<Integer> bridge = new LinkedList<>();
		//다리 길이만큼 큐를 채워서 초기화 시키자.  -> 다리길이에 무게를 넣었다 빼면서 다리를 다 건넌건지 확인하려고
		for(int i=0; i<W; i++) { 
			bridge.add(0);
		}
		
		//다리에 채워진 0들이 다 빠져서 비었다면 모든 트럭이 다 건넌 것
		while(!bridge.isEmpty()) { 
			time++;
			bridgeOK -= bridge.poll();
			if(!trucks.isEmpty()) {
				if(trucks.peek() + bridgeOK <= L) {
					bridgeOK += trucks.peek();
					bridge.offer(trucks.poll());
				}else {
					bridge.offer(0);
				}
			}
			
			
		}
		
		System.out.println(time);
		
		//Queue에서 데이터를 추가, 삭제, 검색할 때 제공되는 메서드들의 차이는
		//문제 상황에서 에러를 발생시키느냐(add, remove, element)
		//아니면 null 혹은 false를 반환(offer, poll, peek) 하는가?
		
		

	}

}
