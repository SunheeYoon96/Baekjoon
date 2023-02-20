import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int weight; //최대무게
	static int bagCnt; //봉지갯수
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		weight = Integer.parseInt(input.readLine());
		bagCnt = 0;
		
		//가장 무거운 5키로 봉지로 많이 채울수록 봉지가 작아질 것
		while(true) {
			//1. 우선 5키로 봉지로 나눠지면 나눠서 처리함
			if(weight%5==0) {
				bagCnt += weight/5;
				break;
			//3. 예외))) 4와7은 절대 3과5의 조합으로 만들수가 없어서 빼줌
			}else if(weight==4 || weight==7) {
				bagCnt =-1;
				break;
			}
			
			//2. 5로 나누어 떨어지지 않으면 3키로 봉지를 하나씩 사용하면서 무게를 줄여감.
			weight -=3;
			bagCnt++;
		}
		
		
		System.out.println(bagCnt);

	}

}
