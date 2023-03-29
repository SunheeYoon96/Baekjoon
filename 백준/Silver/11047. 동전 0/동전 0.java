import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N,K, coins[],cnt;

	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
        
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		coins = new int[N];
		for (int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(input.readLine());
		}
		
		for(int i=coins.length-1; i>=0; i--) {
			if(K>=coins[i]) {
				cnt +=  K/coins[i];
				K %= coins[i];
				//System.out.println(K);
				
			}
		}
		
		System.out.println(cnt);

	}
	
	private static String instr = "10 4200\r\n" + 
			"1\r\n" + 
			"5\r\n" + 
			"10\r\n" + 
			"50\r\n" + 
			"100\r\n" + 
			"500\r\n" + 
			"1000\r\n" + 
			"5000\r\n" + 
			"10000\r\n" + 
			"50000";

}