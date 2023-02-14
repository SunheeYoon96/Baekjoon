import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static String N;
	static int[] nums;
	static boolean[] visited;
	static int minVal;
	
	public static void main(String[] args) throws IOException {
		N = input.readLine();
		
		nums = new int[N.length()];
		for(int i=0; i<N.length(); i++) {
			nums[i] = N.charAt(i)-'0'; //char to int
		}
		
		visited = new boolean[N.length()+1];
		minVal = 999999;
		makeCombination(0, new int[N.length()]);
		if(minVal==999999) {
			minVal = 0;
		}
		System.out.println(minVal);
	}
	
	public static void makeCombination(int nthpick, int[] choosed) {
		if(nthpick==choosed.length) {
			//System.out.println(Arrays.toString(choosed));
			String tmp = "";
			for(int i=0; i<choosed.length; i++) {
				tmp += choosed[i]+"";
			}
			
			int combNum =Integer.parseInt(tmp); 
			if(combNum > Integer.parseInt(N)) {
				minVal = Math.min(minVal, combNum);
			}
			return;
		}
		
		for(int i=0; i<nums.length; i++) {
			if(!visited[i]) {
				visited[i]=true;
				choosed[nthpick] = nums[i];
				makeCombination(nthpick+1, choosed);
				visited[i]= false;
			}
			
		}
	}

}
