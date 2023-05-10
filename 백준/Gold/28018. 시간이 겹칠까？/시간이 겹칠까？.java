import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//Arrays.fill은 안되넴..
//누적합 -> 시간 범위시작 +1 끝에-1 체크해 놓고 누적합구하기 

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N, timeTable[], startTime, endTime, Q, checkTime;
	static final int MAXVAL = 1000000;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		
		timeTable = new int[MAXVAL+2];
		
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(input.readLine());
			startTime = Integer.parseInt(tokens.nextToken());
			endTime = Integer.parseInt(tokens.nextToken());
			
			timeTable[startTime] += 1; //시작점
			timeTable[endTime+1] -= 1; //끝점
		}
		
		for (int i = 1; i < MAXVAL+1; i++) {
			timeTable[i] += timeTable[i-1];
		}
		
		Q = Integer.parseInt(input.readLine());
		checkTime =0;
		
		tokens = new StringTokenizer(input.readLine());
		
		for (int i = 0; i < Q; i++) {
			//확인하려는 특정시간들
			checkTime = Integer.parseInt(tokens.nextToken());
			//누적합의 특정시간을 인덱스로 하는 value = 특정시간이 겹치는 범위의 갯수 = 특정한 시각에 선택할 수 없는 좌석수 
			output.append(timeTable[checkTime]).append("\n");
		}
		
		System.out.println(output);
		
	}

}