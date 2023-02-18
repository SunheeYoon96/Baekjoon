import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N ; //기말고사 과목 수
	static int[] scores; //성적정보
	static double[] newScore; // 새점수
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		
		int maxVal = Integer.MIN_VALUE;
		
		scores = new int[N];
		newScore = new double[N];
		
		tokens = new StringTokenizer(input.readLine());
		for(int i=0; i<N; i++) {
			scores[i] = Integer.parseInt(tokens.nextToken());
			maxVal = Math.max(maxVal, scores[i]);
		}

		double sum = 0;
		for(int i=0; i<N; i++) {
			newScore[i] = (double)(scores[i])/maxVal*100;
			//System.out.println(scores[i]);
			sum += newScore[i];
		}

		double newAvg = sum/N;
	
		System.out.println(newAvg);
		
		
		
		

	}

}
