import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N, map[][], cnt1, cnt2, cnt3;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		
		map = new int[N][N];
		
		for (int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
//		for(int row[]:map) {
//			System.err.println(Arrays.toString(row));
//		}
		
		cnt1=0; 
		cnt2=0; 
		cnt3=0;
		
		divide(0,0,N);
		
		//output.append(cnt1).append("\n");
		//output.append(cnt2).append("\n");
		//output.append(cnt3);
		//System.out.println(output);
		System.out.println(cnt1);
		System.out.println(cnt2);
		System.out.println(cnt3);

	}

	//종이 나누기
	private static void divide(int startR, int startC, int size) {
		
		int dividedMap[][] = new int[size][size];
		
		for(int r=0, rEnd = r+size; r<rEnd; r++) {
			for(int c=0, cEnd=c+size; c<cEnd; c++) {
				dividedMap[r][c] = map[r+startR][r+startC];
			}
		}
		
		
		if(check(startR, startC, size)) {
			//System.out.println(check(dividedMap));
			if(dividedMap[0][0]==-1) {
				cnt1++;
			}else if(dividedMap[0][0]==0) {
				cnt2++;
			}else if(dividedMap[0][0]==1) {
				cnt3++;
			}
		}else {
			int newsize = size/3 ;
			divide(startR, startC, newsize);
			divide(startR, startC+newsize, newsize);
			divide(startR, startC+newsize+newsize, newsize);
			divide(startR+newsize, startC, newsize);
			divide(startR+newsize, startC+newsize, newsize);
			divide(startR+newsize, startC+newsize+newsize, newsize);
			divide(startR+newsize+newsize, startC, newsize);
			divide(startR+newsize+newsize, startC+newsize, newsize);
			divide(startR+newsize+newsize, startC+newsize+newsize, newsize);
			
		}
		
		
		
	}
	
	private static Boolean check(int sr, int sc, int s) {
		int start = map[sr][sc];
		
		for (int r = sr; r < sr+s; r++) {
			for (int c = sc; c < sc+s; c++) {
				if(start!=map[r][c]) {
					return false;
				}
			}
		}
		
		return true;
	}

}