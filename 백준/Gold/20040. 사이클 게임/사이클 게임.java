import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 * [키워드]
 * 입력값이 커서 인접행렬로 풀 수 없다.
 * 사이클이 있는지 없는지 만 확인하면 된다.
 * 카운팅을 하다가 사이클이 만들어지면 바로 종료하자.
 * 
 * [풀이과정]
 * 
 * [입력]
 * [출력] 
 */

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, M, repres[], cnt;

	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		//초기화 -> 대표자를 자기자신으로 초기화
		makeset();
		
		for (int m = 1; m <= M; m++) {
			tokens = new StringTokenizer(input.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			
			if(union(a, b)) {
				cnt = m; //m번째에서 사이클 형성
				break;
			}
			
		}
		
		System.out.println(cnt);
		

	}
	
	//대표자 초기화
	private static void makeset() {
		repres = new int[N];
		for (int i = 0; i < repres.length; i++) {
			repres[i] = i;
		}
	}
	
	private static boolean union(int a, int b) {
		a = findSet(a); //a의 대표자 찾기
		b = findSet(b); //b의 대표자 찾기
		
		//사이클이 형성됨
		if(a == b) return true;
		else repres[b] = a; //b에 a를 연결한다고 하자.
		
		return false;
	}

	private static int findSet(int a) {
		if(repres[a]==a) {
			return a;
		}
		
		return repres[a] = findSet(repres[a]);
	}

	private static String instr = "6 5\r\n" + 
			"0 1\r\n" + 
			"1 2\r\n" + 
			"2 3\r\n" + 
			"5 4\r\n" + 
			"0 4";

}