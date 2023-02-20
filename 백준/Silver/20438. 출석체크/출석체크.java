import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, K, Q, M;
	static int[] students; //총 학생의 정보
	static boolean[] sleep;  //조는 학생들
	static boolean[] attend; //출석코드를 받는 처음학생들
	static int start, end ; //확인하는 구간의 시작과 끝

	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken()); //총학생수
		K = Integer.parseInt(tokens.nextToken()); //조는 학생수
		Q = Integer.parseInt(tokens.nextToken()); //출석코드를 받는 학생 수
		M = Integer.parseInt(tokens.nextToken()); //출석을 확인하려는 구간의 갯수
		
		//출석번호를 인덱스로 사용함 
		students = new int[N+3]; //출석번호를 3번부터 부여받는다고 했음 (0,1,2 사용X)
		
		for(int i=3; i<N+3; i++) {
			students[i]=i;
		}
		
		//조는 학생
		tokens = new StringTokenizer(input.readLine());
		sleep = new boolean [N+3];
		for(int i=0; i<K; i++) {
			int x = Integer.parseInt(tokens.nextToken());
			sleep[x] = true;
		}
		
		//출석코드를 받은 학생
		tokens = new StringTokenizer(input.readLine());
		attend = new boolean [N+3];
		int plus;
		for(int i=0; i<Q; i++) {
			int x = Integer.parseInt(tokens.nextToken());
			if(sleep[x]) {
				continue; //조는 학생은 출석체크를 할 수 없다.
			}
			plus = x;
			
			while(x<N+3) {
				if(sleep[x]) {
					x += plus; //조는 학생 뒤에 있는 학생들은 출석학생의 배수면 출석코드를 받을 수 있음!!!!!!!!!!!!!!!!!
					continue;
				}
				attend[x] = true;
				x += plus;
			}
		}
		
		for(int i=3; i<N+3; i++) {
			int x;
			if(!attend[i]) {
				x =1;
			}else {
				x=0;
			}
			
			students[i] = students[i-1] + x;				
		}
		
		//구간정보
		for(int m=0; m<M; m++) {
			tokens = new StringTokenizer(input.readLine());
			start = Integer.parseInt(tokens.nextToken());
			end = Integer.parseInt(tokens.nextToken());
			//System.out.println(Arrays.toString(students));
			System.out.println(students[end]-students[start-1]);
		}
		
	

	}
	
	static String instr = "50 4 5 1\r\n" + 
			"24 15 27 43\r\n" + 
			"3 4 6 20 25\r\n" + 
			"3 52";

}
