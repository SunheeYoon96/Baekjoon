import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N, ranks[];
	static Human[] peoples;
	
	static class Human{
		int weight, height;

		public Human(int weight, int height) {
			super();
			this.weight = weight;
			this.height = height;
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		
		peoples = new Human[N];
		ranks = new int[N];
		
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(input.readLine());
			int w = Integer.parseInt(tokens.nextToken());
			int h = Integer.parseInt(tokens.nextToken());
			peoples[i] = new Human(w, h);
		}
		
		for (int i = 0; i < N; i++) {
			Human nowHuman = peoples[i];
			int biggerCnt = 0;
			
			for (int j = 0; j < N; j++) {
				if((nowHuman.weight < peoples[j].weight) && (nowHuman.height < peoples[j].height)) {
					biggerCnt++;
				}
			}
			
			ranks[i] = biggerCnt+1;
			
		}
		
		for (int i = 0; i < N; i++) {
			output.append(ranks[i]).append(" ");
		}
		
		System.out.println(output);
		

	}

}