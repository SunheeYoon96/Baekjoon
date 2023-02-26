import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static BufferedReader input = new  BufferedReader(new InputStreamReader(System.in));
	static long len, hash;
	static String line;
	static final int M = 1234567891;
	static int alphas[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};

	public static void main(String[] args) throws NumberFormatException, IOException {
		len = Integer.parseInt(input.readLine());
		
		line = input.readLine();
		hash = 0;
		for(int i=0; i<len; i++) {
			char c = line.charAt(i);
			//System.out.println(c-'a'+1);
			hash += (c-'a'+1)*((long)Math.pow(31, i)) %M;
			//System.out.println(hash);
		}

		
		System.out.println(hash);
		

	}

}