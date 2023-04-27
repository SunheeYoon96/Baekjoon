import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * [키워드]
 *  1. 이진수 로 변환해서 규칙 찾기
 *  2. XO, XXO, XXXO, ... 등으로 규칙 찾기 + 이진수 계산 DP (안하면 시간초과남)
 */

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	
	static String str;
	static char[] oxs;
	static long answer, multi;
	static final long mod = 1000000007L;
	
	public static void main(String[] args) throws IOException {
		str = input.readLine();
		oxs = str.toCharArray();
		
		multi = 1L; 
		answer = 0L;
		
		
		for (int i = 0; i < oxs.length; i++) {
			if(oxs[i]=='O') {
				answer = answer%mod + multi;
			}
			
			answer %=mod;
			multi = multi%mod*2;
		}
		
		System.out.println(answer);
		
		
		
	}


}