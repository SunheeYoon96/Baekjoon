import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, M, map[][], maxVal;
	
	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		map = new int[N][M];
		for (int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		maxVal = -1;
		int tmp[] = new int[N*M];
		int idx=0;
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				
				tmp[idx] = ㅡ(r,c);
				maxVal = Math.max(maxVal, tmp[idx++]);
				idx=0;
				tmp[idx] = ㅣ(r,c);
				maxVal = Math.max(maxVal, tmp[idx++]);
				idx=0;
				tmp[idx] = ㅁ(r,c);
				maxVal = Math.max(maxVal, tmp[idx++]);
				idx=0;
				tmp[idx] = ㄴ1(r,c);
				maxVal = Math.max(maxVal, tmp[idx++]);
				idx=0;
				tmp[idx] = ㄴ2(r,c);
				maxVal = Math.max(maxVal, tmp[idx++]);
				idx=0;
				tmp[idx] = ㄴ3(r,c);
				maxVal = Math.max(maxVal, tmp[idx++]);
				idx=0;
				tmp[idx] = ㄴ4(r,c);
				maxVal = Math.max(maxVal, tmp[idx++]);
				idx=0;
				tmp[idx] = ㄴ5(r,c);
				maxVal = Math.max(maxVal, tmp[idx++]);
				idx=0;
				tmp[idx] = ㄴ6(r,c);
				maxVal = Math.max(maxVal, tmp[idx++]);
				idx=0;
				tmp[idx] = ㄴ7(r,c);
				maxVal = Math.max(maxVal, tmp[idx++]);
				idx=0;
				tmp[idx] = ㄴ8(r,c);
				maxVal = Math.max(maxVal, tmp[idx++]);
				idx=0;
				tmp[idx] = ㄹ1(r,c);
				maxVal = Math.max(maxVal, tmp[idx++]);
				idx=0;
				tmp[idx] = ㄹ2(r,c);
				maxVal = Math.max(maxVal, tmp[idx++]);
				idx=0;
				tmp[idx] = ㄹ3(r,c);
				maxVal = Math.max(maxVal, tmp[idx++]);
				idx=0;
				tmp[idx] = ㄹ4(r,c);
				maxVal = Math.max(maxVal, tmp[idx++]);
				idx=0;
				tmp[idx] = ㅜ(r,c);
				maxVal = Math.max(maxVal, tmp[idx++]);
				idx=0;
				tmp[idx] = ㅏ(r,c);
				maxVal = Math.max(maxVal, tmp[idx++]);
				idx=0;
				tmp[idx] = ㅓ(r,c);
				maxVal = Math.max(maxVal, tmp[idx++]);
				idx=0;
				tmp[idx] = ㅗ(r,c);
				maxVal = Math.max(maxVal, tmp[idx++]);
				idx=0;
			}
		}
		
		System.out.println(maxVal);
		
		

	}
	
	private static int ㅡ(int r, int c) {
		int ec = c+3;
		int sum = 0;
		
		if(isIn(r, ec)) {
			sum += (map[r][c]+map[r][c+1]+map[r][c+2]+map[r][c+3]);
		}
		return sum;
	}
	
	private static int ㅣ(int r, int c) {
		int er = r+3;
		int sum = 0;
		
		if(isIn(er, c)) {
			sum += (map[r][c]+map[r+1][c]+map[r+2][c]+map[r+3][c]);
		}
		return sum;
	}
	
	private static int ㅁ(int r, int c) {
		int er = r+1;
		int ec = c+1;
		int sum = 0;
		
		if(isIn(er, ec)) {
			sum += (map[r][c]+map[r][c+1]+map[r+1][c]+map[r+1][c+1]);
		}
		return sum;
	}
	
	private static int ㄴ1(int r, int c) {
		int er = r+2;
		int ec = c+1;
		int sum = 0;
		
		if(isIn(er, ec)) {
			sum += (map[r][c]+map[r+1][c]+map[r+2][c]+map[r+2][c+1]);
		}
		return sum;
	}
	
	private static int ㄴ2(int r, int c) {
		int er = r+2;
		int ec = c+1;
		int sum = 0;
		
		if(isIn(er, ec)) {
			sum += (map[r][c]+map[r+1][c]+map[r+2][c]+map[r][c+1]);
		}
		return sum;
	}
	
	private static int ㄴ3(int r, int c) {
		int er = r-2;
		int ec = c+1;
		int sum = 0;
		
		if(isIn(er, ec)) {
			sum += (map[r][c]+map[r][c+1]+map[r-1][c+1]+map[r-2][c+1]);
		}
		return sum;
	}
	
	private static int ㄴ4(int r, int c) {
		int er = r+2;
		int ec = c+1;
		int sum = 0;
		
		if(isIn(er, ec)) {
			sum += (map[r][c]+map[r][c+1]+map[r+1][c+1]+map[r+2][c+1]);
		}
		return sum;
	}
	
	private static int ㄴ5(int r, int c) {
		int er = r+1;
		int ec = c+2;
		int sum = 0;
		
		if(isIn(er, ec)) {
			sum += (map[r][c]+map[r+1][c]+map[r+1][c+1]+map[r+1][c+2]);
		}
		return sum;
	}
	
	private static int ㄴ6(int r, int c) {
		int er = r+1;
		int ec = c+2;
		int sum = 0;
		
		if(isIn(er, ec)) {
			sum += (map[r][c]+map[r+1][c]+map[r][c+1]+map[r][c+2]);
		}
		return sum;
	}
	
	private static int ㄴ7(int r, int c) {
		int er = r+1;
		int ec = c+2;
		int sum = 0;
		
		if(isIn(er, ec)) {
			sum += (map[r][c]+map[r][c+1]+map[r][c+2]+map[r+1][c+2]);
		}
		return sum;
	}
	
	private static int ㄴ8(int r, int c) {
		int er = r-1;
		int ec = c+2;
		int sum = 0;
		
		if(isIn(er, ec)) {
			sum += (map[r][c]+map[r][c+1]+map[r][c+2]+map[r-1][c+2]);
		}
		return sum;
	}
	
	private static int ㄹ1(int r, int c) {
		int er = r-2;
		int ec = c+1;
		int sum = 0;
		
		if(isIn(er, ec)) {
			sum += (map[r][c]+map[r-1][c]+map[r-1][c+1]+map[r-2][c+1]);
		}
		return sum;
	}
	
	private static int ㄹ2(int r, int c) {
		int er = r+1;
		int ec = c+2;
		int sum = 0;
		
		if(isIn(er, ec)) {
			sum += (map[r][c]+map[r][c+1]+map[r+1][c+1]+map[r+1][c+2]);
		}
		return sum;
	}
	
	private static int ㄹ3(int r, int c) {
		int er = r+2;
		int ec = c+1;
		int sum = 0;
		
		if(isIn(er, ec)) {
			sum += (map[r][c]+map[r+1][c]+map[r+1][c+1]+map[r+2][c+1]);
		}
		return sum;
	}
	
	private static int ㄹ4(int r, int c) {
		int er = r-1;
		int ec = c+2;
		int sum = 0;
		
		if(isIn(er, ec)) {
			sum += (map[r][c]+map[r][c+1]+map[r-1][c+1]+map[r-1][c+2]);
		}
		return sum;
	}
	
	private static int ㅜ(int r, int c) {
		int er = r+1;
		int ec = c+2;
		int sum = 0;
		
		if(isIn(er, ec)) {
			sum += (map[r][c]+map[r][c+1]+map[r][c+2]+map[r+1][c+1]);
		}
		return sum;
	}
	
	private static int ㅓ(int r, int c) {
		int er = r+2;
		int ec = c-1;
		int sum = 0;
		
		if(isIn(er, ec)) {
			sum += (map[r][c]+map[r+1][c]+map[r+2][c]+map[r+1][c-1]);
		}
		return sum;
	}
	
	private static int ㅗ(int r, int c) {
		int er = r-1;
		int ec = c+2;
		int sum = 0;
		
		if(isIn(er, ec)) {
			sum += (map[r][c]+map[r][c+1]+map[r][c+2]+map[r-1][c+1]);
		}
		return sum;
	}
	
	private static int ㅏ(int r, int c) {
		int er = r+2;
		int ec = c+1;
		int sum = 0;
		
		if(isIn(er, ec)) {
			sum += (map[r][c]+map[r+1][c]+map[r+1][c+1]+map[r+2][c]);
		}
		return sum;
	}

	
	
	private static boolean isIn(int nr, int nc) {
		if(nr>=0 && nr<N && nc>=0 && nc<M) return true;
		return false;
	}
	
	
	private static String instr = "5 5\r\n" + 
			"1 2 3 4 5\r\n" + 
			"5 4 3 2 1\r\n" + 
			"2 3 4 5 6\r\n" + 
			"6 5 4 3 2\r\n" + 
			"1 2 1 2 1";

}