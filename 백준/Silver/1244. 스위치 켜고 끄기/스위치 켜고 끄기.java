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
	static int N;
	static int[] switches;
	static int peopleCnt;
	static int[][] peoples;
	
	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		
		switches = new int[N+1];
		tokens = new StringTokenizer(input.readLine());
		for(int i=1; i<=N; i++) {
			switches[i] = Integer.parseInt(tokens.nextToken());
		}
		
		tokens = new StringTokenizer(input.readLine());
		peopleCnt = Integer.parseInt(tokens.nextToken());
		peoples = new int[peopleCnt][2];
		for(int i=0; i<peopleCnt; i++) {
			tokens = new StringTokenizer(input.readLine());
			peoples[i][0] = Integer.parseInt(tokens.nextToken());
			peoples[i][1] = Integer.parseInt(tokens.nextToken());
		}
		//입력완
		
		//<실행문>
		for(int p=0; p<peopleCnt; p++) {
			int tmp = 0;
			int pnum=0;

			//남자일 경우
			if(peoples[p][0]==1) {
				pnum = peoples[p][1]; //남자가 부여받은 번호
				tmp = (int) N/peoples[p][1]; //배수 계산을 하기 위해
				for(int t=1; t<=tmp; t++) {
					//받은 수의 배수들은 상태를 변화시킴
					switches[pnum*t] = changeSwitch(pnum*t); 
				}
			//여자일 경우
			}else if(peoples[p][0]==2) {
				pnum = peoples[p][1]; //여자가 부여받은 번호
				int cnt = 1; //인덱스 대칭구조 만들기 위해
				switches[pnum] = changeSwitch(pnum);
				
				while(pnum-cnt > 0 && pnum+cnt <=N) { //범위내에 있으면 반복
					if(switches[pnum-cnt] == switches[pnum+cnt]) {
						switches[pnum-cnt] = changeSwitch(pnum-cnt);
						switches[pnum+cnt] = changeSwitch(pnum+cnt);
						cnt++;
					}else {
						break;
					}
				}
				
			}
		}
		
		//<출력>
		for(int i = 1; i < switches.length; i++) {
        	System.out.print(switches[i] + " ");
        	if(i % 20 == 0) {
        		System.out.println();
        	}
        }
		//<출력>

	}
	
	public static int changeSwitch(int s) {
		if(switches[s]==1) {
			return 0;
		}
		return 1;
	}
	
	static String instr = "8\r\n" + 
			"0 0 0 0 0 0 0 0\r\n" + 
			"8\r\n" + 
			"1 2\r\n" + 
			"1 3\r\n" + 
			"1 4\r\n" + 
			"1 5\r\n" + 
			"2 2\r\n" + 
			"2 3\r\n" + 
			"2 4\r\n" + 
			"2 5";
	

}
