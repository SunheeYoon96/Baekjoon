import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int TC, N, applicants[][], applicants2[], cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		TC = Integer.parseInt(input.readLine());
		
		for (int tc = 0; tc < TC; tc++) {
			N = Integer.parseInt(input.readLine());
			applicants2 = new int[N+1];
			cnt = 1;
			
			for (int i = 0; i < N; i++) {
				tokens = new StringTokenizer(input.readLine());
				int paper = Integer.parseInt(tokens.nextToken());
				int meeting = Integer.parseInt(tokens.nextToken());
				applicants2[paper] = meeting;
			}
			
			int meetingScore = applicants2[1];
			
			for (int i = 2; i <= N; i++) {
				if(meetingScore>applicants2[i]) {
					cnt++;
					meetingScore = applicants2[i];
				}
			}
			output.append(cnt).append("\n");
		}
		System.out.println(output);
		
	}

	

}