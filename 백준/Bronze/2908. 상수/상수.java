import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static String num1;
	static String num2;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		tokens = new StringTokenizer(input.readLine());
		num1 = tokens.nextToken();
		num2 = tokens.nextToken();
		
		String sangsuNum1 = "";
		String sangsuNum2 = "";
		
		for(int i=num1.length()-1; i>=0; i--) {
			sangsuNum1 += num1.charAt(i);
		}
		
		for(int i=num2.length()-1; i>=0; i--) {
			sangsuNum2 += num2.charAt(i);
		}
		
		if(Integer.parseInt(sangsuNum1) > Integer.parseInt(sangsuNum2) ) {
			System.out.println(sangsuNum1);
		}else {
			System.out.println(sangsuNum2);
		}
		

	}

}
