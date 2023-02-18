import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static StrInfo[] strs;
	
	public static class StrInfo {
		int cnt;
		String str;
		
		public StrInfo() {};
		
		public StrInfo(int cnt, String str) {
			super();
			this.cnt = cnt;
			this.str = str;
		}
		
	}

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		
		strs = new StrInfo[N];
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine());
			int num = Integer.parseInt(tokens.nextToken());
			String s = tokens.nextToken();
			
			strs[i] = new StrInfo(num, s);
		}
		
		String newSS;
		
		for(int i=0; i<strs.length; i++) {
			int snum = strs[i].cnt;
			String ss = strs[i].str;
			newSS = "";
			
			for(int j=0; j<ss.length(); j++) {
				char c = ss.charAt(j);
				for(int k=0; k<snum; k++) {
					newSS += c+"";
				}
			}
			output.append(newSS).append("\n");
		}
		System.out.println(output);
		

	}

}











