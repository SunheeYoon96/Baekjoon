import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * link : https://www.acmicpc.net/problem/2178
 * perf(성능) :  kb /  ms
 * category : 부분집합
 * note :  
 * @author SSAFY
 *
 */

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static boolean[] isSelected;
	static Ingredient[] cart;
	static int[] make;
	static int minVal;
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		
		cart = new Ingredient[N] ;
		isSelected = new boolean[N];
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine());
			int s = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			Ingredient tmp = new Ingredient(s, b);
			//재료보관함에 담아두기
			cart[i] = tmp;
		}
		
//		for(int i=0; i<N; i++) {
//			System.out.println(cart[i].sour +" : "+ cart[i].bitter);
//		}
		
		minVal = Integer.MAX_VALUE;
		subSet(0);
		System.out.println(minVal);

	}
	
	public static void subSet(int nthPick) {
		if(nthPick==N) {
			int sour = 1;
			int bitter = 0;
			int cntI=0;
			for(int i=0; i<N; i++) {
				if(isSelected[i]) {
					cntI++;
					sour *= cart[i].sour;
					bitter += cart[i].bitter;
				}
			}
			
			if(cntI == 0) return; //공집합일 때
			
			if(minVal > Math.abs(sour - bitter)) {
				minVal = Math.abs(sour - bitter);
			}
			return;
			
		}
		isSelected[nthPick] = true;
		subSet(nthPick+1);
		isSelected[nthPick] = false;
		subSet(nthPick+1);
	}
	
	//재료를 클래스를 묶음
	public static class Ingredient {
		int sour;
		int bitter;
		
		public Ingredient() {
			
		}
		
		public Ingredient(int sour, int bitter) {
			this.sour = sour;
			this.bitter = bitter;
		}
	}

}
