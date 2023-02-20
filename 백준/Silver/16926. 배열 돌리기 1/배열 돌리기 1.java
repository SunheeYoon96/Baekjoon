import java.awt.print.Printable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M, rotateCnt;
	static int[][] map;
	//반시계방향으로 회전하는 배열이니까 데이터 전달은 시계방향으로 가야함
	static int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}}; //우하좌상
	 

	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		rotateCnt = Integer.parseInt(tokens.nextToken());
		
		//원본배열 받기
		map = new int[N][M];
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		int block = Math.min(N,M)/2;
		
		for(int i=0; i<rotateCnt; i++) {
			rotate(block);
		}
		
		print(map);
	}
	
	public static void rotate(int block) {
		int[][] copymap = clone(map);
		
		for(int b=0; b<block; b++) {
			int r = b;
			int c = b;
			
			int keep = copymap[r][c];
			
			int idx=0;
			while(idx<4) {
				int nr = r + deltas[idx][0];
    			int nc = c + deltas[idx][1];
    			
    			// 범위 안이라면
    			if(nr < N-b && nc < M-b && nr >= b && nc >= b) {
    				copymap[r][c] = copymap[nr][nc];
    				r = nr;
    				c = nc;
    			} 
    			// 범위를 벗어났다면 다음 방향으로 어감
    			else {
    				idx++;
    			}
    			
    		}
    		
			copymap[b+1][b] = keep; // 빼 놓은 값 넣어 줌		
				
			}
		
		map = copymap;
		
	}
	
	public static int[][] clone(int[][] map) {
		int [][] copied = new int[N][M];
		
		for (int r = 0; r < N; r++) {
            // copied[r] = map[r]; // 얕은 복사 - 단순 레퍼런스 전달 , 주소값이 안에 들어가는 것 
            // copied[r] = map[r].clone(); // 깊은 복사 - 전혀 새로운 배열 객체 할당
            for (int c = 0; c < M; c++) {
                copied[r][c] = map[r][c];
            }
        }
        return copied;
	}
	
	public static void print(int[][] map) {
		for(int i=0; i<N; i++) {
    		for(int j=0; j<M; j++) {
    			//System.out.print(map[i][j] + " ");
    			output.append(map[i][j]).append(" ");
    		}
    		output.append("\n");
    	}
		System.out.println(output);
	}

}
