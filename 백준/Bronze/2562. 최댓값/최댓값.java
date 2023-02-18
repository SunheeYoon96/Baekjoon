import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static int[] numbers;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		numbers = new int[9];
		int maxVal = Integer.MIN_VALUE;
		
		for(int i=0; i<9; i++) {
			numbers[i] = Integer.parseInt(input.readLine());
			maxVal = Math.max(maxVal, numbers[i]);
		}
		
		for(int i=0; i<9; i++) {
			if(maxVal == numbers[i]) {
				System.out.println(maxVal);
				System.out.println(i+1);
			}
		}
		
		
		
		

	}

}
