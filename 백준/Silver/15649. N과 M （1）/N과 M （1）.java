import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	//static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static int M;
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		//M번째, choosed :뽑은 숫자들, 방문여부
		// 0번째부터 뽑기 시작해서 M개를 뽑을 꺼다. 이미 뽑았는집 아닌지는 isSelected로 방문체크하자. 
		Permutation(0, new int[M], new boolean[N+1]);
		
		
	}
	
	static void Permutation(int nthpick, int[] choosed, boolean[] isSelected ) {
		if(nthpick == choosed.length) {
			for(int i=0; i<choosed.length; i++) {
				System.out.print(choosed[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=1; i<=N; i++) { //N까지 반복
			if(!isSelected[i]) {
				isSelected[i] = true;
				choosed[nthpick] = i; 
				//System.out.print(choosed[nthpick]+" ");
				Permutation(nthpick+1, choosed, isSelected);
				isSelected[i] = false;
			}
		}//end for
	}

}
