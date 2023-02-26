import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M, cards[], searchNums[]; 

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		
		cards = new int[N];
		
		tokens = new StringTokenizer(input.readLine());
		for(int i=0; i<N; i++) {
			cards[i] = Integer.parseInt(tokens.nextToken()); 
		}
	
		tokens = new StringTokenizer(input.readLine());
		M = Integer.parseInt(tokens.nextToken());
		
		searchNums = new int[M];
		
		tokens = new StringTokenizer(input.readLine());
		for(int i=0; i<M; i++) {
			searchNums[i] = Integer.parseInt(tokens.nextToken()); 
		}
		// 입력 끝
		
		Arrays.sort(cards);
		
		for(int i=0; i<M; i++) {
			output.append(upperB(searchNums[i]) - lowerB(searchNums[i])).append(" ");
		}
		
		System.out.println(output);

	}
	
	public static int upperB(int key) {
		int low = 0;
		int high = cards.length;
		
		while(low<high) {
			int mid = (low + high)/2;
			
			if(key < cards[mid]) {
				high = mid;
			}else {
				low = mid+1;
			}
			
		}
		
		return low;
	}
	
	public static int lowerB(int key) {
		int low = 0;
		int high = cards.length;
		
		while(low<high) {
			int mid = (low + high)/2;
			
			if(key <= cards[mid]) {
				high = mid;
			}else {
				low = mid+1;
			}
			
		}
		
		return low;
	}

}