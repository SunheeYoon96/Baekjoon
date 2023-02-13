
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	static HashSet<String> set = new HashSet<>(); //중복제거를 위해 hashset을 사용함.
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		arr = new int[N];
		tokens = new StringTokenizer(input.readLine());
		//배열초기화
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		
		// 오름차순으로 정렬
		Arrays.sort(arr);
		// 조합
		makeCombination(0, new int[M], 0);
		
		System.out.println(sb);
		
	}
	
	//중복제거 조합
	static void makeCombination(int cnt, int[] choosed, int start) {
		if(cnt == M) {
			StringBuilder temp = new StringBuilder();
			for(int i=0;i<cnt;i++) {
				temp.append(choosed[i]).append(' ');
			}
			temp.append('\n');
			String str = temp.toString();
			
			//중복제거를 위해
			if(!set.contains(str)) { //해당 조합이 이전에 나온적이 없으면
				set.add(str);
				sb.append(temp);
			}
			return;
		}
		for(int i=start;i<N;i++) {
			choosed[cnt] = arr[i];
			makeCombination(cnt+1, choosed, i+1);
		}
	}
}