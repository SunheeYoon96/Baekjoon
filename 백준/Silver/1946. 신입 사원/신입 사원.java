import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [키워드]
 * 
 * [풀이과정]
 * 
 * [입력]
 * [출력] 
 * 
 * @author 윤선희
 * @since 
 * @see
 * @performance
 * @category #
 */

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int TC, N, applicants[][], cnt;


	public static void main(String[] args) throws NumberFormatException, IOException {
		TC = Integer.parseInt(input.readLine());
		
		for (int tc = 0; tc < TC; tc++) {
			N = Integer.parseInt(input.readLine());
			
			applicants = new int[N][2];
			cnt = 1;
			
			for (int i = 0; i < N; i++) {
				tokens = new StringTokenizer(input.readLine());
				int paper = Integer.parseInt(tokens.nextToken());
				int meeting = Integer.parseInt(tokens.nextToken());
				applicants[i][0] = paper;
				applicants[i][1] = meeting;
			}

			//앞 원소 기준 오름차순 정렬
			Arrays.sort(applicants, (o1, o2) ->{
				return o1[0]-o2[0];
			});
			
			int minMeeting = applicants[0][1];
			
			for (int i = 0; i < N; i++) {
				if(applicants[i][1] < minMeeting) {
					cnt++;
					minMeeting = applicants[i][1]; 
				}
			}
			
			output.append(cnt).append("\n");
			
		}
		System.out.println(output);

	}
	

}