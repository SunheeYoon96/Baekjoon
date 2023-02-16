import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	//static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N; //N행
	static int M; //M열
	static int K; //연산횟수
	static int[][] map; //배열
	static int[][] rotateInfo; //회전연산 배열 0:r, 1:c, 2:s
	static boolean[] visited; //방문확인
	static int[] choosed; //순열담기
	static int minVal; //최소값 

	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		
		//배열정보
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		//배열 입력받기
		map = new int[N][M];
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		//회전정보 입력받기
		rotateInfo = new int[K][3];
		for(int i=0; i<K; i++) {
			tokens = new StringTokenizer(input.readLine());
			for(int j=0; j<3; j++) {
				rotateInfo[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}		
		
		//연산한 순서에 따라 결과값이 다르다 -> 순서의미O -> 연산정보를 순열로 만들자. 
		visited = new boolean[K];
		choosed = new int[K];
		minVal = Integer.MAX_VALUE;
		makePermutation(0, K);
		System.out.println(minVal);

	}
	
	// makePermutation : 순열
	//ex) abc 정보일 경우, acb, bac, bca, abc 순으로 볼 수 있도록 인덱스만 챙겨놓기  
	public static void makePermutation(int nthpick, int rotateCnt) {
		
		if(nthpick == rotateCnt) { //연산횟수만큼 뽑았으면 재귀탈출
			int[][] rotateArr = copyArray();
			calcMin(rotateArr);	
			return;
		}
		
		for(int i=0; i<rotateCnt; i++) {
			if(!visited[i]) {
				visited[i] = true;
				choosed[nthpick] = i;
				makePermutation(nthpick+1, rotateCnt);
				visited[i] = false;
			}	
		}//end 
	}
	
    //배열복사하기
	public static int[][] copyArray() {
		int[][] copyArr = new int[N][M];
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				copyArr[r][c] = map[r][c];
			}
		}
		return copyArr;
	}
	
    //각 행의 최솟값 계산하기
	public static void calcMin(int[][] copy) {
		for(int i=0; i<choosed.length; i++) {
			//가장 왼쪽위칸 좌표
			int leftx = rotateInfo[choosed[i]][0] - rotateInfo[choosed[i]][2] -1;
			int lefty = rotateInfo[choosed[i]][1] - rotateInfo[choosed[i]][2] -1;
			//가장 오른쪽아래칸 좌표
			int rightx = rotateInfo[choosed[i]][0] + rotateInfo[choosed[i]][2] -1;
			int righty = rotateInfo[choosed[i]][1] + rotateInfo[choosed[i]][2] -1;
			
			//위 좌표로 만들어진 배열에서 회전하기 
			rotate(leftx, lefty, rightx, righty, copy);
		}
		//각 행의 합들 중 최소값
		for(int r=0; r<copy.length; r++) {
			int rowSum=0;
			for(int c=0; c<copy[r].length; c++) {
				rowSum += copy[r][c];
			}
			minVal = Math.min(minVal, rowSum);
		}
	}
	
    //배열 회전
	public static void rotate(int leftx, int lefty, int rightx, int righty, int[][] copy ) {
		if(leftx == rightx && lefty == righty) {//배열이 생성되지 않는 경우는 회전하지 않고 리턴
			return;
		}
		
        int temp1 = copy[leftx][righty];
        int temp2 = copy[rightx][righty];
        int temp3 = copy[rightx][lefty];
        
        //오른쪽
        for(int i = righty; i > lefty; i--) {
            copy[leftx][i] = copy[leftx][i - 1];
        }
        //아래
        for(int i = rightx; i > leftx; i--) {
            if(i == leftx + 1){
                copy[i][righty] = temp1;
            }
            else copy[i][righty] = copy[i - 1][righty];
        }
        //왼쪽
        for(int i = lefty; i < righty; i++) {
            if(i == righty - 1){
              copy[rightx][i] = temp2;  
            } 
            else copy[rightx][i] = copy[rightx][i + 1];
        }
        //위
        for(int i = leftx; i < rightx; i++) {
            if(i == rightx - 1){
                copy[i][lefty] = temp3;
            } 
            else copy[i][lefty] = copy[i + 1][lefty];
        }    
		
		rotate(leftx+1, lefty+1, rightx-1, righty-1, copy );
		
	}
	
	static String instr = "5 6 2\r\n" + 
			"1 2 3 2 5 6\r\n" + 
			"3 8 7 2 1 3\r\n" + 
			"8 2 3 1 4 5\r\n" + 
			"3 4 5 1 1 1\r\n" + 
			"9 3 2 1 4 3\r\n" + 
			"3 4 2\r\n" + 
			"4 2 1";

}
