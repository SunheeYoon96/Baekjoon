import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N,R,C;
	static int space[][];
	static int cnt;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		
		cnt=0;
		int size = exp2(N);
		
		findZ(size, R, C);
		System.out.println(cnt);

	}
	
	private static int exp2(int n) { //사이즈를 2^^N으로 만듬
		
		if(n==1) return 2;
		
		int y = exp2(n/2);
		
		return n%2==0? y*y : y*y*2;
		
	}
	
	public static void findZ(int size, int r, int c) {
		//크기가 1이 되면 단위크기이므로 종료
		if(size==1) return;
		
		// 1 | 2
		//--------
		// 3 | 4
		//4개의 구역으로 나눈다.
		
		if(r<size/2 && c<size/2) {  //1
			findZ(size/2,r,c);
		}else if(r<size/2 && c>=size/2) { //2
			cnt += size*size/4;
			findZ(size/2, r, c-size/2);
			
		}else if(r>=size/2 && c<size/2) { //3
			cnt += size*size/4*2; //앞에 2개가 있음
			findZ(size/2, r-size/2, c);
			
		}else if(r>=size/2 && c>=size/2) { //4
			cnt += size*size/4*3; //앞에 3개가 있음
			findZ(size/2, r-size/2, c-size/2);
		}
		
		
	}

}
