
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in) );

	public static void main(String[] args) throws IOException {
		String word = input.readLine();
		
		word = word.toUpperCase();
		
		int[] alphabets = new int[26];
		
		for(int i=0; i<word.length(); i++) {
			alphabets[word.charAt(i)-'A']++;
		}
		
		int max = -1;
		char ch='?';
		
		for (int i = 0; i < 26; i++) {
			if (alphabets[i] > max) {
				max = alphabets[i];
				ch = (char) (i + 65); // 대문자로 출력해야하므로 65를 더해준다.
			}
			else if (alphabets[i] == max) {
				ch = '?';
			}
		}
		
		
		System.out.println(ch);
		
	}

}
