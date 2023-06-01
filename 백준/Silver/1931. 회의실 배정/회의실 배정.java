import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [키워드]
 * 시간이 2^32 -1 범위이므로 카운팅 정렬 불가
 */

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, timeTable[][], sorted[][], cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		
		timeTable = new int[N][2];
		sorted = new int[N][2];
		cnt = 0;
		
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(input.readLine());
			int start = Integer.parseInt(tokens.nextToken());
			int end = Integer.parseInt(tokens.nextToken());
			timeTable[i][0] = start;
			timeTable[i][1] = end;
		}
		
		Arrays.sort(timeTable, (o1, o2)-> {
			
			if(o1[1]==o2[1]) {
				return o1[0]-o2[0];
			}
			return o1[1]-o2[1]; //두번째 숫자 기준 오름차순
		});
		
		int compareTime =0;
		
		for (int i = 0; i < N; i++) {
			if(compareTime <= timeTable[i][0]) {
				compareTime = timeTable[i][1];
				cnt++;
			}
			
		}
		
		System.out.println(cnt);
	}

}