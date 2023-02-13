
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 * link : https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AYWWyGKq3-ADFAVt&contestProbId=AV19AcoKI9sCFAZN&probBoxId=AYWWyGKq3-EDFAVt+&type=PROBLEM&problemBoxTitle=0206%EC%A3%BC&problemBoxCnt=++1+
 * perf(성능) : 18,556 kb / 107 ms
 * category : 구현, 재귀, chaAt으로 비트 비교
 * note : 비트를 스위치할 때 전체를 고려할 필요가 없다. on/off로 생각하자.
 * @author SSAFY
 *
 */
public class Solution {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int T;
	
	static int byCharRecur(String str, int i, int initial) {
		int cnt=0;
		
		if(i==str.length()) { //기저조건
			return cnt;
		}
		
		if(initial != str.charAt(i)) {
			cnt = 1;
			initial = str.charAt(i);
		}

		return cnt + byCharRecur(str, i+1, initial); //재귀반복
	}

	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		tokens = new StringTokenizer(input.readLine());
		T = Integer.parseInt(tokens.nextToken());
		
		for(int t=1; t<=T; t++) {
			tokens = new StringTokenizer(input.readLine());
			String str = tokens.nextToken();
			int slen = str.length(); //메모리 길이
			//System.out.println(slen);
			
			//메모리를 0으로 셋팅하고 스위치 될때마다 변경한다. 
			char initial = '0';  
			int cnt = 0;
			
			/*
			 * 반복문 구현
			for(int i=0; i<slen; i++) {
				if(initial != str.charAt(i)) { //원래 메모리랑 현재랑 다르면 현재를 변경하고 카운팅한다.
					initial = str.charAt(i);
					cnt++;
				}
			}
			*/
			
			//재귀 사용
			cnt = byCharRecur(str, 0, initial);
			
			
			output.append("#").append(t).append(" ").append(cnt).append("\n");
			
		
		}//end 테케
		System.out.println(output);
		

	}
	
	static String instr = "10\r\n" + 
			"01010101010101010101010101010101010101010101010101\r\n" + 
			"01\r\n" + 
			"1000110010011111010110000100100000000001001\r\n" + 
			"10011010001110111010111010001100101101\r\n" + 
			"00110101100001010000110010111\r\n" + 
			"101111110101010100111100101111001\r\n" + 
			"01110011110001110\r\n" + 
			"1010101001010101010101010100111111\r\n" + 
			"01010100010100101100111010100010111111011001011000\r\n" + 
			"1111100101101110000";

}
