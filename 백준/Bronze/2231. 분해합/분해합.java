import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	
	static int N, answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		
		int len = String.valueOf(N).length(); //N의 자릿수
		int startLimit = N - 9*len;
		
		findConstructor(startLimit, N);
		
		System.out.println(answer);
	}

	private static void findConstructor(int start, int target) {
		
		for (int i = start; i < N; i++) {
			int sum = i;
			int k = i;
			
			while (k>0) {
				sum += (k%10);
				k /= 10;
			}
			
			if(sum == N) {
				answer = i;
				return;
			}
			
		}
		
		
	}

}