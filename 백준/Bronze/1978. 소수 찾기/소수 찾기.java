import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, numsers[];
	static boolean isPrime[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		
		numsers = new int[N];
		isPrime = new boolean[1000+1];
		isPrime[0] = isPrime[1] = true ; //0과1은 소수가 아니다.
		
		tokens = new StringTokenizer(input.readLine());
		
		for (int i = 0; i < N; i++) {
			numsers[i] = Integer.parseInt(tokens.nextToken());
		}
		
		for (int i = 2; i <= 1000 ; i++) {
			if(isPrime[i]) continue;
			
			for (int j = i*i; j <= 1000; j+=i) {
				isPrime[j] = true; //소수가 아닌것에 체크함으로 써 소수를 판별하는 것
			}
		}
		
		int cnt = 0;
		
		for(int x : numsers) {
			if(!isPrime[x]) cnt++;
		}
		
		System.out.println(cnt);

	}

}