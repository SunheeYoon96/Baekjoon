import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [키워드]
 * 
 * [풀이과정]
 * 
 * [입력]
 * [출력] 
 * 
 * @author SSAFY
 * @see
 * @performance
 * @category 
 */

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, numbers[], accuNum[], M, range[][], ans;

	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		
		numbers = new int[N];
		accuNum = new int[N]; //누적합한 배열
		
		tokens = new StringTokenizer(input.readLine());
		for(int i=0; i<N; i++) {
			numbers[i] = Integer.parseInt(tokens.nextToken());
		}
		
		//누적합한 배열
		accuNum[0] = numbers[0];
		for(int i=1; i<N; i++) {
			accuNum[i] = numbers[i] + accuNum[i-1];
		}
		
		tokens = new StringTokenizer(input.readLine());
		M = Integer.parseInt(tokens.nextToken());
		//구간 정보
		range = new int[M][2];
		for(int i=0; i<M; i++) {
			tokens = new StringTokenizer(input.readLine());
			for(int j=0; j<2; j++) {
				range[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		ans = 0;
		int start=0;
		int end=0;
		
		for(int i=0; i<M; i++) {
			start = range[i][0]-1;
			end = range[i][1]-1;
			if(start-1<0) {
				ans = accuNum[end];
			}else {
				//System.out.println(start-1);
				ans = accuNum[end] - accuNum[start-1];	
			}
			output.append(ans).append("\n");
		}
		
		System.out.println(output);

	}
	
	static String instr = "5\r\n" + 
			"10 20 30 40 50\r\n" + 
			"5\r\n" + 
			"1 3\r\n" + 
			"2 4\r\n" + 
			"3 5\r\n" + 
			"1 5\r\n" + 
			"4 4";

}


;