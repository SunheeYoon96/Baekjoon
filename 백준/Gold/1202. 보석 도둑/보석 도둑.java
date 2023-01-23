import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Jewel {
	int weight;
	int value;
	
	Jewel(int weight, int value){
		this.weight = weight;
		this.value = value;
	}
}

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	//static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static int K;

	public static void main(String[] args) throws Exception {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		Jewel[] jewels= new Jewel[N];
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine());
			int w = Integer.parseInt(tokens.nextToken());
			int v = Integer.parseInt(tokens.nextToken());
			
			jewels[i] = new Jewel(w, v);
		}
		
		//보석의 무게 오름차순 정렬(단, 무게가 같으면 가격을 내림차순)
		Arrays.sort(jewels, new Comparator<Jewel>() {

			@Override
			public int compare(Jewel o1, Jewel o2) { 
				if(o1.weight == o2.weight) { //무게가 같으면 
					return o2.value - o1.value; //가격을 내림차순
				}
				
				return o1.weight - o2.weight; //기본은 무게 오름차순
			}
		});
		
		//가방배열 선언
		int[] carrier = new int[K];
		for(int i=0; i<K; i++) {
			carrier[i] = Integer.parseInt(input.readLine());
		}
		
		//가방배열도 오름차순으로 정렬해주기
		Arrays.sort(carrier);
		
		//가방과 보석의 무게를 비교해서 우선순위 큐에 담자
		//우선순위 큐에서는 보석의 가격이 내림차순 되도록 담자 -> 가장 비싼 결과물을 얻기 위해
		PriorityQueue<Integer> pqueue = new PriorityQueue<>(Comparator.reverseOrder());
		
		long answer = 0; //한 가방의 최대 무게가 100,000,000이므로 long으로 설정
		
		for(int i=0, j=0; i<K; i++) { //가방의 갯수만큼 반복 
			//보석범위 내 && 현재 가방의 무게보다 작거나 같은 보석을 큐에 담기
			while(j<N && jewels[j].weight <= carrier[i] ){
				pqueue.offer(jewels[j++].value);
			}
			
			//우선순위 큐에 있는 요소들을 하나씩 빼서 가방에 넣음
			//우선순위 큐에서 이미 가격 내림차순으로 정렬되어있으니 첫번째부터 꺼내서 담으면 된다.
			//큐가 비어있지 않으면
			if(!pqueue.isEmpty()) {
				answer += pqueue.poll();
				//System.out.println(K);
			}
		}
		
		System.out.println(answer);
		
		
	}

}
