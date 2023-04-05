import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [키워드]
 * 부분집합
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

public class Solution {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int D, W, K, ans,T; //두께, 가로너비, 안전지수
	static int[][] origin, copy;
	static int[] select; //특정 idx 레이어에  -1: 안넣음 0: A넣음 1:B넣음
	
	static int[] layer0, layer1; //0:A약품채우기 1:B약품채우기
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		T = Integer.parseInt(input.readLine());
		
		for (int t = 1; t <=T; t++) {
			output.append("#").append(t).append(" ");
			
			tokens = new StringTokenizer(input.readLine());
			
			D = Integer.parseInt(tokens.nextToken());
			W = Integer.parseInt(tokens.nextToken());
			K = Integer.parseInt(tokens.nextToken());
			
			origin = new int[D][W];
			for (int r = 0; r < D; r++) {
				tokens = new StringTokenizer(input.readLine());
				for (int c = 0; c < W; c++) {
					origin[r][c] = Integer.parseInt(tokens.nextToken());
				}
				
			}
			select = new int[D];
			ans = D;
			
			layer0 = new int[W];
			layer1 = new int[W];
			Arrays.fill(layer0, 0);
			Arrays.fill(layer1, 1);
			
			subset(0,0);
			
			output.append(ans).append("\n");
		}
		
		System.out.println(output);
		
		
	}
	
	private static void subset(int idx, int cnt) {
		
		if(idx==D) {
			if(check(origin))
				ans = Math.min(ans, cnt);
			return;
		}
		
		subset(idx+1, cnt); // 현재 레이어에 약품투입 안하는 경우 idx 안건드리고 다음행으로.
		
		int[] tmp = origin[idx]; // 원본 보관
		
		origin[idx] = layer0; // 현재 idx 레이어에 약품 0 채운상태로 기다려보기
		subset(idx+1, cnt+1); // 현재 레이어에 약품 채웠으니 카운트 증가.
		
		origin[idx] = layer1; // 현재 idx 레이어에 약품 1 채운상태로 기다려보기
		subset(idx+1, cnt+1);
		
		origin[idx] = tmp;
		
	}
	

	private static boolean check(int[][] map) {
		for (int i = 0; i < W; i++) {
			int cnt=1;
			for (int j = 1; j < D; j++) {
				if(map[j-1][i]==map[j][i]) {
					cnt++;
				}else {
					cnt=1;
				}
				
				if(cnt==K) break;
			}
			if(cnt<K) return false;
		}
		return true;
	}

}