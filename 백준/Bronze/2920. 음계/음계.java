import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static String notes;

	public static void main(String[] args) throws IOException {
		
		notes = "";
		
		tokens = new StringTokenizer(input.readLine());
		
		for (int i = 0; i < 8; i++) {
			notes += tokens.nextToken();
		}
		
		if(notes.equals("12345678")) {
			System.out.println("ascending");
		}else if(notes.equals("87654321")) {
			System.out.println("descending");
		}else {
			System.out.println("mixed");
		}

	}

}