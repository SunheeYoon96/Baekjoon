import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	
	static int N, ropes[], maxVal;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		
		ropes = new int[N];
		
		for (int i = 0; i < N; i++) {
			ropes[i] = Integer.parseInt(input.readLine());
		}
		
		maxVal = -1;
		
		Arrays.sort(ropes);
		
		maxVal = Math.max(maxVal, ropes[N-1]);
		//maxVal = Math.max(maxVal, ropes[0]*N);
		for (int i = 0; i < N; i++) {
			maxVal = Math.max(maxVal, ropes[i]*(N-i));
		}
		
		System.out.println(maxVal);
	}

}