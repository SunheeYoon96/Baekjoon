import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * [키워드]
 * 박스 안에 있는 모든 수에 대해 그 수의 모든 배수가 무한히 박스에 있다.
 * -> 박스안에 있는 N이하의 가장 작은 소수를 구하는 것 
 * 질문은 20번만 가능
 * 
 * [풀이과정]
 * 
 * [입력]
 * [출력] 
 * 
 * @since 
 * @see
 * @performance
 * @category #
 */

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

	static StringTokenizer tokens;
	static int N,ans, low, high,mid, K;
	static boolean prime[];
	static ArrayList<Integer>primeList;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());

		prime = new boolean[N+1];
		for(int i=0; i<N+1; i++) {
			prime[i] = true;
		}
		
		//소수 판별 후 찐 소수들을 담을 리스트
		primeList = new ArrayList<>();
		
		//소수 구하기
		makePrime();
		
		//이분탐색 준비
		low = 0;
		high = primeList.size()-1;
		
		//질의하기
		while (low <= high) {
			//중간값구하기
			mid = (low+high)/2;
			K = primeList.get(mid);
			
			//질의
			output.write("? "+K+"\n");
			output.flush();
			
			ans = Integer.parseInt(input.readLine());
			
			if(ans==1) { //k를 포함한 작은 소수들 있어!
				low = mid+1; //그 위를 탐색하자
			}else if (ans==0) { //k없는데?
				high = mid-1; //그 아래를 탐색하자.
			}
		}//end
		
		K = primeList.get(low);
		
		output.write("! "+K+"\n");
		output.flush();
		output.close();

	}
	

	//에라토스테네스의 체
	private static void makePrime() {
		prime[0] = prime[1] = false;
		
		for(int i=2; i<=Math.sqrt(N+1/2); i++) {
			if(!prime[i]) continue;
			
			for(int j=i*i; j<N+1; j+=i) {
				prime[j] = false;
			}
		}
		
		for(int i=0; i<prime.length; i++) {
			if(prime[i]) {
				primeList.add(i);
			}
		}
	}
	
	

}