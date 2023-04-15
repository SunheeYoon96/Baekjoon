import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [키워드]
 * 
 * [풀이과정]
 * 
 * [입력]
 * [출력] 
 * 
 * @author 윤선희
 * @since 
 * @see
 * @performance
 * @category #
 */

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N, map[][], dir;
	static String cmd, kingLocation, stoneLocation;
	static int deltas[][] = {{0,1},{0,-1},{1,0},{-1,0},{-1,1},{-1,-1},{1,1},{1,-1}}; //R L B T RT LT RB LB
	

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		
		kingLocation = tokens.nextToken();
		stoneLocation = tokens.nextToken();
		N = Integer.parseInt(tokens.nextToken());
		
		map = new int[8][8];
		
		int kc = kingLocation.charAt(0)-'A';
		int kr = Math.abs(kingLocation.charAt(1)-'1'-7);
//		System.out.println(kr+":"+kc);
		
		int sc = stoneLocation.charAt(0)-'A';
		int sr = Math.abs(stoneLocation.charAt(1)-'1'-7);
		
		for (int i = 0; i < N; i++) {
			cmd = input.readLine();
			
			dir = changeDir(cmd);
			
			int nr = kr + deltas[dir][0];
			int nc = kc + deltas[dir][1];
			
			if(!isIn(nr, nc)) continue;
			
			//움직인 위치가 돌이 있는 자리라면 돌이 킹이 움직인 방향과 같은 방향으로 이동시킴
			if(nr==sr && nc==sc) {
				
				int newsr = sr + deltas[dir][0];
				int newsc = sc + deltas[dir][1];
				
				if(!isIn(newsr, newsc)) continue;
				sr = newsr;
				sc = newsc;
			}
			
			//킹 움직이기
			kr = nr;
			kc = nc;
			
		}
		
		//최종 킹의 위치 출력하기
		String finalKing = (char)(kc+'A') +  "" + (Math.abs(kr-7)+1) + "";
		String finalStone = (char)(sc+'A') + "" + (Math.abs(sr-7)+1) + "";
		
//		System.out.println(kr+":"+kc);
//		System.out.println((char)(kc+'A'));
//		System.out.println(finalKing);
		
		output.append(finalKing).append("\n").append(finalStone).append("\n");
		System.out.println(output);
		

	}
	
	private static int changeDir(String cmd) {
		int newDir = -1;
		
		switch (cmd) {
		case "R":
			newDir = 0;
			break;
		case "L":
			newDir = 1;			
			break;
		case "B":
			newDir = 2;
			break;
		case "T":
			newDir = 3;
			break;
		case "RT":
			newDir = 4;
			break;
		case "LT":
			newDir = 5;
			break;
		case "RB":
			newDir = 6;
			break;
		case "LB":
			newDir = 7;
			break;
		}
		
		return newDir;
	}
	
	private static boolean isIn(int nr, int nc) {
		if(nr>=0 && nr<8 && nc>=0 && nc<8) return true;
		return false;
	}

}