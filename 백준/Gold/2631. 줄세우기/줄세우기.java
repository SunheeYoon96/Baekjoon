import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	
	static int N, children[], dp[]; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		
		children = new int[N];
		dp =new int[N];
		
		for (int i = 0; i < N; i++) {
			children[i] = Integer.parseInt(input.readLine());
		}
		
		int size=0;
		
		for (int i = 0; i < children.length; i++) {
			//목표값이 옮겨질 위치 찾기
			int searchIdx = Arrays.binarySearch(dp, 0,size, children[i]);
			searchIdx = Math.abs(searchIdx)-1;
			
			dp[searchIdx] = children[i];
			
			if(size==searchIdx) {
				size++;
			}
			
		}
		
		//System.out.println(Arrays.toString(dp));
		System.out.println(N-size);
		
	
	}

}