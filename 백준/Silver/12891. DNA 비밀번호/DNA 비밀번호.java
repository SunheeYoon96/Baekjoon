import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int S, P, Acnt, Ccnt, Gcnt, Tcnt, answer;
	static String DNAs;
	static char[] dnaArr;
	static int[] checkArr, fixed;
	static final int A=0, C=1, G=2, T=3;

	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		tokens = new StringTokenizer(input.readLine());
		S = Integer.parseInt(tokens.nextToken());
		P = Integer.parseInt(tokens.nextToken());
		
		DNAs = input.readLine();
		dnaArr = DNAs.toCharArray(); //원본 DNA문자열을 배열로 받아오기
		fixed = new int[4];
		
		tokens = new StringTokenizer(input.readLine());
		for (int i = 0; i < 4; i++) {
			fixed[i] = Integer.parseInt(tokens.nextToken());
		}
		
		answer=0;
		checkArr = new int[4];
		
		//초기배열 셋틴
		for (int i = 0; i < P; i++) {
			if(dnaArr[i]=='A') checkArr[A]++;
			else if(dnaArr[i]=='C') checkArr[C]++;
			else if(dnaArr[i]=='G') checkArr[G]++;
			else if(dnaArr[i]=='T') checkArr[T]++;
		}
		
		
		if(checkCnt()) answer+=1;
		
		int eidx=0;
		
		for (int i = 1; i < S-P+1; i++) {
			eidx = i+P-1;
			
			//이전문자열은 삭제
			if(dnaArr[i-1]=='A') checkArr[A]--;
			else if(dnaArr[i-1]=='C') checkArr[C]--;
			else if(dnaArr[i-1]=='G') checkArr[G]--;
			else if(dnaArr[i-1]=='T') checkArr[T]--;
			
			//추가되는 마지막 문자열은 추가
			if(dnaArr[eidx]=='A') checkArr[A]++;
			else if(dnaArr[eidx]=='C') checkArr[C]++;
			else if(dnaArr[eidx]=='G') checkArr[G]++;
			else if(dnaArr[eidx]=='T') checkArr[T]++;
			
			if(checkCnt()) answer +=1;
		}
		
		System.out.println(answer);

	}
	
	private static boolean checkCnt() {
		
		for (int i = 0; i < checkArr.length; i++) {
			if(checkArr[i] < fixed[i]) return false;
		}
		
		return true;
	}
	
	static String instr = "4 2\r\n" + 
			"GATA\r\n" + 
			"1 0 0 1";

}