import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder output = new StringBuilder();
	public static StringTokenizer tokens;
	
	public static int N, M;
	public static HashMap<String, Integer> hashMap;
	public static List<String> list;
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		hashMap = new HashMap<>();
		list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			hashMap.put(input.readLine(), 1);
		}
		
		for (int i = 0; i < M; i++) {
			String str = input.readLine();
			hashMap.put(str, hashMap.getOrDefault(str, 0) +1);
			if(hashMap.get(str)==2) {
				list.add(str);
			}
		}
		
		//System.out.println(hashMap);
		
		output.append(list.size()).append("\n");
		Collections.sort(list);
		for(String s : list) {
			output.append(s).append("\n");
		}
		
		System.out.println(output);
		
		
		
		

	}

}