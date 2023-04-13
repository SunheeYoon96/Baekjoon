import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [키워드]
 * 닮음비 로 삼각형 길이구하기
 */

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static double X,Y,C, width, answer;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		
		X = Double.parseDouble(tokens.nextToken());
		Y = Double.parseDouble(tokens.nextToken());
		C = Double.parseDouble(tokens.nextToken());
		
		//W를 조절하면서 C를 찾는다 -> 오차범위 10^-3
		//이분탐색으로 오차범위를 줄여나야한다고 생각하는게 어려웠음..
		//알고리즘 분류 힌트보고 다시품
		
		double low = 0;
		double high = Math.min(X, Y);
		
		while (high - low >= 0.001) {
			
			width = (low+high)/2;
			double xh = Math.sqrt(X*X - width*width);
			double yh = Math.sqrt(Y*Y - width*width);
			double smallC = (xh*yh)/(xh+yh);
			
			if(smallC>=C) {
				low = width;
			}else {
				high=width;
			}
		}
		
		System.out.printf("%.3f", high);

	}

}