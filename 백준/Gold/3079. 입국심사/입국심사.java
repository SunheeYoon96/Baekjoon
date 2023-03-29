import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [키워드]
 * 입력값이 개 크다 -> 탐색을 짧게 해야한다 -> 가장 빠른 이분탐색
 * 랜선자르기
 * 
 * [풀이과정]
 * 
 * [입력]
 * 첫째 줄에 N과 M이 주어진다. (1 ≤ N ≤ 100,000, 1 ≤ M ≤ 1,000,000,000)
 * 다음 N개 줄에는 각 심사대에서 심사를 하는데 걸리는 시간인 Tk가 주어진다. (1 ≤ Tk ≤ 10^9)
 * [출력] 

 */

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N;
	static long M, times[], answer, maxVal;

	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken()); //심사대 갯수
		M = Long.parseLong(tokens.nextToken()); //심사받아야할 인원 수 -> key값 //시간이 range가 되는 것
		
		times = new long[N];
		maxVal = 0;
		
		for (int i = 0; i < N; i++) {
			times[i] = Integer.parseInt(input.readLine());
			maxVal = Math.max(maxVal, times[i]);
		}
		
		//이진탐색 전에 정렬하기
		Arrays.sort(times);
		
		//입국심사 시작
		answer = immigration(N, M);
		System.out.println(answer);

	}
	
	//입국심사
	private static long immigration(int n, long key) {
		long low = 1;
		long high = maxVal * M-1;
		
		while (low <= high) {
			long mid = (low+high)/2;
			long sum = 0;
			
			for (int i = 0; i < times.length; i++) {
				long canPeople = mid/times[i];
				
				if(sum >= key) {
					break;
				}
				sum += canPeople;
			}
			
			
			if(sum>=key) { //계산한 인원이 원하는 값보다 크면
				high = mid-1; //범위를 줄이고
			}else { //계산한 인원이 원하는 값보다 작으면
				low = mid+1; //범위를 늘린다.
			}
		}	
		return low;
	}


}