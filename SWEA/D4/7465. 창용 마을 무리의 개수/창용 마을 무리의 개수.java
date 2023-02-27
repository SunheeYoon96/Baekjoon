import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 * [키워드]
 * 
 * [풀이과정]
 * 
 * [입력]
 * [출력] 
 * 
 * @author SSAFY
 * @see
 * @performance
 * @category 
 */

public class Solution {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T;
	static int N, M, represent[], cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		//input = new BufferedReader(new StringReader(instr));
		T = Integer.parseInt(input.readLine());
		
		for(int t=1; t<=T; t++) {
			output.append("#").append(t).append(" ");
			cnt=0;
			
			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			M = Integer.parseInt(tokens.nextToken());
			
			//1. 자기자신을 마을 대표로 하는 초기화
			makeSet();
			
			for(int m=0; m<M; m++) {
				tokens = new StringTokenizer(input.readLine());
				int a = Integer.parseInt(tokens.nextToken())-1;
				int b = Integer.parseInt(tokens.nextToken())-1;
				union(a, b);
			}
			
			for(int i=0; i<N; i++) {
				//대표자가 나랑 같아 -> 같은 친구야 -> 같은 마을이야 
				if(represent[i]==i) {
					findSet(i);
					cnt++;
				}
			}
			
			output.append(cnt).append("\n");
		}
		System.out.println(output);
		

	}
	
	public static void makeSet() {
		represent = new int[N];
		
		for(int i=0; i<N; i++) {
			represent[i] = i;
		}
	}
	
	
	private static int findSet(int a) {
		if(represent[a]==a) {
			//cnt++;
			return a;
		}else {
			//path compression :a의 대표자를 a가 속한 그룹의 대표자로 변경해버리기
			//이게 없으면 findset도 시간초과가 남
			return represent[a] = findSet(represent[a]);
		}
	}
	
	public static boolean union(int a, int b) {
		a = findSet(a);
		b = findSet(b);
		
		if(a==b) {
			return false;
		}else {
			represent[a] = b;
			return true;
		}
	}
	

	public static String instr = "2\r\n" + 
			"6 5\r\n" + 
			"1 2\r\n" + 
			"2 5\r\n" + 
			"5 1\r\n" + 
			"3 4\r\n" + 
			"4 6\r\n" + 
			"6 8\r\n" + 
			"1 2\r\n" + 
			"2 5\r\n" + 
			"5 1\r\n" + 
			"3 4\r\n" + 
			"4 6\r\n" + 
			"5 4\r\n" + 
			"2 4\r\n" + 
			"2 3";

}