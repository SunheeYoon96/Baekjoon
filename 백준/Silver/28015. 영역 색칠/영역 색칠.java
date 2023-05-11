import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author 윤선희
 * @since 2023. 2. 7.
 * @see 
 * @performance KB, ms
 * @category #
 * @note : 두가지 색상 1,2 를 칠한다. 덧칠 가능
 */

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, M, cnt, map[][],ans;
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		map = new int[N][M+1];
		cnt = 0;
		
		for (int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}//입력완
		
		boolean hasZero = false;
		int cnt1 =0;
		int cnt2 =0;
		
		for (int i = 0; i < N; i++) {
			hasZero = false;
			int before=0;
			
			for (int j = 0; j < M; j++) {
				if(map[i][j]==0) {
					hasZero = true;
				}
			}
			
			//1. 0으로 나뉘어지지 않는 줄이면
			if(!hasZero) {
				for (int j = 0; j < M; j++) {
					if(map[i][j]==1 && before!=map[i][j]) {
						cnt1 += 1;
						before = 1;
					}else if(map[i][j]==2 && before!=map[i][j]) {
						cnt2 += 1;
						before = 2;
					}
				}

				ans += Math.min(cnt1, cnt2) + 1;
			}
			//2. 0으로 나뉘어지는 줄이면
			else {
				cnt1=0; cnt2=0;
				for (int j = 0; j < M; j++) {
					if(map[i][j]!=0) {
						if(map[i][j]==1 && before!=map[i][j]) {
							cnt1 += 1;
							before = 1;
						}else if(map[i][j]==2 && before!=map[i][j]) {
							cnt2 += 1;
							before = 2;
						}
					}else if(map[i][j]==0) {
						if(cnt1!=0 ||cnt2!=0) {
							ans += Math.min(cnt1, cnt2) + 1;
							cnt1=0; cnt2=0;
							before=0;							
						}
					}
				}
				if(cnt1!=0 ||cnt2!=0) {
					ans += Math.min(cnt1, cnt2) + 1;
										
				}
			}//
			
		}
		
		
		
		System.out.println(ans);
		
		
		
		
	}

	
	
	

}