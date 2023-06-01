import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [키워드]
 * 정렬 + 누적합 => 최소값
 * 
 * [풀이과정]
 * 정렬해서 누적합을 구하자
 * 어떻게 정렬하니?
 * 1. 그냥 정렬
 * 2. 카운팅 정렬
 * 
 * [입력]
 * [출력] 
 * 
 * @author 윤선희
 * @since 
 * @see
 * @performance
 * @category #
 */

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, time[],couting[], sorted[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		
		tokens = new StringTokenizer(input.readLine());
		
		time = new int[N];  //사람은 N명
		couting = new int[1001]; //시간의 범위 1~1000
		sorted = new int[N];
		
		for (int i = 0; i < N; i++) {
			time[i] = Integer.parseInt(tokens.nextToken());
			couting[time[i]]++;
		}
		
		for (int i = 1; i < couting.length; i++) {
			couting[i] += couting[i-1]; //누적합
		}
		
		for (int i = time.length-1; i >=0; i--) {
			int val = time[i];
			couting[val]--;
			sorted[couting[val]] = val;
		}
		
		//처음 배열 값을 시작 값으로 
		int sum=sorted[0];
		
		for (int i = 1; i < sorted.length; i++) {
			sorted[i] += sorted[i-1];
			sum += sorted[i];
		}
		
//		System.out.println(Arrays.toString(sorted));
		
		System.out.println(sum);
		
		


	}

}