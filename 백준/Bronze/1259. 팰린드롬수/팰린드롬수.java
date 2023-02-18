
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String num;

	public static void main(String[] args) throws IOException {
		String line = "";
		
		while(!line.equals("0")) {
			line = input.readLine();
			num = line;
			int len = num.length();
			boolean flag = true;
	
			for(int i=0; i<len; i++) {
				if(num.charAt(i)!=num.charAt(len-1-i)) {
					flag = false;
				}
			}
			
			//마지막줄이
			if(flag==true && !num.equals("0")) {
				output.append("yes").append("\n");				
			}else if(flag==false && !num.equals("0")){
				output.append("no").append("\n");				
			}
		}
		
		System.out.println(output);

	}

}
