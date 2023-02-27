import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, K;
	static long lines[], max, ans;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		K = Integer.parseInt(tokens.nextToken());
		N = Integer.parseInt(tokens.nextToken());
		
		lines = new long[K];
		max = 0;
		ans = 0;
		
		for(int i=0; i<K; i++) {
			tokens = new StringTokenizer(input.readLine());
			lines[i] = Long.parseLong(tokens.nextToken());
			max = Math.max(max, lines[i]);
		}
		//key = 원하는 갯수
		//mid = 랜선길이
		ans = binarySearch(N, max);
		System.out.println(ans);
		
		
	}
	
	public static long binarySearch(int N, long max) {
		long half = 0;
		long min = 1;
		
		while(min <= max) {
			half = (min + max)/2; //자르고자하는 길이
			long cnt = 0; //잘린 랜선의 갯수
			
			for(long l : lines) {
				cnt += l/half;
			}
			
			//원하는 랜선의 갯수보다 잘라진 랜선의 수가 적을 경우
			//하나의 랜선 길이가 길어서 길이를 더 짧게 만들어야한다.
			//half보다 작은 수
			if(cnt < N) {
				max = half-1;
			}
			//원하는 랜선의 갯수보다 잘라진 랜선 수가 많은 경우
			//하나의 랜선길이가 짧아서 더 길게 만들어야한다.
			//half보다 큰수
			else {
				min = half+1;
			}
		}
		
		return(max+min)/2;
	}

}