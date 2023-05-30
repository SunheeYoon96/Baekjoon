import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	
	static int x;
	static HashSet<Integer> hashSet;
	

	public static void main(String[] args) throws IOException {
		
		hashSet = new HashSet<>();
		x=0;		
		
		for (int i = 0; i < 10; i++) {
			x = Integer.parseInt(input.readLine());
			hashSet.add(x%42);
		}
		
		System.out.println(hashSet.size());
		
	}

}