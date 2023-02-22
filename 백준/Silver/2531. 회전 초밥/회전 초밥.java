
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, D, K, coupon;
	static int sushiRail[], eating[];
	static int eatCnt, maxVal;

	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken()); //현재 벨트에 놓인 접시 수
		D = Integer.parseInt(tokens.nextToken()); //초밥의 가짓수
		K = Integer.parseInt(tokens.nextToken()); //연속으로 먹을 수 있는 초밥갯수
		coupon = Integer.parseInt(tokens.nextToken()); //쿠폰번호
		
		sushiRail = new int[N];
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine());
			sushiRail[i] = Integer.parseInt(tokens.nextToken());
		}
		
		//인덱스를 이용해 초밥 가짓수를 체크할 것 
		eating = new int[D+1];
		
		maxVal = Integer.MIN_VALUE;
		eatCnt = 0;
		
		//0인덱스부터 K개씩 먹어봄
		for(int i=0; i<K; i++) {
			int sushiNum = sushiRail[i];
			
			if(eating[sushiNum]==0) {//중복되지 않으면
				eatCnt++; //먹기
			}
			eating[sushiNum]++; //중복여부 체크
		}
		
		maxVal = eatCnt; 
		
		//시작인덱스를 1부터 하나씩 뒤로 밀면서 체크한다.
		for(int i=0; i<N; i++) {
			//System.out.println(eatCnt + " : " +maxVal);
			if(eatCnt >= maxVal) { //현재까지 먹은 횟수가 최대보다 크거나 같으면
				//아직 쿠폰을 안썻으면 한개 더 먹을 수 있다.
				if(eating[coupon]==0) {
					maxVal = eatCnt + 1;
				//이미 쿠폰을 쓴 경우
				}else { 
					maxVal = eatCnt;
				}
			}
			
			//시작인덱스 한칸 움직이기
			eating[sushiRail[i]]--;
			if(eating[sushiRail[i]] == 0) { //중복되지않으면
				eatCnt--; //하나 빼기
			}
			
			//endIdx = (i+k) % N -> 회전초밥이니까 한 사이클을 돌면 원래자리로 돌아옴.
			//int endIdx = (i+K)%N;
			if(eating[sushiRail[(i+K)%N]]==0) { //중복되지 않으면
				eatCnt++; //먹기
			}
			eating[sushiRail[(i+K)%N]]++; //먹은 번호 체크하기
		}
		
		System.out.println(maxVal);

	}
	
	static String instr = "8 30 4 30\r\n" + 
			"7\r\n" + 
			"9\r\n" + 
			"7\r\n" + 
			"30\r\n" + 
			"2\r\n" + 
			"7\r\n" + 
			"9\r\n" + 
			"25";

}
