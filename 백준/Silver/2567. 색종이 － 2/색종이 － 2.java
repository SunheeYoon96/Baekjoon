import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//스카프 (서울_9반_윤선희)

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, blacks[][], whiteMap[][], roundDist;
	static final int blen=10; //검정색 색종이의 한변의 길이
	static int deltas[][] = {{1,0},{-1,0},{0,1},{0,-1}};

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		
		whiteMap = new int[100][100]; //흰색천은 0으로 초기화
		blacks = new int[N][2]; //검은색 천 정보
		
		//검은천의 정보 입력받기
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine());
			for(int j=0; j<2; j++) {
				blacks[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		//입력완료
		
		// 1. 검은 천의 위치를 1로 표시하기
		for(int i=0; i<blacks.length; i++) {
			int bsr = blacks[i][0]; //검은천의 왼쪽 하단 x좌표
			int bsc = blacks[i][1]; //검은천의 왼쪽 하단 y좌표
			
			//검은천의 시작+10 크기의 사각형을 1로 채우기
			for(int r=bsr; r<bsr+blen; r++) {
				for(int c=bsc; c<bsc+blen; c++) {
					if(whiteMap[r][c]==0) {
						
						whiteMap[r][c]=1;
					}
				}
			}
		}
		
		roundDist = 0; //둘레 초기화

		// 2. 상하좌우 중 한곳이상에 0이 위치한 1을 찾자 = 둘레
		for(int r=0; r<whiteMap.length; r++) {
			for(int c=0; c<whiteMap[r].length; c++) {
				//상하좌우 탐색 
				for(int d=0; d<deltas.length; d++) {
					int nr = r+ deltas[d][0]; 
					int nc = c+ deltas[d][1];
					
					//범위내에 존재하면서 자신은 1이면서 주변이 0인 1의 갯수를 찾자.
					if(isIn(nr, nc) && whiteMap[nr][nc]==0 && whiteMap[r][c]==1) {
						roundDist++;
					}
					
					//검은색천테두리가 범위 극단에 있을때는 예외대상이므로 추가적으로 계산해줌.
					if(!isIn(nr, nc) && whiteMap[r][c]==1) {
						roundDist++;
					}
					
				}//4방향 탐색종료
			}
		}
		
		//검은색 천의 둘레 출력
		System.out.println(roundDist);
	}
	
	
	//범위체크
	public static boolean isIn(int r, int c) {
		if(r>=0 && r<100 && c>=0 && c<100) return true;
		return false;
	}

}